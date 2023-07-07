package service.controller;

import java.util.List;

import member.bean.MemberDTO;
import service_answer.bean.ServaDTO;
import service_question.bean.ServqDTO;

public interface ServService {
	//회원정보 처리
	public MemberDTO getMember(String id);
	//질문
	public int servq_write(ServqDTO dto);
	public int servq_count_member(int mem_num);
	public int servq_count_all();	
	public ServqDTO servq_view(int question_seq);
	public List<ServqDTO> servq_list_member(int mem_num, int startNum, int endNum);
	public List<ServqDTO> servq_list_all(int startNum, int endNum);
	//답변
	public int serva_write(ServaDTO dto);
	public int serva_modify(ServaDTO dto);
	public int serva_delete(int answer_seq);
	public List<ServaDTO> serva_view(int question_seq);
	public ServaDTO serva_view_one(int answer_seq);
	public int serva_exist(int question_seq);
}
