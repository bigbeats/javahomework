import java.util.Scanner;

public class Test2 {
	public static void printMatrix(int n) { // �����ӡ������
		int m,count=0; // ��������m�������������������count����Ǿ������n�ı�����ʵ�ֻ���
		for(int i=0;i<n*n;i++) { // ����ѭ����ӡ���������������n�ı������У�����������
		m=(int)(Math.random()*2);
		System.out.print(m+" ");
		count++;
		if(count%n==0)
			System.out.print("\n");	// ��n�ı������У�����������		
		}
	}
	
	public static void main(String[] args) {
		System.out.print("Enter n:"); // �������Ľ���
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		printMatrix(n); // �������������
		input.close();
	}
}
