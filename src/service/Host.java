package service;

public interface Host {
	public static final String ID = "host";
	public static final String PASSWORD = "host";
	
	public void bookList();//å���
	public void bookAdd();//å�߰�
	public void bookUpdate();//å����
	public void bookDel();//å����
	
	public void saleTotal();//���
	public void orderList();//�ֹ����
	public void orderConfirm();//��������
	public void orderCancel();//�������
	
}
