package com.bestlove.test;

/**
 * Filter与Processor具有相同的接口元素，但是因为它并非继承自Processor——
 * 因为Filter类的创建者压根不清楚你想要将它用作Processor——因此你不能将Filter
 * 用于Apply.process()方法，即便这样做可以正常运行(实际编译器会报错)。
 * 这里主要原因是因为Apply.process()方法和Processor之间的耦合过紧，已经超出了
 * 所需要的程度，这就使得应该复用Apply.process()的代码时，复用却被禁止了。
 * 另外还需要注意的是它们输入和输出都是Waveform。
 * @author think
 *
 */

public class Waveform {
	private static long counter;
	private final long id  = counter++;
	public String toString() {
		return "Waveform " + id;
	}
}

class Filter {
	public String name() {
		return getClass().getSimpleName();
	}
	public Waveform process(Waveform input) {
		return input;
	}
}

class LowPass extends Filter {
	double cutoff;
	public LowPass(double cutoff) {
		this.cutoff = cutoff;
	}
	public Waveform process(Waveform input) {
		return input;
	}
}

class HighPass extends Filter {
	double cutoff;
	public HighPass(double cutoff) {
		this.cutoff = cutoff;
	}
	public Waveform process(Waveform input) {
		return input;
	}
}

class BandPass extends Filter {
	double lowCutoff, highCutoff;
	public BandPass(double lowCut, double highCut) {
		lowCutoff = lowCut;
		highCutoff = highCut;
	}
	public Waveform process(Waveform input) {
		return input;
	}
}
