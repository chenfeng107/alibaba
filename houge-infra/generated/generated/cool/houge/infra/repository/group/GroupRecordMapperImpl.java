package cool.houge.infra.repository.group;

import cool.houge.domain.model.Group;
import cool.houge.domain.model.User;
import cool.houge.infra.db.tables.records.GroupRecord;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-07T18:37:54+0800",
    comments = "version: 1.5.0.Beta1, compiler: javac, environment: Java 11.0.8 (Oracle Corporation)"
)
public class GroupRecordMapperImpl implements GroupRecordMapper {

    @Override
    public Group map(GroupRecord record) {
        if ( record == null ) {
            return null;
        }

        Group group = new Group();

        group.setOwner( groupRecordToUser( record ) );
        group.setCreator( groupRecordToUser1( record ) );
        if ( record.getId() != null ) {
            group.setId( record.getId().intValue() );
        }
        group.setMemberSize( record.getMemberSize() );
        group.setCreateTime( record.getCreateTime() );
        group.setUpdateTime( record.getUpdateTime() );

        return group;
    }

    protected User groupRecordToUser(GroupRecord groupRecord) {
        if ( groupRecord == null ) {
            return null;
        }

        User user = new User();

        if ( groupRecord.getOwnerId() != null ) {
            user.setId( groupRecord.getOwnerId().intValue() );
        }

        return user;
    }

    protected User groupRecordToUser1(GroupRecord groupRecord) {
        if ( groupRecord == null ) {
            return null;
        }

        User user = new User();

        if ( groupRecord.getCreatorId() != null ) {
            user.setId( groupRecord.getCreatorId().intValue() );
        }

        return user;
    }
}
