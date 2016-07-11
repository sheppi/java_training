package by.tr.library.service;

import by.tr.library.service.impl.ClientServiceImpl;
import by.tr.library.service.impl.LibraryServiceImpl;

public class ServiceFactory {
	private static ServiceFactory factory = new ServiceFactory();

	private final ClientService clienService = new ClientServiceImpl();
	private final LibraryService libraryService = new LibraryServiceImpl();
	
	private ServiceFactory(){}
	
	public static ServiceFactory getInstance(){
		return factory;
	}
	
	public ClientService getClientService(){
		return clienService;
	}
	
	public LibraryService getLibraryService(){
		return libraryService;
	}
	
	
}
