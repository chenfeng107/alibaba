package cool.houge.infra.repository.system;

import cool.houge.domain.model.AppInst;
import cool.houge.infra.db.tables.records.ServerInstanceRecord;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-27T16:49:54+0800",
    comments = "version: 1.5.0.Beta1, compiler: javac, environment: Java 11.0.8 (Oracle Corporation)"
)
public class ServerInstanceMapperImpl implements ServerInstanceMapper {

    @Override
    public AppInst map(ServerInstanceRecord record) {
        if ( record == null ) {
            return null;
        }

        AppInst appInst = new AppInst();

        if ( record.getId() != null ) {
            appInst.setId( record.getId() );
        }
        appInst.setAppName( record.getAppName() );
        appInst.setHostName( record.getHostName() );
        appInst.setHostAddress( record.getHostAddress() );
        appInst.setOsName( record.getOsName() );
        appInst.setOsVersion( record.getOsVersion() );
        appInst.setOsArch( record.getOsArch() );
        appInst.setOsUser( record.getOsUser() );
        appInst.setJavaVmName( record.getJavaVmName() );
        appInst.setJavaVmVersion( record.getJavaVmVersion() );
        appInst.setJavaVmVendor( record.getJavaVmVendor() );
        appInst.setWorkDir( record.getWorkDir() );
        if ( record.getPid() != null ) {
            appInst.setPid( record.getPid() );
        }
        if ( record.getVer() != null ) {
            appInst.setVer( record.getVer() );
        }
        appInst.setCreateTime( record.getCreateTime() );
        appInst.setCheckTime( record.getCheckTime() );

        return appInst;
    }
}
