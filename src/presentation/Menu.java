package presentation;

public interface Menu {
	public void commonMenu(int menu);//메뉴공통
	public void loginMenu();//로그인 메뉴
	public void hostMenu();//관리자 메뉴
	public void hostStockMenu();//관리자 제고 메뉴
	public void hostOrderMenu();//관리자 주문관리 메뉴
	public void guestmenu();//고객 메뉴
	public void guestCartMenu();//고객 장바구니
	
	
}
