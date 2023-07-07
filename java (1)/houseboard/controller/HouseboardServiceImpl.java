package houseboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import houseboard.bean.HouseboardDTO;
import houseboard.dao.HouseboardDAO;
import member.bean.MemberDTO;
import member.dao.MemberDAO;

@Service
public class HouseboardServiceImpl implements HouseboardService {
	@Autowired
	private HouseboardDAO hbdao;
	@Autowired
	private MemberDAO mdao;
	
	@Override
	public int hb_write(HouseboardDTO dto) {
		return hbdao.hb_write(dto);
	}

	@Override
	public int hb_modify(HouseboardDTO dto) {
		return hbdao.hb_modify(dto);
	}

	@Override
	public int hb_hitup(int house_num) {
		return hbdao.hb_hitup(house_num);
	}

	@Override
	public int hb_delete(int house_num) {
		return hbdao.hb_delete(house_num);
	}

	@Override
	public List<HouseboardDTO> hb_list(int startNum, int endNum) {
		return hbdao.hb_list(startNum, endNum);
	}

	@Override
	public int get_total() {
		return hbdao.get_total();
	}

	@Override
	public HouseboardDTO hb_view(int house_num) {
		return hbdao.hb_view(house_num);
	}

	@Override
	public MemberDTO getMember(String id) {
		return mdao.getMember(id);
	}
}
