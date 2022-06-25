package go.travel.trivio.domain.member.controller;

import go.travel.trivio.domain.member.dto.Member;
import go.travel.trivio.domain.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
    
    @Autowired
    MemberService memberService;
    
    @GetMapping("/")
    public String test(){
        Member member = memberService.getMember();
        System.out.println("member = " + member);

        return "home";
    }
}
