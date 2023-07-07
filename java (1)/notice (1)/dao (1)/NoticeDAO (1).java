package notice.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import notice.bean.NoticeDTO;

@Repository("noticedao")
public class NoticeDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;
	private String mapper = "mybatis.noticeMapper.";
	
	public int notice_write(NoticeDTO dto) {
		return sqlSession.insert(mapper + "notice_write", dto);
	}
	
	public int view_hit(int notice_seq) {
		return sqlSession.update(mapper + "view_hit", notice_seq);
	}
	
	public int notice_modify(NoticeDTO dto) {
		return sqlSession.update(mapper + "notice_modify", dto);
	}
	
	public int notice_delete(int notice_seq) {
		return sqlSession.delete(mapper + "notice_delete", notice_seq);
	}
	
	public int get_total() {
		return sqlSession.selectOne(mapper + "get_total");
	}
	
	public NoticeDTO notice_view(int notice_seq) {
		return sqlSession.selectOne(mapper + "notice_view", notice_seq);
	}
	
	public List<NoticeDTO> notice_list(int startNum, int endNum) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		return sqlSession.selectList(mapper + "notice_list", map);
	}
}
