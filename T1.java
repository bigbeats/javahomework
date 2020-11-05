package test;
import java.util.Date;
import java.util.Scanner;
public class T1 {
	public static void main(String[] args) {
	Date date=new Date(); // 用Date类的缺省构造方法去初始化一个Date对象
	Scanner input=new Scanner(System.in);
	int flag=0;
	while(flag==0) { // 用flag标记循环结束，依次输入10000到100000000000
		System.out.println("请输入需要转换为日期字符串的流逝时间，单位是毫秒数");
		long seconds = input.nextLong();
		date.setTime(seconds); // 每次循环设置一个新的流逝时间
		System.out.println("流逝时间为"+seconds+"的日期为："+date.toString()+"\n继续输入新的流逝时间请输入0，不再输入新的流逝时间按1退出");
		// 用toString()方法去输出时间字符串
		flag = input.nextInt(); // 每次循环结束决定是否要继续
	}
	input.close();
	System.out.println("程序结束");
	}
}
