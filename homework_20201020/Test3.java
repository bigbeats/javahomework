public class Test3 {
	public static void counts() { // 定义随机数计次函数
		int[] array1 =new int[100]; // 初始化一个长度为100的数组array1，用来之后存储100个随机数
		int[] array2 =new int[10]; // 初始化一个长度为10的数组array2，数组元素都为0
		for(int i=0;i<100;i++) {
			array1[i]=(int)(Math.random()*10); // 用长度为100的数组array1存储100个随机数
		}
		for(int i:array1) {
			array2[i]++; // 对array1中每个元素i，都是[0,9]的随机数的正整数，所以array2[i]刚好存放可以对应array1中元素i出现的次数
		}
		for(int i=0;i<10;i++)
		System.out.println("数字"+i+"出现了"+array2[i]+"次");	
		// 用for循环输出相应元素出现的次数
	}
	
	public static void main(String[] args) {
		System.out.print("出现次数如下\n");
		counts(); // 调用随机数计次函数
	}
}
