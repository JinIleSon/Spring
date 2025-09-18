package kr.co.ch04.Controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

// 수동 입력
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
class User1ControllerTest {

    @Autowired
    private MockMvc mockMvc; // MVC 테스트를 위한 가상 객체

    @Test
    void register() throws Exception {
        for(int i=0 ; i<100 ; i++) {
            mockMvc.perform(
                            post("/user1/register")
                                    .param("userId", "a200" + i)
                                    .param("userName", "홍길동")
                                    .param("birth", "1992-10-02")
                                    .param("age", "21")
                    )
                    .andExpect(status().is3xxRedirection())
                    .andExpect(redirectedUrl("/user1/list"))
                    .andDo(print());
        }
    }

    @Test
    void list() throws Exception {

        mockMvc.perform(get("/user1/list")) // get으로 list경로 감
                .andExpect(status().isOk()) // 200인지 확인
                .andExpect(view().name("/user1/list"))
                .andDo(print()); // 검사 결과 출력
    }

    @Test
    void modify() throws Exception {

        mockMvc.perform(
                        post("/user1/modify")
                                .param("userId", "asdfas") // post로 /user1/modify에 param을 보냄
                                .param("userName", "홍길동")
                                .param("birth", "1992-10-02")
                                .param("age", "21")
                )
                .andExpect(status().is3xxRedirection()) // 3xx 상태인지 확인
                .andExpect(redirectedUrl("/user1/list")) // redirect 경로가 /user1/list인지 확인
                .andDo(print());


    }

    @Test
    void delete() throws Exception {
        mockMvc.perform(get("/user1/delete").param("userId", "a1021")) // get으로 /user1/delete에 userId를 보냄
                .andExpect(redirectedUrl("/user1/list"))
                .andDo(print());

    }
}