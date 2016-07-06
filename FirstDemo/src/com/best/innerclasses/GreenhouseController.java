package com.best.innerclasses;


/**
 * 
 * 这个类的作用是初始化系统，所以它添加了所有相应的事件。
 * Restart事件反复运行，而且它每次都会讲eventList加载到
 * GreenhouseControls对象中。如果提供了命令行参数，系统
 * 会以它作为毫秒数，决定什么时候终止程序。
 * 
 * @author think
 *
 */

public class GreenhouseController {

	public static void main(String[] args) {
		
		GreenhouseControls gc = new GreenhouseControls();
		gc.addEvent(gc.new Bell(900));
		Event[] eventList = {
			gc.new ThermostatNight(0),
			gc.new LightOn(200),
			gc.new LightOff(400),
			gc.new WaterOn(600),
			gc.new WaterOff(800),
			gc.new ThermostatDay(1400)
		};
		gc.addEvent(gc.new Restart(200, eventList));
		if(args.length == 0){
			gc.addEvent(
					new GreenhouseControls.Terminate(new Integer(0))
					);
			gc.run();
		}
		
	}
	
	
}
