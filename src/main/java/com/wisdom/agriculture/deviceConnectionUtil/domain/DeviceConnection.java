package com.wisdom.agriculture.deviceConnectionUtil.domain;

import java.net.Socket;

public class DeviceConnection {

	
	public DeviceConnection(String deviceId, String deviceKey,
			Socket deviceSocket, Integer isOnline) {
		this.deviceId = deviceId;
		this.deviceKey = deviceKey;
		this.deviceSocket = deviceSocket;
		this.isOnline = isOnline;
	}
	
	
	public DeviceConnection() {
	}


	private String deviceId;
	private String deviceKey;
	private Socket deviceSocket;
	private Integer isOnline=0;//�豸�Ƿ����� 0�������� 1������
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public String getDeviceKey() {
		return deviceKey;
	}
	public void setDeviceKey(String deviceKey) {
		this.deviceKey = deviceKey;
	}
	public Socket getDeviceSocket() {
		return deviceSocket;
	}
	public void setDeviceSocket(Socket deviceSocket) {
		this.deviceSocket = deviceSocket;
	}
	public Integer getIsOnline() {
		return isOnline;
	}
	public void setIsOnline(Integer isOnline) {
		this.isOnline = isOnline;
	}
	
	
	
}
