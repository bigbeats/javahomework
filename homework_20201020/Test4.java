import java.util.Scanner;

public class Test4 {
	public static int indexOfSmallestElement(double[] array) { // ������СԪ��index����
		double min=array[0]; // ����˫���ȱ���min��������������С��Ԫ��
		int index=0;
		for(int i=0;i<10;i++){  // ����ѭ�����������ʽ��ʵ��minֵ�ĸ��£��ҵ������е���Сֵ
			min=array[i]>min?min:array[i]; 
		}
		for(double i:array){ // �ҵ���������Сֵ���±꣬��������СֵԪ��������ʱ�����index��С��Ԫ�ص�index
			if(min!=i)
				index++;
			else break; // �ҵ���Сֵ�ͽ���ѭ�� 
		}
		return index;	
	}
	
	public static void main(String[] args) {
		System.out.print("������10������\n");
		Scanner input = new Scanner(System.in);
		double[] array =new double[10]; // �ó���Ϊ10��������������10������
		for(int i=0;i<10;i++) {
			array[i]=input.nextDouble();
		}
		input.close();//�����������������ͷ��ڴ档
		System.out.print(indexOfSmallestElement(array));
	}
}
