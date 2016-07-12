package by.tr.library.controller;

import java.util.HashMap;
import java.util.Map;

import by.tr.library.command.Command;
import by.tr.library.command.impl.book.*;
import by.tr.library.command.impl.user.*;

public class CommandHelper {
	private Map<CommandName, Command> commands = new HashMap<>();
	
	public CommandHelper(){
		//book
		commands.put(CommandName.ADD_BOOK_COMMAND, new AddBookCommand());
		commands.put(CommandName.DELETE_BOOK_COMMAND, new DeleteBookCommand());
		commands.put(CommandName.GET_CATALOG, new GetCalatog());
		commands.put(CommandName.TAKE_BOOK_COMMAND, new TakeBookCommand());

		//user
		commands.put(CommandName.AUTHORIZATION_COMMAND, new AuthorizationCommand());
		commands.put(CommandName.BLOCK_USER, new BlockUser());
		commands.put(CommandName.REGISTER_USER, new RegisterUser());
		commands.put(CommandName.UNBLOCK_USER, new UnBlockUser());
		commands.put(CommandName.DELETE_USER, new DeleteUser());

	}
	
	public Command getCommand(String commandName){
		CommandName command = CommandName.valueOf(commandName);
		Command executeCommand = commands.get(command);
		return executeCommand;
	}
	

}
