package by.tr.library.bean;

public class Request {
	private String commandName;
	private String login;
	private String password;
	private String title;
	private String author;
	
	public Request(){
		
	}
	
	public Request(String login, String password, String title) {
		super();
		this.login = login;
		this.password = password;
		this.title = title;
	}

	public Request(String login, String password, String title, String author) {
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
}
