package test_2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
题目描述
有 n 个学生站成一排，每个学生有一个能力值，牛牛想从这 n 个学生中按照顺序选取 k 名学生，
要求相邻两个学生的位置编号的差不超过 d，使得这 k 个学生的能力值的乘积最大，你能返回最大的乘积吗？

输入描述:
每个输入包含 1 个测试用例。
每个测试数据的第一行包含一个整数 n (1 <= n <= 50)，表示学生的个数，
接下来的一行，包含 n 个整数，按顺序表示每个学生的能力值 ai（-50 <= ai <= 50）。
接下来的一行包含两个整数，k 和 d (1 <= k <= 10, 1 <= d <= 50)。

输出描述:
输出一行表示最大的乘积

测试用例：
3
7 4 7
2 50
输出49
 */

//换句话说，就是求指定数目的乘积最大值
public class hechangtuan {

	public static void main(String[] args) throws RuntimeException, IOException {
		//首先处理输入
		//第一行输入的是学生人数
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());
		if (size<1||size>50) {
			return;
		}
		//通过该输入建立一个数组存储学生能力大小
		int[] bility = new int[size];
		//输入学生能力值
		String string = br.readLine();
		//分离开,转换成整型
		String[] strings = string.split(" ");
		for (int i = 0; i < strings.length; i++) {
			bility[i] = Integer.parseInt(strings[i]);
			if (bility[i]<-50||bility[i]>50) {
				return;
			}
		}
		int[] a = new int[2];
		//输入选取的学生数与坐标间隔数
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
		//找到长度为学生数的所有字串的集合
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
            //一次字串的添加
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
