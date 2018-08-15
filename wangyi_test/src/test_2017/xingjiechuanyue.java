package test_2017;

import java.util.Scanner;

/*
 * 
 */
public class xingjiechuanyue {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Long aLong = sc.nextLong();
		sc.close();
		int i = 0;
		while (Math.pow(i, 2)+i<=aLong) {
			i++;
		}
		System.out.println(i-1);
	}

}
