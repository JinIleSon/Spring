package kr.co.ch06.controller;

import kr.co.ch06.DTO.User4DTO;
import kr.co.ch06.Service.User4Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class User4Controller {

    private final User4Service user4Service;

    @GetMapping("/user4/list")
    public String list(Model model){
        List<User4DTO> dtoList = user4Service.findAll();
        model.addAttribute("dtoList", dtoList);
        return "/user4/list";
    }

    @GetMapping("/user4/register")
    public String register(){
        return "/user4/register";
    }

    @PostMapping("/user4/register")
    public String register(User4DTO user4DTO){
        user4Service.save(user4DTO);
        return "redirect:/user4/list";
    }

    @GetMapping("/user4/modify")
    public String modify(String userId,Model model){
        User4DTO user4DTO = user4Service.findById(userId);
        model.addAttribute("user4DTO", user4DTO);
        return "/user4/modify";
    }

    @PostMapping("/user4/modify")
    public String modify(User4DTO user4DTO){
        user4Service.modify(user4DTO);
        return "redirect:/user4/list";
    }

    @GetMapping("/user4/delete")
    public String delete(String userId){
        user4Service.delete(userId);
        return "redirect:/user4/list";
    }
}
