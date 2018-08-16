package test_2017;

import java.util.Scanner;

/*
 * 简单来说，就是输入两行字符串，判断第二行是否是第一行的子串
ukaovhzydz
uhzdz
 */
public class qiuzichuan {

	public static void main(String[] args) {
		//处理输入
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String parent = sc.nextLine();
			String subline = sc.nextLine();
			char[] chars = parent.toCharArray();//转换成字符数组
			//这题最大的特点就是子串的顺序也是按照父串的顺序排列
			char[] subs = subline.toCharArray();
			int begin = 0;
			int count = 0;
			for (int i = 0; i < subs.length; i++) {
				for (int j = begin; j < chars.length; j++) {
					//查找匹配，若有匹配，则更改开始位置并跳出循环
					if (subs[i]==chars[j]) {
						begin = j+1;
						count++;
						break;
					}
				}
			}
			if (count==subs.length) {
				System.out.println("Yes");
			}else {
				System.out.println("No");
			}
		}

	}

}
