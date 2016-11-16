package br.com.unicarioca.unimail.controller;

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

/**
 * Created by alessandro.santos on 11/16/16.
 */

@Controller
@RequestMapping(value = "/register")
public class RegisterController {

    @Autowired
    private MailClient mailClient;

    @RequestMapping(method = RequestMethod.GET)
    public String register() {
        return "register";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String registerUser(@RequestParam("email") String email, @RequestParam("name") String name, Model model)
        throws RemoteException {

        ResponseDTO responseDTO = mailClient.recoverUser(email);

        if(responseDTO.getStatus().equalsIgnoreCase("user_not_found")) {
            mailClient.createUser(email, name);
            model.addAttribute("message", "Usuário criado com sucesso");
            return "home";
        }

        model.addAttribute("errorMessage", "email já registrado, por favor use outro email");

        return "register";
    }

}
