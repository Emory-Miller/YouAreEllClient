package rocks.zipcode.service.mapper;

import org.mapstruct.*;
import rocks.zipcode.domain.Channel;
import rocks.zipcode.domain.Message;
import rocks.zipcode.service.dto.ChannelDTO;
import rocks.zipcode.service.dto.MessageDTO;

/**
 * Mapper for the entity {@link Channel} and its DTO {@link ChannelDTO}.
 */
@Mapper(componentModel = "spring")
public interface ChannelMapper extends EntityMapper<ChannelDTO, Channel> {
    @Mapping(target = "message", source = "message", qualifiedByName = "messageId")
    ChannelDTO toDto(Channel s);

    @Named("messageId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    MessageDTO toDtoMessageId(Message message);
}
