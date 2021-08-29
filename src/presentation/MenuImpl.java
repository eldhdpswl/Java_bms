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
			case SHOP_LOGIN:   //�α���
				loginMenu();
				break;
			
			case HOST_MENU:  //����
				hostMenu();
				break;
			
			case HOST_STOCK_MENU: //������
				hostStockMenu();
				break;
			
			case HOST_BOOK_LIST:  //å���
				h.bookList();
				break;
			
			case HOST_BOOK_ADD:
				h.bookAdd();//å �߰�
				break;
			
			case HOST_BOOK_UPDATE: //å ����
				h.bookUpdate();
				break;
			
			case HOST_BOOK_DEL: //å ����
				h.bookDel();
				break;
			
			case HOST_ORDER_MENU:   ///////////////�ֹ�����
				hostOrderMenu();
				break;
			
			case HOST_ORDER_LIST:  //�ֹ����
				h.orderList();
				break;
			
			case HOST_ORDER_CONFIRM: //��������
				h.orderConfirm();
				break;
			
			case HOST_ORDER_CANCEL: //�������
				h.orderCancel();
				break;
			
			case HOST_SALE_TOTAL:  //���
				h.saleTotal();
				break;
			
			case GUEST_MENU: //�մ�
				guestmenu();
				break;
			case GUEST_CART_MENU: //////////////��ٱ���
				guestCartMenu();
			
			case GUEST_CART_LIST:  //��ٱ��� ����Ʈ
				g.cartList();
				break;
			
			case GUEST_CART_ADD:  //��ٱ��� ���
				g.cartAdd();
				break;
			
			case GUEST_CART_DEL:  //��ٱ��� ����
				g.cartDel();
				break; 
			
			case GUEST_NOW_BUY:     //�ٷα���
				g.cartBuy();
				break;
			
			case GUEST_ORDER_LIST:  //�ٷα��� ���
				g.nowBuy();
				break;
			
			case GUEST_REFUND:   //ȯ��
				g.refund();
				break;
				
		}
	}
	//�޴�����
	/*
	 * case SHOW_LOGIN:     //�α���
	 *      loginMenu();
	 *      break;
	 * 
	 * case HOST_MENU:     //������ �޴�
	 * 		hostMenu();     
	 * 		break;
	 * 
	 * 		//������ ���� ����
	 * 		//������ ���� ���
	 * 		//������ ���� �߰�
	 * 		//������ ���� ����
	 * 		//������ ���� ����
	 * 
	 * 		//������ �ֹ�����
	 * 
	 * 		//������ �ֹ����
	 * 		//������ ��������
	 * 		//������ �������
	 * 		//������ ���
	 * 
	 * 		//���޴�
	 * 		//�� ��ٱ��� ���
	 * 		//�� ��ٱ��� �߰�
	 * 		//�� ��ٱ��� ����
	 * 		//�� �ٷα���
	 * 
	 * 		//�� ��ٱ��� �޴�
	 *		//������
	 *		//��ȯ��
	 * 
	 */

	@Override
	public void loginMenu() {  //�α���
		System.out.println("�������������������������������α��Φ���������������������������");
		System.out.println("1. ��" + "\t2. ������" + "\t3. ȸ��"+ "\t4. ����");
		System.out.println("������������������������������������������������������������������");
		
		while(true) {
			
			System.out.print("�޴���ȣ�� �Է��ϼ���. : ");
			int login = Integer.parseInt(Console.input());
			
			if(login == 1) {
				while(true) {
					System.out.print("�� ID : ");
					String id = Console.input();
					System.out.print("�� PW : ");
					String pw = Console.input();
					if(id.equals(Guest.ID)) {
						if(pw.equals(Guest.PASSWORD)) {
							System.out.println("==========================================");
							System.out.println("\t�α��εǾ����ϴ�.");
							System.out.println("==========================================");
							commonMenu(GUEST_MENU);
							break;
						}else {
							System.out.println("��й�ȣ�� Ʋ���ϴ�.");
						}
						
					}else {
						System.out.println("���̵� Ʋ�Ƚ��ϴ�.");
					}
				}
			}else if(login == 2) {
				while(true) {
					System.out.print("������ ID : ");
					String id = Console.input();
					System.out.print("������ PW : ");
					String pw = Console.input();
					if(id.equals(Host.ID)) {
						if(pw.equals(Host.PASSWORD)) {
							System.out.println("==========================================");
							System.out.println("\t�α��εǾ����ϴ�.");
							System.out.println("==========================================");
							commonMenu(HOST_MENU);
							break;
						} else {
							System.out.println("��й�ȣ�� Ʋ���ϴ�.");
						}
						
					}else {
						System.out.println("���̵� Ʋ�Ƚ��ϴ�.");
					}
				}
				
			}else if(login == 3) {
				
			}else if(login == 4) {
				System.out.println("�ý��� ����!");
				break;
			}else {
				System.out.println("�߸��Է��Ͽ����ϴ�.");
			}
		
		}
		
	}

	@Override
	public void hostMenu() {  //�����ڸ޴�
		// TODO Auto-generated method stub
		System.out.println("���������������������������������������ڸ޴�����������������������������������");
		System.out.println("1. ������" + "\t2. �ֹ�����" + "\t3. �α׾ƿ�");
		System.out.println("����������������������������������������������������������������������������������");
		while(true) {
			System.out.print("�޴���ȣ�� �Է��ϼ���. : ");
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
					System.out.println("�߸��Է��Ͽ����ϴ�. �ٽ��Է����ּ���");
			}
			
		}
		
	}

	@Override
	public void hostStockMenu() {  //������ ���� �޴�(������)
		// TODO Auto-generated method stub
		System.out.println("��������������������������������������������������������������������������");
		System.out.println("1. ���" + "\t2. �߰�" + "\t3. ����" + "\t4. ����" + "\t5. ����");
		System.out.println("������������������������������������������������������������������������������");
		while(true) {
			System.out.print("�޴���ȣ�� �Է��ϼ���. : ");
			
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
					System.out.print("�߸��Է��ϼ̽��ϴ�.");
			}
			
		}
			  
	}
	
	@Override
	public void hostOrderMenu() {  //������ �ֹ����� �޴�
		// TODO Auto-generated method stub
		System.out.println("������������������������������������ �ֹ�������������������������������������");
		System.out.println("1.�ֹ����" + "\t2.��������" + "\t3.�������" + "\t4.���" + "\t5.����");
		System.out.println("������������������������������������������������������������������������������");
		while(true) {
			System.out.print("�޴� ��ȣ�� �Է��ϼ���. : ");
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
					System.out.println("�߸��Է��Ͽ����ϴ�.");
						
			}
		}
	}

	@Override
	public void guestmenu() { //�� �޴�
		// TODO Auto-generated method stub
		System.out.println("�������������������������������������޴�����������������������������������");
		System.out.println("1. ��ٱ���" +"      2. ����"+ "      3. ȯ��" + "      4. �α׾ƿ�");
		System.out.println("������������������������������������������������������������������������������");
		while(true){
			System.out.print("�޴���ȣ�� �Է��ϼ���. : ");
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
					System.out.println("�߸��Է��Ͽ����ϴ�.");
			}
			
		}
	}

	@Override
	public void guestCartMenu() {  //�� ��ٱ���
		// TODO Auto-generated method stub
		
		while(true) {
			System.out.println("=============== ��ٱ��� ===============");
			System.out.println("1.�߰�" + "\t2.����" + "\t3.����" + "\t4.����");
			System.out.println("=====================================");
			System.out.print("�޴� ��ȣ�� �Է��ϼ���. : ");
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
					System.out.println("�߸��Է��Ͽ����ϴ�.");
			}
			
		}
		
	}
	
}
