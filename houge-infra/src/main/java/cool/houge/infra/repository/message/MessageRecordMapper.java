package cool.houge.infra.repository.message;

import cool.houge.domain.model.Msg;
import cool.houge.infra.db.tables.records.MessageRecord;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/** @author KK (kzou227@qq.com) */
@Mapper
public interface MessageRecordMapper {

  MessageRecordMapper INSTANCE = Mappers.getMapper(MessageRecordMapper.class);

  /**
   * @param record
   * @return
   */
  @Mapping(source = "receiverId", target = "receiver.id")
  @Mapping(source = "senderId", target = "sender.id")
  @Mapping(source = "groupId", target = "group.id")
  Msg map(MessageRecord record);
}
