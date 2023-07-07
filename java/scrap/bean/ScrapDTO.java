package scrap.bean;

public class ScrapDTO {
	private int scrap_num;			// 스크랩번호
    private int house_num;			// 집들이번호(house_board 글번호)
    private int mem_num;			// 회원번호(member)
    
	public int getScrap_num() {
		return scrap_num;
	}
	public void setScrap_num(int scrap_num) {
		this.scrap_num = scrap_num;
	}
	public int getHouse_num() {
		return house_num;
	}
	public void setHouse_num(int house_num) {
		this.house_num = house_num;
	}
	public int getMem_num() {
		return mem_num;
	}
	public void setMem_num(int mem_num) {
		this.mem_num = mem_num;
	}
    
}
