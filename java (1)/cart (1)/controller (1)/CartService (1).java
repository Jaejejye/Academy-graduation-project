package cart.controller;

import java.util.List;

import cart.bean.CartDTO;

public interface CartService {
	public int addCart(CartDTO dto);
	
	public List<CartDTO> getCartList(int startNum, int endNum);
	
	public int getTotalA();
	
	public CartDTO cartView(int cart_num);
	
	public int cartDelete(int cart_num);
	
	public int cartModify(int cart_num);
}
