package board.spring.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;

@Controller
public class BoardController {
	@Autowired
	@Qualifier("boardservice")
	BoardService service;
	
	@RequestMapping("/board")
	public String boardstart() {
		return "board/board";
	}
	
	@RequestMapping("/boardlist")
	public ModelAndView boardlist(@RequestParam(value = "page", required =false, defaultValue = "1")
	int page) {
	// 게시판리스트 만들기
	/* 1.select count(*)from board; board-int-model저장
	 * 2.select * from board limit (page-1)*3 , 3개씩 -list-model저장
	 * 3. board/list.jsp
	 * */
		int countboard = service.getTotalBoard();
		int limit = (page-1)*3;
		List<BoardDTO> list = service.getBoardList(limit);
		ModelAndView mv = new ModelAndView();
		mv.addObject("totalcount", countboard);
		mv.addObject("list", list);
		mv.setViewName("board/list");
		return mv;
	}
	
	@RequestMapping("/oneboard")
	public ModelAndView oneboard(int seq) {
		BoardDTO dto = service.oneBoard(seq);
		service.viewUp(dto);
		ModelAndView mv = new ModelAndView();
		mv.addObject("oneboard", dto);
		mv.setViewName("board/oneboard");
		return mv;
	}
	
	@PostMapping("updateboard")
	public ModelAndView updateboard(BoardDTO dto) {
		ModelAndView mv = new ModelAndView();
		service.updateBoard(dto);
		mv.addObject("result","수정되었습니다.");
		String viewname ="redirect:/oneboard?seq=" + dto.getSeq();
		mv.setViewName(viewname);
		return mv; 
	}
	
	@GetMapping("deleteboard")
	public String deleteboard(int seq) {
		service.deleteBoard(seq);
		return "board/board";
	}
	
	@GetMapping("/insertboard")
	public String insertboard() {	
		return "board/insertboard";
	}
	
	@PostMapping("/insertboard")
	public ModelAndView insertboardprocess(BoardDTO dto, HttpSession session){
		ModelAndView mv = new ModelAndView();
		service.insertBoard(dto);	
		mv.setViewName("redirect:/boardlist");			
		return mv;
	}
	
}
