package by.tr.library.service;

import by.tr.library.service.exception.ServiceException;

public interface ClientService {
       boolean logination(String login, String password) throws ServiceException ;
       boolean registration(String login, String password) throws ServiceException;
       boolean deleteUser(int idUser) throws ServiceException;
       boolean blockUser(int idUser) throws ServiceException;
       boolean unBlockUser(int idUser) throws ServiceException;
}
