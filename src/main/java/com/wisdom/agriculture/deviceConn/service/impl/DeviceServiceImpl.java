package com.wisdom.agriculture.deviceConn.service.impl;

import java.sql.SQLException;

import com.wisdom.agriculture.deviceConn.domain.DeviceConnection;
import com.wisdom.agriculture.deviceConn.service.DeviceService;
import com.wisdom.agriculture.deviceConn.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;


public class DeviceServiceImpl implements DeviceService {

	
	
	/* (non-Javadoc)
	 * @see com.lql.service.DeviceService#checkin(com.lql.domain.DeviceConnection)
	 * ��½�豸
	 * 
	 */
	@Override
	public void checkin(DeviceConnection deviceCon) throws SQLException {
		
		/*QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		
		String sql = "update device set isOnline=? where deviceId=?";
		queryRunner.update(sql, deviceCon.getIsOnline(),deviceCon.getDeviceId());*/
		
	}

}
