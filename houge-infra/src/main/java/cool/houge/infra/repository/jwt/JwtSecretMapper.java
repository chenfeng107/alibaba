package cool.houge.infra.repository.jwt;

import cool.houge.domain.model.JwtSecret;
import cool.houge.infra.db.tables.records.JwtSecretRecord;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/** @author KK (kzou227@qq.com) */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface JwtSecretMapper {

  JwtSecretMapper INSTANCE = Mappers.getMapper(JwtSecretMapper.class);

  /**
   * @param model
   * @return
   */
  @Mapping(target = "createTime", ignore = true)
  @Mapping(target = "updateTime", ignore = true)
  JwtSecretRecord map(JwtSecret model);

  /**
   * @param record
   * @return
   */
  JwtSecret map(JwtSecretRecord record);
}
