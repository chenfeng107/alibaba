package cool.houge.infra.repository.system;

import cool.houge.domain.model.ServerInstance;
import cool.houge.infra.db.tables.records.ServerInstanceRecord;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-27T16:35:46+0800",
    comments = "version: 1.5.0.Beta1, compiler: javac, environment: Java 11.0.8 (Oracle Corporation)"
)
public class ServerInstanceMapperImpl implements ServerInstanceMapper {

    @Override
    public ServerInstance map(ServerInstanceRecord record) {
        if ( record == null ) {
            return null;
        }

        ServerInstance serverInstance = new ServerInstance();

        if ( record.getId() != null ) {
            serverInstance.setId( record.getId() );
        }
        serverInstance.setAppName( record.getAppName() );
        serverInstance.setHostName( record.getHostName() );
        serverInstance.setHostAddress( record.getHostAddress() );
        serverInstance.setOsName( record.getOsName() );
        serverInstance.setOsVersion( record.getOsVersion() );
        serverInstance.setOsArch( record.getOsArch() );
        serverInstance.setOsUser( record.getOsUser() );
        serverInstance.setJavaVmName( record.getJavaVmName() );
        serverInstance.setJavaVmVersion( record.getJavaVmVersion() );
        serverInstance.setJavaVmVendor( record.getJavaVmVendor() );
        serverInstance.setWorkDir( record.getWorkDir() );
        if ( record.getPid() != null ) {
            serverInstance.setPid( record.getPid() );
        }
        if ( record.getVer() != null ) {
            serverInstance.setVer( record.getVer() );
        }
        serverInstance.setCreateTime( record.getCreateTime() );
        serverInstance.setCheckTime( record.getCheckTime() );

        return serverInstance;
    }
}
