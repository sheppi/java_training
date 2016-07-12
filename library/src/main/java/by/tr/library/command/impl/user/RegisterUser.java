package by.tr.library.command.impl.user;

import by.tr.library.bean.Request;
import by.tr.library.bean.Response;
import by.tr.library.command.Command;
import by.tr.library.command.exception.CommandException;
import by.tr.library.service.ClientService;
import by.tr.library.service.ServiceFactory;
import by.tr.library.service.exception.ServiceException;

public class RegisterUser implements Command {

	@Override
	public Response execute(Request request) throws CommandException {
		String login = request.getLogin();
		String password = request.getPassword();

/////////////////////////
		ServiceFactory factory = ServiceFactory.getInstance();
		ClientService service = factory.getClientService();

/////////////////////////
		try {
			boolean result = service.registration(login, password);
		} catch (ServiceException e) {
			throw new CommandException("command message", e);
		}
		Response response = new Response();
		response.setErrorMessage(null);
		response.setMessage("User " + login + " is successfully registered.");

		return response;
	}

}
