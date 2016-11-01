package com.bestlove.string;

import java.util.Formatter;

/**
 * %[argument_index$][flags][width][.precision]conversion
 * 格式化说明符
 * 在插入数据时，如果想要控制空格与对齐。最常见的应用是控制一个域的最小尺寸，
 * 这可以通过指定width来实现。Formatter对象通过在必要时添加空格，来确保一个
 * 域至少达到某个长度。在默认的情况下数据是右对齐，不过可以通过使用“-”标志来
 * 改变对齐方向
 * @author think
 *
 */

public class Receipt {

	private double total = 0;
	private Formatter f = new Formatter(System.out);
	public void printTitle() {
		f.format("%-15s %5s %10s\n", "Item", "Qty", "Price");
		f.format("%-15s %5s %10s\n", "----", "---", "-----");
	}
	public void print(String name, int qty, double price) {
		//.precision 用于String表示打印String时输出字符的最大数量15
		//.precision 用于浮点数时，它表示小数部分要显示出来的位数（默认是6位小数）
		//如果小数位数过多则舍入，太少则在尾部补零
		f.format("%-15.15s %5d %10.2f\n", name, qty, price);
		total += price;
	}
	public void printTotal() {
		f.format("%-15s %5s %10.2f\n", "Tax", "", total*0.06);//小数位过多则舍入
		f.format("%-15s %5s %10s\n", "", "", "-----");
		f.format("%-15s %5s %10.2f\n", "Total", "", total*1.06);//小数位过多则舍入
	}

	public static void main(String[] args) {
		
		Receipt receipt = new Receipt();
		receipt.printTitle();
		receipt.print("Jack's Magic Beans",	4, 4.25);
		receipt.print("Princess Peas", 3, 5.1);//尾部补零
		receipt.print("Three Bears Porridge", 1, 14.29);
		receipt.printTotal();
		
//		Item              Qty      Price
//		----              ---      -----
//		Jack's Magic Be     4       4.25
//		Princess Peas       3       5.10
//		Three Bears Por     1      14.29
//		Tax                         1.42
//		                           -----
//		Total                      25.06
	}
	
}
