package secretproject.board.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import secretproject.board.vo.BoardVO;

@Repository("boardDAO")
public class BoardDAO extends EgovAbstractDAO {
	
	/**
	 * 글 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return 글 목록
	 * @exception Exception
	 */
	public List<?> selectBoardList(BoardVO boardVO) throws Exception {
		return list("boardDAO.selectBoardList", boardVO);
	}
}
