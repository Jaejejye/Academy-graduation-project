package order.controller;

import java.util.List;

import order.bean.OrderDTO;

public interface OrderService {
	public List<OrderDTO> orderList(int startNum, int endNum); 
	public int getTotalA();
	public int orderWrite(OrderDTO dto);
	public OrderDTO orderView(int order_num);
	public int orderDelete(int order_num);
}
