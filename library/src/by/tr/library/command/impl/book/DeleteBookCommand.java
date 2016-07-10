package by.tr.library.command.impl.book;

import by.tr.library.bean.Request;
import by.tr.library.bean.Response;
import by.tr.library.command.Command;
import by.tr.library.command.exception.CommandException;

/**
 * Created by Kirill Kaluga on 10.07.2016.
 */
public class DeleteBookCommand implements Command {
    @Override
    public Response execute(Request request) throws CommandException {
        return null;
    }
}
