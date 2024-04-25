package secretproject.user.vo;


import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;
import secretproject.cmmn.vo.DefaultVO;

@Data
@SuppressWarnings("serial")
public class UserVO extends DefaultVO{
	
	@NotEmpty
	@Pattern(regexp = "^[a-z0-9]{5,20}+$")
	private String userId; // 유저 아이디
	
	@NotEmpty
	@Pattern(regexp = "^[a-z0-9]{5,20}+$")
	private String userPw; // 유저 비밀번호

	@NotEmpty
	@Pattern(regexp = "^[가-힣a-zA-Z]{2,15}$")
	private String userName; // 유저 이름
	
	@NotEmpty
	@Pattern(regexp = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$")
	private String userEmail; // 유저 이메일
	
	@NotEmpty
	@Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$")
	private String userPhone; // 유저 핸드폰번호
	
	private int userAuthNum;
	
	private String authName;

}
