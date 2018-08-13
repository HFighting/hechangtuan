package test_2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
��Ŀ����
�� n ��ѧ��վ��һ�ţ�ÿ��ѧ����һ������ֵ��ţţ����� n ��ѧ���а���˳��ѡȡ k ��ѧ����
Ҫ����������ѧ����λ�ñ�ŵĲ���� d��ʹ���� k ��ѧ��������ֵ�ĳ˻�������ܷ������ĳ˻���

��������:
ÿ��������� 1 ������������
ÿ���������ݵĵ�һ�а���һ������ n (1 <= n <= 50)����ʾѧ���ĸ�����
��������һ�У����� n ����������˳���ʾÿ��ѧ��������ֵ ai��-50 <= ai <= 50����
��������һ�а�������������k �� d (1 <= k <= 10, 1 <= d <= 50)��

�������:
���һ�б�ʾ���ĳ˻�

����������
3
7 4 7
2 50
���49
 */

//���仰˵��������ָ����Ŀ�ĳ˻����ֵ
public class hechangtuan {

	public static void main(String[] args) throws RuntimeException, IOException {
		//���ȴ�������
		//��һ���������ѧ������
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());
		if (size<1||size>50) {
			return;
		}
		//ͨ�������뽨��һ������洢ѧ��������С
		int[] bility = new int[size];
		//����ѧ������ֵ
		String string = br.readLine();
		//���뿪,ת��������
		String[] strings = string.split(" ");
		for (int i = 0; i < strings.length; i++) {
			bility[i] = Integer.parseInt(strings[i]);
			if (bility[i]<-50||bility[i]>50) {
				return;
			}
		}
		int[] a = new int[2];
		//����ѡȡ��ѧ��������������
		string = br.readLine();
		strings = string.split(" ");
		for (int i = 0; i < 2; i++) {
			a[i] = Integer.parseInt(strings[i]);
		}
		if (a[0]<1||a[0]>10) { 
			return;
		}
		if (a[1]<1||a[1]>50) {
			return;
		}
		//�ҵ�����Ϊѧ�����������ִ��ļ���
		List<ArrayList<Integer>> list = getSubArrays(bility,a);
		int max = 0;
		for (int i = 0; i < list.size(); i++) {
			ArrayList<Integer> subarray = list.get(i);
			int num = 1;
			for (int j = 0; j < subarray.size(); j++) {
				num *= subarray.get(j);
			}
			if (num>max) {
				max = num;
			}
		}
		System.out.println(max);
	}
	
	public static List getSubArrays(int[] nums,int[] a){
        int count = (int)Math.pow(2,nums.length);
        List<ArrayList<Integer>> arrays = new ArrayList<ArrayList<Integer>>();
        for(int i=1;i<count;i++){
            List<Integer> subarray = new ArrayList<Integer>();
            int temp = i;
            int index = 0;
            int befor = index;
            //һ���ִ������
            while (temp!=0){
                if((temp&1)==1){
                	if (index-befor<a[1]) {
                		subarray.add(nums[index]);
                        befor = index;
					}else {
						subarray.clear();
						break;
					}
                }
                index++;
                temp = temp >>1;
            }
            if (subarray.size()==a[0]) {
            	arrays.add((ArrayList<Integer>) subarray);
			}
        }
        return arrays;
    }
}
