package secretproject.board.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.hibernate.validator.constraints.NotEmpty;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springmodules.validation.bean.BeanValidator;

import secretproject.board.service.BoardService;
import secretproject.board.vo.BoardVO;

@Validated
@Controller
public class BoardController {
	
	private static final org.slf4j.Logger log = LoggerFactory.getLogger(BoardController.class);    //로거 생성

	
	
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
		
		
		List<BoardVO> boardList = boardService.selectBoardList(boardVO);
		model.addAttribute("boardList", boardList);
		
		log.info("BoardList ==>> {}",boardList);
		
		log.info("/BoardList.do Ended");                                         //예시 로그

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
	public String write(  @NotEmpty(message = "Input movie list cannot be empty.") @ModelAttribute("boardVO") @Valid BoardVO boardVO) throws Exception {
		boardService.insertBoard(boardVO);
		return "redirect:BoardList.do";
	}
	
	// 게시글 수정
	@RequestMapping(value="/updateBoard.do")
	public String updateBoard(@ModelAttribute("boardVO") BoardVO boardVO) throws Exception {
		boardService.updateBoard(boardVO);
		return "redirect:BoardDetail.do?boardSn="+boardVO.getBoardSn();
	}
	
	// 게시글 삭제
	@RequestMapping(value="/deleteBoard.do")
	public String deleteBoard(HttpServletRequest request) throws Exception {
		int boardSn = Integer.parseInt(request.getParameter("boardSn"));
		boardService.deleteBoard(boardSn);
		return "redirect:BoardList.do";
	}
}
