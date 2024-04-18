package secretproject.board.serviceimpl;

import java.util.List;


import egovframework.rte.psl.dataaccess.mapper.Mapper;
import secretproject.board.vo.BoardVO;

@Mapper
public interface BoardMapper {
	
	public List<BoardVO> selectBoardList(BoardVO boardVO) throws Exception;

	public BoardVO selectDetail(int boardSn) throws Exception;

	public void insertBoard(BoardVO boardVO) throws Exception;

	public void updateBoard(BoardVO boardVO) throws Exception;

	public void deleteBoard(int boardSn) throws Exception;

	public int getTotCntBoard() throws Exception;

}
