package com.easycore.utils;

import java.util.Date;
import com.alibaba.fastjson.annotation.JSONField;

public class ChatMessage {
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date msgtime;
	private String msgfrom;
	private String msgto;
	private String msgbody;

	public Date getMsgtime() {
		return msgtime;
	}

	public void setMsgtime(Date msgtime) {
		this.msgtime = msgtime;
	}

	public String getMsgfrom() {
		return msgfrom;
	}

	public void setMsgfrom(String msgfrom) {
		this.msgfrom = msgfrom;
	}

	public String getMsgto() {
		return msgto;
	}

	public void setMsgto(String msgto) {
		this.msgto = msgto;
	}

	public String getMsgbody() {
		return msgbody;
	}

	public void setMsgbody(String msgbody) {
		this.msgbody = msgbody;
	}

	@Override
	public String toString() {
		return "ChatMessage [msgtime=" + msgtime + ", msgfrom=" + msgfrom
				+ ", msgto=" + msgto + ", msgbody=" + msgbody + "]";
	}
}
