import java.util.Scanner;
public class Test1 {
	public static void reverse(int number) { // ������������ĺ����Ķ���
		String a =(number+""); // �Ƚ����������תΪ�ַ���
		int k= a.length();
		int t= a.length();
		if(number<0)
			k--; // ���������Ǹ�����������Ҫ�����������ʱĩβ��������
		char[] e = new char[k]; // ����һ���ַ����齫��������������߼������µ��ַ�����������±��Ԫ����ԭ����ת������ַ�����������±�֮��Ϊ���鳤��-1
		for(int i = 0;i<k;i++ ) {
			e[i] = a.charAt(t-1);
			t--;		
		}
		if(number<0)
		System.out.print("-"); // ���������Ǹ��������򷵻ص�ҲӦ����һ���µĸ�����	
		System.out.println(e);	
	}
	
	public static void main(String[] args) {
		System.out.print("������һ������\n");
		Scanner input = new Scanner(System.in);
		int a = input.nextInt();
		System.out.print("�����ķ�������Ϊ\n");
		Test1.reverse(a); // ���ö���õķ���������ֺ���
		input.close(); // �����������������ͷ��ڴ�
	}
}
