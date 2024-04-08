package secretproject.user.vo;

import lombok.Data;

@Data
public class UserVO {
	
	private String userId; // 유저 아이디
	
	private String userPw; // 유저 비밀번호
	
	private String userName; // 유저 이름
	
	private String userEmail; // 유저 이메일
	
	private String userPhone; // 유저 핸드폰번호

}
