package secretproject.board.dao;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import secretproject.board.serviceimpl.BoardMapper;
import secretproject.board.vo.BoardVO;

@Repository("boardDAO")
public class BoardDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private BoardMapper mapper;
	
	@PostConstruct
	public void init() {
		mapper = sqlSession.getMapper(BoardMapper.class);
	}
	
	/**
	 * 글 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return 글 목록
	 * @exception Exception
	 */
	
	public List<BoardVO> selectBoardList(BoardVO boardVO) throws Exception {
		return mapper.selectBoardList(boardVO);
	}
	
	public BoardVO selectDetail(int boardSn) throws Exception {
		return mapper.selectDetail(boardSn);
	}
	
	public void insertBoard(BoardVO boardVO) throws Exception {
		mapper.insertBoard(boardVO);
	}
	
	public void updateBoard(BoardVO boardVO) throws Exception {
		mapper.updateBoard(boardVO);
	}
	
	public void deleteBoard(int boardSn) throws Exception {
		mapper.deleteBoard(boardSn);
	}
	
	public int getTotCntBoard() throws Exception{
		return mapper.getTotCntBoard();
	}
	
	
}
