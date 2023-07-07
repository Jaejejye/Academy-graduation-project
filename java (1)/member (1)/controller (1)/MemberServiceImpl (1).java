package member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import member.bean.MemberDTO;
import member.dao.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDAO dao;
	
	@Override
	public int write(MemberDTO dto) {
		return dao.write(dto);
	}

	@Override
	public String login(String mem_id, String passwd) {
		return dao.login(mem_id, passwd);
	}

	@Override
	public boolean isExistId(String mem_id) {
		return dao.isExistId(mem_id);
	}

	@Override
	public int modify(MemberDTO dto) {
		return dao.modify(dto);
	}

	@Override
	public MemberDTO getMember(String mem_id) {
		return dao.getMember(mem_id);
	}
	
	@Override
	public int buisUpdate(MemberDTO dto) {
		return dao.buisUpdate(dto);
	}

	@Override
	public int delete(String mem_id) {
		return dao.delete(mem_id);
	}

}
