package com.bestlove.classtype;

public interface Null {}

class Person {
	public final String FIRST;
	public final String LAST;
	public final String ADDRESS;
	public Person(String first, String last, String address) {
		FIRST = first;
		LAST = last;
		ADDRESS = address;
	}
	@Override
	public String toString() {
		return "Person: " + FIRST + " " + LAST + " " + ADDRESS;
	}
	public static class NullPerson extends Person implements Null {

		private NullPerson() {
			super("None", "None", "None");
		}
		@Override
		public String toString() {
			return "NullPerson";
		}
	}
	public static final Person NULL = new NullPerson();
}
