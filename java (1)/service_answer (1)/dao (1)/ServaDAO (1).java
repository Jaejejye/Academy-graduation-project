package service_answer.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import service_answer.bean.ServaDTO;

@Repository("servadao")
public class ServaDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;
	private String mapper = "mybatis.servaMapper.";
	
	public int serva_write(ServaDTO dto) {
		return sqlSession.insert(mapper + "serva_write", dto);
	};
	public int serva_modify(ServaDTO dto) {
		return sqlSession.update(mapper + "serva_modify", dto);
	}
	public int serva_delete(int answer_seq) {
		return sqlSession.delete(mapper + "serva_delete", answer_seq);
	}
	public List<ServaDTO> serva_view(int question_seq) {
		return sqlSession.selectList(mapper + "serva_view", question_seq);
	}
	public ServaDTO serva_view_one(int answer_seq) {
		return sqlSession.selectOne(mapper + "serva_view_one", answer_seq);
	}
	public int serva_exist(int question_seq) {
		return sqlSession.selectOne(mapper + "serva_exist", question_seq);
	}
}
