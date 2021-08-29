package domain;

public interface Code {
	public static final int SHOP_LOGIN = 999; //로그인
	public static final int SHOP_LOGOUT = 998; //로그아웃
	
	public static final int HOST_MENU = 100; // 100 주인
	public static final int HOST_STOCK_MENU = 110;//재고관리
	public static final int HOST_BOOK_LIST = 111; //책목록
	public static final int HOST_BOOK_ADD = 112; //책 추가
	public static final int HOST_BOOK_UPDATE = 113; //책 수정
	public static final int HOST_BOOK_DEL = 114; //책 삭제
	public static final int HOST_ORDER_MENU=120; //////주문관리
	public static final int HOST_ORDER_LIST = 121;  //주문목록 121
	public static final int HOST_ORDER_CONFIRM = 122;//결제승인
	public static final int HOST_ORDER_CANCEL = 123;//결제취소
	public static final int HOST_SALE_TOTAL = 124; //결산
	
	
	//손님
	public static final int GUEST_MENU = 200;
	public static final int GUEST_CART_MENU=210;  //////장바구니
	
	public static final int GUEST_CART_LIST = 211; //장바구니 리스트
	public static final int GUEST_CART_ADD = 212; //////장바구니 담기
	public static final int GUEST_CART_DEL = 213; //장바구니 삭제
	public static final int GUEST_CART_BUY = 214; //구매
	
	public static final int GUEST_NOW_BUY = 220; //바로구매
	public static final int GUEST_ORDER_LIST = 221; //바로구매 목록
	
	public static final int GUEST_REFUND = 230; //환불
	
	
}
