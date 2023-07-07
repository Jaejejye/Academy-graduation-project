package order.bean;

public class OrderDTO {
    private int order_num;    				// 주문번호
    private String order_date;  			// 주문일
    private String order_zipcode;      		// 우편번호
    private String order_address1;    		// 주소
    private String order_address2;
    private String receiver_name;       	// 수령인 성명
    private String receiver_phone1;     	// 전화번호
    private String receiver_phone2;
    private String receiver_phone3;
    private String receiver_email1;     	// 이메일
    private String receiver_email2;
    private int mem_num;                  	// *회원번호
    private int prod_num;                	// *상품번호
    private String prod_option;				// *상품 옵션
    private int pay_quan;               	// *주문수량
    private int pay_price;                	// *주문금액
    private int coupon_num;              	// *쿠폰번호
    private String buis_name;        		// *사업자명
    private int delive_price;				// *배송비
    private String delive_type;				// *배송유형
	@Override
	public String toString() {
		return "OrderDTO [order_num=" + order_num + ", order_date=" + order_date + ", order_zipcode=" + order_zipcode
				+ ", order_address1=" + order_address1 + ", order_address2=" + order_address2 + ", receiver_name="
				+ receiver_name + ", receiver_phone1=" + receiver_phone1 + ", receiver_phone2=" + receiver_phone2
				+ ", receiver_phone3=" + receiver_phone3 + ", receiver_email1=" + receiver_email1 + ", receiver_email2="
				+ receiver_email2 + ", mem_num=" + mem_num + ", prod_num=" + prod_num + ", prod_option=" + prod_option
				+ ", pay_quan=" + pay_quan + ", pay_price=" + pay_price + ", coupon_num=" + coupon_num + ", buis_name="
				+ buis_name + ", delive_price=" + delive_price + ", delive_type=" + delive_type + "]";
	}
	public OrderDTO(int order_num, String order_date, String order_zipcode, String order_address1,
			String order_address2, String receiver_name, String receiver_phone1, String receiver_phone2,
			String receiver_phone3, String receiver_email1, String receiver_email2, int mem_num, int prod_num,
			String prod_option, int pay_quan, int pay_price, int coupon_num, String buis_name, int delive_price,
			String delive_type) {
		super();
		this.order_num = order_num;
		this.order_date = order_date;
		this.order_zipcode = order_zipcode;
		this.order_address1 = order_address1;
		this.order_address2 = order_address2;
		this.receiver_name = receiver_name;
		this.receiver_phone1 = receiver_phone1;
		this.receiver_phone2 = receiver_phone2;
		this.receiver_phone3 = receiver_phone3;
		this.receiver_email1 = receiver_email1;
		this.receiver_email2 = receiver_email2;
		this.mem_num = mem_num;
		this.prod_num = prod_num;
		this.prod_option = prod_option;
		this.pay_quan = pay_quan;
		this.pay_price = pay_price;
		this.coupon_num = coupon_num;
		this.buis_name = buis_name;
		this.delive_price = delive_price;
		this.delive_type = delive_type;
	}
	public OrderDTO() {
		// TODO Auto-generated constructor stub
	}
	public int getOrder_num() {
		return order_num;
	}
	public void setOrder_num(int order_num) {
		this.order_num = order_num;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	public String getOrder_zipcode() {
		return order_zipcode;
	}
	public void setOrder_zipcode(String order_zipcode) {
		this.order_zipcode = order_zipcode;
	}
	public String getOrder_address1() {
		return order_address1;
	}
	public void setOrder_address1(String order_address1) {
		this.order_address1 = order_address1;
	}
	public String getOrder_address2() {
		return order_address2;
	}
	public void setOrder_address2(String order_address2) {
		this.order_address2 = order_address2;
	}
	public String getReceiver_name() {
		return receiver_name;
	}
	public void setReceiver_name(String receiver_name) {
		this.receiver_name = receiver_name;
	}
	public String getReceiver_phone1() {
		return receiver_phone1;
	}
	public void setReceiver_phone1(String receiver_phone1) {
		this.receiver_phone1 = receiver_phone1;
	}
	public String getReceiver_phone2() {
		return receiver_phone2;
	}
	public void setReceiver_phone2(String receiver_phone2) {
		this.receiver_phone2 = receiver_phone2;
	}
	public String getReceiver_phone3() {
		return receiver_phone3;
	}
	public void setReceiver_phone3(String receiver_phone3) {
		this.receiver_phone3 = receiver_phone3;
	}
	public String getReceiver_email1() {
		return receiver_email1;
	}
	public void setReceiver_email1(String receiver_email1) {
		this.receiver_email1 = receiver_email1;
	}
	public String getReceiver_email2() {
		return receiver_email2;
	}
	public void setReceiver_email2(String receiver_email2) {
		this.receiver_email2 = receiver_email2;
	}
	public int getMem_num() {
		return mem_num;
	}
	public void setMem_num(int mem_num) {
		this.mem_num = mem_num;
	}
	public int getProd_num() {
		return prod_num;
	}
	public void setProd_num(int prod_num) {
		this.prod_num = prod_num;
	}
	public String getProd_option() {
		return prod_option;
	}
	public void setProd_option(String prod_option) {
		this.prod_option = prod_option;
	}
	public int getPay_quan() {
		return pay_quan;
	}
	public void setPay_quan(int pay_quan) {
		this.pay_quan = pay_quan;
	}
	public int getPay_price() {
		return pay_price;
	}
	public void setPay_price(int pay_price) {
		this.pay_price = pay_price;
	}
	public int getCoupon_num() {
		return coupon_num;
	}
	public void setCoupon_num(int coupon_num) {
		this.coupon_num = coupon_num;
	}
	public String getBuis_name() {
		return buis_name;
	}
	public void setBuis_name(String buis_name) {
		this.buis_name = buis_name;
	}
	public int getDelive_price() {
		return delive_price;
	}
	public void setDelive_price(int delive_price) {
		this.delive_price = delive_price;
	}
	public String getDelive_type() {
		return delive_type;
	}
	public void setDelive_type(String delive_type) {
		this.delive_type = delive_type;
	}
    
    
    
    
}
