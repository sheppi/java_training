package by.tr.library.command.impl.book;

import by.tr.library.bean.Book;
import by.tr.library.bean.Request;
import by.tr.library.bean.Response;
import by.tr.library.command.Command;
import by.tr.library.command.exception.CommandException;
import by.tr.library.service.LibraryService;
import by.tr.library.service.ServiceFactory;
import by.tr.library.service.exception.ServiceException;

import java.util.List;

/**
 * Created by Kirill Kaluga on 10.07.2016.
 */
public class TakeBookCommand implements Command {
    @Override
    public Response execute(Request request) throws CommandException {
        String title = request.getTitle();

        ServiceFactory factory = ServiceFactory.getInstance();
        LibraryService service = factory.getLibraryService();

        Book book;
        try {
            book = service.findByTitle(title);
        } catch (ServiceException e) {
            throw new CommandException("command message", e);
        }

        Response response = new Response();
        response.setErrorMessage(null);
        response.setBook(book);

        return response;
    }
}
