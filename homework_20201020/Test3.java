public class Test3 {
	public static void counts() { // ����������ƴκ���
		int[] array1 =new int[100]; // ��ʼ��һ������Ϊ100������array1������֮��洢100�������
		int[] array2 =new int[10]; // ��ʼ��һ������Ϊ10������array2������Ԫ�ض�Ϊ0
		for(int i=0;i<100;i++) {
			array1[i]=(int)(Math.random()*10); // �ó���Ϊ100������array1�洢100�������
		}
		for(int i:array1) {
			array2[i]++; // ��array1��ÿ��Ԫ��i������[0,9]���������������������array2[i]�պô�ſ��Զ�Ӧarray1��Ԫ��i���ֵĴ���
		}
		for(int i=0;i<10;i++)
		System.out.println("����"+i+"������"+array2[i]+"��");	
		// ��forѭ�������ӦԪ�س��ֵĴ���
	}
	
	public static void main(String[] args) {
		System.out.print("���ִ�������\n");
		counts(); // ����������ƴκ���
	}
}
