package kr.co.ch08.controller;

import kr.co.ch08.dto.User1DTO;
import kr.co.ch08.service.User1Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class User1Controller {

    private final User1Service user1Service;

    @ResponseBody
    @GetMapping("/user1")
    public List<User1DTO> list(){
        List<User1DTO> dtoList = user1Service.getUserAll();
        log.info("dtoList={}",dtoList);
        return dtoList;
    }

    @ResponseBody
    @GetMapping("/user1/{userId}")
    public User1DTO user1(@PathVariable("userId") String userId){

        log.info("userId={}",userId);
        User1DTO user1DTO = user1Service.getUser(userId);

        return user1DTO;
    }

    @ResponseBody
    @PostMapping("/user1")
    public String register(User1DTO user1DTO){
        user1Service.save(user1DTO);
        return "success";
    }

    @ResponseBody
    @PutMapping("/user1")
    public String modify(@RequestBody User1DTO user1DTO){ // @RequestBody : 요청 객체 body로 전송되는 JSON 데이터 수신
        log.info("user1DTO={}",user1DTO);

        user1Service.modify(user1DTO);

        return "modified";
    }

    @ResponseBody
    @DeleteMapping("/user1/{userId}")
    public String delete(@PathVariable("userId") String userId){
        log.info("userId={}",userId);

        user1Service.remove(userId);

        return "deleted";

    }


}
