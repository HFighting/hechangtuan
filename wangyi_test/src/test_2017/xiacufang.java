package test_2017;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

/*
 * 简单来说：
 * 输入n行，每行<=m个字符串（字符全部为大写），每个字符串之间使用空格做分隔符
 * 		输入文件不超过50行，每行不超过50个字符
 * 输出：输入的所有字符串中不重复的有多少个
 */
public class xiacufang {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<String> list = new ArrayList<>();
		int rows = 50;
		while(sc.hasNext()&&rows-->0) {
			String line = sc.nextLine();
			if (line.length()>50) {
				return;
			}
			String[] lines = line.split(" ");
			for (int i = 0; i < lines.length; i++) {
				list.add(lines[i]);
			}
		}
		Stream<String> stream = list.parallelStream();
		System.out.println(stream.distinct().count());
		
	}

}
