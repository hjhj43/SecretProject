package secretproject.user.vo;


import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Data
public class UserVO {
	
	@NotEmpty(message = "Movie name cannot be empty.")
//	@Pattern(regexp = "/^[a-z0-9]{5,20}$/")
	private String userId; // 유저 아이디
	
	@NotEmpty
	private String userPw; // 유저 비밀번호

	@NotEmpty
	private String userName; // 유저 이름
	
	@NotEmpty
	private String userEmail; // 유저 이메일
	
	@NotEmpty
	private String userPhone; // 유저 핸드폰번호

}
