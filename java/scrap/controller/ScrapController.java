package scrap.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import member.bean.MemberDTO;
import scrap.bean.ScrapDTO;

@Controller
public class ScrapController {
	@Autowired
	ScrapService scrapService;
	
	@RequestMapping(value="/scrap/scrapBook.do")	// scrapbook 페이지 -> 스크랩 리스트
	public ModelAndView scrap_list(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String mem_id = (String) session.getAttribute("mem_id");
		MemberDTO mdto = scrapService.getMember(mem_id);
		int mem_num = mdto.getMem_num();
		
/*		houseboard dto
 * 		houseboard house_num 
 */
		
		// 페이징
		int pg = 1;
		if (request.getParameter("pg") != null) {
			pg = Integer.parseInt(request.getParameter("pg"));
		}
		
		int endNum = pg * 10;
		int startNum = endNum - 9;
		
		List<ScrapDTO> list = scrapService.scrap_list(startNum, endNum, mem_num);
		int totalA = scrapService.scrap_total();	
		int totalP = (totalA + 9) / 10;
		
		int startPage = (pg - 1) / 5 * 5 + 1;
		int endPage = startPage + 4;
		if(endPage > totalP) endPage = totalP;
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("list", list);
		modelAndView.addObject("totalP", totalP);
		modelAndView.addObject("startPage", startPage);
		modelAndView.addObject("endPage", endPage);
		modelAndView.setViewName("scrapBook.jsp");
		
		return modelAndView;
	}
	
	@RequestMapping(value="/scrap/scrapIn.do")
	public ModelAndView scrap_in(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String mem_id = (String) session.getAttribute("mem_id");
		MemberDTO mdto = scrapService.getMember(mem_id);
		int mem_num = mdto.getMem_num();
//		int house_num = hdto.getHouse_num();	=> house_num ScrapService에서 dto 선언해서 넘겨받아주세요...ㅠ ㅜ
		int scrap_num = Integer.parseInt(request.getParameter("scrap_num"));
		
		ScrapDTO sdto = new ScrapDTO();
		sdto.setScrap_num(scrap_num);
		sdto.setMem_num(mem_num);
//		sdto.setHouse_num(house_num);
		
		int result = scrapService.scrap_in(sdto);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("result", result);
		modelAndView.setViewName("scrapIn.jsp");
		
		return modelAndView;
	}
	
	@RequestMapping(value="/scrap/scrapOut.do")
	public ModelAndView scrap_out(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String mem_id = (String) session.getAttribute("mem_id");
		MemberDTO mdto = scrapService.getMember(mem_id);
		int scrap_num = Integer.parseInt(request.getParameter("scrap_num"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		int result = scrapService.scrap_out(scrap_num);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("result", result);
		modelAndView.addObject("pg", pg);
		modelAndView.setViewName("scrapOut.jsp");
		
		return modelAndView;
	}
 }
