package com.bestlove.test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
/**
 * Java 8 time包
 * @author think
 *
 */
public class HelloDate {

	public static void main(String[] args) {
		
		System.out.println(Instant.now());
		System.out.println(LocalDate.now());
		System.out.println(LocalDateTime.now());
		System.out.println(System.getenv("OS"));
		
	}
	
}
