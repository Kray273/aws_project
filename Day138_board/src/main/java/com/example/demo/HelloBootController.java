package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloBootController {

	@Autowired
	HelloDTO dto;
	
	@RequestMapping("/")
	public ModelAndView helloBoot() {
		ModelAndView mv = new ModelAndView();
		dto.setModel("부트 실행 결과입니다.");
		mv.addObject("dto",dto);
		
		mv.setViewName("helloboot"); 
		// spring : src/main/webapp/WEB-INF/view/?.jsp
		// spring boot : 저장위치가 자유롭다.
			// boot의 모든 설정은 properties에서 통합 관리한다.
		return mv;
	}
	
	
	@GetMapping("/hellobootajax")
	public @ResponseBody String helloAjax() {
		return "{\"result\" : \"부트에서 Ajax 호출 응답 \"}";
	}
	
}
