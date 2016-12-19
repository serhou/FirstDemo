package com.bestlove.generics;

import java.util.List;

/**
 * 类型边界更多层次示例
 * @author think
 *
 */

public class EpicBattle {

	static <POWER extends SuperHearing> void useSuperHearing(SuperHero<POWER> hero) {
		hero.getPower().hearSubtleNoises();
	}
	
	static <POWER extends SuperHearing & SuperSmell> void superFind(SuperHero<POWER> hero) {
		hero.getPower().hearSubtleNoises();
		hero.getPower().trackBySmell();
	}
	
	public static void main(String[] args) {
		
		DogBoy dogBoy = new DogBoy();
		useSuperHearing(dogBoy);
		superFind(dogBoy);
		List<? extends SuperHearing> audioBoys;
//		List<? extends SuperHearing & SuperSmell> dogBoys;//错误，通配符被限制为单一边界
	}
	
}

interface SuperPower {}
//接口之间的继承
interface XRayVision extends SuperPower {
	void seeThroughWalls();
}
interface SuperHearing extends SuperPower {
	void hearSubtleNoises();
}
interface SuperSmell extends SuperPower {
	void trackBySmell();
}

class SuperHero<POWER extends SuperPower> {
	POWER power;
	SuperHero(POWER power) {
		this.power = power;
	}
	POWER getPower() {
		return power;
	}
}

class SuperSleuth<POWER extends XRayVision> extends SuperHero<POWER> {
	SuperSleuth(POWER power) {
		super(power);
	}
	void see() {
		power.seeThroughWalls();
	}
}

class CanineHero<POWER extends SuperHearing & SuperSmell> extends SuperHero<POWER>{
	CanineHero(POWER power) {
		super(power);
	}
	void hear() {
		power.hearSubtleNoises();
	}
	void smell() {
		power.trackBySmell();
	}
}

class SuperHearSmell implements SuperHearing, SuperSmell {
	@Override
	public void trackBySmell() {
		System.out.println("SuperHearSmell.trackBySmell()");
	}
	@Override
	public void hearSubtleNoises() {
		System.out.println("SuperHearSmell.hearSubtleNoises()");
	}
}

class DogBoy extends CanineHero<SuperHearSmell> {
	DogBoy() {
		super(new SuperHearSmell());
	}
}