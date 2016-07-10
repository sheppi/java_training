package by.tr.library.command.impl.book;

import by.tr.library.bean.Request;
import by.tr.library.bean.Response;
import by.tr.library.command.Command;
import by.tr.library.command.exception.CommandException;
import by.tr.library.service.ClientService;
import by.tr.library.service.ServiceFactory;
import by.tr.library.service.exception.ServiceException;

public class AddBookCommand implements Command {

	@Override
	public Response execute(Request request) throws CommandException {
		String login = request.getTitle();
		String password = request.getPassword();

/////////////////////////
		ServiceFactory factory = ServiceFactory.getInstance();
		ClientService service = factory.getClientService();

/////////////////////////
		try {
			boolean result = service.logination(login, password);
		} catch (ServiceException e) {
			throw new CommandException("command message", e);
		}
		Response response = new Response();
		response.setErrorMessage(null);
		response.setMessage("Logination is OK");

		return null;
	}

}
