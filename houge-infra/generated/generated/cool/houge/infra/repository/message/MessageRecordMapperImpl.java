package cool.houge.infra.repository.message;

import cool.houge.domain.model.Group;
import cool.houge.domain.model.Msg;
import cool.houge.domain.model.User;
import cool.houge.infra.db.tables.records.MessageRecord;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-07T18:37:54+0800",
    comments = "version: 1.5.0.Beta1, compiler: javac, environment: Java 11.0.8 (Oracle Corporation)"
)
public class MessageRecordMapperImpl implements MessageRecordMapper {

    @Override
    public Msg map(MessageRecord record) {
        if ( record == null ) {
            return null;
        }

        Msg msg = new Msg();

        msg.setReceiver( messageRecordToUser( record ) );
        msg.setSender( messageRecordToUser1( record ) );
        msg.setGroup( messageRecordToGroup( record ) );
        msg.setId( record.getId() );
        if ( record.getKind() != null ) {
            msg.setKind( record.getKind().intValue() );
        }
        msg.setContent( record.getContent() );
        if ( record.getContentType() != null ) {
            msg.setContentType( record.getContentType().intValue() );
        }
        if ( record.getUnread() != null ) {
            msg.setUnread( record.getUnread().intValue() );
        }
        msg.setCreateTime( record.getCreateTime() );
        msg.setUpdateTime( record.getUpdateTime() );

        return msg;
    }

    protected User messageRecordToUser(MessageRecord messageRecord) {
        if ( messageRecord == null ) {
            return null;
        }

        User user = new User();

        if ( messageRecord.getReceiverId() != null ) {
            user.setId( messageRecord.getReceiverId().intValue() );
        }

        return user;
    }

    protected User messageRecordToUser1(MessageRecord messageRecord) {
        if ( messageRecord == null ) {
            return null;
        }

        User user = new User();

        if ( messageRecord.getSenderId() != null ) {
            user.setId( messageRecord.getSenderId().intValue() );
        }

        return user;
    }

    protected Group messageRecordToGroup(MessageRecord messageRecord) {
        if ( messageRecord == null ) {
            return null;
        }

        Group group = new Group();

        if ( messageRecord.getGroupId() != null ) {
            group.setId( messageRecord.getGroupId().intValue() );
        }

        return group;
    }
}
