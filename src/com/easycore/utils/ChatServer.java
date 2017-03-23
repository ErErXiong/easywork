package com.easycore.utils;

import java.beans.PropertyEditorSupport;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import org.java_websocket.WebSocket;
import org.java_websocket.framing.Framedata;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import com.alibaba.fastjson.JSON;

/**
 * A simple WebSocketServer implementation. Keeps track of a "chatroom".
 */
public class ChatServer extends WebSocketServer {
	// 自动绑定日期字段
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new DateEditorC());
	}

	// 无参构造/读取配置文件websocket.ip
	public ChatServer() {
		super(new InetSocketAddress(Integer.parseInt(ConfigUtils.getVal(
				"config/chat.properties", "websocket.ip").split(":")[2])));
	}

	public ChatServer(int port) throws UnknownHostException {
		super(new InetSocketAddress(port));
	}

	public ChatServer(InetSocketAddress address) {
		super(address);
	}

	// 返回配置文件websocket.ip
	public String getChatServerIp() {
		return ConfigUtils.getVal("config/chat.properties", "websocket.ip")
				.trim();
	}

	// 开启chat服务
	@Override
	public void start() {
		try {
			super.start();
		} catch (Exception e) {
			System.out.println("can only be started once");
		}
	}

	// onOpen
	@Override
	public void onOpen(WebSocket conn, ClientHandshake handshake) {
	}

	// onClose
	@Override
	public void onClose(WebSocket conn, int code, String reason, boolean remote) {
	}

	// onMessage
	@Override
	public void onMessage(WebSocket conn, String message) {
		ChatMessage msgobj = JSON.parseObject(message, ChatMessage.class);
		msgobj.setMsgtime(new Date());
		setMsgFrom(conn, msgobj);
		setMsgBody(msgobj);
		this.sendToAll(JSON.toJSONString(msgobj));
	}

	// 设置msgfrom
	private void setMsgFrom(WebSocket conn, ChatMessage msgobj) {
		if (null == msgobj.getMsgfrom()
				|| "".equals(msgobj.getMsgfrom().trim())) {
			String cstr = conn.toString().trim();
			msgobj.setMsgfrom("No." + cstr.split("@")[1]);
		}
	}

	// 设置msgbody
	private void setMsgBody(ChatMessage msgobj) {
		String oldstr = msgobj.getMsgbody();
		String newstr = HtmlUtils.getChatMsg(oldstr);
		msgobj.setMsgbody(newstr);
	}

	// @Override
	public void onFragment(WebSocket conn, Framedata fragment) {
		System.out.println("received fragment: " + fragment);
	}

	@Override
	public void onError(WebSocket conn, Exception ex) {
		ex.printStackTrace();
		if (conn != null) {
			// some errors like port binding failed may not be assignable to a
			// specific websocket
		}
	}

	// 发送至公聊
	public void sendToAll(String text) {
		Collection<WebSocket> con = connections();
		synchronized (con) {
			for (WebSocket c : con) {
				c.send(text);
			}
		}
	}

}

class DateEditorC extends PropertyEditorSupport {
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = format.parse(text);
		} catch (ParseException e) {
			format = new SimpleDateFormat("yyyy-MM-dd");
			try {
				date = format.parse(text);
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
		}
		setValue(date);
	}
}