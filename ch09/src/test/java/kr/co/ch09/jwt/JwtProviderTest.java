package kr.co.ch09.jwt;

import io.jsonwebtoken.Claims;
import kr.co.ch09.Ch09Application;
import kr.co.ch09.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.Authentication;

@SpringBootTest(classes = Ch09Application.class)
class JwtProviderTest {

    @Autowired
    private JwtProvider jwtProvider;

    @Test
    void createToken() {

        User user = User.builder()
                .usid("a101")
                .pass("1234")
                .name("홍길동")
                .role("ADMIN")
                .age(23)
                .build();
        String token = jwtProvider.createToken(user, -1);

        System.out.println(token);
    }

    @Test
    void getClaims() {

        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ0aHN3bHNkbGYwMDAwQGdtYWlsLmNvbSIsImlhdCI6MTc1ODc2MzY0NSwiZXhwIjoxNzU4ODUwMDQ1LCJ1c2VybmFtZSI6ImExMDEiLCJyb2xlIjoiQURNSU4ifQ.N7R6w748I5ZJ3Jj6Gxz_U-WJK84XB6c7uei7qoPMowk";
        String expiredToken = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ0aHN3bHNkbGYwMDAwQGdtYWlsLmNvbSIsImlhdCI6MTc1ODc2NDE5NCwiZXhwIjoxNzU4Njc3Nzk0LCJ1c2VybmFtZSI6ImExMDEiLCJyb2xlIjoiQURNSU4ifQ.17o30r2nN883vpOz8TYYKNJzSpBB6WrpCoDGveKOqnk";

        try {
            jwtProvider.getAuthentication(token);
            System.out.println("토큰 이상 없음...");
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    void getAuthentication() {
    }

    @Test
    void validateToken() {
    }

    @Test
    void getIssuer() {
    }

    @Test
    void getSecretKey() {
    }
}