package houseboard.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
import houseboard.bean.HouseboardDTO;

@Controller
public class HouseboardController {
	@Autowired
	HouseboardService hbServ;
	
	@RequestMapping(value="/houseboard/houseboardWriteForm.do")
	public String houseboardWriteForm() {		
		return "../houseboard/houseboardWriteForm.jsp";
	}
	
	@RequestMapping(value="/houseboard/houseboardWrite.do")
	public ModelAndView houseboardWrite(HttpServletRequest request, MultipartFile img) {
		UUID uuid = UUID.randomUUID();
		String filePath = request.getSession().getServletContext().getRealPath("/house_img");
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
		
		int mem_num = -1;
		HttpSession session = request.getSession();
		if(session.getAttribute("mem_id") != null) {
			String mem_id = (String) session.getAttribute("mem_id");
			MemberDTO memdto = hbServ.getMember(mem_id);
			mem_num = memdto.getMem_num();
		}
		
		String house_type = request.getParameter("house_type");
		int house_area = Integer.parseInt(request.getParameter("house_area"));
		String house_style = request.getParameter("house_style");
		String house_title = request.getParameter("house_title");
		String house_content = request.getParameter("house_content");
		String house_img = savedName;
		
		HouseboardDTO dto = new HouseboardDTO();
		dto.setHouse_type(house_type);
		dto.setHouse_area(house_area);
		dto.setHouse_style(house_style);
		dto.setHouse_title(house_title);
		dto.setHouse_content(house_content);
		dto.setHouse_img(house_img);
		dto.setMem_num(mem_num);
		
		int result = hbServ.hb_write(dto);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("result", result);
		modelAndView.setViewName("../houseboard/houseboardWrite.jsp");
		
		return modelAndView;
	}
	
	@RequestMapping(value="/houseboard/houseboardList.do")
	public ModelAndView houseboardList(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String mem_id = (String) session.getAttribute("mem_id");
		
		int pg = 1;
		if (request.getParameter("pg") != null) {
			pg = Integer.parseInt(request.getParameter("pg"));
		}
		int endNum = pg * 10;
		int startNum = endNum - 9;
		
		List<HouseboardDTO> list = hbServ.hb_list(startNum, endNum);
		int totalA = hbServ.get_total();
		
		int totalP = (totalA + 9) / 10;
		
		int startPage = (pg - 1) / 5 * 5 + 1;
		int endPage = startPage + 4;
		if(endPage > totalP) endPage = totalP;
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("../houseboard/houseboardList.jsp");
		modelAndView.addObject("mem_id", mem_id);
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("list", list);
		modelAndView.addObject("totalP", totalP);
		modelAndView.addObject("startPage", startPage);
		modelAndView.addObject("endPage", endPage);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/houseboard/houseboardView.do")
	public ModelAndView houseboardView(HttpServletRequest request) {
		int mem_num = -1;
		int mem_auth = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("mem_id") != null) {
			String mem_id = (String) session.getAttribute("mem_id");
			MemberDTO memdto = hbServ.getMember(mem_id);
			mem_num = memdto.getMem_num();
			mem_auth = memdto.getMem_auth();
		}
		
		int hnum = Integer.parseInt(request.getParameter("hnum"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		hbServ.hb_hitup(hnum);
		HouseboardDTO dto = hbServ.hb_view(hnum);
		int writer_num = dto.getMem_num();
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("mem_num", mem_num);
		modelAndView.addObject("writer_num", writer_num);
		modelAndView.addObject("mem_auth", mem_auth);
		modelAndView.addObject("hnum", hnum);
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("dto", dto);
		
		modelAndView.setViewName("../houseboard/houseboardView.jsp");
		
		return modelAndView;
	}
	
	@RequestMapping(value="/houseboard/houseboardDelete.do")
	public ModelAndView houseboardDelete(HttpServletRequest request) {
		int hnum = Integer.parseInt(request.getParameter("hnum"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		HouseboardDTO dto = hbServ.hb_view(hnum);
		String filePath = request.getSession().getServletContext().getRealPath("/house_img");
		String fileName = dto.getHouse_img();
		File image = new File(filePath + "/" + fileName);
		if(image.isFile()) {
			image.delete();
		}		
		
		int result = hbServ.hb_delete(hnum);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("hnum", hnum);
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("result", result);
		
		modelAndView.setViewName("../houseboard/houseboardDelete.jsp");
		
		return modelAndView;
	}
	
	@RequestMapping(value="/houseboard/houseboardModifyForm.do")
	public ModelAndView houseboardModifyForm(HttpServletRequest request) {
		int hnum = Integer.parseInt(request.getParameter("hnum"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		HouseboardDTO dto = hbServ.hb_view(hnum);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("hnum", hnum);
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("dto", dto);
		modelAndView.setViewName("../houseboard/houseboardModifyForm.jsp");
		
		return modelAndView;
	}
	
	@RequestMapping(value="/houseboard/houseboardModify.do")
	public ModelAndView houseboardModify(HttpServletRequest request, MultipartFile img) {
		UUID uuid = UUID.randomUUID();
		int hnum = Integer.parseInt(request.getParameter("hnum"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		String filePath = request.getSession().getServletContext().getRealPath("/house_img");
		String img_org = request.getParameter("img_org");
		String fileName = null;
		String savedName = null;
		File file;
		
		if(!img.isEmpty()) {			
			String fullpath_org = filePath + "/" + img_org;
			File file_org = new File(fullpath_org);
			if(file_org.isFile()) {
				file_org.delete();
			}
			
			fileName = img.getOriginalFilename();
			savedName = uuid.toString() + "_" + fileName;
			file = new File(filePath, savedName);
			
			try {
				FileCopyUtils.copy(img.getInputStream(), new FileOutputStream(file));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		String house_type = request.getParameter("house_type");
		int house_area = Integer.parseInt(request.getParameter("house_area"));
		String house_style = request.getParameter("house_style");
		String house_title = request.getParameter("house_title");
		String house_content = request.getParameter("house_content");
		String house_img = img_org;
		if(fileName != null) {
			house_img = savedName;
		}
		int house_num = hnum;
		
		HouseboardDTO dto = new HouseboardDTO();
		dto.setHouse_type(house_type);
		dto.setHouse_area(house_area);
		dto.setHouse_style(house_style);
		dto.setHouse_title(house_title);
		dto.setHouse_content(house_content);
		dto.setHouse_img(house_img);
		dto.setHouse_num(house_num);
		
		int result = hbServ.hb_modify(dto);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("hnum", hnum);
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("result", result);
		modelAndView.setViewName("../houseboard/houseboardModify.jsp");
		
		return modelAndView;
	}
}
