package com.best.innerclasses;

public abstract class Event {

	private long eventTime;
	protected final long delayTime;
	public Event(long delayTime) {
		this.delayTime = delayTime;
		start();
	}
	public void start() {
		//获取当前时间，然后加上一个延迟时间，这样生成触发事件的时间
		eventTime = System.nanoTime() + delayTime;
	}
	//ready()告诉你何时可以运行action()方法了。当然，可以在导出类中覆盖ready()方法，
	//使得Event能够基于时间以外的其他因素而触发。
	public boolean ready() {
		return System.nanoTime() >= eventTime;
	}
	public abstract void action();
	
}
