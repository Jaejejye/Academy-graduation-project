package houseboard.controller;

import java.util.List;

import houseboard.bean.HouseboardDTO;
import member.bean.MemberDTO;

public interface HouseboardService {
	public int hb_write(HouseboardDTO dto);
	public int hb_modify(HouseboardDTO dto);
	public int hb_hitup(int house_num);
	public int hb_delete(int house_num);
	public List<HouseboardDTO> hb_list(int startNum, int endNum);
	public int get_total();
	public HouseboardDTO hb_view(int house_num);
	public MemberDTO getMember(String id);
}
