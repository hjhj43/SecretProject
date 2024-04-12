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
	List<BoardVO> selectBoardList(BoardVO boardVO) throws Exception;

	public BoardVO selectDetail(int boardSn) throws Exception;

	public void insertBoard(BoardVO boardVO) throws Exception;

	public void updateBoard(BoardVO boardVO) throws Exception;

	public void deleteBoard(int boardSn) throws Exception;
	
	public int getTotCntBoard() throws Exception;

}
