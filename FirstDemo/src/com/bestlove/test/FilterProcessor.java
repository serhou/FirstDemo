package com.bestlove.test;

public class FilterProcessor {

	public static void main(String[] args) {
		Waveform w = new Waveform();
		Apply2.process(new FilterAdapter(new LowPass(1.0)), w);
		Apply2.process(new FilterAdapter(new HighPass(2.0)), w);
		Apply2.process(new FilterAdapter(new BandPass(3.0, 4.0)), w);
	}
	
}

//适配器设计模式：适配器中的代码将接受你所拥有的接口，并产生你所需要的接口
class FilterAdapter implements Processor2 {
	Filter filter;

	public FilterAdapter(Filter filter) {
		this.filter = filter;
	}

	public String name() {
		return filter.name();
	}

	public Waveform process(Object input) {
		return filter.process((Waveform) input);
	}
	
}
