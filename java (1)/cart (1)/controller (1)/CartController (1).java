package cart.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cart.bean.CartDTO;

@Controller
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@RequestMapping(value="/cart/cartAdd.do")
	public ModelAndView addCart(HttpServletRequest request) {

		HttpSession session = request.getSession();
		
		int cart_num = Integer.parseInt(request.getParameter("cart_num"));
		int prod_num = Integer.parseInt(request.getParameter("prod_num"));
		int mem_num = Integer.parseInt(request.getParameter("mem_num"));
		int cart_quan = Integer.parseInt(request.getParameter("cart_quan"));

		CartDTO dto = new CartDTO();
		dto.setCart_num(cart_num);
		dto.setProd_num(prod_num);
		dto.setMem_num(mem_num);
		dto.setCart_quan(cart_quan);
		
		int result = cartService.addCart(dto);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("result",result);
		modelAndView.setViewName("cartAdd.jsp");
		
		return modelAndView;
		
	}

	@RequestMapping(value="/cart/cartList.do")
	public ModelAndView CartList(HttpServletRequest request) {
		// 데이터
		int pg = 1;
		if (request.getParameter("pg") != null) {
			pg = Integer.parseInt(request.getParameter("pg"));
		}
		// 1. 목록보기 : 5개
		int endNum = pg * 5;
		int startNum = endNum - 4;

		//BoardDAO dao = new BoardDAO();
		List<CartDTO> list = cartService.getCartList(startNum, endNum);

		// 2. 페이징 처리
		int totalA = cartService.getTotalA(); // 총글수
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
		modelAndView.setViewName("cartList.jsp");
		
		return modelAndView;
	}
	
	@RequestMapping(value="/cart/cartView.do")
	public ModelAndView cartView(HttpServletRequest request) {
		int cart_num = Integer.parseInt(request.getParameter("cart_num"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		CartDTO dto = cartService.cartView(cart_num);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("cart_num", cart_num);
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("dto", dto);
		modelAndView.setViewName("cartView.jsp");
		
		return modelAndView;
		
	}
	
	@RequestMapping(value="/board/cartDelete.do")
	public ModelAndView boardDelete(HttpServletRequest request) {
		int cart_num = Integer.parseInt(request.getParameter("cart_num"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		
	
		int result = cartService.cartDelete(cart_num);
		
		// 화면 네비게이션
		// ModelAndView : 공유 데이터와 view 처리 파일명을 저장하는 클래스
		// => DispatcherServlet이 리턴받아서 사용함
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("result", result);
		modelAndView.setViewName("cartDelete.jsp");
		return modelAndView;
	}

	
	

	
	
}
