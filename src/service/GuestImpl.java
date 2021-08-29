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

public class GuestImpl implements Guest {
	// 메뉴에서 접근할때 싱글톤
	private static GuestImpl g = new GuestImpl();

	public static GuestImpl getInstance() {
		return g;
	}

	public static Map<String, String> join = new HashMap<String, String>();

	@Override
	public void cartList() { // 장바구니 목록
		// TODO Auto-generated method stub
		System.out.println("============ 장바구니 목록 ===============");
		System.out.println("1.번호" + "\t2.도서명" + "\t3.저자" + "\t4.가격" + "\t5.수량");
		System.out.println("======================================");
		for (Map.Entry<Integer, Book> c : Cart.cart.entrySet()) {
			int key = c.getKey();
			Book value = c.getValue();
			System.out.println(c.getKey() + "\t" + c.getValue());
		}
	}

	@Override
	public void cartAdd() { // 장바구니 담기
		// TODO Auto-generated method stub

		while (true) {
			System.out.print("장바구니에 담을 책의 코드를 입력하세요. [이전:0] : ");
			int code = Integer.parseInt(Console.input()); 
			if (Shelf.map.containsKey(code)) {
				System.out.print("수량을 입력하세요. : ");
				int quan = Integer.parseInt(Console.input());
				if (Shelf.map.get(code).getBookCount() >= quan) {
					System.out.println("==========================================");
					System.out.println("장바구니에 담겼습니다.");
					System.out.println("==========================================");
					Cart.cart.put(code, new Book(Shelf.map.get(code).getBookTitle(),
							Shelf.map.get(code).getBookAuthor(), Shelf.map.get(code).getBookPrice(), quan));
				} else {
					System.out.println("수량이 맞지않습니다. 다시입력해주세요");
				}
				

			} else if (code == 0) {
				break;
			} else {
				System.out.println("입력하신 코드가 없습니다.");
			}
		}
	}

	@Override
	public void cartDel() { // 장바구니 삭제
		// TODO Auto-generated method stub

		while (true) {
			System.out.print("삭제하려는 책의 코드를 입력하세요. [이전:0] : ");
			int login = Integer.parseInt(Console.input());
			if (Cart.cart.containsKey(login)) {
				Cart.cart.remove(login);
				System.out.println("=============== 도서 수정 ===============");
				System.out.println(login + "번 도서가 삭제되었습니다.");
				System.out.println("=====================================");

			} else if (login == 0) {
				break;
			} else {
				System.out.println("입력하신 코드가 없습니다.");
			}
		}
	}

	@Override
	public void cartBuy() { // 장바구니 구매
		// TODO Auto-generated method stub

		while (true) {
			System.out.print("구매할 책의 코드를 입력하세요. [이전:0] : ");
			int login = Integer.parseInt(Console.input());
			if (Cart.cart.containsKey(login)) {
				if(Order.order.containsKey(login)) {  //주문목록에 있을 경우
					System.out.println("==========================================");
					System.out.println("\t구매 요청 되었습니다.");
					System.out.println("==========================================");
					
					Order.order.put(login, new Book(Cart.cart.get(login).getBookTitle(), 
							Cart.cart.get(login).getBookAuthor(), Cart.cart.get(login).getBookPrice(), 
							Order.order.get(login).getBookCount() + Cart.cart.get(login).getBookCount()));
					
					int asd = Shelf.map.get(login).getBookCount() - Order.order.get(login).getBookCount() + Cart.cart.get(login).getBookCount();

					Shelf.map.put(login, new Book(Shelf.map.get(login).getBookTitle(), Shelf.map.get(login).getBookAuthor(),
							Shelf.map.get(login).getBookPrice(), asd));

					Cart.cart.remove(login);
					
				}else {   //주문목록에 없을 경우
					System.out.println("==========================================");
					System.out.println("\t구매 요청 되었습니다.");
					System.out.println("==========================================");
					
					Order.order.put(login,
							new Book(Cart.cart.get(login).getBookTitle(), Cart.cart.get(login).getBookAuthor(),
									Cart.cart.get(login).getBookPrice(), Cart.cart.get(login).getBookCount()));
					
					int asd = Shelf.map.get(login).getBookCount() - Cart.cart.get(login).getBookCount();

					Shelf.map.put(login, new Book(Shelf.map.get(login).getBookTitle(), Shelf.map.get(login).getBookAuthor(),
							Shelf.map.get(login).getBookPrice(), asd));

					Cart.cart.remove(login);
					
				}
				
			} else if (login == 0) {
				break;
			} else {
				System.out.println("입력하신 코드가 없습니다.");
			}

		}
	}

	@Override
	public void nowBuy() { // 바로구매
		// TODO Auto-generated method stub
		while (true) {
			System.out.print("구매할 책의 코드를 입력하세요. [이전:0] : ");
			int login = Integer.parseInt(Console.input());
			if (Shelf.map.containsKey(login)) {
				System.out.print("수량을 입력하세요 : ");
				int quan = Integer.parseInt(Console.input());
				if (Shelf.map.get(login).getBookCount() >= quan) {
					if(Order.order.containsKey(login)) {   //주문목록에 있을 경우
						System.out.println("==========================================");
						System.out.println("\t구매 요청 되었습니다.");
						System.out.println("==========================================");
						
						Order.order.put(login, new Book(Shelf.map.get(login).getBookTitle(), 
								Shelf.map.get(login).getBookAuthor(), Shelf.map.get(login).getBookPrice(), 
								Order.order.get(login).getBookCount() + quan));
						
						int asd = Shelf.map.get(login).getBookCount() - quan;
						Shelf.map.put(login, new Book(Shelf.map.get(login).getBookTitle(),
								Shelf.map.get(login).getBookAuthor(), Shelf.map.get(login).getBookPrice(), asd));
					
					}else {    //주문목록에 없을 경우
						System.out.println("==========================================");
						System.out.println("\t구매 요청 되었습니다.");
						System.out.println("==========================================");
						
						Order.order.put(login, new Book(Shelf.map.get(login).getBookTitle(),
								Shelf.map.get(login).getBookAuthor(), Shelf.map.get(login).getBookPrice(), quan));
						
						int asd = Shelf.map.get(login).getBookCount() - quan;
						Shelf.map.put(login, new Book(Shelf.map.get(login).getBookTitle(),
								Shelf.map.get(login).getBookAuthor(), Shelf.map.get(login).getBookPrice(), asd));
					}
				
				} else {
					System.out.println("수량이 맞지 않습니다. 다시 입력해주세요!");
				}

			} else if (login == 0) {
				break;
			} else {
				System.out.println("입력하신 코드가 없습니다.");
			}
		}
	}

	@Override
	public void buyList() { // 바로구매 목록
		// TODO Auto-generated method stub
		System.out.println("=========== 구매 완료 목록 ============");
		System.out.println("번호" + "\t도서명" + "\t저자" + "\t가격" + "\t수량");
		System.out.println("================================");
		for (Map.Entry<Integer, Book> l : Sales.sales.entrySet()) {
			int key = l.getKey();
			Book value = l.getValue();
			System.out.println(l.getKey() + "\t" + l.getValue());
		}
	}

	@Override
	public void refund() { // 환불
		// TODO Auto-generated method stub
		buyList();
		while (true) {
			System.out.print("환불 요청할 책의 코드를 입력하세요. [이전:0] : ");
			int login = Integer.parseInt(Console.input());
			if (Sales.sales.containsKey(login)) {
				System.out.println("==========================================");
				System.out.println("\t환불 요청 되었습니다.");
				System.out.println("==========================================");
				Refund.refund.put(login,
						new Book(Sales.sales.get(login).getBookTitle(), Sales.sales.get(login).getBookAuthor(),
								Sales.sales.get(login).getBookPrice(), Sales.sales.get(login).getBookCount()));
				Order.order.remove(login);
				Sales.sales.remove(login);
			} else if (login == 0) {
				break;
			} else {
				System.out.println("입력하신 코드가 없습니다.");
			}
		}

	}

	
	
}
