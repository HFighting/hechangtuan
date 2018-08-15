package test_2017;

import java.util.Scanner;

/*
 * 分苹果：
 * n 只奶牛坐在一排，每个奶牛拥有 ai 个苹果，
 * 现在你要在它们之间转移苹果，使得最后所有奶牛拥有的苹果数都相同，
 * 每一次，你只能从一只奶牛身上拿走恰好两个苹果到另一个奶牛上，
 * 问最少需要移动多少次可以平分苹果，如果方案不存在输出 -1。
 * 
 * 换句话说：
 * 输入一行数，互相转移，最后使所有数相等，求最小转移次数
 * 
 * 输入：
 * 每个输入包含一个测试用例。
 * 每个测试用例的第一行包含一个整数 n（1 <= n <= 100），接下来的一行包含 n 个整数 ai（1 <= ai <= 100）。
 * 
 * 输出：
 * 输出一行表示最少需要移动多少次可以平分苹果，如果方案不存在则输出 -1。
 * 
 * 例如：
4
7 15 9 5

3
 */
public class fenpingguo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = 0;//转移的次数
		int size = 0;
		size = sc.nextInt();//数组大小
		int[] nums = new int[size];
		int aver = 0;
		//处理输入，把输入都存储起来，最后使用ctrl+z结束输入
		while (sc.hasNext()) {			
			int add = 0;
			for (int i = 0; i < size; i++) {
				nums[i] = sc.nextInt();//存储苹果的数组
				add += nums[i];
			}
			if (add%size!=0) {
				System.out.println(-1);
				return;
			}
			aver = add/size;//求平均值
		}
		sc.close();
		for (int i = 0; i < nums.length; i++) {
			while (nums[i]>aver) {
				nums[i] -= 2;//有一个-2，必定有一个+2
				for (int j = 0; j < nums.length; j++) {
					if (j==i) {
						continue;
					}
					if (nums[j]<aver) {
						nums[j] += 2;
						count++;
						break;
					}
				}
				if (nums[i]<aver) {
					System.out.println(-1);
					return;
				}
			}
		}
		System.out.println(count);
	}

}
