package br.com.unicarioca.unimail.controller;

import br.com.unicarioca.unimail.rmi.MessageDTO;
import br.com.unicarioca.unimail.rmi.ResponseDTO;
import br.com.unicarioca.unimail.service.MailClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by alessandro.santos on 11/16/16.
 */

@Controller
public class LoginController {

    @Autowired
    private MailClient mailClient;

    @RequestMapping(value = "/login", method = {RequestMethod.POST, RequestMethod.GET})
    public String login(Model model, HttpSession session, @RequestParam("email") String email) throws RemoteException {

        ResponseDTO responseDTO = mailClient.recoverUser(email);

        if(responseDTO.getStatus().equalsIgnoreCase("success")) {

            session.setAttribute("user", responseDTO.getUserDTO());
            List<MessageDTO> messages = mailClient.getMessages(responseDTO.getUserDTO().getId());
            model.addAttribute("messages", messages);
            model.addAttribute("boxmessage", "Caixa de entrada");
            return "mailbox";
        }

        model.addAttribute("errorMessage", "email não registrado");
        return "home";
    }
}
