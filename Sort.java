package test;
import java.util.*;
public class Sort {
	public static void main(String args[]) {
		ArrayList<Number> list=new ArrayList<Number>();
		System.out.println("请输入数字个数:");
		Scanner input=new Scanner(System.in);	
		int n=input.nextInt();
		System.out.println("请依次输入数字:");
		for(int i=0;i<n;i++) {		// 循环对list中的元素赋值
			int a=input.nextInt();
			list.add(a); // 用arraylist中的add方法在尾部添加新的元素
		}
		input.close();
		sort(list);
		System.out.print("排序后list为："+list);
	}
	public static void sort(ArrayList<Number> list) {
		for (int n=0;n<list.size();n++){
			int min=list.get(n).intValue();
			int finish=n; 
			for (int i=n;i<list.size();i++){ 
                if (list.get(i).intValue()<min){
                	min=list.get(i).intValue();
                	finish=i;
                }
		    }
		    list.set(finish,list.get(n).intValue()); 
		    list.set(n, min);
		}

	}
}


