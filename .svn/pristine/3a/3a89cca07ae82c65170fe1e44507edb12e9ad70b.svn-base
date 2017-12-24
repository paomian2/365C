package com.commsdk.common;

import android.os.Handler;
import android.os.Message;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 时间倒计时工具类
 * 
 * */
public class TimerUtil {

	private static TimerUtil instance;
	private MyTimer timer;
	/**倒计时时间，默认60s*/
	private int TIME_DEF=60;
	/***/
	private int showTime;
	/**是否正在进行倒计时*/
	private boolean isRunning;

	private TimerUtil(){

	}

	synchronized public static TimerUtil getInstance(){
		if (instance==null)
			instance=new TimerUtil();
		return instance;
	}


	public void setTime(int time){
		this.TIME_DEF=time;
	}


	public MyTimer startRunning(){
		showTime=TIME_DEF;
		timer=new MyTimer();
		final TimerTask timerTask=new TimerTask() {
			@Override
			public void run() {
				showTime--;
				Message msg=new Message();
				msg.what=showTime;
				showTimeHandler.sendMessage(msg);
			}
		};
		timer.schedule(timerTask, 1000, 1000);
		return timer;
	}

	class MyTimer extends Timer {
		public void resCancel(){
			this.cancel();
		};
	}


	private Handler showTimeHandler=new Handler(){
		public void handleMessage(Message msg) {
			if (msg.what<=0) {
				if(timer!=null)
					timer.cancel();
				timer=null;
				if (mTimerCallBack!=null)
					mTimerCallBack.donInFinishTime(msg.what);
				isRunning=false;
			}else{
				if (mTimerCallBack!=null)
					mTimerCallBack.doInRunTime(msg.what);
			}
		};
	};


	public interface TimerCallBack{
		public void doInRunTime(int time);
		public void donInFinishTime(int time);
	}

	private TimerCallBack mTimerCallBack;
	public void setTimerCallBack(TimerCallBack timerCallBack){
		this.mTimerCallBack=timerCallBack;
	}


}
