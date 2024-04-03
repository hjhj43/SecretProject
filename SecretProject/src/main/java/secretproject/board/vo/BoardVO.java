package secretproject.board.vo;

import java.util.Date;

/**
 * @author hjhj43
 *
 */
public class BoardVO {
	
	private int boardSn; // 게시글 순번

	private String boardTitle; // 게시글 제목

	private String boardContent; // 게시글 내용
	
	private Date boardDate; // 게시글 등록일 (YYYY-MM-DD)
	
	private String boardRegisterId; // 게시글 등록 유저 아이디
	
	public int getBoardSn() {
		return boardSn;
	}

	public void setBoardSn(int boardSn) {
		this.boardSn = boardSn;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public Date getBoardDate() {
		return boardDate;
	}

	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}

	public String getBoardRegisterId() {
		return boardRegisterId;
	}

	public void setBoardRegisterId(String boardRegisterId) {
		this.boardRegisterId = boardRegisterId;
	}
	
	@Override
	public String toString() {
		return "BoardVO [boardSn=" + boardSn + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent
				+ ", boardDate=" + boardDate + ", boardRegisterId=" + boardRegisterId + "]";
	}

}
