package product.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import product.bean.ProductDTO;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@RequestMapping (value="/product/ProductWriteForm.do")
	public String ProductWriteForm () {
		return "ProductWriteForm.jsp";
		
	}
	
	@RequestMapping (value="/product/ProductWrite.do")
	public ModelAndView ProductWrite(HttpServletRequest request, MultipartFile img) {
		String filePath = request.getSession().getServletContext().getRealPath("/product_image");
		String fileName = img.getOriginalFilename();
		
		File file = new File(filePath, fileName);
		// jsp에서 MultipartRequest가 자동으로 저장시키지만, 여기서는 수동으로 저장시킴
		try {
			FileCopyUtils.copy(img.getInputStream(), new FileOutputStream(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		ProductDTO dto= new ProductDTO();
		dto.setProd_num(Integer.getInteger("Prod_num"));
		dto.setProd_name(request.getParameter("Prod_name"));
		dto.setProd_price(Integer.getInteger("Prod_price"));
		dto.setDelive_price(request.getParameter("Delive_price"));
		dto.setDelive_type(request.getParameter("Delive_type"));
		dto.setProd_option1(request.getParameter("Prod_option1"));
		dto.setProd_option2(request.getParameter("Prod_option2"));
		dto.setProd_content(request.getParameter("Prod_content"));
		dto.setProd_img(request.getParameter("Prod_img"));
		dto.setProd_filename(request.getParameter("Prod_filename"));
		dto.setThumbnail_img(request.getParameter("Thumbnail_imge"));
		dto.setThumbnail_filename(request.getParameter("Thumbnail_filename"));
		dto.setProd_quan(Integer.getInteger("Prod_quan"));
		dto.setAdd_product(request.getParameter("Add_product"));
		dto.setProd_reg_date(request.getParameter("Prod_reg_date"));
		dto.setProd_keyword(request.getParameter("Prod_keyword"));
		dto.setMem_num(Integer.getInteger("Mem_num"));
		dto.setProd_cate(request.getParameter("Prod_cate"));
		dto.setProd_option3(request.getParameter("Prod_option3"));
		dto.setProd_option4(request.getParameter("Prod_option4"));
		dto.setProd_option5(request.getParameter("Prod_option5"));
		dto.setProd_option6(request.getParameter("Prod_option6"));
		dto.setProd_option7(request.getParameter("Prod_option7"));
		dto.setProd_option8(request.getParameter("Prod_option8"));
		dto.setProd_option9(request.getParameter("Prod_option9"));
		dto.setProd_option10(request.getParameter("Prod_option10"));
		
		
		
		
		
		// 화면 네비게이션
				ModelAndView modelAndView = new ModelAndView();
				modelAndView.addObject("dto", dto);
				modelAndView.setViewName("ProductWrite.jsp");	
				return modelAndView;
	}
	
	@RequestMapping(value="/product/ProductList.do")
	public ModelAndView boardList(HttpServletRequest request) {
		// 데이터
		int pg = 1;
		if (request.getParameter("pg") != null) {
			pg = Integer.parseInt(request.getParameter("pg"));
		}
		// 1. 목록보기 : 5개
		int endNum = pg * 5;
		int startNum = endNum - 4;

		
		List<ProductDTO> list = productService.productList(startNum, endNum);

		// 2. 페이징 처리
		int totalA = productService.getTotalA(); // 총글수
		int totalP = (totalA + 4) / 5; // 총 페이지수

		// 블럭 설정 : 3블럭
		int startPage = (pg - 1) / 3 * 3 + 1;
		int endPage = startPage + 2;
		if (endPage > totalP)
			endPage = totalP;
		
		// 3. 화면 네비게이션 = 데이터 공유 + view 처리 파일명 선택
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("list", list);
		modelAndView.addObject("totalP", totalP);
		modelAndView.addObject("startPage", startPage);
		modelAndView.addObject("endPage", endPage);
		modelAndView.setViewName("ProductList.jsp");
		
		return modelAndView;
	}
	
	@RequestMapping(value="/product/ProductView.do")
	public ModelAndView boardView(HttpServletRequest request) {
		int seq = Integer.parseInt(request.getParameter("Prod_num"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		   
		
		productService.view_hit(seq);					// 조회수 증가시키기
		ProductDTO dto = productService.productView(seq);	// 상세보기 
		
		// 화면 네비게이션 = 데이터 공유 + view 처리 파일명 리턴
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("Prod_num", seq);
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("dto", dto);
		modelAndView.setViewName("ProductView.jsp");
		
		return modelAndView;
	}
	
	@RequestMapping(value="/product/ProductDelete.do")
	public ModelAndView boardDelete(HttpServletRequest request) {
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		
		int result = productService.productDelete(seq);
		
		// 화면 네비게이션
		// ModelAndView : 공유 데이터와 view 처리 파일명을 저장하는 클래스
		// => DispatcherServlet이 리턴받아서 사용함
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("result", result);
		modelAndView.setViewName("ProductDelete.jsp");
		return modelAndView;
	}
}
