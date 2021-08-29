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
	// �������
	// �̱���
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
	public void bookAdd() {  //å���
		// TODO Auto-generated method stub
		while (true) {
			bookNum = (int) (Math.random() * 2000 + 1000); // �ڵ带 �������� booknum�� �ѹ��� ����.
			System.out.println("=============== ���� ��� ===============");
			System.out.print("å ���� : ");
			title = Console.input();
			System.out.print("å ���� : ");
			author = Console.input();
			System.out.print("å ���� : ");
			price = Integer.parseInt(Console.input());
			System.out.print("å ���� : ");
			count = Integer.parseInt(Console.input());
			Shelf.map.put(bookNum, new Book(title, author, price, count));

			System.out.println("=====================================");
			System.out.println("\t������ ��ϵǾ����ϴ�.");
			System.out.println("=====================================");

			
			break;

		}

	}

	@Override
	public void bookList() {    //������Ϻҷ�����
		// TODO Auto-generated method stub
		System.out.println("=============== ���� ��� ===============");
		System.out.println("��ȣ" + "\t������" + "\t����" + "\t����" + "\t����");
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
	public void bookUpdate() { // å����
		// TODO Auto-generated method stub
		while (true) {
			System.out.print("�����Ϸ��� å�� �ڵ带 �Է��ϼ���. [����:0] : ");
			login = Integer.parseInt(Console.input());
			if (Shelf.map.containsKey(login)) {
				System.out.println("=============== ���� ���� ===============");
				System.out.print("å ���� : ");
				title = Console.input();
				System.out.print("å ���� : ");
				author = Console.input();
				System.out.print("å ���� : ");
				price = Integer.parseInt(Console.input());
				System.out.print("å ���� : ");
				count = Integer.parseInt(Console.input());
				Shelf.map.put(login, new Book(title, author, price, count));
				
				System.out.println("=====================================");
				System.out.println("\t������ �����Ǿ����ϴ�.");
				System.out.println("=====================================");
			
			}else if(login == 0) {
				break;
			}else {
				System.out.println("�Է��Ͻ� �ڵ尡 �����ϴ�.");
			}

		}
	}

	@Override
	public void bookDel() { // å����
		// TODO Auto-generated method stub
		
		while (true) {
			System.out.print("�����Ϸ��� å�� �ڵ带 �Է��ϼ���. [����:0] : ");
			login = Integer.parseInt(Console.input());
			
			if (Shelf.map.containsKey(login)) {
				Shelf.map.remove(login);
				System.out.println("=============== ���� ���� ===============");
				System.out.println(login + "�� ������ �����Ǿ����ϴ�.");
				System.out.println("=====================================");
			}else if(login == 0) {
				break;
			}else {
				System.out.println("�Է��Ͻ� �ڵ尡 �����ϴ�.");
			}
		}
		
	}

	@Override
	public void saleTotal() { // ���
		// TODO Auto-generated method stub
		int total=0;
		for(Map.Entry<Integer, Book> z : Sales.sales.entrySet()) {
			
			Book value = z.getValue();
			total += value.getBookPrice()  *  value.getBookCount() ;
			
		}
		System.out.println("��� : " + total);
		
	}

	@Override
	public void orderList() { // �ֹ����
		// TODO Auto-generated method stub
		System.out.println("=============== ���� ��û ��� ===============");
		System.out.println("��ȣ" + "\t������" + "\t����" + "\t����" + "\t����");
		System.out.println("=====================================");
		for (Map.Entry<Integer, Book> a : Order.order.entrySet()) {
			int key = a.getKey();
			Book value = a.getValue();
			System.out.println(key + "\t" + value.toString());
		}
	}

	@Override
	public void orderConfirm() {  //��������
		// TODO Auto-generated method stub
		while(true) {
			System.out.print("���� ������ �ڵ带 �Է��ϼ���. [����:0] : ");
			int login = Integer.parseInt(Console.input());
			if(Order.order.containsKey(login)) {
				System.out.println("=====================================");
				System.out.println("\t���� ���� �Ǿ����ϴ�.");
				System.out.println("=====================================");
				Sales.sales.put(login,
						new Book(Order.order.get(login).getBookTitle(), Order.order.get(login).getBookAuthor(),
								Order.order.get(login).getBookPrice(), Order.order.get(login).getBookCount()));
				
				//total += Sales.sales.get(login).getBookPrice()  *  Sales.sales.get(login).getBookCount() ;

			}else if(login==0) {
				break;
			}else {
				System.out.println("�Է��Ͻ� �ڵ尡 �����ϴ�.");
			}
			
		}
		
	}
//////////////
	@Override
	public void orderCancel() { // �������
		// TODO Auto-generated method stub
		System.out.println("============ ȯ�� ��û ��� =============");
		System.out.println("��ȣ" + "\t������" + "\t����" + "\t����" + "\t����");
		System.out.println("======================================");
		for(Map.Entry<Integer, Book> r : Refund.refund.entrySet()) {
			int key = r.getKey();
			Book value = r.getValue();
			System.out.println(r.getKey() + "\t" + r.getValue());
		}
		while(true) {
			System.out.print("ȯ�� ó���� �ڵ带 �Է��ϼ���. [����:0] : ");
			int login = Integer.parseInt(Console.input());
			if(Refund.refund.containsKey(login)) {
				System.out.println("=====================================");
				System.out.println("\tȯ�� ó�� �Ǿ����ϴ�.");
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
				System.out.println("�Է��Ͻ� �ڵ尡 �����ϴ�.");
			}
			   
		}
	}

}
