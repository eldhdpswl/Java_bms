package service;

public interface Guest {
	public static final String ID = "guest";
	public static final String PASSWORD = "guest";
	//기능정의
	public void cartList(); //장바구니 목록 - 
	public void cartAdd(); //장바구니 담기
	public void cartDel(); //장바구니 삭제
	public void cartBuy(); //구매
	
	public void nowBuy(); //바로구매
	public void buyList(); //바로구매 목록
	public void refund(); //환불
	
	
}
