package scrap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import member.bean.MemberDTO;
import member.dao.MemberDAO;
import scrap.bean.ScrapDTO;
import scrap.dao.ScrapDAO;

@Service
public class ScrapServiceImpl implements ScrapService {
	@Autowired
	private ScrapDAO sdao;
	@Autowired
	private MemberDAO mdao;
/*	@Autowired
 	private houseboard DAO 지정해주세요;	
*/
	
	@Override
	public int scrap_in(ScrapDTO dto) {
		return sdao.scrap_in(dto);
	}
	
	@Override
	public int scrap_out(int scrap_num) {
		return sdao.scrap_out(scrap_num);
	}
	
	@Override
	public int scrap_total() {
		return sdao.scrap_total();
	}
	
	@Override
	public List<ScrapDTO> scrap_list(int startNum, int endNum, int mem_num) {
		return sdao.scrap_list(startNum, endNum, mem_num);
	}
	
	@Override
	public MemberDTO getMember(String id) {
		return mdao.getMember(id);
	}
	
/*	@Override
 *  public houseboard dto ~~ {
 *  	return ~
 *  }
 */
	
}
