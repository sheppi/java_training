package by.tr.library.start;

import by.tr.library.bean.Request;
import by.tr.library.bean.Response;
import by.tr.library.controller.Controller;

public class Main {

	public static void main(String[] args) {
		Controller controller = new Controller();
		
		
		Request request = new Request();
		request.setCommandName("AUTHORIZATION_COMMAND");
		request.setLogin("mylogin");
		request.setPassword("mypassword");
		
		Response response = controller.doAction(request);
		
		if(response.getErrorMessage() == null){
			System.out.println(response.getMessage());
		}else{
			System.out.println(response.getErrorMessage());
		}
		
		

	}

}
