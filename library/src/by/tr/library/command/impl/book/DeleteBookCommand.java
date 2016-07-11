package by.tr.library.command.impl.book;

import by.tr.library.bean.Request;
import by.tr.library.bean.Response;
import by.tr.library.command.Command;
import by.tr.library.command.exception.CommandException;
import by.tr.library.service.LibraryService;
import by.tr.library.service.ServiceFactory;
import by.tr.library.service.exception.ServiceException;

/**
 * Created by Kirill Kaluga on 10.07.2016.
 */
public class DeleteBookCommand implements Command {
    @Override
    public Response execute(Request request) throws CommandException {
        String title = request.getTitle();
        boolean result;

        ServiceFactory factory = ServiceFactory.getInstance();
        LibraryService service = factory.getLibraryService();

        try {
            result = service.deleteBook(title);
        } catch (ServiceException e) {
            throw new CommandException("command message", e);
        }
        Response response = new Response();
        response.setErrorMessage(null);
        if (result) {
            response.setMessage("Book deleted.");
        }
        else {
            response.setMessage("Book doesn't delete.");
        }

        return response;
    }
}
