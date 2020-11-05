import java.util.Scanner;

public class Test4 {
	public static int indexOfSmallestElement(double[] array) { // 定义最小元素index函数
		double min=array[0]; // 引入双精度变量min来接受数组中最小的元素
		int index=0;
		for(int i=0;i<10;i++){  // 利用循环和条件表达式来实现min值的更新，找到数组中的最小值
			min=array[i]>min?min:array[i]; 
		}
		for(double i:array){ // 找到数组中最小值的下标，且满足最小值元素有两个时，输出index最小的元素的index
			if(min!=i)
				index++;
			else break; // 找到最小值就结束循环 
		}
		return index;	
	}
	
	public static void main(String[] args) {
		System.out.print("请输入10个数字\n");
		Scanner input = new Scanner(System.in);
		double[] array =new double[10]; // 用长度为10的数组接受输入的10个数字
		for(int i=0;i<10;i++) {
			array[i]=input.nextDouble();
		}
		input.close();//函数结束数据流，释放内存。
		System.out.print(indexOfSmallestElement(array));
	}
}
