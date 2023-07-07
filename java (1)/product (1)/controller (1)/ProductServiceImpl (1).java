package product.controller;

import java.util.List;

import org.springframework.stereotype.Service;

import product.bean.ProductDTO;

@Service
public class ProductServiceImpl  implements ProductService{

	@Override
	public int getTotalA() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int board_write(ProductDTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ProductDTO productView(int prod_num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int view_hit(int prod_num) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int productDelete(int prod_num) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ProductDTO> productList(int strartNum, int endNum) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
