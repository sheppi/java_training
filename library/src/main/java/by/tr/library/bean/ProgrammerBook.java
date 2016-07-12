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

	@Override
	public String toString() {
		return getAuthor() + ' ' + getTitle() + ' ' + getPrice() + ' ' + language + ' ' + level;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;

		ProgrammerBook that = (ProgrammerBook) o;

		if (!language.equals(that.language)) return false;
		return level.equals(that.level);

	}

	@Override
	public int hashCode() {
		int result = language.hashCode();
		result = 31 * result + level.hashCode();
		return result;
	}
}
