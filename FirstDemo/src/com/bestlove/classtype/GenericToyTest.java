package com.bestlove.classtype;

/**
 * 如果是超类，那么编译器将只允许声明超类引用是“某个类，它是FancyToy超类”；
 * 由于含糊性，up.newInstance()的返回值不是精确类型，而是Object
 * @author think
 *
 */

public class GenericToyTest {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		
		Class<FancyToy> ftClass = FancyToy.class;
		FancyToy fancyToy = ftClass.newInstance();
		Class<? super FancyToy> up = ftClass.getSuperclass();//返回的是基类不是接口
//		Class<Toy> up2 = ftClass.getSuperclass();//不被接受
		Object obj = up.newInstance();
		
		//新的转型语法   类型转换
		Building b = new House();
		Class<House> houseType = House.class;
		House h = houseType.cast(b);
		System.out.println(h.equals(b));
		h = (House)b;//... or just do this
	}
	
}
class Building {}
class House extends Building {}
