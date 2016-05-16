package com.bestlove.pratices;

import static net.mindview.util.Print.*;

import java.util.Random;

public class MathOps {

	public static void main(String[] args) {
		//Create a seeded random number generator 
		//new Random(57)传参数后生成了一个为随机数生成器
		Random rand = new Random(57);
		int i, j, k;
		j = rand.nextInt(100) + 1;
		print("j: " + j);
		k = rand.nextInt(100) + 1;
		print("k : " + k);
		i = j + k;
		print("j + k : " + i);
		i = j - k;
		print("j - k : " + i);
		i = k / j;
		print("k / j : " + i);
		i = k * j;
		print("k * j : " + i);
		i = k % j;
		print("k % j : " + i);
		k %= j;
		print("k %= j : " + k);
		j %= k;
		print("j %= k : " + j);
		//float
		float u, v, w;
		v = rand.nextFloat();
		print("v : " + v);
		w = rand.nextFloat();
		print("w : " + w);
		u = v + w;
		print("v + w : " + u);
		u = v - w;
		print("v - w : " + u);
		u = v * w;
		print("v * w : " + u);
		u = v / w;
		print("v / w : " + u);
		u += v;
		print("u += v : " + u);
		u -= v;
		print("u -= v : " + u);
		u *= v;
		print("u *= v : " + u);
		u /= v;
		print("u /= v : " + u);
		
	}
	
}
