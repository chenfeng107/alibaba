package cool.houge.infra.repository.user;

import cool.houge.domain.model.User;
import cool.houge.infra.db.tables.records.UserRecord;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-27T16:49:53+0800",
    comments = "version: 1.5.0.Beta1, compiler: javac, environment: Java 11.0.8 (Oracle Corporation)"
)
class UserRecordMapperImpl implements UserRecordMapper {

    @Override
    public UserRecord toRecord(Long id, User model) {
        if ( id == null && model == null ) {
            return null;
        }

        UserRecord userRecord = new UserRecord();

        if ( model != null ) {
            userRecord.setOriginUid( model.getOriginUid() );
        }
        userRecord.setId( id );

        return userRecord;
    }

    @Override
    public User toModel(UserRecord userRecord) {
        if ( userRecord == null ) {
            return null;
        }

        User user = new User();

        user.setId( userRecord.getId() );
        user.setOriginUid( userRecord.getOriginUid() );
        user.setCreateTime( userRecord.getCreateTime() );
        user.setUpdateTime( userRecord.getUpdateTime() );

        return user;
    }
}
