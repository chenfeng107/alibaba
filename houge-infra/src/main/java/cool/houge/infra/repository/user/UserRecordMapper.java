package cool.houge.infra.repository.user;

import cool.houge.domain.model.User;
import cool.houge.infra.db.tables.records.UserRecord;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/** @author KK (kzou227@qq.com) */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface UserRecordMapper {

  UserRecordMapper INSTANCE = Mappers.getMapper(UserRecordMapper.class);

  /**
   * @param id
   * @param model
   * @return
   */
  @Mapping(source = "id", target = "id")
  @Mapping(target = "createTime", ignore = true)
  @Mapping(target = "updateTime", ignore = true)
  UserRecord toRecord(Long id, User model);

  /**
   * @param userRecord
   * @return
   */
  User toModel(UserRecord userRecord);
}
