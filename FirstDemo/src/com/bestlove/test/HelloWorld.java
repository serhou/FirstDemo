import java.util.*;

public class HelloWorld {

	public static void main(String[] args) {

		System.out.println("Hello World!");

		test();		
		getName();

	}




	public static void test() {

		for(int i = 0; i<5; i++){

			System.out.println("wo men dou  shi xiao qing wa" + i);		

		}
	

	}

	public static void getName() {

		Date date = new Date();
		System.out.println(date);
	
		List list = new ArrayList();
		for(int i = 0; i<10; i++){
			list.add(date);
		}	

		System.out.println(list.size());

	}



}






