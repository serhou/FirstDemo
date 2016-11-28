package com.bestlove.classtype;

import java.util.List;

interface Robot {

	String name();
	String model();
	List<Operation> operations();
	class Test {
		public static void test(Robot r) {
			if (r instanceof Null) {
				System.out.println("[Null Robot]");
			}
			System.out.println("Robot name: " + r.name());
			System.out.println("Robot model: " + r.model());
			for (Operation operation : r.operations()) {
				System.out.println(operation.description());
				operation.command();
			}
		}
	}
}

public interface Operation {
	String description();
	void command();
}
