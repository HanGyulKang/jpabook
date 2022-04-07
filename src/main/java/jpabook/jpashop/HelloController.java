package jpabook.jpashop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        // model에 data라는 이름으로 Hello!란 값을 담아서 View로 보냄
        model.addAttribute("data", "Hello!");
        // return은 화면 이름
        return "hello";
    }
}
