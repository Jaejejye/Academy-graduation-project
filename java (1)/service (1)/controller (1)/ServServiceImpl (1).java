package service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import member.bean.MemberDTO;
import member.dao.MemberDAO;
import service_answer.bean.ServaDTO;
import service_answer.dao.ServaDAO;
import service_question.bean.ServqDTO;
import service_question.dao.ServqDAO;

@Service
public class ServServiceImpl implements ServService {
	@Autowired
	private ServqDAO qdao;
	@Autowired
	private ServaDAO adao;
	@Autowired
	private MemberDAO mdao;
	
	@Override
	public int servq_write(ServqDTO dto) {
		return qdao.servq_write(dto);
	}

	@Override
	public int servq_count_member(int mem_num) {
		return qdao.servq_count_member(mem_num);
	}

	@Override
	public int servq_count_all() {
		return qdao.servq_count_all();
	}

	@Override
	public ServqDTO servq_view(int question_seq) {
		return qdao.servq_view(question_seq);
	}

	@Override
	public List<ServqDTO> servq_list_member(int mem_num, int startNum, int endNum) {
		return qdao.servq_list_member(mem_num, startNum, endNum);
	}

	@Override
	public List<ServqDTO> servq_list_all(int startNum, int endNum) {
		return qdao.servq_list_all(startNum, endNum);
	}

	@Override
	public int serva_write(ServaDTO dto) {
		return adao.serva_write(dto);
	}

	@Override
	public int serva_modify(ServaDTO dto) {
		return adao.serva_modify(dto);
	}

	@Override
	public int serva_delete(int answer_seq) {
		return adao.serva_delete(answer_seq);
	}

	@Override
	public List<ServaDTO> serva_view(int question_seq) {
		return adao.serva_view(question_seq);
	}
	
	@Override
	public ServaDTO serva_view_one(int answer_seq) {
		return adao.serva_view_one(answer_seq);
	}

	@Override
	public int serva_exist(int question_seq) {
		return adao.serva_exist(question_seq);
	}

	@Override
	public MemberDTO getMember(String id) {
		return mdao.getMember(id);
	}
}
