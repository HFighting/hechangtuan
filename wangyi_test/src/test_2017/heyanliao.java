package test_2017;

import java.util.Scanner;

/*
 * 输入一行数，问这行数最少能被几个数异或出来
 * 
 * 实则：求矩阵的秩
 * 一行数能被看作是一个二进制数，若是32位的
 * 则n个数可看成是n*32的矩阵
 * 行与行之间进行异或
 */
public class heyanliao {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] a = new int[size];
		for (int i = 0; i < size; i++) {
			a[i] = sc.nextInt();
		}
		//对数组进行排序(冒泡),最大的沉入到最后面
		Boolean flag = true;
		for (int i = 0; i < size-1&&flag; i++) {
			flag = false;
			for (int j = i+1; j < size-i; j++) {
				if (a[j]>a[j-1]) {
					swap(a[j],a[j-1]);
					flag = true;
				}
			}
		}
		//从最大的数开始循环(即从上往下异或操作)
		for (int i = size-1; i > 1; i--) {
			for (int j = i-1; j > 0; j--) {
				//若大的数与小的数异或小于小的数，则说明这两个数的最高位是相同的
				if ((a[j]^a[i])<a[j]) {
					a[j] ^= a[i];
				}
			}
		}
		int i = 0;
		for (; a[i]==0; i++) ;
		System.out.println(size-i);
	}
	public static void swap(int a,int b) {
		int temp = a;
		a = b;
		b = temp;
	}

}
