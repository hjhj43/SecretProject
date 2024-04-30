package secretproject.user.vo;


import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;
import secretproject.cmmn.vo.DefaultVO;

@Data
@SuppressWarnings("serial")
public class UserVO extends DefaultVO{
	
	@NotEmpty(message = "아이디는 공백이 될 수 없습니다.")
	@Pattern(regexp = "^[a-z0-9]{5,20}+$", message = "아이디는 5~20자 영문 소문자와 숫자만 입력하세요.")
	private String userId; // 유저 아이디
	
	@NotEmpty(message = "비밀번호는 공백이 될 수 없습니다.")
	@Pattern(regexp = "^[a-z0-9]{5,20}+$", message = "비밀번호는 5~20자 영문 소문자와 숫자만 입력하세요.")
	private String userPw; // 유저 비밀번호

	@NotEmpty(message = "이름은 공백이 될 수 없습니다.")
	@Pattern(regexp = "^[가-힣a-zA-Z]{2,15}$", message = "이름은 2~15자 한글과 영어만 입력하세요.")
	private String userName; // 유저 이름
	
	@NotEmpty(message = "이메일은 공백이 될 수 없습니다.")
	@Pattern(regexp = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$", message = "잘못된 이메일 형식입니다.")
	private String userEmail; // 유저 이메일
	
	@NotEmpty(message = "전화번호는 공백이 될 수 없습니다.")
	@Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "잘못된 전화번호 형식입니다.")
	private String userPhone; // 유저 핸드폰번호
	
	private int userAuthNum;
	
	private String authName;

}
