package com.wisdom.agriculture.deviceConn.service;

import java.sql.SQLException;


import com.wisdom.agriculture.deviceConn.domain.DeviceConnection;

public interface DeviceService {

	void checkin(DeviceConnection deviceCon) throws SQLException;

}
