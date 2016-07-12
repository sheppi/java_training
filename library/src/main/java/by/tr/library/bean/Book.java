package by.tr.library.bean;

public class Book {

	private String author;
	private String title;
	private int price;

	public Book(){
		this.title = "";
		this.author = "";
		this.price = 0;
	}

	
	public Book(String title, int price){
		this.title = title;
		this.price = price;
	}

	public Book(String author, String title, int price) {
		this.title = title;
		this.author = author;
		this.price = price;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return author + ' ' + title + ' ' + price;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Book book = (Book) o;

		if (price != book.price) return false;
		if (!author.equals(book.author)) return false;
		return title.equals(book.title);

	}
}
