package order.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import order.bean.OrderDTO;

@Repository("orderdao")
public class OrderDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public List<OrderDTO> orderList(int startNum, int endNum){
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		return sqlSession.selectList("mybatis.orderMapper.orderList", map);
		
	}
	
	public int getTotalA() {
		return sqlSession.selectOne("mybatis.orderMapper.getTotalA");
	}

	public int order_write(OrderDTO dto) {
		return sqlSession.insert("mybatis.orderMapper.orderInsert", dto);
	}
	
	public OrderDTO orderView (int mem_num) {
		return sqlSession.selectOne("mybatis.orderMapper.orderView", mem_num);	
	}
	
	public int orderDelete(int order_num) {
		return sqlSession.delete("mybatis.orderMapper.deleteOrder", order_num);
	}
	

}
