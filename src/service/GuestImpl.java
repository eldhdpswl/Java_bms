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
	// �޴����� �����Ҷ� �̱���
	private static GuestImpl g = new GuestImpl();

	public static GuestImpl getInstance() {
		return g;
	}

	public static Map<String, String> join = new HashMap<String, String>();

	@Override
	public void cartList() { // ��ٱ��� ���
		// TODO Auto-generated method stub
		System.out.println("============ ��ٱ��� ��� ===============");
		System.out.println("1.��ȣ" + "\t2.������" + "\t3.����" + "\t4.����" + "\t5.����");
		System.out.println("======================================");
		for (Map.Entry<Integer, Book> c : Cart.cart.entrySet()) {
			int key = c.getKey();
			Book value = c.getValue();
			System.out.println(c.getKey() + "\t" + c.getValue());
		}
	}

	@Override
	public void cartAdd() { // ��ٱ��� ���
		// TODO Auto-generated method stub

		while (true) {
			System.out.print("��ٱ��Ͽ� ���� å�� �ڵ带 �Է��ϼ���. [����:0] : ");
			int code = Integer.parseInt(Console.input()); 
			if (Shelf.map.containsKey(code)) {
				System.out.print("������ �Է��ϼ���. : ");
				int quan = Integer.parseInt(Console.input());
				if (Shelf.map.get(code).getBookCount() >= quan) {
					System.out.println("==========================================");
					System.out.println("��ٱ��Ͽ� �����ϴ�.");
					System.out.println("==========================================");
					Cart.cart.put(code, new Book(Shelf.map.get(code).getBookTitle(),
							Shelf.map.get(code).getBookAuthor(), Shelf.map.get(code).getBookPrice(), quan));
				} else {
					System.out.println("������ �����ʽ��ϴ�. �ٽ��Է����ּ���");
				}
				

			} else if (code == 0) {
				break;
			} else {
				System.out.println("�Է��Ͻ� �ڵ尡 �����ϴ�.");
			}
		}
	}

	@Override
	public void cartDel() { // ��ٱ��� ����
		// TODO Auto-generated method stub

		while (true) {
			System.out.print("�����Ϸ��� å�� �ڵ带 �Է��ϼ���. [����:0] : ");
			int login = Integer.parseInt(Console.input());
			if (Cart.cart.containsKey(login)) {
				Cart.cart.remove(login);
				System.out.println("=============== ���� ���� ===============");
				System.out.println(login + "�� ������ �����Ǿ����ϴ�.");
				System.out.println("=====================================");

			} else if (login == 0) {
				break;
			} else {
				System.out.println("�Է��Ͻ� �ڵ尡 �����ϴ�.");
			}
		}
	}

	@Override
	public void cartBuy() { // ��ٱ��� ����
		// TODO Auto-generated method stub

		while (true) {
			System.out.print("������ å�� �ڵ带 �Է��ϼ���. [����:0] : ");
			int login = Integer.parseInt(Console.input());
			if (Cart.cart.containsKey(login)) {
				if(Order.order.containsKey(login)) {  //�ֹ���Ͽ� ���� ���
					System.out.println("==========================================");
					System.out.println("\t���� ��û �Ǿ����ϴ�.");
					System.out.println("==========================================");
					
					Order.order.put(login, new Book(Cart.cart.get(login).getBookTitle(), 
							Cart.cart.get(login).getBookAuthor(), Cart.cart.get(login).getBookPrice(), 
							Order.order.get(login).getBookCount() + Cart.cart.get(login).getBookCount()));
					
					int asd = Shelf.map.get(login).getBookCount() - Order.order.get(login).getBookCount() + Cart.cart.get(login).getBookCount();

					Shelf.map.put(login, new Book(Shelf.map.get(login).getBookTitle(), Shelf.map.get(login).getBookAuthor(),
							Shelf.map.get(login).getBookPrice(), asd));

					Cart.cart.remove(login);
					
				}else {   //�ֹ���Ͽ� ���� ���
					System.out.println("==========================================");
					System.out.println("\t���� ��û �Ǿ����ϴ�.");
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
				System.out.println("�Է��Ͻ� �ڵ尡 �����ϴ�.");
			}

		}
	}

	@Override
	public void nowBuy() { // �ٷα���
		// TODO Auto-generated method stub
		while (true) {
			System.out.print("������ å�� �ڵ带 �Է��ϼ���. [����:0] : ");
			int login = Integer.parseInt(Console.input());
			if (Shelf.map.containsKey(login)) {
				System.out.print("������ �Է��ϼ��� : ");
				int quan = Integer.parseInt(Console.input());
				if (Shelf.map.get(login).getBookCount() >= quan) {
					if(Order.order.containsKey(login)) {   //�ֹ���Ͽ� ���� ���
						System.out.println("==========================================");
						System.out.println("\t���� ��û �Ǿ����ϴ�.");
						System.out.println("==========================================");
						
						Order.order.put(login, new Book(Shelf.map.get(login).getBookTitle(), 
								Shelf.map.get(login).getBookAuthor(), Shelf.map.get(login).getBookPrice(), 
								Order.order.get(login).getBookCount() + quan));
						
						int asd = Shelf.map.get(login).getBookCount() - quan;
						Shelf.map.put(login, new Book(Shelf.map.get(login).getBookTitle(),
								Shelf.map.get(login).getBookAuthor(), Shelf.map.get(login).getBookPrice(), asd));
					
					}else {    //�ֹ���Ͽ� ���� ���
						System.out.println("==========================================");
						System.out.println("\t���� ��û �Ǿ����ϴ�.");
						System.out.println("==========================================");
						
						Order.order.put(login, new Book(Shelf.map.get(login).getBookTitle(),
								Shelf.map.get(login).getBookAuthor(), Shelf.map.get(login).getBookPrice(), quan));
						
						int asd = Shelf.map.get(login).getBookCount() - quan;
						Shelf.map.put(login, new Book(Shelf.map.get(login).getBookTitle(),
								Shelf.map.get(login).getBookAuthor(), Shelf.map.get(login).getBookPrice(), asd));
					}
				
				} else {
					System.out.println("������ ���� �ʽ��ϴ�. �ٽ� �Է����ּ���!");
				}

			} else if (login == 0) {
				break;
			} else {
				System.out.println("�Է��Ͻ� �ڵ尡 �����ϴ�.");
			}
		}
	}

	@Override
	public void buyList() { // �ٷα��� ���
		// TODO Auto-generated method stub
		System.out.println("=========== ���� �Ϸ� ��� ============");
		System.out.println("��ȣ" + "\t������" + "\t����" + "\t����" + "\t����");
		System.out.println("================================");
		for (Map.Entry<Integer, Book> l : Sales.sales.entrySet()) {
			int key = l.getKey();
			Book value = l.getValue();
			System.out.println(l.getKey() + "\t" + l.getValue());
		}
	}

	@Override
	public void refund() { // ȯ��
		// TODO Auto-generated method stub
		buyList();
		while (true) {
			System.out.print("ȯ�� ��û�� å�� �ڵ带 �Է��ϼ���. [����:0] : ");
			int login = Integer.parseInt(Console.input());
			if (Sales.sales.containsKey(login)) {
				System.out.println("==========================================");
				System.out.println("\tȯ�� ��û �Ǿ����ϴ�.");
				System.out.println("==========================================");
				Refund.refund.put(login,
						new Book(Sales.sales.get(login).getBookTitle(), Sales.sales.get(login).getBookAuthor(),
								Sales.sales.get(login).getBookPrice(), Sales.sales.get(login).getBookCount()));
				Order.order.remove(login);
				Sales.sales.remove(login);
			} else if (login == 0) {
				break;
			} else {
				System.out.println("�Է��Ͻ� �ڵ尡 �����ϴ�.");
			}
		}

	}

	
	
}
