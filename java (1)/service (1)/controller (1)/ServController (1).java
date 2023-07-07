package service.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import member.bean.MemberDTO;
import service_answer.bean.ServaDTO;
import service_question.bean.ServqDTO;

@Controller
public class ServController {
	@Autowired
	ServService serServ;
	
	@RequestMapping(value="/service/questionWriteForm.do")
	public String questionWriteForm() {
		return "../service/questionWriteForm.jsp";
	}
	
	@RequestMapping(value="/service/questionWrite.do")
	public ModelAndView questionWrite(HttpServletRequest request, MultipartFile img) {
		UUID uuid = UUID.randomUUID();
		String filePath = request.getSession().getServletContext().getRealPath("/storage");
		String fileName = img.getOriginalFilename();
		String savedName = uuid.toString() + "_" + fileName;
		File file = new File(filePath, savedName);
		
		if(fileName != null) {
			try {
				FileCopyUtils.copy(img.getInputStream(), new FileOutputStream(file));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		HttpSession session = request.getSession();
		String mem_id = (String) session.getAttribute("mem_id");
		MemberDTO memdto = serServ.getMember(mem_id);
		int mem_num = memdto.getMem_num();
		String mem_name = memdto.getMem_name();
		
		String question_type = request.getParameter("question_type");
		String question_subject = request.getParameter("question_subject");
		String question_content = request.getParameter("question_content");
		String question_image = savedName;
		
		ServqDTO dto = new ServqDTO();
		dto.setMem_num(mem_num);
		dto.setMem_name(mem_name);
		dto.setQuestion_type(question_type);
		dto.setQuestion_subject(question_subject);
		dto.setQuestion_content(question_content);
		dto.setQuestion_image(question_image);
		
		int result = serServ.servq_write(dto);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("result", result);
		modelAndView.setViewName("../service/questionWrite.jsp");
		
		return modelAndView;
	}
	
	@RequestMapping(value="/service/serviceList.do")
	public ModelAndView serviceList(HttpServletRequest request) {
		int pg = 1;
		if (request.getParameter("pg") != null) {
			pg = Integer.parseInt(request.getParameter("pg"));
		}
		int endNum = pg * 10;
		int startNum = endNum - 9;
		
		HttpSession session = request.getSession();
		String mem_id = (String) session.getAttribute("mem_id");
		MemberDTO memdto = serServ.getMember(mem_id);
		int mem_num = memdto.getMem_num();
		int mem_auth = memdto.getMem_auth();
		
		List<ServqDTO> list = new ArrayList<ServqDTO>();
		List<String> ex_list = new ArrayList<String>();
		int totalA;
		String a_ex;
		
		if(mem_auth < 3) {
			list = serServ.servq_list_member(mem_num, startNum, endNum);
			totalA = serServ.servq_count_member(mem_num);
		} else {
			list = serServ.servq_list_all(startNum, endNum);
			totalA = serServ.servq_count_all();
		}
		
		for(ServqDTO dto : list) {
			int seq = dto.getQuestion_seq();
			int serva_exist = serServ.serva_exist(seq);
			if(serva_exist == 0) {
				a_ex = "진행중";
			} else {
				a_ex = "답변완료";
			}
			ex_list.add(a_ex);
		}
		
		int totalP = (totalA + 9) / 10;
		
		int startPage = (pg - 1) / 5 * 5 + 1;
		int endPage = startPage + 4;
		if(endPage > totalP) endPage = totalP;
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("mem_auth", mem_auth);
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("list", list);
		modelAndView.addObject("ex_list", ex_list);
		modelAndView.addObject("totalP", totalP);
		modelAndView.addObject("startPage", startPage);
		modelAndView.addObject("endPage", endPage);

		modelAndView.setViewName("../service/serviceList.jsp");		
		
		return modelAndView;
	}
	
	@RequestMapping(value="/service/serviceView.do")
	public ModelAndView serviceView(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String mem_id = (String) session.getAttribute("mem_id");
		MemberDTO memdto = serServ.getMember(mem_id);
		int mem_auth = memdto.getMem_auth();
		
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		ServqDTO qdto = serServ.servq_view(seq);
		List<ServaDTO> a_list = serServ.serva_view(seq);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("mem_auth", mem_auth);
		modelAndView.addObject("seq", seq);
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("qdto", qdto);
		modelAndView.addObject("a_list", a_list);
		
		modelAndView.setViewName("../service/serviceView.jsp");
		
		return modelAndView;
	}
	
	@RequestMapping(value="/service/answerWriteForm.do")
	public ModelAndView answerWriteForm(HttpServletRequest request) {
		int qseq = Integer.parseInt(request.getParameter("qseq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("qseq", qseq);
		modelAndView.addObject("pg", pg);
		
		modelAndView.setViewName("../service/answerWriteForm.jsp");
		
		return modelAndView;
	}
	
	@RequestMapping(value="/service/answerWrite.do")
	public ModelAndView answerWrite(HttpServletRequest request) {
		int question_seq = Integer.parseInt(request.getParameter("question_seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		String answer_content = request.getParameter("answer_content");
		
		ServaDTO adto = new ServaDTO();
		adto.setQuestion_seq(question_seq);
		adto.setAnswer_content(answer_content);
		
		int result = serServ.serva_write(adto);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("result", result);
		modelAndView.addObject("seq", question_seq);
		modelAndView.addObject("pg", pg);
		
		modelAndView.setViewName("../service/answerWrite.jsp");
		
		return modelAndView;
	}
	
	@RequestMapping(value="/service/answerModifyForm.do")
	public ModelAndView answerModifyForm(HttpServletRequest request) {
		int qseq = Integer.parseInt(request.getParameter("qseq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		int aseq = Integer.parseInt(request.getParameter("aseq"));
		
		ServaDTO dto = serServ.serva_view_one(aseq);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("dto", dto);
		modelAndView.addObject("qseq", qseq);
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("aseq", aseq);
		
		modelAndView.setViewName("../service/answerModifyForm.jsp");
		
		return modelAndView;
	}
	
	@RequestMapping(value="/service/answerModify.do")
	public ModelAndView answerModify(HttpServletRequest request) {
		int question_seq = Integer.parseInt(request.getParameter("question_seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		int answer_seq = Integer.parseInt(request.getParameter("answer_seq"));
		String answer_content = request.getParameter("answer_content");
		
		ServaDTO adto = new ServaDTO();
		adto.setAnswer_seq(answer_seq);
		adto.setAnswer_content(answer_content);
		
		int result = serServ.serva_modify(adto);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("result", result);
		modelAndView.addObject("seq", question_seq);
		modelAndView.addObject("pg", pg);
		
		modelAndView.setViewName("../service/answerModify.jsp");
		
		return modelAndView;
	}
	
	@RequestMapping(value="/service/answerDelete.do")
	public ModelAndView answerDelete(HttpServletRequest request) {
		int qseq = Integer.parseInt(request.getParameter("qseq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		int aseq = Integer.parseInt(request.getParameter("aseq"));
		
		int result = serServ.serva_delete(aseq);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("result", result);
		modelAndView.addObject("seq", qseq);
		modelAndView.addObject("pg", pg);
		
		return modelAndView;
	}
}
