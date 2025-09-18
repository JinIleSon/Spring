package kr.co.ch05.controller;

import kr.co.ch05.dto.User5DTO;
import kr.co.ch05.service.User5Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class User5Controller {

    private final User5Service user5Service;

    @GetMapping("/user5/list")
    public String list(Model model){
        model.addAttribute("dtoList", user5Service.findAll());
        return "/user5/list";
    }

    @GetMapping("/user5/register")
    public String register(){
        return "/user5/register";
    }

    @PostMapping("/user5/register")
    public String register(User5DTO user5DTO){
        user5Service.register(user5DTO);
        return "redirect:/user5/list";
    }

    @GetMapping("/user5/modify")
    public String modify(String userId, Model model){
        model.addAttribute("user5DTO", user5Service.findById(userId));
        return "/user5/modify";
    }

    @PostMapping("/user5/modify")
    public String modify(User5DTO userDTO){
        user5Service.modify(userDTO);
        return "redirect:/user5/list";
    }

    @GetMapping("/user5/delete")
    public String remove(String userId){
        user5Service.remove(userId);
        return "redirect:/user5/list";
    }

}
