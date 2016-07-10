package by.tr.library.bean;

public class ProgrammerBook extends Book {

	private String language;
	private String level;
	
	public ProgrammerBook(){
		super("no title", 0);//new Book("",0);
		language = "";
		level="no";
	}
	
	public ProgrammerBook(String title, int price, String language, String level){
		super(title, price);
		this.language = language;
		this.level = level;
		
	}

	public ProgrammerBook(String author, String title, int price, String language, String level) {
		super(author, title, price);
		this.language = language;
		this.level = level;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}


	
	

}
