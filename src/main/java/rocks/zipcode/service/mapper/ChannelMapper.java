package rocks.zipcode.service.mapper;

import org.mapstruct.*;
import rocks.zipcode.domain.Channel;
import rocks.zipcode.domain.UserProfile;
import rocks.zipcode.service.dto.ChannelDTO;
import rocks.zipcode.service.dto.UserProfileDTO;

/**
 * Mapper for the entity {@link Channel} and its DTO {@link ChannelDTO}.
 */
@Mapper(componentModel = "spring")
public interface ChannelMapper extends EntityMapper<ChannelDTO, Channel> {
    @Mapping(target = "userProfile", source = "userProfile", qualifiedByName = "userProfileId")
    ChannelDTO toDto(Channel s);

    @Named("userProfileId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    UserProfileDTO toDtoUserProfileId(UserProfile userProfile);
}
