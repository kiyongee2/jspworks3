package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import board.Board;
import board.BoardDAO;
import member.Member;
import member.MemberDAO;

@WebServlet("*.do")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	MemberDAO memberDAO;
	BoardDAO boardDAO;

	public void init(ServletConfig config) throws ServletException {
		memberDAO = new MemberDAO();
		boardDAO = new BoardDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String uri = request.getRequestURI();
		System.out.println(uri);
		String command = uri.substring(uri.lastIndexOf("/"));
		System.out.println(uri.lastIndexOf("/"));
		System.out.println("command:" + command);
		
		String nextPage = null;
		
		//세션 객체 생성(로그인 처리)
		HttpSession session = request.getSession();
		//출력 객체 생성
		PrintWriter out = response.getWriter();
		
		if(command.equals("/memberList.do")) {
			ArrayList<Member> memberList = memberDAO.getMemberList();
			
			request.setAttribute("memberList", memberList);
			nextPage = "/member/memberList.jsp";
		}else if(command.equals("/memberForm.do")) {
			nextPage = "/member/memberForm.jsp";
		}else if(command.equals("/addMember.do")) {
			//폼 데이터 받기
			String memberId = request.getParameter("memberId");
			String passwd = request.getParameter("passwd1");
			String name = request.getParameter("name");
			String gender = request.getParameter("gender");
			
			Member newMember = new Member();  //회원 객체 생성
			newMember.setMemberId(memberId);
			newMember.setPasswd(passwd);
			newMember.setName(name);
			newMember.setGender(gender);
			
			session.setAttribute("sessionId", memberId);  //세션 발급
			
			memberDAO.addMember(newMember);  //회원 가입 및 자동 로그인
			
			nextPage = "index.jsp";
		}else if(command.equals("/memberView.do")) {
			
			String memberId = request.getParameter("memberId");
			
			Member member = memberDAO.getMember(memberId);
			
			request.setAttribute("member", member);
			
			nextPage = "/member/memberView.jsp";
		}else if(command.equals("/loginForm.do")) {
			nextPage = "/member/loginForm.jsp";
		}else if(command.equals("/loginProcess.do")) {
			//폼 데이터 받기
			String memberId = request.getParameter("memberId");
			String passwd = request.getParameter("passwd");
			
			Member loginMember = new Member();
			loginMember.setMemberId(memberId);
			loginMember.setPasswd(passwd);
			
			boolean result = memberDAO.checkLogin(loginMember);
			if(result) {
				session.setAttribute("sessionId", memberId); //세션 발급
				nextPage = "/index.jsp";
			}else {
				out.println("<script>");
				out.println("alert('아이디나 비밀번호를 확인해주세요')");
				out.println("history.go(-1)");
				out.println("</script>");
			}
		}else if(command.equals("/logout.do")) {
			session.invalidate();
			nextPage = "/index.jsp";
		}else if(command.equals("/memberDelete.do")) {
			String memberId = request.getParameter("memberId");
			
			memberDAO.deleteMember(memberId);  //회원 삭제
			
			nextPage = "/memberList.do";
		}else if(command.equals("/memberEvent.do")) {
			nextPage = "/member/memberEvent.jsp";
		}
		
		//게시글 목록(페이지 처리)
		if(command.equals("/boardList.do")) {
			String pageNum = request.getParameter("pageNum");
			if(pageNum == null){
				pageNum = "1";
			}
			int currentPage = Integer.parseInt(pageNum);  //현재 페이지
			int pageSize = 10;  //페이지당 개시글 수
			//(1page -> 1번(start)), (2 -> 11), (3 -> 21)
			int startRow =(currentPage-1)*pageSize + 1;   //매 페이지의 첫 행
			
			//시작 페이지 = 시작행 / 페이지당 행수 + 1
			int startPage = startRow / pageSize + 1; 
			/*마지막 페이지 = 페이지당 총 수 / 페이지당 행수
				13 -> 2, 23 -> 3, 33 -> 4
				13/10 -> 1.3 -> ceil(1.3) -> 2.0(올림)*/
			//int endPage = (int)Math.ceil((double)total/pageSize);
			//게시글 총수
			int total = boardDAO.getBoardCount();
			
			int endPage = total / 10;
			endPage = (total % 10 == 0) ? endPage : endPage + 1;
			
			//dao - 게시글 목록 메소드 호출
			ArrayList<Board> boardList = boardDAO.getBoardList(currentPage);
			
			//model - 회원 목록, 현재, 시작, 마지막 페이지
			request.setAttribute("boardList", boardList);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
			request.setAttribute("total", total);
			
			nextPage = "board/boardList.jsp";
		}else if(command.equals("/boardForm.do")) {  //글쓰기 폼
			nextPage = "board/boardForm.jsp";
		}else if(command.equals("/addBoard.do")) {
			String realFolder = "C:/Users/kiyon/git/jspworks3/Members/src/main/webapp/upload";

			MultipartRequest multi = new MultipartRequest(request, realFolder, 5*1024*1024,
					"utf-8", new DefaultFileRenamePolicy());
			
			//name 속성 가져오기
			String title = multi.getParameter("title");
			String content = multi.getParameter("content");
			String memberId = (String)session.getAttribute("sessionId");
			
			//fileName 속성 가져옴
			Enumeration<String> files = multi.getFileNames();
			String name = "";
			String fileName = "";
			if(files.hasMoreElements()) {
				name = (String)files.nextElement();
				fileName = multi.getFilesystemName(name);
			}
			
			Board newBoard = new Board();
			newBoard.setTitle(title);
			newBoard.setContent(content);
			newBoard.setMemberId(memberId);
			newBoard.setFileUpload(fileName);
			
			boardDAO.addBoard(newBoard);  //게시글 추가
			
		}else if(command.equals("/boardView.do")) {  
			int bnum = Integer.parseInt(request.getParameter("bnum"));
			Board board = boardDAO.getBoard(bnum); //상세 보기
			
			request.setAttribute("board", board);  //모델 생성
			nextPage = "board/boardView.jsp";
		}else if(command.equals("/boardDelete.do")) {
			
			int bnum = Integer.parseInt(request.getParameter("bnum"));
			boardDAO.boardDelete(bnum);  //게시글 삭제
			
		}else if(command.equals("/boardUpdate.do")) { //수정 페이지 요청
			int bnum = Integer.parseInt(request.getParameter("bnum"));
			
			Board board = boardDAO.getBoard(bnum);  //글 1개 가져오기
			
			request.setAttribute("board", board);
			nextPage = "board/boardUpdate.jsp";
		}else if(command.equals("/boardUpdateProcess.do")) {
			//입력 폼 데이터 가져오기
			int bnum = Integer.parseInt(request.getParameter("bnum"));
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			//게시글 객체 생성
			Board board = new Board();
			board.setTitle(title);
			board.setContent(content);
			board.setBnum(bnum);
			
			boardDAO.boardUpdate(board);  //게시글 수정
		}
		
		//페이지 이동
		if(command.equals("/addBoard.do")) { //새로고침 중복 저장 문제 해결
			response.sendRedirect("/boardList.do");
		}else if(command.equals("/boardDelete.do")) {
			response.sendRedirect("/boardList.do");
		}else if(command.equals("/boardUpdateProcess.do")) {
			response.sendRedirect("/boardList.do");
		}else {
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher(nextPage);
			
			dispatcher.forward(request, response);
		}
	}
}
