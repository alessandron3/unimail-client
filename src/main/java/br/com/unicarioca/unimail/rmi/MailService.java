package br.com.unicarioca.unimail.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by alessandro.santos on 11/15/16.
 */
public interface MailService extends Remote {

    void sendMessage(MessageDTO messageDTO) throws RemoteException;

    List<MessageDTO> getMessages(Long userId) throws RemoteException;

    ResponseDTO createUser(UserDTO userDTO) throws RemoteException;

    List<MessageDTO> getSentMessages(Long userId) throws RemoteException;

    ResponseDTO recoverUser(String email) throws RemoteException;
}
