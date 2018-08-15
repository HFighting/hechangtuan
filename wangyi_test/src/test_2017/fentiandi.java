package test_2017;

import java.util.Scanner;


/*
 * 分田地：
 * 简单来说：
 * 输入第一行，包括矩阵的行数m和列数n
 * 接下来输入m行数据，每行n个数字（0-9）之间
 * 
 * 输出：输出这些数字中最小的数字
 * 
 * 例如：
4 4
3332
3233
3332
2323
2
难点：把连续输入的数字分隔开，作为一个个体
 */
public class fentiandi {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int rows = sc.nextInt();//行数
			int spans = sc.nextInt();//列数
			int min = 10;
			while(rows>0) {
				int c = spans;
				int a = sc.nextInt();	
				//保证列数最大为输入值
				if (a<(int)Math.pow(10, c)) {
					//逐位分割该数字,从最大的一位开始分割
					while (c>0) {
						int num = a/((int)Math.pow(10, c-1));
						if (num<min) {
							min = num;
						}
						a = a - num*(int)Math.pow(10, c-1);
						c -= 1;
					}
				}else {
					return;
				}
				rows -= 1;
			}
			sc.close();
			System.out.println(min);
		}
	}
}
