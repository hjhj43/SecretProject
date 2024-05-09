package secretproject.board.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import secretproject.board.service.BoardService;
import secretproject.board.vo.BoardVO;
import secretproject.cmmn.vo.DefaultVO;
import secretproject.user.vo.UserVO;

@Slf4j
@Validated
@Controller
public class BoardController {
	
	@Resource(name = "boardService")
	private BoardService boardService;
	
//	@Autowired                        															   //이방법으로 의존성 주입도 가능함.
//	private BoardService boardService;

	
	/**
	 * 글 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 BoardVO
	 * @param model
	 * @return "egovSampleList"
	 * @exception Exception
	 */
	@RequestMapping(value = "/BoardList.do")
	public String selectBoardList(@ModelAttribute("boardVO") BoardVO boardVO, Model model) throws Exception {
		
		log.info("/BoardList.do started");										//예시 로그
		
		int boardCnt = boardService.getTotCntBoard();							//전체 카운트 구한다.
		
		boardVO.setTotalRowCount(boardCnt);										//전체 ROW 세팅
		boardVO.setUpPagination();												//페이징  셋업
		
		List<BoardVO> boardList = boardService.selectBoardList(boardVO);		//페이징 세팅 값을 들고 selectBoard해옴
		
		DefaultVO pagingVO = boardVO;											//DefaultVO (페이징 및 검색기능 있음)으로 캐스팅
		
		model.addAttribute("boardList", boardList);
		model.addAttribute("boardPagingVO", pagingVO);							//페이징용 VO
		
		log.info("BoardList ==>> {}",boardList);								
		log.info("/BoardList.do Ended");                                        //예시 로그

		return "board/boardList";
	}	
	
	// 게시글 상세페이지
	@RequestMapping(value="/BoardDetail.do")
	public String viewBoard(Model model, HttpServletRequest request) throws Exception{
		
		int boardSn = Integer.parseInt(request.getParameter("boardSn"));
		
		BoardVO boardVO = boardService.selectDetail(boardSn);
		model.addAttribute("boardList", boardVO);
		
		return "board/boardDetail";
	}
	
	// 게시글 작성페이지
	@RequestMapping(value="/BoardRegister.do")
	public String boardRegister() {
		return "board/boardRegister";
	}
	
	// 게시글 작성
	@RequestMapping(value="/insertBoard.do")
	public String write(@ModelAttribute("boardVO") @Valid BoardVO boardVO) throws Exception {
		
		boardService.insertBoard(boardVO);

		return "redirect:BoardList.do";
	}
	
	// 게시글 수정 (게시글 작성자만 수정 가능)
	@RequestMapping(value="/updateBoard.do")
	public String updateBoard(@ModelAttribute("boardVO") @Valid BoardVO boardVO, HttpServletRequest request, HttpSession session) throws Exception {
		
		BoardVO boardData = boardService.getBoardData(boardVO);
		String boardRegisterId = boardData.getBoardRegisterId();
		int boardSn = boardData.getBoardSn();
		
		UserVO sessionUserData = (UserVO) session.getAttribute("sessionUserData");
		String userId = sessionUserData.getUserId();
		
		if(boardRegisterId.equals(userId) && boardSn != 0) {
			boardService.updateBoard(boardData);
		}
		return "redirect:BoardDetail.do?boardSn="+boardVO.getBoardSn();
	}
	
	// 게시글 삭제 (게시글 작성자와 admin만 삭제 가능)
	@RequestMapping(value="/deleteBoard.do")
	public String deleteBoard(HttpServletRequest request, HttpSession session, BoardVO boardVO) throws Exception {
		
		// session에 있는 userData 가져오기
		UserVO sessionUserData = (UserVO) session.getAttribute("sessionUserData");
		String userId = sessionUserData.getUserId();
		int userAuthNum = sessionUserData.getUserAuthNum();
		
		// boardVO에 있는 boardData 가져오기
		BoardVO boardData = boardService.getBoardData(boardVO);
	    String boardRegisterId = boardData.getBoardRegisterId();
	    int dataBoardSn = boardData.getBoardSn();
	    
	    if(boardRegisterId.equals(userId) || userAuthNum == 1) {
			boardService.deleteBoard(dataBoardSn);
	    }
		return "redirect:BoardList.do";
	}
}
