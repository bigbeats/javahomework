import java.util.Scanner;
public class Test5 {
	public static double sumMajorDiagonal(double[][] m){ // �Խ���Ԫ����ͺ����Ķ���
		double sum = 0;
		for(int i=0;i<4;i++) // ����һ��ѭ���ԶԽ���Ԫ����ͣ��Խ���Ԫ�ؾ������к���ͬ�ľ���Ԫ��
		sum = sum + m[i][i];
		return sum;
	}
	
	public static void main(String[] args) {
		double matrix[][] = new double[4][4];
		System.out.print("Enter a 4-by-4 matrix row by row\n");
		Scanner input = new Scanner(System.in);
		for(int row=0;row<matrix.length;row++) { // ѭ��ʵ�ֶԾ����Ԫ�ظ�ֵ
			for(int column=0; column<matrix[row].length; column++) {
				matrix[row][column] = input.nextDouble();
			}
		}
		input.close(); // �����������������ͷ��ڴ�
		System.out.println("Sum of the elements in the major diagonal is "+sumMajorDiagonal(matrix));// ������ͺ���
	}

}
