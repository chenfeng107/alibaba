package cool.houge.infra.repository.jwt;

import cool.houge.domain.model.JwtSecret;
import cool.houge.infra.db.tables.records.JwtSecretRecord;
import java.util.Arrays;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-27T16:49:54+0800",
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
        byte[] secretKey = model.getSecretKey();
        if ( secretKey != null ) {
            jwtSecretRecord.setSecretKey( Arrays.copyOf( secretKey, secretKey.length ) );
        }
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
        byte[] secretKey = record.getSecretKey();
        if ( secretKey != null ) {
            jwtSecret.setSecretKey( Arrays.copyOf( secretKey, secretKey.length ) );
        }
        if ( record.getDeleted() != null ) {
            jwtSecret.setDeleted( record.getDeleted() );
        }
        jwtSecret.setCreateTime( record.getCreateTime() );
        jwtSecret.setUpdateTime( record.getUpdateTime() );

        return jwtSecret;
    }
}
