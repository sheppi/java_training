package by.tr.library.command.impl.user;

import by.tr.library.bean.Request;
import by.tr.library.bean.Response;
import by.tr.library.command.Command;
import by.tr.library.command.exception.CommandException;
import by.tr.library.service.ClientService;
import by.tr.library.service.ServiceFactory;
import by.tr.library.service.exception.ServiceException;

/**
 * Created by Kirill Kaluga on 10.07.2016.
 */
public class BlockUser implements Command {
    @Override
    public Response execute(Request request) throws CommandException {
        int id = request.getId();

/////////////////////////
        ServiceFactory factory = ServiceFactory.getInstance();
        ClientService service = factory.getClientService();

/////////////////////////
        try {
            boolean result = service.blockUser(id);
        } catch (ServiceException e) {
            throw new CommandException("command message", e);
        }
        Response response = new Response();
        response.setErrorMessage(null);
        response.setMessage("User " + id + " is successfully blocked.");

        return response;
    }
}
