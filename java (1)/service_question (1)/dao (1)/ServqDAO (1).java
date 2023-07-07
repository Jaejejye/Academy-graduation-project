package service_question.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import service_question.bean.ServqDTO;

@Repository("servqdao")
public class ServqDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;
	private String mapper = "mybatis.servqMapper.";
	
	public int servq_write(ServqDTO dto) {
		return sqlSession.insert(mapper + "servq_write", dto);
	}
	
	public int servq_count_member(int mem_num) {
		return sqlSession.selectOne(mapper + "servq_count_member", mem_num);
	}
	public int servq_count_all() {
		return sqlSession.selectOne(mapper + "servq_count_all");
	}
	
	public ServqDTO servq_view(int question_seq) {
		return sqlSession.selectOne(mapper + "servq_view", question_seq);
	}
	
	public List<ServqDTO> servq_list_member(int mem_num, int startNum, int endNum) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("mem_num", mem_num);
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		
		return sqlSession.selectList(mapper + "servq_list_member", map);
	}
	
	public List<ServqDTO> servq_list_all(int startNum, int endNum) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		
		return sqlSession.selectList(mapper + "servq_list_all", map);
	}
}
