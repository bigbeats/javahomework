import java.util.Scanner;
public class Test5 {
	public static double sumMajorDiagonal(double[][] m){ // 对角线元素求和函数的定义
		double sum = 0;
		for(int i=0;i<4;i++) // 利用一个循环对对角线元素求和，对角线元素就是行列号相同的矩阵元素
		sum = sum + m[i][i];
		return sum;
	}
	
	public static void main(String[] args) {
		double matrix[][] = new double[4][4];
		System.out.print("Enter a 4-by-4 matrix row by row\n");
		Scanner input = new Scanner(System.in);
		for(int row=0;row<matrix.length;row++) { // 循环实现对矩阵各元素赋值
			for(int column=0; column<matrix[row].length; column++) {
				matrix[row][column] = input.nextDouble();
			}
		}
		input.close(); // 函数结束数据流，释放内存
		System.out.println("Sum of the elements in the major diagonal is "+sumMajorDiagonal(matrix));// 调用求和函数
	}

}
