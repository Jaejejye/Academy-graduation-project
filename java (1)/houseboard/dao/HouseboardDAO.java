package houseboard.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import houseboard.bean.HouseboardDTO;

@Repository("hbdao")
public class HouseboardDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;
	private String mapper = "mybatis.houseboardMapper.";
	
	public int hb_write(HouseboardDTO dto) {
		return sqlSession.insert(mapper + "hb_write", dto);
	}
	
	public int hb_modify(HouseboardDTO dto) {
		return sqlSession.update(mapper + "hb_modify", dto);
	}
	
	public int hb_hitup(int house_num) {
		return sqlSession.update(mapper + "hb_hitup", house_num);
	}
	
	public int hb_delete(int house_num) {
		return sqlSession.update(mapper + "hb_delete", house_num);
	}
	
	public List<HouseboardDTO> hb_list(int startNum, int endNum) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		return sqlSession.selectList(mapper + "hb_list", map);
	}
	
	public int get_total() {
		return sqlSession.selectOne(mapper + "get_total");
	}
	
	public HouseboardDTO hb_view(int house_num) {
		return sqlSession.selectOne(mapper + "hb_view", house_num);
	}
}
