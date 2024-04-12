package secretproject.cmmn.vo;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DefaultVO implements Serializable {

	private static final long serialVersionUID = -6989671720065902655L;
	
	//입력받는 데이터
	private int curPage=1;				// 현재 페이지 번호
	private int rowSizePerPage=10;		// 한 페이지당 레코드 수      기본10
	private int pageSize=10;			// 페이지 리스트에서 보여줄 페이지 갯수  이거는 보통 10 or 5 안 변함
	private int totalRowCount ;			// 총 레코드 건수


	//입력받는 데이터를 통해 계산되는 값
	private int firstRow;				// 시작 레크드 번호
	private int lastRow;				// 마지막 레크드 번호
	private int totalPageCount;			// 총 페이지 건수
	private int firstPage;				// 페이지 리스트에서 시작  페이지 번호
	private int lastPage;				// 페이지 리스트에서 마지막 페이지 번호
	
	
	private String pagingYn = "Y";		 	//페이징 여부 기본 값 Y; 

	
	
	/** 검색Keyword */
	private String searchKeyword;			//검색어

	private String selectedId;             //id로 검색  그냥  searchKeyword 사용하고  필요시 사용.
	
	

	/** 검색조건 */
	private String searchCondition = ""; 


	/** 검색사용여부 */
	private boolean searchUseYn = false;  
	
	
	
	public void setUpPagination() {

		totalPageCount = (totalRowCount-1) / rowSizePerPage+ 1;
		firstRow = (curPage - 1) * rowSizePerPage + 1;
		lastRow = firstRow + rowSizePerPage-1;

		if(lastRow >= totalRowCount) {
			lastRow = totalRowCount;
		}

		firstPage = ((curPage-1) / pageSize) * pageSize + 1;

		lastPage = firstPage + pageSize-1;

		if(lastPage > totalPageCount) {
			lastPage = totalPageCount;
		}

	}

}
