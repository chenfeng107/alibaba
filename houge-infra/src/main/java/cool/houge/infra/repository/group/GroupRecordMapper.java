package cool.houge.infra.repository.group;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/** @author KK (kzou227@qq.com) */
@Mapper
public interface GroupRecordMapper {

  GroupRecordMapper INSTANCE = Mappers.getMapper(GroupRecordMapper.class);
}
