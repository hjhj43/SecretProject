package secretproject.cmmn;

import java.util.Arrays;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * JUnit의 테스트용 테스트용 Utils  
 * 
 * @author jelly
 */
public class StringUtils {
	
	/**
	 * JUnit 테스팅용으로 만들어놓은 임의의 함수. 추후 삭제 하세용~
	 * 
	 * @param int a 
	 * @param int b
	 * 
	 * @return int a + b
	 */
	public static int sumInts(int a, int b) {
		
		int sum;
		
		sum = a + b;
		
		return sum;
		
	}
	
	
	
	/**
	 * check if charSequence is empty 
	 * 
	 * return true if the CharSequence is empty or null
	 * 
	 * charSequnce 가  비어있는경우 혹은 null 이면 true 
	 * 
	 * 상세 설명 주석 참조 
	 * 
	 * 
	 * <pre>
	 * StringUtils.isEmpty(null)      = true
	 * StringUtils.isEmpty("")        = true
	 * StringUtils.isEmpty(" ")       = false
	 * StringUtils.isEmpty("bob")     = false
	 * StringUtils.isEmpty("  bob  ") = false
	 * </pre>
	 * 
	 * @param cs  the CharSequence to check, may be null
	 * @return {@code true} if the CharSequence is empty or null
	 * @since  signature from isEmpty(String) to isEmpty(CharSequence)
	 */
	public static boolean isEmpty(final CharSequence cs) {
	    return cs == null || cs.length() == 0;
	}
	
	
	public static boolean isNotEmptyString(String str) {
		return !isEmpty(str);
	}

	
	/**
	 * 한국어 이름 마스킹 처리 하여 리턴하는 메소드
	 * 
	 * 영어 이름의 경우 마스킹 안함
	 * 
	 * @param String name
	 * @return String maskedName
	 */
	public static String getNameMaskedType(String name) {
		String return_name = "";
		
			
		if(isNotEmptyString(name) && name.length() >= 2) {
			String masking = "*";
																				// 한글명인 경우
			if (Pattern.matches("^[ㄱ-ㅎ가-힣]*$", name)) {
				if(name.length()>4) {											//이름이 5글자 이상인 경우 성 뒤 이름의 첫자리 부터 두글자 마스킹 처리
					return_name = name.charAt(0) + "**" + name.substring(3);
				}else {
					return_name = name.charAt(0) + masking + name.substring(2); // 성 뒤 이름의 첫자리 마스킹 처리
				}
				
			} else { 															//영어의 경우 마스킹 예외 
				return_name = name;
			}
		}
		
		return return_name;
	}
	
	public static String phoneMasking(String userPhone) {
	    String regex = "(\\d{2,3})-?(\\d{3,4})-?(\\d{4})$";

	    Matcher matcher = Pattern.compile(regex).matcher(userPhone);
	    if(matcher.find()) {
	        String target = matcher.group(2);
	        int length = target.length();
	        char[] c = new char[length];
	        Arrays.fill(c, '*');

	        return userPhone.replace(target, String.valueOf(c));
	    }
	    return userPhone;
	}

}
