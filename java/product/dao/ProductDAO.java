package product.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import product.bean.ProductDTO;

@Repository("productdao")
public class ProductDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;

	// 목록 보기
	public List<ProductDTO> productList(int startNum, int endNum) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		return sqlSession.selectList("mybatis.productMapper.ProductList", map);

	}

	// 전체 글수 구하기
	public int getTotalA() {
		return sqlSession.selectOne("mybatis.productMapper.getTotalA");
	}

	// 글저장
	public int product_write(ProductDTO dto) {
		return sqlSession.insert("mybatis.productMapper.product_write", dto);
	}

	// 상세보기
	// 글 1개 보기
	public ProductDTO boardView(int prod_num) {
		return sqlSession.selectOne("mybatis.productMapper.productView", prod_num);
	}

	// 조회수 증가시키기
	public int view_hit(int prod_num) {
		return sqlSession.update("mybatis.boardMapper.view_hit", prod_num);
	}

	// 글 삭제
	public int productDelete(int prod_num) {
		return sqlSession.delete("mybatis.productMapper.productDelete", prod_num);
	}
}
