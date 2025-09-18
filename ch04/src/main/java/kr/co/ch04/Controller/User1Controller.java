package kr.co.ch04.Controller;

import kr.co.ch04.dto.User1DTO;
import kr.co.ch04.service.User1Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.logging.Logger;

@Slf4j
@Controller
@RequiredArgsConstructor
public class User1Controller {

    private final User1Service user1Service;

    @GetMapping("/user1/register")
    public String register() {
        return "/user1/register";
    }

    @PostMapping("/user1/register")
    public String register(User1DTO user1DTO) {
        log.debug(user1DTO.toString());
        user1Service.save(user1DTO);
        return "redirect:/user1/list";
    }

    @GetMapping("/user1/list")
    public String list(Model model) {

        model.addAttribute("dtoList", user1Service.getUsers());

        return "/user1/list";
    }

    @GetMapping("/user1/modify")
    public String modify() {
        return "/user1/modify";
    }

}
