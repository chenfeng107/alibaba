package cool.houge.infra.repository.jwt;

import cool.houge.domain.model.JwtSecret;
import cool.houge.infra.db.tables.records.JwtSecretRecord;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-07T18:37:54+0800",
    comments = "version: 1.5.0.Beta1, compiler: javac, environment: Java 11.0.8 (Oracle Corporation)"
)
public class JwtSecretMapperImpl implements JwtSecretMapper {

    @Override
    public JwtSecretRecord map(JwtSecret model) {
        if ( model == null ) {
            return null;
        }

        JwtSecretRecord jwtSecretRecord = new JwtSecretRecord();

        jwtSecretRecord.setId( model.getId() );
        jwtSecretRecord.setAlgorithm( model.getAlgorithm() );
        jwtSecretRecord.setDeleted( model.getDeleted() );

        return jwtSecretRecord;
    }

    @Override
    public JwtSecret map(JwtSecretRecord record) {
        if ( record == null ) {
            return null;
        }

        JwtSecret jwtSecret = new JwtSecret();

        jwtSecret.setId( record.getId() );
        jwtSecret.setAlgorithm( record.getAlgorithm() );
        if ( record.getDeleted() != null ) {
            jwtSecret.setDeleted( record.getDeleted() );
        }
        jwtSecret.setCreateTime( record.getCreateTime() );
        jwtSecret.setUpdateTime( record.getUpdateTime() );

        return jwtSecret;
    }
}
