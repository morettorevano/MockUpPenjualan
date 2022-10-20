package Testwing.controller;

import Testwing.dto.RegisterDTO;
import Testwing.entity.Account;
import Testwing.service.abstraction.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService service;

    @GetMapping("/loginForm")
    public String loginForm(Model model){
        return "account/login-form";
    }

    @GetMapping("/registerForm")
    public String registerForm(Model model){
        RegisterDTO dto = new RegisterDTO();
        model.addAttribute("dto", dto);
        return "account/register-form";
    }

    @PostMapping("/register")
    public String regForm(@Valid @ModelAttribute("dto") RegisterDTO dto,
                               BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            return "account/register-form";
        }
        service.registerAccount(dto);
        return "redirect:/account/loginForm";
    }

//
}
