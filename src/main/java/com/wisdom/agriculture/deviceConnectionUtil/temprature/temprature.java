package com.wisdom.agriculture.deviceConnectionUtil.temprature;

import com.wisdom.agriculture.deviceConnectionUtil.domain.DeviceConnection;
import com.wisdom.agriculture.deviceConnectionUtil.service.DeviceService;
import com.wisdom.agriculture.deviceConnectionUtil.service.impl.DeviceServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;




import java.util.*;

import java.io.IOException;
import java.io.InputStream;

import java.io.OutputStream;

import java.net.*;


class SocketServer extends Thread {
	private Socket socket;
	private OutputStream outputStream;
	private InputStream in;
	private boolean isReceive = true;

	public SocketServer(Socket socket) {
		this.socket = socket;
		try {
			// 设置接收客户端消息的超时的时间
			socket.setSoTimeout(20000);
			outputStream = socket.getOutputStream();
			in = socket.getInputStream();
		} catch (SocketException e) {
			isReceive = false;//结束当前线程

			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void run() {
		String output = "";
		boolean flage = true;
		try {

			if (flage) {
				flage = false;
				outputStream.write("你已经连接上服务其".getBytes());

			}
			while (true) {

				byte[] buffer = new byte[1024];
				int length = in.read(buffer);
				String aa=new String(buffer, 0, length);

				String[] temp=aa.split(",");
				System.out.println(temp[1]);
				System.out.println(temp[1].split(":")[1]);
				//String number=temp[1].split(":")[1];
				//	System.out.println(number);

				System.out.println(new String(buffer, 0, length)+getName()+": "+getThreadGroup().activeCount());

			}

		} catch (IOException ioex) {

			ioex.printStackTrace();
		} finally {

			try {
				in.close();
				outputStream.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}
}

public class temprature extends HttpServlet {
	private String message;

	public void init() throws ServletException {
		System.out.println("=================TCP SerVice Start！=================");
		new Thread() {
			public void run() {
				try {
					ServerSocket server = new ServerSocket(8888);
					Socket socket = null;
					while (true) {
						socket = server.accept();
						System.out.println("接收来自"
								+ socket.getInetAddress().getHostAddress());
						OutputStream outputStream = socket.getOutputStream();
						//	outputStream.write("你已经连接上服务其".getBytes());
						DeviceConnection deviceCon = getDeviceCon(socket);
						//获取所有的连接
						Map<String, DeviceConnection> deviceConnection = getDeviceConnection();
						//将连接添加到map中
						deviceConnection.put(deviceCon.getDeviceId(), deviceCon);
						//去数据库中修改设备的登陆状态
						DeviceService device = new DeviceServiceImpl();
						//设备登陆
						device.checkin(deviceCon);
						//返回信息
						outputStream.write("ok".getBytes());

						SocketServer ss = new SocketServer(socket);
						ss.start();
					}
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				}

			}
		}.start();

		System.out
				.println("=================TCP SerVice Start！=================");
	}

	/**
	 * 拼装成Device
	 * @param socket
	 * @return
	 * @throws IOException
	 */
	protected DeviceConnection getDeviceCon(Socket socket) throws IOException {

//    	//获取登陆设备的信息
		InputStream in = socket.getInputStream();
//		BufferedReader msReader = new BufferedReader(new InputStreamReader(in));
		byte[] buffer = new byte[1024];
		int length = in.read(buffer);

		//设备的登陆信息
		String deviceMsg = new String(buffer, 0, length);
		System.out.println("设备:"+deviceMsg);
/*
		JSONObject jsonObject = JSONObject.fromObject(deviceMsg);
		String m = jsonObject.getString("M");
		String deviceId = jsonObject.getString("ID");
		String appkey = jsonObject.getString("K");*/
		DeviceConnection deviceConnection = null;//new DeviceConnection(deviceId,appkey,socket,1);
		//in.close();
		return deviceConnection;
	}

	/**
	 * @return 获取系统中的所有设备连接
	 */
	public Map<String, DeviceConnection> getDeviceConnection(){

		ServletContext servletContext = getServletContext();
		Map<String,DeviceConnection> Connections = (Map<String, DeviceConnection>) servletContext.getAttribute("connections");

		if(Connections==null){

			Connections = new HashMap<>();
			servletContext.setAttribute("connections", Connections);

		}

		return Connections;
	}

	public void destroy() {
	}
}
