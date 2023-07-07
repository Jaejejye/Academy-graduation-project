package member.dao;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import member.bean.MemberDTO;

@Repository("memberdao")
public class MemberDAO {
	
	@Autowired
	SqlSessionTemplate sqlSession;

	// SQL
	// insert - 회원 등록
	public int write(MemberDTO dto) {
		return sqlSession.insert("mybatis.memberMapper.write", dto);
	}

	// 로그인
	public String login(String mem_id, String passwd) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("mem_id", mem_id);
		map.put("passwd", passwd);
		return sqlSession.selectOne("mybatis.memberMapper.login", map);
	}

	// id 검사
	public boolean isExistId(String mem_id) {
		boolean exist = false;
		if (sqlSession.selectOne("mybatis.memberMapper.isExistId", mem_id) != null) {
			exist = true;
		}
		return exist;
	}

	// 개인정보 수정
	public int modify(MemberDTO dto) {
		return sqlSession.update("mybatis.memberMapper.modify", dto);
	}

	// 회원1명의 정보 읽어오기 - 개인정보 보기
	public MemberDTO getMember(String mem_id) {
		return sqlSession.selectOne("mybatis.memberMapper.getMember", mem_id);
	}

	// buisUpdate - 사업자회원 등록
	public int buisUpdate(MemberDTO dto) {
		return sqlSession.update("mybatis.memberMapper.buisUpdate", dto);
	}

	// 회원탈퇴 (삭제)
	public int delete(String mem_id) {
		return sqlSession.delete("mybatis.memberMapper.delete", mem_id);
	}
}
