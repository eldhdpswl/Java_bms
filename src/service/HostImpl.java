package service;

import java.util.HashMap;
import java.util.Map;

import domain.Book;
import domain.Cart;
import domain.Order;
import domain.Refund;
import domain.Sales;
import domain.Shelf;
import presentation.Console;
import presentation.MenuImpl;

public class HostImpl implements Host {
	// 도서목록
	// 싱글톤
	String title;
	String author;
	int price;
	int count;
	int login;

	public int bookNum;

	private static HostImpl h = new HostImpl();

	public static HostImpl getInstance() {
		return h;
	}

	static int total = 0;

	
	@Override
	public void bookAdd() {  //책등록
		// TODO Auto-generated method stub
		while (true) {
			bookNum = (int) (Math.random() * 2000 + 1000); // 코드를 랜덤으로 booknum에 한번만 받음.
			System.out.println("=============== 도서 등록 ===============");
			System.out.print("책 제목 : ");
			title = Console.input();
			System.out.print("책 저자 : ");
			author = Console.input();
			System.out.print("책 가격 : ");
			price = Integer.parseInt(Console.input());
			System.out.print("책 수량 : ");
			count = Integer.parseInt(Console.input());
			Shelf.map.put(bookNum, new Book(title, author, price, count));

			System.out.println("=====================================");
			System.out.println("\t도서가 등록되었습니다.");
			System.out.println("=====================================");

			
			break;

		}

	}

	@Override
	public void bookList() {    //도서목록불러오기
		// TODO Auto-generated method stub
		System.out.println("=============== 도서 목록 ===============");
		System.out.println("번호" + "\t도서명" + "\t저자" + "\t가격" + "\t수량");
		System.out.println("=====================================");
		/*
		 * for(Map.Entry<Integer, Book> s : Shelf.map.entrySet()) { int key =
		 * s.getKey(); Book value = s.getValue(); System.out.println(s.getKey() + "\t" +
		 * s.getValue()); }
		 */
		for (Map.Entry<Integer, Book> s : Shelf.map.entrySet()) {
			int key = s.getKey();
			Book value = s.getValue();
			System.out.println(s.getKey() + "\t" + s.getValue());
		}

	}

	@Override
	public void bookUpdate() { // 책수정
		// TODO Auto-generated method stub
		while (true) {
			System.out.print("수정하려는 책의 코드를 입력하세요. [이전:0] : ");
			login = Integer.parseInt(Console.input());
			if (Shelf.map.containsKey(login)) {
				System.out.println("=============== 도서 수정 ===============");
				System.out.print("책 제목 : ");
				title = Console.input();
				System.out.print("책 저자 : ");
				author = Console.input();
				System.out.print("책 가격 : ");
				price = Integer.parseInt(Console.input());
				System.out.print("책 수량 : ");
				count = Integer.parseInt(Console.input());
				Shelf.map.put(login, new Book(title, author, price, count));
				
				System.out.println("=====================================");
				System.out.println("\t도서가 수정되었습니다.");
				System.out.println("=====================================");
			
			}else if(login == 0) {
				break;
			}else {
				System.out.println("입력하신 코드가 없습니다.");
			}

		}
	}

	@Override
	public void bookDel() { // 책삭제
		// TODO Auto-generated method stub
		
		while (true) {
			System.out.print("삭제하려는 책의 코드를 입력하세요. [이전:0] : ");
			login = Integer.parseInt(Console.input());
			
			if (Shelf.map.containsKey(login)) {
				Shelf.map.remove(login);
				System.out.println("=============== 도서 수정 ===============");
				System.out.println(login + "번 도서가 삭제되었습니다.");
				System.out.println("=====================================");
			}else if(login == 0) {
				break;
			}else {
				System.out.println("입력하신 코드가 없습니다.");
			}
		}
		
	}

	@Override
	public void saleTotal() { // 결산
		// TODO Auto-generated method stub
		int total=0;
		for(Map.Entry<Integer, Book> z : Sales.sales.entrySet()) {
			
			Book value = z.getValue();
			total += value.getBookPrice()  *  value.getBookCount() ;
			
		}
		System.out.println("결산 : " + total);
		
	}

	@Override
	public void orderList() { // 주문목록
		// TODO Auto-generated method stub
		System.out.println("=============== 구매 요청 목록 ===============");
		System.out.println("번호" + "\t도서명" + "\t저자" + "\t가격" + "\t수량");
		System.out.println("=====================================");
		for (Map.Entry<Integer, Book> a : Order.order.entrySet()) {
			int key = a.getKey();
			Book value = a.getValue();
			System.out.println(key + "\t" + value.toString());
		}
	}

	@Override
	public void orderConfirm() {  //결제승인
		// TODO Auto-generated method stub
		while(true) {
			System.out.print("구매 승인할 코드를 입력하세요. [이전:0] : ");
			int login = Integer.parseInt(Console.input());
			if(Order.order.containsKey(login)) {
				System.out.println("=====================================");
				System.out.println("\t결제 승인 되었습니다.");
				System.out.println("=====================================");
				Sales.sales.put(login,
						new Book(Order.order.get(login).getBookTitle(), Order.order.get(login).getBookAuthor(),
								Order.order.get(login).getBookPrice(), Order.order.get(login).getBookCount()));
				
				//total += Sales.sales.get(login).getBookPrice()  *  Sales.sales.get(login).getBookCount() ;

			}else if(login==0) {
				break;
			}else {
				System.out.println("입력하신 코드가 없습니다.");
			}
			
		}
		
	}
//////////////
	@Override
	public void orderCancel() { // 결제취소
		// TODO Auto-generated method stub
		System.out.println("============ 환불 요청 목록 =============");
		System.out.println("번호" + "\t도서명" + "\t저자" + "\t가격" + "\t수량");
		System.out.println("======================================");
		for(Map.Entry<Integer, Book> r : Refund.refund.entrySet()) {
			int key = r.getKey();
			Book value = r.getValue();
			System.out.println(r.getKey() + "\t" + r.getValue());
		}
		while(true) {
			System.out.print("환불 처리할 코드를 입력하세요. [이전:0] : ");
			int login = Integer.parseInt(Console.input());
			if(Refund.refund.containsKey(login)) {
				System.out.println("=====================================");
				System.out.println("\t환불 처리 되었습니다.");
				System.out.println("=====================================");
				
				Shelf.map.put(login,
						new Book(Refund.refund.get(login).getBookTitle(), Refund.refund.get(login).getBookAuthor(),
								Refund.refund.get(login).getBookPrice(), 
								Shelf.map.get(login).getBookCount() + Refund.refund.get(login).getBookCount()));
				Sales.sales.remove(login);
				
				//total = Sales.sales.get(login).getBookPrice()  *  Sales.sales.get(login).getBookCount() ;
				
			}else if(login==0) {
				break;
			}else {
				System.out.println("입력하신 코드가 없습니다.");
			}
			   
		}
	}

}
