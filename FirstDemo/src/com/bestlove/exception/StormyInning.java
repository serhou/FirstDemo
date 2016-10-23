package com.bestlove.exception;

public class StormyInning extends Inning implements Storm{

	public StormyInning() throws RainedOut, BaseballException {};
	
	public StormyInning(String s) throws Foul, BaseballException {};
	
//	void walk() throws PopFoul {}//父类限制不能抛异常
	
//	public void event() throws RainedOut {}//接口与父类冲突
	
	//overrides com.bestlove.exception.Inning.event
	public void event() {
		//可以一个异常也不抛出
	}
	
	@Override
	public void rainHard() throws RainedOut {
	}

	@Override//抛出通过继承得到的异常
	public void atBat() throws PopFoul {//throw inherited exceptions
	
	}
	
	public static void main(String[] args) {
		
		try {
			StormyInning si  = new StormyInning();
			si.atBat();
		} catch (PopFoul e) {
			System.out.println("Pop foul");
		} catch (RainedOut e) {
			System.out.println("Rained out");
		} catch (BaseballException e) {
			System.out.println("Generic baseball exception");
		}
		
		try {
			Inning i = new StormyInning();
			i.atBat();
		} catch (Strike e) {
			System.out.println("Strike...");
		} catch (Foul e) {
			System.out.println("Foul...");
		} catch (RainedOut e) {
			System.out.println("Rained out...");
		} catch (BaseballException e) {
			System.out.println("Generic baseball exception...");
		}
		
		
	}

}

class BaseballException extends Exception {}
class Foul extends BaseballException {}
class Strike extends BaseballException {}

abstract class Inning {
	public Inning() throws BaseballException {}
	public void event() throws BaseballException {}
	public abstract void atBat() throws Strike, Foul;
	public void walk() {}
}

class StormException extends Exception {}
class RainedOut extends StormException {}
class PopFoul extends Foul {}

interface Storm {
	public void event() throws RainedOut;
	public void rainHard() throws RainedOut;
}