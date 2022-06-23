package go.travel.trivio.domain.member.service;

import go.travel.trivio.domain.member.dto.Member;
import go.travel.trivio.domain.member.mapper.MemberMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    MemberMapper memberMapper;

    public MemberService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    public Member getMember() {
        return memberMapper.getMember();
    }
}
