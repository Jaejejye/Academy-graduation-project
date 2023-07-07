package notice.controller;

import java.util.List;

import member.bean.MemberDTO;
import notice.bean.NoticeDTO;

public interface NoticeService {
	public MemberDTO getMember(String id);
	public int notice_write(NoticeDTO dto);
	public int view_hit(int notice_seq);
	public int notice_modify(NoticeDTO dto);
	public int notice_delete(int notice_seq);
	public int get_total();
	public NoticeDTO notice_view(int notice_seq);
	public List<NoticeDTO> notice_list(int startNum, int endNum);
}
