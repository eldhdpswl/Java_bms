package domain;

public class Book {
	//å��ȣ   //�������� ó��
 	private String bookTitle;   //å�̸�
	private String bookAuthor;  //å����
	private int bookPrice;  //å����
	private int bookCount;  //å ���� 
	
	//�⺻������
	public Book() {
		
	}
	//�Ű����� ������
	public Book(String bookTitle, String bookAuthor, int bookPrice, int bookCount) {
		//this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		this.bookPrice = bookPrice;
		this.bookCount = bookCount;
	}
	
	//setter, getter
	
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	
	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}
	public int getBookPrice() {
		return bookPrice;
	}
	
	public void setBookCount(int bookCount) {
		this.bookCount = bookCount;
	}
	public int getBookCount() {
		return bookCount;
	}
	//toString
	
	public String toString() {
		return bookTitle + "\t" + bookAuthor + "\t" + bookPrice + "\t" + bookCount;
	}
	
}
