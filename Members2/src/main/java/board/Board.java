package board;

import java.io.Serializable;
import java.sql.Timestamp;

public class Board implements Serializable{
	private static final long serialVersionUID = 2L;
	
	private int bnum;
	private String title;
	private String content;
	private Timestamp regDate;
	private int hit;
	private String memberId;
	private Timestamp modifyDate;
	
	private String fileUpload;  //파일 업로드
	
	public int getBnum() {
		return bnum;
	}
	public void setBnum(int bnum) {
		this.bnum = bnum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getRegDate() {
		return regDate;
	}
	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public Timestamp getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Timestamp modifyDate) {
		this.modifyDate = modifyDate;
	}
	public String getFileUpload() {
		return fileUpload;
	}
	public void setFileUpload(String fileUpload) {
		this.fileUpload = fileUpload;
	}
}
