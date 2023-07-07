package cart.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cart.bean.CartDTO;

@Repository("cartdao")
public class CartDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	//목록보기
	public List<CartDTO> cartList(int startNum, int endNum) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		return sqlSession.selectList("mybatis.cartMapper.cartList", map);
	}
	
	//전체 글수 구하기
	public int getTotalA() {
		return sqlSession.selectOne("mybatis.cartMapper.getTotalA");
	}
	
	// 글저장
	public int cart_write(CartDTO dto) {
		return sqlSession.insert("mybatis.cartMapper.addCart", dto);
	}
	
	// 상세보기
	// 글 1개 보기
	public CartDTO cartView(int cart_num) {
		return sqlSession.selectOne("mybatis.cartMapper.getCart", cart_num);
	}
	
	// 글 삭제
	public int cartDelete(int cart_num) {
		return sqlSession.delete("mybatis.cartMapper.deleteCart", cart_num);
	}
	
	// 수량 수정?
	public int cartModify(int cart_num) {
		return sqlSession.update("mybatis.cartMapper.modifyCount", cart_num);
	}
	
}
