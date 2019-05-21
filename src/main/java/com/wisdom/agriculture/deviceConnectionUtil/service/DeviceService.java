package com.wisdom.agriculture.deviceConnectionUtil.service;

import java.sql.SQLException;


import com.wisdom.agriculture.deviceConnectionUtil.domain.DeviceConnection;

public interface DeviceService {

	void checkin(DeviceConnection deviceCon) throws SQLException;

}
