package member.controller;

import member.bean.MemberDTO;

public interface MemberService {
	public int write(MemberDTO dto);
	public String login(String id, String pwd);
	public boolean isExistId(String id);
	public int modify(MemberDTO dto);
	public MemberDTO getMember(String id);
	public int buisUpdate(MemberDTO dto);
	public int delete(String id);
}
