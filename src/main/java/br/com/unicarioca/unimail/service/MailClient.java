package br.com.unicarioca.unimail.service;

import br.com.unicarioca.unimail.rmi.MailService;
import br.com.unicarioca.unimail.rmi.MessageDTO;
import br.com.unicarioca.unimail.rmi.ResponseDTO;
import br.com.unicarioca.unimail.rmi.UserDTO;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by alessandro.santos on 11/15/16.
 */


@Service
public class MailClient {

    private final MailService mailService;

    public MailClient() throws RemoteException, NotBoundException, MalformedURLException {
         mailService = (MailService) Naming.lookup("//localhost/unimail");
    }


    public List<MessageDTO> getSentMessages(Long userId) throws RemoteException {
        return mailService.getSentMessages(userId);
    }

    public List<MessageDTO> getMessages(Long userId) throws RemoteException {
        return mailService.getMessages(userId);
    }

    public void createUser(String email, String name) throws RemoteException {
        mailService.createUser(new UserDTO(email, name, null));
    }


    public void sendMessage(MessageDTO messageDTO) throws RemoteException  {
        mailService.sendMessage(messageDTO);
    }

    public ResponseDTO recoverUser(String email) throws RemoteException {
        return mailService.recoverUser(email);
    }



}
