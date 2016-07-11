package by.tr.library.start;

import by.tr.library.bean.ProgrammerBook;
import by.tr.library.bean.Request;
import by.tr.library.bean.Response;
import by.tr.library.controller.Controller;

public class Start {

	public static void main(String[] args) {
		ProgrammerBook prBook = new ProgrammerBook();

		Controller controller = new Controller();


		Request request = new Request();
		request.setCommandName("AUTHORIZATION_COMMAND");
		request.setLogin("mylogin");
		request.setPassword("mypassword");
		Response response = controller.doAction(request);
		System.out.println(response.getMessage());

		request = new Request();
		request.setCommandName("GET_CATALOG");
		response = controller.doAction(request);
		System.out.println(response.getListBook());

		request = new Request();
		request.setCommandName("REGISTER_USER");
		request.setLogin("mynewlogin123");
		request.setPassword("mynewpassword123");
		response = controller.doAction(request);
		System.out.println(response.getMessage());
	}

}
