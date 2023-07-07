package product.controller;



import java.util.List;

import product.bean.ProductDTO;



public interface ProductService {
	public List<ProductDTO> productList(int strartNum, int endNum);
	public int getTotalA();
	public int board_write(ProductDTO dto);
	public ProductDTO productView(int prod_num);
	public int view_hit(int prod_num);
	public int productDelete(int prod_num);
}
	
