package service;

public interface Guest {
	public static final String ID = "guest";
	public static final String PASSWORD = "guest";
	//�������
	public void cartList(); //��ٱ��� ��� - 
	public void cartAdd(); //��ٱ��� ���
	public void cartDel(); //��ٱ��� ����
	public void cartBuy(); //����
	
	public void nowBuy(); //�ٷα���
	public void buyList(); //�ٷα��� ���
	public void refund(); //ȯ��
	
	
}
