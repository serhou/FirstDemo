package com.bestlove.pratices;

import static net.mindview.util.Print.*;

public class Assignment {

	public static void main(String[] args) {
		
		Tank t1 = new Tank();
		Tank t2 = new Tank();
		t1.level = 9;
		t2.level = 78;
		print("1:t1.level:"+t1.level+", t2.level:"+t2.level);
		t1 = t2;
		print("2:t1.level:"+t1.level+", t2.level:"+t2.level);
		t1.level = 23;
		print("3:t1.level:"+t1.level+", t2.level:"+t2.level);
		
	}
	
	
}


class Tank {
	int level;
}
