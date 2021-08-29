package domain;

public class Book {
	//책번호   //랜덤으로 처리
 	private String bookTitle;   //책이름
	private String bookAuthor;  //책저자
	private int bookPrice;  //책가격
	private int bookCount;  //책 수량 
	
	//기본생성자
	public Book() {
		
	}
	//매개변수 생성자
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
