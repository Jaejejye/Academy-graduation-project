package scrap.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import scrap.bean.ScrapDTO;

@Repository
public class ScrapDAO {
	@Autowired
	SqlSessionTemplate sqlSession;
	
	// insert
	public int scrap_in(ScrapDTO dto) {
		return sqlSession.insert("mybatis.scrapMapper.scrap_in", dto);
	}
	
	// scrap 개수
	public int scrap_total() {
		return sqlSession.selectOne("mybatis.scrapMapper.scrap_total");
	}
	
	// list
	public List<ScrapDTO> scrap_list(int startNum, int endNum, int mem_num) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		map.put("mem_num", mem_num);
		
		return sqlSession.selectList("mybatis.scrapMapper.scrap_list", map);
	}
	
	// delete
	public int scrap_out(int scrap_num) {
		return sqlSession.delete("mybatis.scrapMapper.scrap_out", scrap_num);
	}
}
