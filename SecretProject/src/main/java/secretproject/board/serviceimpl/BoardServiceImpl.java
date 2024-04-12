package secretproject.board.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import lombok.extern.slf4j.Slf4j;
import secretproject.board.dao.BoardDAO;
import secretproject.board.service.BoardService;
import secretproject.board.vo.BoardVO;

@Slf4j
@Service("boardService")
public class BoardServiceImpl extends EgovAbstractServiceImpl implements BoardService {
	
	@Resource(name = "boardDAO")
	private BoardDAO boardDAO;
	/**
	 * 글 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return 글 목록
	 * @exception Exception
	 */
	@Override
	public List<BoardVO> selectBoardList(BoardVO boardVO) throws Exception {
		return boardDAO.selectBoardList(boardVO);
	}
	
	@Override
	public BoardVO selectDetail(int boardSn) throws Exception {
		return boardDAO.selectDetail(boardSn);
	}
	
	@Override
	public void insertBoard(BoardVO boardVO) throws Exception {
		boardDAO.insertBoard(boardVO);
	}
	
	@Override
	public void updateBoard(BoardVO boardVO) throws Exception {
		boardDAO.updateBoard(boardVO);
	}
	
	@Override
	public void deleteBoard(int boardSn) throws Exception {
		boardDAO.deleteBoard(boardSn);
	}

	@Override
	public int getTotCntBoard() throws Exception {
		int totalCountOfBoard = 0;
		
		totalCountOfBoard = boardDAO.getTotCntBoard();
		log.info("totalCountOfBoard ==>{}",totalCountOfBoard);
		
		return totalCountOfBoard;
	}

}
