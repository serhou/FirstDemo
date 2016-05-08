package com.bestlove.test;

/**
 * 向上转型
 * @author think
 *
 */


class Wind extends Instrument{

	@Override
	public void play(Note n) {
		System.out.println("Wind.play()==="+n);
	}
	
	public void look(Note n){
		System.out.println("Wind.look()==="+n);
	}
	
}


public class Music{
	
	public static void tune(Instrument i, Note n){
		i.play(n);
	}
	
	
	public static void main(String[] args) {
		Wind flute = new Wind();
		tune(flute, Note.B_FLAT);
		flute.look(Note.C_SHARP);
		flute.play(Note.C_SHARP);
		flute.see(Note.MIDDLE_C);
	}
}



class Instrument{
	public void play(Note n){
		System.out.println("Instrument.play()==="+n);
	}
	
	public void see(Note n){
		System.out.println("Instrument.see()==="+n);
	}
}

enum Note{
	MIDDLE_C, C_SHARP, B_FLAT
}

