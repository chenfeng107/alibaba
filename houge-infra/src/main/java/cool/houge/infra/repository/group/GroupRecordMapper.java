package cool.houge.infra.repository.group;

import cool.houge.domain.model.Group;
import cool.houge.infra.db.tables.records.GroupRecord;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/** @author KK (kzou227@qq.com) */
@Mapper
public interface GroupRecordMapper {

  GroupRecordMapper INSTANCE = Mappers.getMapper(GroupRecordMapper.class);

  /**
   * @param record
   * @return
   */
  @Mapping(target = "owner.id", source = "ownerId")
  @Mapping(target = "creator.id", source = "creatorId")
  Group map(GroupRecord record);
}
