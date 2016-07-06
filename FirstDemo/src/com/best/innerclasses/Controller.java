package com.best.innerclasses;

import java.util.ArrayList;
import java.util.List;


/**
 * 注意，在目前的设计中你并不知道Event到底做了什么。这正是此设计的关键所在，
 * “使变化的事物与不变的事物相互分离”。“变化向量”就是各种不同的Event对象所
 * 具有的不同行为，而你通过创建不同的Event子类来表现不同的行为。
 * 
 * 这正是内部类要做的事情，内部类允许：
 * 1) 控制框架的完整实现是由单个的类创建的，从而使得实现的细节被封装了起来。
 * 	  内部类用来表示解决问题所必需的各种不同的action()。
 * 2) 内部类能够很容易地访问外围类的任意成员，所以可以避免这种实现变得笨拙。
 *   如果没有这种能力，代码将变得令人讨厌，以至于你肯定会选择别的方法。
 * @author think
 *
 */


public class Controller {

	private List<Event> eventList = new ArrayList<Event>();
	
	public void addEvent(Event c) {
		eventList.add(c);
	}
	/**
	 * run()方法循环遍历eventList，寻找就绪的(ready())，要运行的
	 * Event对象。
	 */
	public void run() {
		while(eventList.size() > 0) {
			for(Event e : new ArrayList<Event>(eventList)){
				if(e.ready()) {
					System.out.println("=============== " + e);
					e.action();
					eventList.remove(e);
				}
			}
		}
	}
	
}
