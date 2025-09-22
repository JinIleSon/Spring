package kr.co.ch06.controller;

import kr.co.ch06.DTO.User3DTO;
import kr.co.ch06.Service.User3Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class User3Controller {

    private final User3Service user3Service;

    @GetMapping("/user3/list")
    public String list(Model model) {
        List<User3DTO> dtoList = user3Service.getUsers();
        model.addAttribute("dtoList", dtoList);
        return "/user3/list";
    }

    @GetMapping("/user3/register")
    public String register() {
        return "/user3/register";
    }

    @PostMapping("/user3/register")
    public String register(User3DTO user3DTO, Model model) {
        user3Service.save(user3DTO);
        return "redirect:/user3/list";
    }

    @GetMapping("/user3/modify")
    public String modify(String userId, Model model) {
        User3DTO user3DTO = user3Service.getUser(userId);
        model.addAttribute("user3DTO", user3DTO);
        return "/user3/modify";
    }

    @PostMapping("/user3/modify")
    public String modify(User3DTO user3DTO, Model model) {
        user3Service.modify(user3DTO);
        return "redirect:/user3/list";
    }

    @GetMapping("/user3/delete")
    public String delete(String userId){
        user3Service.delete(userId);
        return "redirect:/user3/list";
    }

}
