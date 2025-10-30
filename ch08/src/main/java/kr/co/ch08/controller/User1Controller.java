package kr.co.ch08.controller;

import jakarta.validation.Valid;
import kr.co.ch08.dto.User1DTO;
import kr.co.ch08.service.User1Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
@RestController // 해당 컨트롤러 요청 메서드 반환값을 JSON 출력으로 처리
public class User1Controller {

    private final User1Service user1Service;

    @GetMapping("/user1")
    public  ResponseEntity<List<User1DTO>> list(){
        List<User1DTO> dtoList = user1Service.getUserAll();

        // 다양한 결과 정보를 출력하기 위해 ResponseEntity로 데이터 전송
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(dtoList);
    }

    @GetMapping("/user1/{userId}")
    public ResponseEntity<User1DTO> user1(@PathVariable("userId") String userId){
        log.info("userId={}",userId);
        User1DTO user1DTO = user1Service.getUser(userId);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(user1DTO);
    }

    @PostMapping("/user1")
    public ResponseEntity<User1DTO> register(@Valid @RequestBody User1DTO user1DTO){

        log.info("user1DTO={}",user1DTO);
        User1DTO savedUser1 = user1Service.save(user1DTO);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedUser1);
    }

    @PutMapping("/user1")
    public ResponseEntity<User1DTO> modify(@RequestBody User1DTO user1DTO){ // @RequestBody : 요청 객체 body로 전송되는 JSON 데이터 수신

        log.info("user1DTO={}",user1DTO);

        User1DTO modifiedUser1 = user1Service.modify(user1DTO);

        return ResponseEntity.status(HttpStatus.OK).body(modifiedUser1);
    }

    @DeleteMapping("/user1/{userId}")
    public ResponseEntity<Boolean> delete(@PathVariable("userId") String userId){
        log.info("userId={}",userId);
        boolean isSuccess = user1Service.remove(userId);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(isSuccess);

    }


}
