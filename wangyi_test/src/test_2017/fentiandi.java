package test_2017;

import java.util.Scanner;


/*
 * ����أ�
 * ����˵��
 * �����һ�У��������������m������n
 * ����������m�����ݣ�ÿ��n�����֣�0-9��֮��
 * 
 * ����������Щ��������С������
 * 
 * ���磺
4 4
3332
3233
3332
2323
2
�ѵ㣺��������������ַָ�������Ϊһ������
 */
public class fentiandi {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int rows = sc.nextInt();//����
			int spans = sc.nextInt();//����
			int min = 10;
			while(rows>0) {
				int c = spans;
				int a = sc.nextInt();	
				//��֤�������Ϊ����ֵ
				if (a<(int)Math.pow(10, c)) {
					//��λ�ָ������,������һλ��ʼ�ָ�
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
