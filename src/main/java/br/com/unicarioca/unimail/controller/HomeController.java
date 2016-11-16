package br.com.unicarioca.unimail.controller;

import br.com.unicarioca.unimail.rmi.MessageDTO;
import br.com.unicarioca.unimail.rmi.UserDTO;
import br.com.unicarioca.unimail.service.MailClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by alessandro.santos on 11/15/16.
 */

@Controller
public class HomeController {

    @Autowired
    private MailClient mailClient;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {

        return "home";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String homeMailbox(HttpSession session, Model model) throws RemoteException {

        UserDTO userDTO = (UserDTO) session.getAttribute("user");
        List<MessageDTO> messages = mailClient.getMessages(userDTO.getId());
        model.addAttribute("messages", messages);
        model.addAttribute("boxmessage", "Caixa de entrada");

        return "mailbox";
    }

    @RequestMapping(value = "/sent-box", method = RequestMethod.GET)
    public String homeSentMailBox(HttpSession session, Model model) throws RemoteException {

        UserDTO userDTO = (UserDTO) session.getAttribute("user");
        List<MessageDTO> messages = mailClient.getSentMessages(userDTO.getId());
        model.addAttribute("messages", messages);
        model.addAttribute("boxmessage", "Caixa de saída");
        return "mailbox";
    }


}
