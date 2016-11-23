package com.bestlove.classtype;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 注册工厂
 * 工厂方法模式：
 * 将对象的创建工作交给类自己去完成。
 * 工厂方法可以被多态的调用，从而为你穿件恰当类型的对象。
 * @author think
 *
 */

public class RegisteredFactories {

	public static void main(String[] args) {
		
		for (int i = 0; i < 25; i++) {//想创建几个创建几个
			System.out.println(Part.createRandom());
		}
		
	}
	
}

interface Factory<T> {
	T create();
}

class Part {
	@Override
	public String toString() {
		return getClass().getSimpleName();
	}
	static List<Factory<? extends Part>> partFactories =
			new ArrayList<Factory<? extends Part>>();
	static {
		partFactories.add(new FuelFilter.Factory());
		partFactories.add(new AirFilter.Factory());
		partFactories.add(new CabinAirFilter.Factory());
		partFactories.add(new OilFilter.Factory());
		partFactories.add(new FanBelt.Factory());
		partFactories.add(new GeneratorBelt.Factory());
		partFactories.add(new PowerSteeringBelt.Factory());
	}
	private static Random rand = new Random();
	public static Part createRandom() {
		int n = rand.nextInt(partFactories.size());
		return partFactories.get(n).create();//每次随机取一个
	}
}

class Filter extends Part {}

class FuelFilter extends Filter {
	public static class Factory implements com.bestlove.classtype.Factory<FuelFilter> {
		@Override
		public FuelFilter create() {
			return new FuelFilter();
		}
	}
}

class AirFilter extends Filter {
	public static class Factory implements com.bestlove.classtype.Factory<AirFilter> {
		@Override
		public AirFilter create() {
			return new AirFilter();
		}
	}
}

class CabinAirFilter extends Filter {
	public static class Factory implements com.bestlove.classtype.Factory<CabinAirFilter> {
		@Override
		public CabinAirFilter create() {
			return new CabinAirFilter();
		}
	}
}

class OilFilter extends Filter {
	public static class Factory implements com.bestlove.classtype.Factory<OilFilter> {
		@Override
		public OilFilter create() {
			return new OilFilter();
		}
	}
}

class Belt extends Part {}

class FanBelt extends Belt {
	public static class Factory implements com.bestlove.classtype.Factory<FanBelt> {
		@Override
		public FanBelt create() {
			return new FanBelt();
		}
	}
}

class GeneratorBelt extends Belt {
	public static class Factory implements com.bestlove.classtype.Factory<GeneratorBelt> {
		@Override
		public GeneratorBelt create() {
			return new GeneratorBelt();
		}
	}
}

class PowerSteeringBelt extends Belt {
	public static class Factory implements com.bestlove.classtype.Factory<PowerSteeringBelt> {
		@Override
		public PowerSteeringBelt create() {
			return new PowerSteeringBelt();
		}
	}
}