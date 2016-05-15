package com.bestlove.test;

import java.util.Arrays;

public abstract class StringProcessor2 implements Processor2 {
	public String name() {
		return getClass().getSimpleName();
	}
	public abstract String process(Object input);
	public static String s = "If she weighs the same as a duck. she's made of wood.";
	public static void main(String[] args) {
		Apply2.process(new Upcase2(), s);
		Apply2.process(new Downcase2(), s);
		Apply2.process(new Splitter2(), s);
	}
}

class Upcase2 extends StringProcessor2 {
	public String process(Object input) {
		return ((String)input).toUpperCase();
	}
}

class Downcase2 extends StringProcessor2 {
	public String process(Object input) {
		return ((String)input).toLowerCase();
	}
}

class Splitter2 extends StringProcessor2 {
	public String process(Object input) {
		return Arrays.toString(((String)input).split(" "));
	}
}



