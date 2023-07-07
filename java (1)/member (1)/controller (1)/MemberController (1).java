package member.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import member.bean.MemberDTO;

@Controller
public class MemberController {
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value="/member/loginForm.do")
	public String loginForm() {
		return "../member/loginForm.jsp";
	}
	
	@RequestMapping(value="/member/login.do")
	public ModelAndView login(HttpServletRequest request) {
		// 한글처리 : post 방식일 경우
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		// 데이터 처리
		String mem_id = request.getParameter("mem_id");
		String passwd = request.getParameter("passwd");
		
		// DB 처리
		String inform = memberService.login(mem_id, passwd);
		
		// 화면 네비게이션 = 공유데이터 + view 처리 파일 선택
		ModelAndView modelAndView = new ModelAndView();
		
		if(inform == null) {	// 로그인 실패
			modelAndView.setViewName("../member/loginFail.jsp");
		} else {	// 로그인 성공		
			HttpSession session = request.getSession();
			// 세션 이용
			session.setAttribute("memInform", inform);
			session.setAttribute("mem_id", mem_id);
			modelAndView.setViewName("../member/loginOk.jsp");
		}
		
		return modelAndView;
	}
	
	@RequestMapping(value="/member/logout.do")
	public String logout(HttpServletRequest request) {
		// 세션 삭제
		HttpSession session = request.getSession();
		session.removeAttribute("memInform");
		session.removeAttribute("mem_id");
		
		return "../member/logout.jsp";
	}
	
	@RequestMapping(value="/member/writeForm.do")
	public String writeForm() {
		return "../member/writeForm.jsp";
	}
	
	@RequestMapping(value="/member/write.do")
	public ModelAndView write(HttpServletRequest request, MultipartFile profile_image) {
		// post 방식 한글설정
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		// 데이터 처리
		String mem_name = request.getParameter("mem_name");
		String mem_id = request.getParameter("mem_id");
		String passwd = request.getParameter("passwd");
		String nickname = request.getParameter("nickname");
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");
		String phone3 = request.getParameter("phone3");
		String zipcode = request.getParameter("zipcode");
		String add1 = request.getParameter("add1");
		String add2 = request.getParameter("add2");
		// 프로필 이미지 파일
		String filePath = request.getSession().getServletContext().getRealPath("/profile_img");
		String fileName = profile_image.getOriginalFilename();
		File file = new File(filePath, fileName);
		// 수동 저장
		try {
			FileCopyUtils.copy(profile_image.getInputStream(), new FileOutputStream(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// db 작업 - 데이터
		MemberDTO dto = new MemberDTO();
		dto.setMem_name(mem_name);
		dto.setMem_id(mem_id);
		dto.setPasswd(passwd);
		dto.setNickname(nickname);
		dto.setEmail1(email1);
		dto.setEmail2(email2);
		dto.setPhone1(phone1);
		dto.setPhone2(phone2);
		dto.setPhone3(phone3);
		dto.setZipcode(zipcode);
		dto.setAdd1(add1);
		dto.setAdd2(add2);
		dto.setProfile_image(fileName);
		
		int result = memberService.write(dto);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("result", result);
		modelAndView.setViewName("../member/write.jsp");
		
		return modelAndView;
	}
	
	@RequestMapping(value="/member/checkId.do")
	public ModelAndView checkId(HttpServletRequest request) {
		String mem_id = request.getParameter("mem_id");
		boolean result = memberService.isExistId(mem_id);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("result", result);
		modelAndView.addObject("mem_id", mem_id);
		modelAndView.setViewName("../member/checkId.jsp");
		
		return modelAndView;
	}
	
	@RequestMapping(value="/member/mypage.do")
	public ModelAndView mypage(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String mem_id = (String) session.getAttribute("mem_id");
		
		// => 1명 데이터 가져오기
		MemberDTO dto = memberService.getMember(mem_id);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("dto", dto);
		modelAndView.setViewName("../member/mypage.jsp");
		
		return modelAndView;
	}
	
	@RequestMapping(value="/member/businessForm.do")
	public ModelAndView businessForm(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String mem_id = (String) session.getAttribute("mem_id");
		
		MemberDTO dto = memberService.getMember(mem_id);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("dto", dto);
		modelAndView.setViewName("../member/businessForm.jsp");
		
		return modelAndView;
	}
	
	@RequestMapping(value="/member/business.do")
	public ModelAndView business(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		HttpSession session = request.getSession();
		String mem_id = (String) session.getAttribute("mem_id");
		String buis_num = request.getParameter("buis_num");
		String ceo_name = request.getParameter("ceo_name");
		String buis_name = request.getParameter("buis_name");
		String buis_open = request.getParameter("buis_open");
		String buis_item = request.getParameter("buis_item");
		
		MemberDTO dto = new MemberDTO();
		dto.setMem_id(mem_id);
		dto.setBuis_num(Integer.parseInt(buis_num));
		dto.setCeo_name(ceo_name);
		dto.setBuis_name(buis_name);
		dto.setBuis_open(buis_open);
		dto.setBuis_item(buis_item);
		
		int result = memberService.buisUpdate(dto);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("result", result);
		modelAndView.setViewName("../member/business.jsp");
		
		return modelAndView;
	}
	
	@RequestMapping(value="/member/modifyForm.do")
	public ModelAndView modifyForm(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String mem_id = (String) session.getAttribute("mem_id");
		
		// => 1명 데이터 가져오기
		MemberDTO dto = memberService.getMember(mem_id);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("dto", dto);
		modelAndView.setViewName("../member/modifyForm.jsp");
		
		return modelAndView;
	}
	
	@RequestMapping(value="/member/modify.do")
	public ModelAndView modify(HttpServletRequest request, MultipartFile profile_image) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		HttpSession session = request.getSession();
		String mem_id = (String) session.getAttribute("mem_id");
		String passwd = request.getParameter("passwd");
		String nickname = request.getParameter("nickname");
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");
		String phone3 = request.getParameter("phone3");
		String zipcode = request.getParameter("zipcode");
		String add1 = request.getParameter("add1");
		String add2 = request.getParameter("add2");
		// 프로필 이미지 파일
		String filePath = request.getSession().getServletContext().getRealPath("/profile_img");
		String fileName = profile_image.getOriginalFilename();
		File file = new File(filePath, fileName);
		// 수동 저장
		try {
			FileCopyUtils.copy(profile_image.getInputStream(), new FileOutputStream(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		MemberDTO dto = new MemberDTO();
		dto.setMem_id(mem_id);
		dto.setPasswd(passwd);
		dto.setNickname(nickname);
		dto.setEmail1(email1);
		dto.setEmail2(email2);
		dto.setPhone1(phone1);
		dto.setPhone2(phone2);
		dto.setPhone3(phone3);
		dto.setZipcode(zipcode);
		dto.setAdd1(add1);
		dto.setAdd2(add2);
		dto.setProfile_image(fileName);
		
		int result = memberService.modify(dto);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("result", result);
		modelAndView.setViewName("../member/modify.jsp");
		
		return modelAndView;
	}
	
	@RequestMapping(value="/member/deleteForm.do")
	public ModelAndView deleteForm(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String mem_id = (String) session.getAttribute("mem_id");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("mem_id", mem_id);
		modelAndView.setViewName("../member/deleteForm.jsp");
		
		return modelAndView;
	}
	
	@RequestMapping(value="/member/delete.do")
	public ModelAndView delete(HttpServletRequest request) {
		
		String mem_id = request.getParameter("mem_id");

		int result = memberService.delete(mem_id);
		
		HttpSession session=request.getSession();
		// 세션 삭제
		if(result > 0) {
			session.removeAttribute("memInform");
			session.removeAttribute("mem_id");
		}
		
		ModelAndView modelAndView= new ModelAndView();
		modelAndView.addObject("result",result);
		modelAndView.setViewName("../member/delete.jsp");
		
		return modelAndView;
	}
	
}
