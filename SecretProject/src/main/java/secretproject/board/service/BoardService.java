package secretproject.board.service;

import java.util.List;

import secretproject.board.vo.BoardVO;

public interface BoardService {
	
	/**
	 * 글 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return 글 목록
	 * @exception Exception
	 */
	List<?> selectBoardList(BoardVO boardVO) throws Exception;

}
