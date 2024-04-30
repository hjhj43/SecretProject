package unit;

import static org.junit.jupiter.api.Assertions.assertEquals;



import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import secretproject.cmmn.StringUtils;

/**
 * JUnit 사용 예시
 *
 */
public class UtilTest {
	

	@Test															//test annotation 붙여야 테스트가 됩니당
	@DisplayName("1 + 1 = 2")										//JUnit test 실행할때 콘솔에 나오는 테스트 이름 
	void addsTwoNumbers() {
		
		// Assertions.assertEquals(int expected, int actual, String message)
		// 예상 값과 실제 값이 일치하는 지 체크 . 일치하지 않을 경우 message 출력
		// String message 는 Optional
		assertEquals(2, StringUtils.sumInts(1, 1), "1 + 1 should equal 2"); 
		
	}

	@ParameterizedTest(name = "{0} + {1} = {2}")					// parameter 사용한 테스트
	@CsvSource({
			"0,    1,   1",
			"1,    2,   3",
			"49,  51, 100",
			"1,  100, 101" 
	})
	void add(int first, int second, int expectedResult) {
		assertEquals(expectedResult, StringUtils.sumInts(first, second),	
				() -> first + " + " + second + " should equal " + expectedResult);
	}
	
	
	@Test
	@DisplayName("김이박최정  -> 김**최정")
	void maskName5() {
		assertEquals("김**최정", StringUtils.getNameMaskedType("김이박최정"), "한국어 이름 다섯글자의 경우 두군데 마스킹이 되어야 합니다 korean name should be masked");

	}

	@Test
	@DisplayName("김이박최  -> 김*박최")
	void maskName4() {
		assertEquals("김*박최", StringUtils.getNameMaskedType("김이박최"), "한국어 이름 네글자의 경우  성 뒤에 이름 한글자가 마스킹이 되어야 합니다 korean name should be masked");

	}
	
	
	@Test
	@DisplayName("김이박  -> 김*박")
	void maskName3() {
		assertEquals("김*박", StringUtils.getNameMaskedType("김이박"), "한국어 이름 세글자의 경우 성 뒤에 이름 한글자가 마스킹이 되어야 합니다 korean name should be masked");

	}
	
	
	@Test
	@DisplayName("김이  -> 김*")
	void maskName2() {
		assertEquals("김*", StringUtils.getNameMaskedType("김이"), "한국어 이름 두글자의 경우 성 뒤에 이름 한글자가 마스킹이 되어야 합니다 korean name should be masked");

	}
	

	//실패하는 테스트.
	
//	
//	@Test
//	@DisplayName("김이  -> *김")
//	void wrongMaskName() {
//		assertEquals("*이", StringUtils.getNameMaskedType("김이"), "한국어 이름 두글자의 경우 성 뒤에 이름 한글자가 마스킹이 되어야 합니다 korean name should be masked");
//
//	}
	
	
}
