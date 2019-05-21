package com.wisdom.agriculture.deviceConnectionUtil.service.impl;

import java.sql.SQLException;

import com.wisdom.agriculture.deviceConnectionUtil.domain.DeviceConnection;
import com.wisdom.agriculture.deviceConnectionUtil.service.DeviceService;


public class DeviceServiceImpl implements DeviceService {



	/* (non-Javadoc)
	 * @see com.lql.service.DeviceService#checkin(com.lql.domain.DeviceConnection)
	 * 登陆设备
	 *
	 */
	@Override
	public void checkin(DeviceConnection deviceCon) throws SQLException {
		System.out.println("进入checkin");

		//QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());

		String sql = "update device set isOnline=? where deviceId=?";
		System.out.println(sql);
		System.out.println(deviceCon.getDeviceId()+"--"+deviceCon.getDeviceKey()+"--"+deviceCon.getDeviceSocket()+"--"+deviceCon.getIsOnline());
		//queryRunner.update(sql, deviceCon.getIsOnline(),deviceCon.getDeviceId());

	}
}
