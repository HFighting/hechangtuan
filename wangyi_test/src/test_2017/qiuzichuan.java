package test_2017;

import java.util.Scanner;

/*
 * ����˵���������������ַ������жϵڶ����Ƿ��ǵ�һ�е��Ӵ�
ukaovhzydz
uhzdz
 */
public class qiuzichuan {

	public static void main(String[] args) {
		//��������
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String parent = sc.nextLine();
			String subline = sc.nextLine();
			char[] chars = parent.toCharArray();//ת�����ַ�����
			//���������ص�����Ӵ���˳��Ҳ�ǰ��ո�����˳������
			char[] subs = subline.toCharArray();
			int begin = 0;
			int count = 0;
			for (int i = 0; i < subs.length; i++) {
				for (int j = begin; j < chars.length; j++) {
					//����ƥ�䣬����ƥ�䣬����Ŀ�ʼλ�ò�����ѭ��
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
