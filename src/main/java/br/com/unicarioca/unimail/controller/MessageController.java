package br.com.unicarioca.unimail.controller;

import br.com.unicarioca.unimail.rmi.MessageDTO;
import br.com.unicarioca.unimail.service.MailClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.rmi.RemoteException;

/**
 * Created by alessandro.santos on 11/16/16.
 */

@Controller
@RequestMapping(value = "/message")
public class MessageController {

    @Autowired
    private MailClient mailClient;


    @RequestMapping(method = RequestMethod.GET)
    public String newMessage() {
        return "new-message";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String sendMessage(@RequestParam("from") String from,
              @RequestParam("title") String title, @RequestParam("to") String to,
              @RequestParam("message") String message, Model model) throws RemoteException {


        MessageDTO messageDTO = new MessageDTO(from, to, title, message);
        mailClient.sendMessage(messageDTO);
        model.addAttribute("message", "Mensagem enviada com sucesso!");
        return "new-message";
    }


}
