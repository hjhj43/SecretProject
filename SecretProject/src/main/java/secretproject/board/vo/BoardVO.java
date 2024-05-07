package secretproject.board.vo;

import java.sql.Date;

import org.hibernate.validator.constraints.NotEmpty;
import org.springmodules.validation.bean.conf.loader.annotation.handler.Max;

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

    @NotEmpty(message = "게시글 제목은 공백이 될 수 없습니다.")
    @Max(value=100, message = "제목은 100자 이내로 작성해주세요.")
	private String boardTitle; // 게시글 제목

	@NotEmpty(message = "게시글 제목은 공백이 될 수 없습니다.")
    @Max(value=200, message = "내용은 200자 이내로 작성해주세요.")
	private String boardContent; // 게시글 내용
	
	private Date boardDate; // 게시글 등록일 (YYYY-MM-DD)
	
	@NotEmpty(message = "유저 아이디는 공백이 될 수 없습니다.")
	private String boardRegisterId; // 게시글 등록 유저 아이디
	
}
