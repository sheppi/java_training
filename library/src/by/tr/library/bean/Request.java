package by.tr.library.bean;

public class Request {
	private String commandName;
	private String login;
	private String password;
	private String title;
	private String author;
	private int price;
	private String type;
	private String firstParameter;
	private String secondParameter;

	public Request(){
		
	}
	
	public Request(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}

	public Request(String login, String password, String title) {
		super();
		this.login = login;
		this.password = password;
		this.title = title;
	}

	public Request(String login, String password, String author, String title) {
		this.login = login;
		this.password = password;
		this.title = title;
		this.author = author;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCommandName() {
		return commandName;
	}

	public void setCommandName(String commandName) {
		this.commandName = commandName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getPrice() {
		return price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFirstParameter() {
		return firstParameter;
	}

	public void setFirstParameter(String firstParameter) {
		this.firstParameter = firstParameter;
	}

	public String getSecondParameter() {
		return secondParameter;
	}

	public void setSecondParameter(String secondParameter) {
		this.secondParameter = secondParameter;
	}
}
