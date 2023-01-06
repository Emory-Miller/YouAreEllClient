package rocks.zipcode.service.mapper;

import org.mapstruct.*;
import rocks.zipcode.domain.Channel;
import rocks.zipcode.domain.Member;
import rocks.zipcode.domain.User;
import rocks.zipcode.service.dto.ChannelDTO;
import rocks.zipcode.service.dto.MemberDTO;
import rocks.zipcode.service.dto.UserDTO;

/**
 * Mapper for the entity {@link Member} and its DTO {@link MemberDTO}.
 */
@Mapper(componentModel = "spring")
public interface MemberMapper extends EntityMapper<MemberDTO, Member> {
    @Mapping(target = "user", source = "user", qualifiedByName = "userId")
    @Mapping(target = "channel", source = "channel", qualifiedByName = "channelId")
    MemberDTO toDto(Member s);

    @Named("userId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    UserDTO toDtoUserId(User user);

    @Named("channelId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    ChannelDTO toDtoChannelId(Channel channel);
}
