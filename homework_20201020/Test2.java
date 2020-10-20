import java.util.Scanner;

public class Test2 {
	public static void printMatrix(int n) { // 定义打印矩阵函数
		int m,count=0; // 声明整数m来收随机数；声明整数count来标记矩阵阶数n的倍数，实现换行
		for(int i=0;i<n*n;i++) { // 利用循环打印，并且遇矩阵阶数n的倍数换行，输出这个矩阵
		m=(int)(Math.random()*2);
		System.out.print(m+" ");
		count++;
		if(count%n==0)
			System.out.print("\n");	// 遇n的倍数换行，输出这个矩阵		
		}
	}
	
	public static void main(String[] args) {
		System.out.print("Enter n:"); // 输入矩阵的阶数
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		printMatrix(n); // 调用输出矩阵函数
		input.close();
	}
}
