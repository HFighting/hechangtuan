package test_2017;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

/*
 * ����˵��
 * ����n�У�ÿ��<=m���ַ������ַ�ȫ��Ϊ��д����ÿ���ַ���֮��ʹ�ÿո����ָ���
 * 		�����ļ�������50�У�ÿ�в�����50���ַ�
 * ���������������ַ����в��ظ����ж��ٸ�
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
