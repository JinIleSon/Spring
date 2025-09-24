package kr.co.ch08.controller;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import kr.co.ch08.dto.User1DTO;
import kr.co.ch08.dto.User2DTO;
import kr.co.ch08.entity.User2;
import kr.co.ch08.service.User2Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class User2Controller {
    private final User2Service user2Service;

    @GetMapping("/user2")
    public ResponseEntity<List<User2DTO>> list(){
        List<User2DTO> dtoList = user2Service.getUserAll();
        return ResponseEntity.status(HttpStatus.OK).body(dtoList);
    }

    @GetMapping("/user2/{userId}")
    public ResponseEntity<User2DTO> user2(@PathVariable("userId") String userId){
        User2DTO user2DTO = user2Service.getUser(userId);
        return ResponseEntity.status(HttpStatus.FOUND).body(user2DTO);
    }

    @PostMapping("/user2")
    public ResponseEntity<User2DTO> register(@RequestBody User2DTO user2DTO){
        User2DTO savedUser2 = user2Service.save(user2DTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser2);
    }

    @PutMapping("/user2")
    public ResponseEntity<User2DTO> modify(@RequestBody User2DTO user2DTO){
        User2DTO modifiedUser2 = user2Service.modify(user2DTO);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(modifiedUser2);
    }

    @DeleteMapping("/user2/{userId}")
    public ResponseEntity<Boolean> delete(@PathVariable("userId") String userId){

        boolean isSuccess = user2Service.remove(userId);
        return ResponseEntity.status(HttpStatus.OK).body(isSuccess);


    }

}
