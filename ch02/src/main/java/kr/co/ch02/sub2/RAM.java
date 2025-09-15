package kr.co.ch02.sub2;

import org.springframework.stereotype.Component;

@Component("hynix") // RAM 빈 등록
public class RAM {

    public void show(){
        System.out.println("RAM : SK Hynix 32GB");

    }

}
