import java.util.Scanner;
public class Test1 {
	public static void reverse(int number) { // 逆向输出整数的函数的定义
		String a =(number+""); // 先将输入的整数转为字符串
		int k= a.length();
		int t= a.length();
		if(number<0)
			k--; // 如果输入的是负整数，则需要控制逆向输出时末尾不带负号
		char[] e = new char[k]; // 利用一个字符数组将整数逆向输出，逻辑就是新的字符数组的索引下标的元素与原数字转化后的字符数组的索引下标之和为数组长度-1
		for(int i = 0;i<k;i++ ) {
			e[i] = a.charAt(t-1);
			t--;		
		}
		if(number<0)
		System.out.print("-"); // 如果输入的是负整数，则返回的也应该是一个新的负整数	
		System.out.println(e);	
	}
	
	public static void main(String[] args) {
		System.out.print("请输入一个整数\n");
		Scanner input = new Scanner(System.in);
		int a = input.nextInt();
		System.out.print("该数的反向整数为\n");
		Test1.reverse(a); // 调用定义好的反向输出数字函数
		input.close(); // 函数结束数据流，释放内存
	}
}
