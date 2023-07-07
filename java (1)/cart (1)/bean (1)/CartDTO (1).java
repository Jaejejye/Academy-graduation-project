package cart.bean;

public class CartDTO {

    private int cart_num;	// 장바구니 번호
    private int mem_num;	//회원번호
    private int prod_num;	// 상품번호
    private int cart_quan; 	// 장바구니에 담긴 상품 갯수
    
    // 상품 
    private String prod_name;	// 상품명
    private int prod_price; 	// 상품가격
    
    // 추가
    private int totalPrice;		// 총 가격

	public int getCart_num() {
		return cart_num;
	}

	public void setCart_num(int cart_num) {
		this.cart_num = cart_num;
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

	public int getCart_quan() {
		return cart_quan;
	}

	public void setCart_quan(int cart_quan) {
		this.cart_quan = cart_quan;
	}

	public String getProd_name() {
		return prod_name;
	}

	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}

	public int getProd_price() {
		return prod_price;
	}

	public void setProd_price(int prod_price) {
		this.prod_price = prod_price;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void initSaleTotal() {
		this.totalPrice = this.prod_price * this.cart_quan;
		
	}
	
	@Override
	public String toString() {
		return "CartDTO [cart_num=" + cart_num + ", mem_num=" + mem_num + ", prod_num=" + prod_num + ", cart_quan="
				+ cart_quan + ", prod_name=" + prod_name + ", prod_price=" + prod_price + ", totalPrice=" + totalPrice
				+ "]";
	}
    
    
    
}
