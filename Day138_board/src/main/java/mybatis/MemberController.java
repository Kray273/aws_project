package mybatis;

import java.io.File;
import java.io.IOError;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
	@Autowired
	@Qualifier("service")
	MemberService service;
	
	@RequestMapping("/start")
	public String start2() {
		return "mybatis/start";
	}
	
	@GetMapping("/login")
	public String login() {
		return "mybatis/loginform";
	}
	
	@PostMapping("/login")
	public String login2(String id, String pw, HttpSession session) {
		MemberDTO dto = service.onemember(id);
		String view = "";
		if(dto == null) {
			//회원가입 view	
			view = "mybatis/memberinsert";
		} else {
			if(pw.equals(dto.getPw())) {
				// 정상 로그인
				//HttpSession session = request.getSession() 매개변수로 처리
				session.setAttribute("loginid", id);
				view = "mybatis/start";
			}else {
				//암호가 다른 시도
				view = "mybatis/loginform";
			}
		}
		return view;		
	}
	
	@RequestMapping("/mybatismemberlist")
	public ModelAndView memberlist() {
		List<MemberDTO> memberlist = service.memberlist();
		ModelAndView mv = new ModelAndView();
		mv.addObject("memberlist",memberlist);
		mv.setViewName("mybatis/memberlist");
		return mv;
 	}
	
	@GetMapping("/memberinsert")
	public String memberinsert() {
		return "mybatis/memberinsert";
	}
	
	@PostMapping("/memberinsert")
	public ModelAndView memberinsert2(MemberDTO dto) throws IOException {
		//유니크 칼럼으로 인한 오류 해결
		MemberDTO db_dto = service.onemember(dto.getId());
		ModelAndView mv = new ModelAndView();
		if(db_dto == null) {
			MultipartFile imagefile = dto.getImagefile();
			String savePath = "c:/upload/";
			
			String filename1 = imagefile.getOriginalFilename();
			String beforeext1 = filename1.substring(0, filename1.lastIndexOf('.'));
			String ext1 = filename1.substring(filename1.lastIndexOf('.'));
			String newfilename1 = beforeext1 + "(" + UUID.randomUUID().toString() +")" + ext1;
			File serverfile1 = new File(savePath + newfilename1);
			imagefile.transferTo(serverfile1);
			dto.setImage(newfilename1);
			
			//dto 객체 저장된 값( 사용자 값) member테이블 저장
			int result = service.insertmember(dto);
			if(result == 1) {
				mv.addObject("result", "정상회원 가입처리");				
			}else {
				mv.addObject("result", "회원가입 중 오류 발생");				
			}
			// 저장한 결과 리턴 "정상회원 가입처리" 모델로 저장
		} else {
			mv.addObject("result", "이미 사용중인 아이디입니다.");			
		}
		mv.setViewName("mybatis/memberinsert2");
		return mv;	
	}
	
	@RequestMapping("/memberinform")
	public ModelAndView memberinform(HttpSession session){
		ModelAndView mv = new ModelAndView(); 
		// 1.HttpSession 객체의 저장된 loginid 값은 가져와서
		if(session.getAttribute("loginid") == null) {
			mv.setViewName("mybatis/start");
		} else {
			// 2. service.onemember() 호출
			String id = (String)session.getAttribute("loginid");
			MemberDTO dto = service.onemember(id);
			// 3. 모델저장
			mv.addObject("one",dto);
			// 4. mybatis/memberinform 뷰로 전달
			mv.setViewName("mybatis/memberinform");
		}		
		// 5. 뷰에서는 form태그에 미리 정보 출력 submit-내 정보수정
		return mv;
	}
	
	@PostMapping("/memberupdate")
	public ModelAndView memberupdate(MemberDTO dto) {
		ModelAndView mv = new ModelAndView();
		int result = service.updatemember(dto);
		if(result == 1) {
			mv.addObject("result", "정상업데이트 되었습니다.");				
			mv.setViewName("mybatis/start");			
		} else {
			mv.addObject("result", "업데이트 되지 않았습니다.");				
			mv.setViewName("mybatis/start");						
		}
		return mv;	
	}
	
	@GetMapping("/memberdelete")
	public ModelAndView memberdelete(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		String id = (String)session.getAttribute("loginid");
		MemberDTO dto = service.onemember(id);
		mv.addObject("one",dto);
		mv.setViewName("mybatis/memberdelete");
		return mv;
	}
	
	@PostMapping("/memberdelete")
	public ModelAndView memberdelete2(String id, HttpSession session) {
		service.deletemember(id);
		session.removeAttribute("loginid");
		ModelAndView mv = new ModelAndView();
		mv.addObject("result", "삭제되었습니다.");				
		mv.setViewName("mybatis/start");
		return mv;	
	}
	
	@GetMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		if(session.getAttribute("loginid") == null) {
			mv.addObject("result", "로그인이 필요합니다.");				
			mv.setViewName("mybatis/start");
		} else {
			session.removeAttribute("loginid");
			mv.addObject("result", "로그아웃되었습니다.");				
			mv.setViewName("mybatis/start");			
		}
		return mv;
	}
	
	@ResponseBody
	@GetMapping("/othermemberinform")
	public MemberDTO othermemberinform(HttpSession session ,String id) {
		String model = null;
		MemberDTO dto = new MemberDTO();
		if(session.getAttribute("loginid") == null) {
			model = "로그인이 필요합니다.";	
		} else {
			String loginid = (String)session.getAttribute("loginid");
			if(!loginid.equalsIgnoreCase("admin")) {
				model = "회원정보를 볼 권한이 없습니다.";	
			}else {
				//id 정보를 db에서 가져온다.
				dto = service.onemember(id);
			}
		}
		
		dto.setId(model);
		return dto;
	}
	
}
