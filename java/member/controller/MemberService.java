package member.controller;

import java.util.List;

import member.bean.MemberDTO;

public interface MemberService {
	public int write(MemberDTO dto);
	public String login(String mem_id, String passwd);
	public boolean isExistId(String mem_id);
	public int modify(MemberDTO dto);
	public MemberDTO getMember(String mem_id);
	public int buisUpdate(MemberDTO dto);
	public int delete(String mem_id);
}
