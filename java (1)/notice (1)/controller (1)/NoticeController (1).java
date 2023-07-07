package notice.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import member.bean.MemberDTO;
import notice.bean.NoticeDTO;

@Controller
public class NoticeController {
	@Autowired
	NoticeService nServ;
	
	@RequestMapping(value="/notice/noticeWriteForm.do")
	public String noticeWriteForm() {		
		return "../notice/noticeWriteForm.jsp";
	}
	
	@RequestMapping(value="/notice/noticeWrite.do")
	public ModelAndView noticeWrite(HttpServletRequest request) {
		String notice_subject = request.getParameter("notice_subject");
		String notice_content = request.getParameter("notice_content");
		
		NoticeDTO dto = new NoticeDTO();
		dto.setNotice_subject(notice_subject);
		dto.setNotice_content(notice_content);
		
		int result = nServ.notice_write(dto);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("result", result);
		
		modelAndView.setViewName("../notice/noticeWrite.jsp");
		
		return modelAndView;
	}
	
	@RequestMapping(value="/notice/noticeList.do")
	public ModelAndView noticeList(HttpServletRequest request) {
		int mem_auth = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("mem_id") != null) {
			String mem_id = (String) session.getAttribute("mem_id");
			MemberDTO memdto = nServ.getMember(mem_id);
			mem_auth = memdto.getMem_auth();
		}
		
		int pg = 1;
		if (request.getParameter("pg") != null) {
			pg = Integer.parseInt(request.getParameter("pg"));
		}
		// 1. 목록보기 : 10개
		int endNum = pg * 10;
		int startNum = endNum - 9;

		List<NoticeDTO> list = nServ.notice_list(startNum, endNum);

		// 2. 페이징 처리
		int totalA = nServ.get_total(); // 총글수
		int totalP = (totalA + 9) / 10; // 총 페이지수

		// 2) 블럭 설정 : 5블럭
		int startPage = (pg - 1) / 5 * 5 + 1;
		int endPage = startPage + 4;
		if(endPage > totalP) endPage = totalP;

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("list", list);
		modelAndView.addObject("totalP", totalP);
		modelAndView.addObject("startPage", startPage);
		modelAndView.addObject("endPage", endPage);
		modelAndView.addObject("mem_auth", mem_auth);

		modelAndView.setViewName("../notice/noticeList.jsp");
		
		return modelAndView;
	}
	
	@RequestMapping(value="/notice/noticeView.do")
	public ModelAndView noticeView(HttpServletRequest request) {
		int mem_auth = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("mem_id") != null) {
			String mem_id = (String) session.getAttribute("mem_id");
			MemberDTO memdto = nServ.getMember(mem_id);
			mem_auth = memdto.getMem_auth();
		}
		
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		nServ.view_hit(seq);
		NoticeDTO dto = nServ.notice_view(seq);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("seq", seq);
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("dto", dto);
		modelAndView.addObject("mem_auth", mem_auth);
		
		modelAndView.setViewName("../notice/noticeView.jsp");
		
		return modelAndView;
	}
	
	@RequestMapping(value="/notice/noticeDelete.do")
	public ModelAndView noticeDelete(HttpServletRequest request) {
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
				
		int result = nServ.notice_delete(seq);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("seq", seq);
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("result", result);
		
		modelAndView.setViewName("../notice/noticeDelete.jsp");
		
		return modelAndView;
	}
	
	@RequestMapping(value="/notice/noticeModifyForm.do")
	public ModelAndView noticeModifyForm(HttpServletRequest request) {
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		NoticeDTO dto = nServ.notice_view(seq);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("seq", seq);
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("dto", dto);
		modelAndView.setViewName("../notice/noticeModifyForm.jsp");
		
		return modelAndView;
	}
	
	@RequestMapping(value="/notice/noticeModify.do")
	public ModelAndView noticeModify(HttpServletRequest request) {
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		String notice_subject = request.getParameter("notice_subject");
		String notice_content = request.getParameter("notice_content");
		
		NoticeDTO dto = new NoticeDTO();
		dto.setNotice_seq(seq);
		dto.setNotice_subject(notice_subject);
		dto.setNotice_content(notice_content);		
		
		int result = nServ.notice_modify(dto);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("seq", seq);
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("result", result);
		
		modelAndView.setViewName("../notice/noticeModify.jsp");
		
		return modelAndView;
	}
}
