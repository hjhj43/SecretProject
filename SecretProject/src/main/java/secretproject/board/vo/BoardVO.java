package secretproject.board.vo;

import java.sql.Date;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;
import secretproject.cmmn.vo.DefaultVO;

/**
 * @author hjhj43
 *
 */
@Data
@SuppressWarnings("serial")
public class BoardVO extends DefaultVO{
	
	private int boardSn; // 게시글 순번

    @NotEmpty(message = "Board title cannot be empty.")
	private String boardTitle; // 게시글 제목

	@NotEmpty
	private String boardContent; // 게시글 내용
	
	private Date boardDate; // 게시글 등록일 (YYYY-MM-DD)
	
	private String boardRegisterId; // 게시글 등록 유저 아이디
	

}
