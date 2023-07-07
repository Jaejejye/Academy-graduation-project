package product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import product.bean.ProductDTO;
import product.dao.ProductDAO;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductDAO dao;
	
	@Override
	public int getTotalA() {
		return dao.getTotalA();
	}

	@Override
	public int board_write(ProductDTO dto) {
		return dao.product_write(dto);
	}

	@Override
	public ProductDTO productView(int prod_num) {
		return dao.boardView(prod_num);
	}

	@Override
	public int view_hit(int prod_num) {
		return dao.view_hit(prod_num);
	}

	@Override
	public int productDelete(int prod_num) {
		return dao.productDelete(prod_num);
	}

	@Override
	public List<ProductDTO> productList(int strartNum, int endNum) {
		return dao.productList(strartNum, endNum);
	}
	

}
