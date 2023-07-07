package notice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import member.bean.MemberDTO;
import member.dao.MemberDAO;
import notice.bean.NoticeDTO;
import notice.dao.NoticeDAO;

@Service
public class NoticeServiceImpl implements NoticeService {
	@Autowired
	private NoticeDAO ndao;
	@Autowired
	private MemberDAO mdao;
	
	@Override
	public int notice_write(NoticeDTO dto) {
		return ndao.notice_write(dto);
	}

	@Override
	public int view_hit(int notice_seq) {
		return ndao.view_hit(notice_seq);
	}

	@Override
	public int notice_modify(NoticeDTO dto) {
		return ndao.notice_modify(dto);
	}

	@Override
	public int notice_delete(int notice_seq) {
		return ndao.notice_delete(notice_seq);
	}

	@Override
	public int get_total() {
		return ndao.get_total();
	}

	@Override
	public NoticeDTO notice_view(int notice_seq) {
		return ndao.notice_view(notice_seq);
	}

	@Override
	public List<NoticeDTO> notice_list(int startNum, int endNum) {
		return ndao.notice_list(startNum, endNum);
	}

	@Override
	public MemberDTO getMember(String id) {
		return mdao.getMember(id);
	}
}
