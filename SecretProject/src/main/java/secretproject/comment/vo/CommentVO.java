package secretproject.comment.vo;

import java.sql.Date;

import org.hibernate.validator.constraints.NotEmpty;
import org.springmodules.validation.bean.conf.loader.annotation.handler.Max;

import lombok.Data;
import secretproject.cmmn.vo.DefaultVO;

@Data
@SuppressWarnings("serial")
public class CommentVO extends DefaultVO {
	
	private int commentSn;
	
	private int commentBoardSn;
	
	private String commentUserId;
	
	@NotEmpty(message = "댓글은 공백이 될 수 없습니다.")
    @Max(value=100, message = "100자 이내로 작성해주세요.")
	private String commentContent;
	
	private Date commentDate;
	
	private Date commentUpdateDate;
	
}
