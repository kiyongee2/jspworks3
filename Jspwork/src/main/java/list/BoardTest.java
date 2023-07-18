package list;

import java.util.ArrayList;

public class BoardTest {

	public static void main(String[] args) {
		ArrayList<Board> boardList = new ArrayList<>();
		
		boardList.add(new Board("제목1", "내용1"));
		boardList.add(new Board("제목2", "내용2"));
		boardList.add(new Board("제목3", "내용3"));
		boardList.add(new Board("제목4", "내용4"));
		boardList.add(new Board("제목5", "내용5"));
		
		Board board1 = boardList.get(4);
		Board board2 = boardList.get(3);
		Board board3 = boardList.get(2);
		
		Board[] newBoard = {board1, board2, board3};
		System.out.println(newBoard[1]);
		//System.out.println(board);
		
		
	}

}
