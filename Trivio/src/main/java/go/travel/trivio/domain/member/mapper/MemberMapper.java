package go.travel.trivio.domain.member.mapper;

import go.travel.trivio.domain.member.dto.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {

    Member getMember();

}
