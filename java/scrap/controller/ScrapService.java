package scrap.controller;

import java.util.List;

import member.bean.MemberDTO;
import scrap.bean.ScrapDTO;

public interface ScrapService {
	// 멤버
	MemberDTO getMember(String id);
	// houseboard 글번호 처리 부탁드립니다.
	// houseboard -> house_num
	public int scrap_in(ScrapDTO dto);
	public int scrap_out(int scrap_num);
	public int scrap_total();
	public List<ScrapDTO> scrap_list(int startNum, int endNum, int mem_num);
}
