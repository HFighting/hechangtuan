package test_2017;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/*题目描述：
 * 牛牛的作业薄上有一个长度为 n 的排列 A，
 * 这个排列包含了从1到n的n个数，
 * 但是因为一些原因，其中有一些位置（不超过 10 个）看不清了，
 * 但是牛牛记得这个数列顺序对的数量是 k（整个数列），
 * 顺序对是指满足 i < j 且 A[i] < A[j] 的对数，
 * 请帮助牛牛计算出，符合这个要求的合法排列的数目。
 * 
 * 输入描述：
 * 每个输入包含一个测试用例。
 * 每个测试用例的第一行包含两个整数 n 和 k（1 <= n <= 100, 0 <= k <= 1000000000），
 * 接下来的 1 行，包含 n 个数字表示排列 A，其中等于0的项表示看不清的位置（不超过 10 个）。
 * 
5 5
4 0 0 2 0
2
 */
public class shuliehuanyuan {
	
	static List<Object[]> all = new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> list = new ArrayList<>();//存储需要放入数列中的数
		//while循环处理整个输入
		while (sc.hasNext()) {
			int length = sc.nextInt();//排列长度
			int couple = sc.nextInt();//顺序对对数
			for (int i = 1; i <= length; i++) {
				list.add(i);
			}
			int[] array = new int[length];
			int i = 0;
			while (i<length) {
				array[i] = sc.nextInt();
				//一边遍历数组，一边从数组中删除元素
				for (Integer k : list) {
					if (k == array[i]) {
						list.remove(k);
						break;
					}
				}
				i++;
			}						
			
			Object[] objectss = list.toArray();
			sorted(objectss, 0, list.size());//求该集合的全部排列
			
			for (Object[] objects : all) {
				for (Object object : objects) {
					System.out.print(object+" ");
				}
				System.out.print("\n");
			}
			
			int maxcount = 0;
			for (Object[] objects : all) {
				int begin = 0;
				int[] arrays = new int[length];
				for (int j = 0; j < length; j++) {
					arrays[j] = array[j];
				}
				for (int m = 0; m < length; m++) {			
					if (arrays[m]==0) {
						if (begin<objects.length) {
							arrays[m] = (int)objects[begin];
							begin++;
						}
					}
				}
				int count = 0;
				for (int j = 0; j < arrays.length-1; j++) {
					for (int j2 = j+1; j2 < arrays.length; j2++) {
						if (arrays[j]<arrays[j2]) {
							count++;
						}
					}
				}
				if (count==couple) {
					maxcount++;
				}
			}
			System.out.println(maxcount);
		}
		sc.close();
		
	}
	public static void sorted(Object[] objects, int begin,int end) {
		if(begin>=end-1){
            all.add(objects); 
            for (int i = 0; i < objects.length; i++) {
				System.out.print(objects[i]+" ");
			}
            System.out.print("\n");
            System.out.println("----------");
            return;
        } 
		//关键代码
		for(int i=begin;i<end;i++){
            swap(objects,begin,i);
            sorted(objects,begin+1,end);    
            swap(objects,begin,i);
        }
	}
	public static void swap(Object[] cs,int index1,int index2){ 
		Object temp = cs[index1];
        cs[index1]=cs[index2];
        cs[index2]=temp;       
    } 

}
