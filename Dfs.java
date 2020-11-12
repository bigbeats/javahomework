package test;
import java.io.*;
import java.security.MessageDigest; // 导入消息摘要，提供信息摘要SHA1算法
import java.util.*;

public class Dfs { 
	public static byte[] SHA1Checksum(InputStream is) throws Exception { // @1.对一个具体文件，通过文件内容计算sha值的方法，即blob对象的key值
		byte[] buffer = new byte[1024]; // 采用一个字节数组做缓冲器
		MessageDigest complete = MessageDigest.getInstance("SHA-1"); // 指定SHA1算法
		int numRead = 0;
		do {
			numRead = is.read(buffer); // 从输入流中读buffer.length个字节给buffer，并且返回实际读取的字节数给整型变量numRead
			if (numRead > 0) {
				complete.update(buffer, 0, numRead);
			}
		} while (numRead != -1); // numRead = -1代表文件读取完毕。需要关闭输入流，并且返回消息摘要字节数组。
		is.close();
		return complete.digest();
	}
	
	public static String convertToHexString(byte data[]) { // @2.由于MessageDigest对象的digest()方法返回的是字符数组，要得到十六进制的sha值还需要转为字符串
									//（tree的value包括了文件名（字符串）、子文件夹名（字符串）、子文件夹的treekey（字符串）、子文件的blobkey（字符串）
		StringBuffer strBuffer = new StringBuffer(); // 用StringBuffer去建立可变字符串对象
		for (int i = 0; i < data.length; i++) {
			strBuffer.append(Integer.toHexString(0xff & data[i])); // 用十六进制数oxff与某个字节值做按位与运算，
																	// 只保留了32位的最后8位，保证负数转换成十六进制不会出错
		}
		return strBuffer.toString();
	}

	public static String dfs(String path) { // 传入一个路径，路径可能代表着目录或者是一个文件。如果无此路径，会抛出异常。
											// 采用深度优先遍历该目录下所有文件和文件夹，并计算相应的blobkey和treekey。
		File dir = new File(path); // 以Path路径新建一个File对象，路径名可能是一个目录或是一个文件
		File[] fs = dir.listFiles(); // 实例对象的listfiles方法生成一个file数组，用一个File类型的数组变量fs接收这个实例对象数组。
		try {
			MessageDigest m=MessageDigest.getInstance("SHA1"); // 消息摘要声明，后期更新使用
			for(int i = 0; i < fs.length; i++) { // 遍历该路径下的所有文件，为了保证深度优先，在对某一级目录中的遍历访问中遇到子目录时需要触发递归。
				// 1.对文件的操作
				// $1.1 对文件内容计算sha值
				if(fs[i].isFile()) { 
					System.out.print("file " + fs[i].getName());
						FileInputStream is = new FileInputStream(fs[i]); // 调用基于文件内容sha值计算函数SHA1Checksum
						byte[] sha1 = SHA1Checksum(is);
						String result = convertToHexString(sha1);  // 调用基于字符串sha值计算函数convertToHexString
						System.out.println(" 文件内容的sha值： " + result);
						m.update(result.getBytes()); // #1.用blobkey值更新treekey值
				// $1.2 对文件的名字计算sha值
						m.update(fs[i].getName().getBytes()); // #2.用文件名更新treekey值，getBytes()得到一个操作系统默认的编码格式的字节数组
															  // getBytes(String decode)方法会根据指定的decode编码返回某字符串在该编码下的byte数组
				}
				// 2.对文件夹的操作
				// $2.1 对该文件夹名计算sha值
				if(fs[i].isDirectory()) { 
					System.out.println("directory " + path + File.separator + fs[i].getName());
					m.update(fs[i].getName().getBytes());  // #3.用文件夹名更新treekey值
				// $2.2 对该文件夹计算tree key值
					String treekey = dfs(path + File.separator + fs[i].getName()); // 访问到子文件夹时，触发对子文件夹的遍历访问,并且此处会调用子文件夹的treekey值。
					m.update(treekey.getBytes()); // #4.用子文件夹的treekey值更新treekey值
				}	
			} // for循环在这里结束，代表这一级目录中所有文件和文件夹遍历结束
			// 此时这一级目录的MessageDigest.getInstance("SHA-1")的实例对象已经更新好了sha值，也就是这一级
			// 目录的treekey值，现在需要把这一级的treekey值再返回给上一级目录当value值。见row 57。

			return convertToHexString(m.digest());
		}catch(Exception e) { // 两种情况有可能抛出异常，情况一就是开始给的PATH其实是一个文件而不是目录，这样33行的listFiles()方法就会报错
							  // 这时应该直接返回这个文件的hash值，于是有了row 67~71 的代码
			try {
				FileInputStream is = new FileInputStream(dir);
				byte[] sha1 = SHA1Checksum(is);
				String result = convertToHexString(sha1);
				return result;
			}	// 情况二就是开始给的PATH是一个不存在的目录或文件，此时需要抛出提示信息
			catch(Exception c) {
				return "异常：路径不存在";
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println("请输入文件/文件夹的路径");
		Scanner dir = new Scanner(System.in);
		System.out.println("您最终要访问的文件/文件夹的hash值为： "+dfs(dir.nextLine()));
		dir.close();
	}
}
