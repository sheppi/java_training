package by.tr.library.command.impl.book;

import by.tr.library.bean.Request;
import by.tr.library.bean.Response;
import by.tr.library.command.Command;
import by.tr.library.command.exception.CommandException;
import by.tr.library.service.ClientService;
import by.tr.library.service.LibraryService;
import by.tr.library.service.ServiceFactory;
import by.tr.library.service.exception.ServiceException;

public class AddBookCommand implements Command {

	@Override
	public Response execute(Request request) throws CommandException {
		String title = request.getTitle();
		String author = request.getAuthor();
		int price = request.getPrice();
		boolean result;

		ServiceFactory factory = ServiceFactory.getInstance();
		LibraryService service = factory.getLibraryService();

		try {
			switch (request.getType().toLowerCase()){
				case "programmer" :
					String language = request.getFirstParameter();
					String level = request.getSecondParameter();
					result = service.addBook(author, title, price, language, level);
					break;

				default:
					result = service.addBook(author, title, price);
					break;
			}
		} catch (ServiceException e) {
			throw new CommandException("command message", e);
		}
		Response response = new Response();
		response.setErrorMessage(null);
		response.setMessage("Book added.");

		return response;
	}

}
