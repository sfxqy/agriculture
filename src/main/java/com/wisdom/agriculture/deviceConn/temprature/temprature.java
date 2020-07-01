package com.wisdom.agriculture.deviceConn.temprature;

import javax.servlet.*;
import javax.servlet.http.*;

import com.wisdom.agriculture.deviceConn.domain.DeviceConnection;
import com.wisdom.agriculture.deviceConn.service.DeviceService;
import com.wisdom.agriculture.deviceConn.service.impl.DeviceServiceImpl;

import java.text.SimpleDateFormat;
import java.util.*;

import java.io.IOException;
import java.io.InputStream;

import java.io.OutputStream;

import java.net.*;


import com.wisdom.agriculture.pojo.Details;
import com.wisdom.agriculture.service.RedisService;
import com.wisdom.agriculture.utils.RedisUtils;
import com.wisdom.agriculture.utils.SpringUtil;
import net.sf.json.JSONObject;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

class SocketServer extends Thread {
	private Socket socket;
	private OutputStream outputStream;
	private InputStream in;
	private boolean isReceive = true;
	private RedisService redisService;
	//private RedisUtils redisUtils=new RedisUtils();



	public SocketServer(Socket socket) {
		redisService=SpringUtil.getBean(RedisService.class);

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
			 	System.out.println("info---"+new String(buffer, 0, length)+getName()+": "+getThreadGroup().activeCount());
				Integer num=redisService.getNum();
				if (num>=5){
					redisService.persistence();
					redisService.removeValue();
				}
				String deviceData=new String(buffer,0,length);
				JSONObject jsonObject = JSONObject.fromObject(deviceData);
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
				String time=df.format(new Date());// new Date()为获取当前系统时间
				Iterator<String>  keys=jsonObject.keys();
				int m=0;
				while (keys.hasNext()) {
					String teams = keys.next();
					String teamsInfo = jsonObject.optString(teams);
					System.out.println(teams+"=="+teamsInfo);


					if (m!=0){
						Float value=Float.parseFloat(teamsInfo);
						String key=teams+"&"+time;
						redisService.setValue(key,value);
					}
					m++;
				}





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

		JSONObject jsonObject = JSONObject.fromObject(deviceMsg);
		String m = jsonObject.getString("M");
		String deviceId = jsonObject.getString("ID");
		String appkey = jsonObject.getString("K");
		DeviceConnection deviceConnection = new DeviceConnection(deviceId,appkey,socket,1);
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
