package com.commsdk.module.response.base;
import java.io.Serializable;

/**
 * @Description 解释基础
 * @author Created by qinxianyuzou on 2014-8-21.
 */
public class BaseResponse implements Serializable {

	/** 序列号 */
	private static final long serialVersionUID = 6945319206585873015L;

	private boolean Result;
	private String State="";
	private String Dynamic="";
	private String Msg="";

	public boolean isResult() {
		return Result;
	}

	public void setResult(boolean result) {
		Result = result;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getMsg() {
		return Msg;
	}

	public void setMsg(String msg) {
		Msg = msg;
	}
}
