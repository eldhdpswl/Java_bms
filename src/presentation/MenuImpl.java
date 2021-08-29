package presentation;

import java.util.HashMap;
import java.util.Map;

import domain.Book;
import domain.Code;
import service.Guest;
import service.GuestImpl;
import service.Host;
import service.HostImpl;

public class MenuImpl implements Menu,Code {
	
	@Override
	public void commonMenu(int menu) {
		GuestImpl g = GuestImpl.getInstance();
		HostImpl h = HostImpl.getInstance();
		switch(menu) {
			case SHOP_LOGIN:   //로그인
				loginMenu();
				break;
			
			case HOST_MENU:  //주인
				hostMenu();
				break;
			
			case HOST_STOCK_MENU: //재고관리
				hostStockMenu();
				break;
			
			case HOST_BOOK_LIST:  //책목록
				h.bookList();
				break;
			
			case HOST_BOOK_ADD:
				h.bookAdd();//책 추가
				break;
			
			case HOST_BOOK_UPDATE: //책 수정
				h.bookUpdate();
				break;
			
			case HOST_BOOK_DEL: //책 삭제
				h.bookDel();
				break;
			
			case HOST_ORDER_MENU:   ///////////////주문관리
				hostOrderMenu();
				break;
			
			case HOST_ORDER_LIST:  //주문목록
				h.orderList();
				break;
			
			case HOST_ORDER_CONFIRM: //결제승인
				h.orderConfirm();
				break;
			
			case HOST_ORDER_CANCEL: //결제취소
				h.orderCancel();
				break;
			
			case HOST_SALE_TOTAL:  //결산
				h.saleTotal();
				break;
			
			case GUEST_MENU: //손님
				guestmenu();
				break;
			case GUEST_CART_MENU: //////////////장바구니
				guestCartMenu();
			
			case GUEST_CART_LIST:  //장바구니 리스트
				g.cartList();
				break;
			
			case GUEST_CART_ADD:  //장바구니 담기
				g.cartAdd();
				break;
			
			case GUEST_CART_DEL:  //장바구니 삭제
				g.cartDel();
				break; 
			
			case GUEST_NOW_BUY:     //바로구매
				g.cartBuy();
				break;
			
			case GUEST_ORDER_LIST:  //바로구매 목록
				g.nowBuy();
				break;
			
			case GUEST_REFUND:   //환불
				g.refund();
				break;
				
		}
	}
	//메뉴공통
	/*
	 * case SHOW_LOGIN:     //로그인
	 *      loginMenu();
	 *      break;
	 * 
	 * case HOST_MENU:     //관리자 메뉴
	 * 		hostMenu();     
	 * 		break;
	 * 
	 * 		//관리자 제고 관리
	 * 		//관리자 도서 목록
	 * 		//관리자 도서 추가
	 * 		//관리자 도서 수정
	 * 		//관리자 도서 삭제
	 * 
	 * 		//관리자 주문관리
	 * 
	 * 		//관리자 주문목록
	 * 		//관리자 결제승인
	 * 		//관리자 결제취소
	 * 		//관리자 결산
	 * 
	 * 		//고객메뉴
	 * 		//고객 장바구니 목록
	 * 		//고객 장바구니 추가
	 * 		//고객 장바구니 삭제
	 * 		//고객 바로구매
	 * 
	 * 		//고객 장바구니 메뉴
	 *		//고객구매
	 *		//고객환불
	 * 
	 */

	@Override
	public void loginMenu() {  //로그인
		System.out.println("───────────────로그인──────────────");
		System.out.println("1. 고객" + "\t2. 관리자" + "\t3. 회원"+ "\t4. 종료");
		System.out.println("─────────────────────────────────");
		
		while(true) {
			
			System.out.print("메뉴번호를 입력하세요. : ");
			int login = Integer.parseInt(Console.input());
			
			if(login == 1) {
				while(true) {
					System.out.print("고객 ID : ");
					String id = Console.input();
					System.out.print("고객 PW : ");
					String pw = Console.input();
					if(id.equals(Guest.ID)) {
						if(pw.equals(Guest.PASSWORD)) {
							System.out.println("==========================================");
							System.out.println("\t로그인되었습니다.");
							System.out.println("==========================================");
							commonMenu(GUEST_MENU);
							break;
						}else {
							System.out.println("비밀번호가 틀립니다.");
						}
						
					}else {
						System.out.println("아이디가 틀렸습니다.");
					}
				}
			}else if(login == 2) {
				while(true) {
					System.out.print("관리자 ID : ");
					String id = Console.input();
					System.out.print("관리자 PW : ");
					String pw = Console.input();
					if(id.equals(Host.ID)) {
						if(pw.equals(Host.PASSWORD)) {
							System.out.println("==========================================");
							System.out.println("\t로그인되었습니다.");
							System.out.println("==========================================");
							commonMenu(HOST_MENU);
							break;
						} else {
							System.out.println("비밀번호가 틀립니다.");
						}
						
					}else {
						System.out.println("아이디가 틀렸습니다.");
					}
				}
				
			}else if(login == 3) {
				
			}else if(login == 4) {
				System.out.println("시스템 종료!");
				break;
			}else {
				System.out.println("잘못입력하였습니다.");
			}
		
		}
		
	}

	@Override
	public void hostMenu() {  //관리자메뉴
		// TODO Auto-generated method stub
		System.out.println("─────────────────관리자메뉴─────────────────");
		System.out.println("1. 재고관리" + "\t2. 주문관리" + "\t3. 로그아웃");
		System.out.println("─────────────────────────────────────────");
		while(true) {
			System.out.print("메뉴번호를 입력하세요. : ");
			int login = Integer.parseInt(Console.input());
			switch(login) {
				case 1:
					commonMenu(HOST_STOCK_MENU); 
					break;
				case 2:
					commonMenu(HOST_ORDER_MENU);
					break;
				case 3:
					commonMenu(SHOP_LOGIN);
					break;
				default:
					System.out.println("잘못입력하였습니다. 다시입력해주세요");
			}
			
		}
		
	}

	@Override
	public void hostStockMenu() {  //관리자 제고 메뉴(재고관리)
		// TODO Auto-generated method stub
		System.out.println("─────────────────재고관리─────────────────");
		System.out.println("1. 목록" + "\t2. 추가" + "\t3. 수정" + "\t4. 삭제" + "\t5. 이전");
		System.out.println("───────────────────────────────────────");
		while(true) {
			System.out.print("메뉴번호를 입력하세요. : ");
			
			int login = Integer.parseInt(Console.input());
			
			switch(login) {
				case 1:
					commonMenu(HOST_BOOK_LIST);
					commonMenu(HOST_STOCK_MENU);
					break;
				case 2:
					commonMenu(HOST_BOOK_ADD);
					commonMenu(HOST_STOCK_MENU);
					break;
				case 3:
					commonMenu(HOST_BOOK_UPDATE);
					commonMenu(HOST_STOCK_MENU);
					break;
				case 4:
					commonMenu(HOST_BOOK_DEL);
					commonMenu(HOST_STOCK_MENU);
					break;
				case 5:
					commonMenu(HOST_MENU);
					break;
				default:
					System.out.print("잘못입력하셨습니다.");
			}
			
		}
			  
	}
	
	@Override
	public void hostOrderMenu() {  //관리자 주문관리 메뉴
		// TODO Auto-generated method stub
		System.out.println("────────────────── 주문관리────────────────");
		System.out.println("1.주문목록" + "\t2.결제승인" + "\t3.결제취소" + "\t4.결산" + "\t5.이전");
		System.out.println("───────────────────────────────────────");
		while(true) {
			System.out.print("메뉴 번호를 입력하세요. : ");
			int login = Integer.parseInt(Console.input());
			switch(login) {
				case 1:
					commonMenu(HOST_ORDER_LIST);
					commonMenu(HOST_ORDER_MENU);
				case 2:
					commonMenu(HOST_ORDER_CONFIRM);
					commonMenu(HOST_ORDER_MENU);
				case 3:
					commonMenu(HOST_ORDER_CANCEL);
					commonMenu(HOST_ORDER_MENU);
					
				case 4:
					commonMenu(HOST_SALE_TOTAL);
					commonMenu(HOST_ORDER_MENU);
				case 5:
					commonMenu(HOST_MENU);
				default:
					System.out.println("잘못입력하였습니다.");
						
			}
		}
	}

	@Override
	public void guestmenu() { //고객 메뉴
		// TODO Auto-generated method stub
		System.out.println("─────────────────고객메뉴─────────────────");
		System.out.println("1. 장바구니" +"      2. 구매"+ "      3. 환불" + "      4. 로그아웃");
		System.out.println("───────────────────────────────────────");
		while(true){
			System.out.print("메뉴번호를 입력하세요. : ");
			int login = Integer.parseInt(Console.input());
			
			switch(login) {
				case 1:
					commonMenu(GUEST_CART_LIST);
					commonMenu(GUEST_CART_MENU);
					break;
				case 2:
					commonMenu(HOST_BOOK_LIST);
					commonMenu(GUEST_ORDER_LIST);
					commonMenu(GUEST_MENU);
					break;
				case 3:
					commonMenu(GUEST_REFUND);
					commonMenu(GUEST_MENU);
					break;
				case 4:
					commonMenu(SHOP_LOGIN);
					break;
				default:
					System.out.println("잘못입력하였습니다.");
			}
			
		}
	}

	@Override
	public void guestCartMenu() {  //고객 장바구니
		// TODO Auto-generated method stub
		
		while(true) {
			System.out.println("=============== 장바구니 ===============");
			System.out.println("1.추가" + "\t2.삭제" + "\t3.구매" + "\t4.이전");
			System.out.println("=====================================");
			System.out.print("메뉴 번호를 입력하세요. : ");
			int login = Integer.parseInt(Console.input());
			switch(login) {
				case 1:
					commonMenu(HOST_BOOK_LIST);
					commonMenu(GUEST_CART_ADD);
					commonMenu(GUEST_CART_LIST);
					break;
				case 2:
					commonMenu(GUEST_CART_LIST);
					commonMenu(GUEST_CART_DEL);
					commonMenu(GUEST_CART_LIST);
					break;
				case 3:
					commonMenu(GUEST_CART_LIST);
					commonMenu(GUEST_NOW_BUY);
					commonMenu(GUEST_CART_LIST);
					break;
				case 4:
					commonMenu(GUEST_MENU);
					break;
				default:
					System.out.println("잘못입력하였습니다.");
			}
			
		}
		
	}
	
}
