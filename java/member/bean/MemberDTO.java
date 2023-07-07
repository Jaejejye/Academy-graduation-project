package member.bean;

public class MemberDTO {
	// 일반 회원 정보
	private int mem_num; 			// 회원번호
	private String mem_id; 			// ID
	private String mem_name; 		// 이름
	private String passwd; 			// 비밀번호
	private String nickname; 		// 닉네임
	private int mem_auth; 			// 회원등급
	private String email1; 			// 이메일
	private String email2;
	private String phone1; 			// 전화번호
	private String phone2;
	private String phone3;
	private String zipcode; 		// 우편번호
	private String add1; 			// 주소
	private String add2;
	private String profile_image; 	// 프로필 이미지
	private String reg_date; 		// 회원가입일

	// 사업자 회원용 정보
	private int buis_count; 		// 사업자 인덱스
	private int buis_num; 			// 사업자번호
	private String ceo_name; 		// 경영자 이름
	private String buis_name; 		// 사업명
	private String buis_open; 		// 개업일
	private String buis_item; 		// 사업분야
	private String app_state; 		// 승인여부
	
	public int getMem_num() {
		return mem_num;
	}
	public void setMem_num(int mem_num) {
		this.mem_num = mem_num;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getMem_auth() {
		return mem_auth;
	}
	public void setMem_auth(int mem_auth) {
		this.mem_auth = mem_auth;
	}
	public String getEmail1() {
		return email1;
	}
	public void setEmail1(String email1) {
		this.email1 = email1;
	}
	public String getEmail2() {
		return email2;
	}
	public void setEmail2(String email2) {
		this.email2 = email2;
	}
	public String getPhone1() {
		return phone1;
	}
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}
	public String getPhone2() {
		return phone2;
	}
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	public String getPhone3() {
		return phone3;
	}
	public void setPhone3(String phone3) {
		this.phone3 = phone3;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getAdd1() {
		return add1;
	}
	public void setAdd1(String add1) {
		this.add1 = add1;
	}
	public String getAdd2() {
		return add2;
	}
	public void setAdd2(String add2) {
		this.add2 = add2;
	}
	public String getProfile_image() {
		return profile_image;
	}
	public void setProfile_image(String profile_image) {
		this.profile_image = profile_image;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public int getBuis_count() {
		return buis_count;
	}
	public void setBuis_count(int buis_count) {
		this.buis_count = buis_count;
	}
	public int getBuis_num() {
		return buis_num;
	}
	public void setBuis_num(int buis_num) {
		this.buis_num = buis_num;
	}
	public String getCeo_name() {
		return ceo_name;
	}
	public void setCeo_name(String ceo_name) {
		this.ceo_name = ceo_name;
	}
	public String getBuis_name() {
		return buis_name;
	}
	public void setBuis_name(String buis_name) {
		this.buis_name = buis_name;
	}
	public String getBuis_open() {
		return buis_open;
	}
	public void setBuis_open(String buis_open) {
		this.buis_open = buis_open;
	}
	public String getBuis_item() {
		return buis_item;
	}
	public void setBuis_item(String buis_item) {
		this.buis_item = buis_item;
	}
	public String getApp_state() {
		return app_state;
	}
	public void setApp_state(String app_state) {
		this.app_state = app_state;
	}
	
}
