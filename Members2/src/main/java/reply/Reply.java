package reply;

import java.io.Serializable;
import java.sql.Timestamp;

public class Reply implements Serializable{
	
	private static final long serialVersionUID = 3L;
	
	private int rno;           //댓글 번호
	private int bnum;          //게시글 번호
	private String rcontent;   //댓글 내용
	private String replyer;    //댓글 작성자
	private Timestamp rdate;   //댓글 작성일
	private Timestamp rupdate; //댓글 수정일
	
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public int getBnum() {
		return bnum;
	}
	public void setBnum(int bnum) {
		this.bnum = bnum;
	}
	public String getRcontent() {
		return rcontent;
	}
	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}
	public String getReplyer() {
		return replyer;
	}
	public void setReplyer(String replyer) {
		this.replyer = replyer;
	}
	public Timestamp getRdate() {
		return rdate;
	}
	public void setRdate(Timestamp rdate) {
		this.rdate = rdate;
	}
	public Timestamp getRupdate() {
		return rupdate;
	}
	public void setRupdate(Timestamp rupdate) {
		this.rupdate = rupdate;
	}
}

