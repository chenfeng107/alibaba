package cool.houge.infra.repository.system;

import cool.houge.domain.model.AppInst;
import cool.houge.infra.db.tables.records.ServerInstanceRecord;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/** @author KK (kzou227@qq.com) */
@Mapper
public interface ServerInstanceMapper {

  ServerInstanceMapper INSTANCE = Mappers.getMapper(ServerInstanceMapper.class);

  /**
   * @param record
   * @return
   */
  AppInst map(ServerInstanceRecord record);
}
