package test_2017;

import java.util.Scanner;

/*
 * ��ƻ����
 * n ֻ��ţ����һ�ţ�ÿ����ţӵ�� ai ��ƻ����
 * ������Ҫ������֮��ת��ƻ����ʹ�����������ţӵ�е�ƻ��������ͬ��
 * ÿһ�Σ���ֻ�ܴ�һֻ��ţ��������ǡ������ƻ������һ����ţ�ϣ�
 * ��������Ҫ�ƶ����ٴο���ƽ��ƻ�������������������� -1��
 * 
 * ���仰˵��
 * ����һ����������ת�ƣ����ʹ��������ȣ�����Сת�ƴ���
 * 
 * ���룺
 * ÿ���������һ������������
 * ÿ�����������ĵ�һ�а���һ������ n��1 <= n <= 100������������һ�а��� n ������ ai��1 <= ai <= 100����
 * 
 * �����
 * ���һ�б�ʾ������Ҫ�ƶ����ٴο���ƽ��ƻ���������������������� -1��
 * 
 * ���磺
4
7 15 9 5

3
 */
public class fenpingguo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = 0;//ת�ƵĴ���
		int size = 0;
		size = sc.nextInt();//�����С
		int[] nums = new int[size];
		int aver = 0;
		//�������룬�����붼�洢���������ʹ��ctrl+z��������
		while (sc.hasNext()) {			
			int add = 0;
			for (int i = 0; i < size; i++) {
				nums[i] = sc.nextInt();//�洢ƻ��������
				add += nums[i];
			}
			if (add%size!=0) {
				System.out.println(-1);
				return;
			}
			aver = add/size;//��ƽ��ֵ
		}
		sc.close();
		for (int i = 0; i < nums.length; i++) {
			while (nums[i]>aver) {
				nums[i] -= 2;//��һ��-2���ض���һ��+2
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
