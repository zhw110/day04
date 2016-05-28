package cn.itcast.web.base;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

//使用JavaSocket编程，读取abc.html文件，写给每个浏览器客户端
public class Demo1 {
	public static void main(String[] args) throws Exception {
		ServerSocket ss = new ServerSocket(9999);
		while (true) {
			Socket s = ss.accept();
			// 得到输入流
			InputStream is = s.getInputStream();
			// 将字节流包装成高级字符流，目的是行行读
			BufferedReader br = new BufferedReader(new FileReader(
					"d:\\abc.html"));
			// 得到输出流
			OutputStream os = s.getOutputStream();
			String line = null;
			// 循环读取abc.html文件中的内容
			while ((line = br.readLine()) != null) {
				// 输出到每个浏览器
				os.write(line.getBytes());
			}
			br.close();
			os.close();
			s.close();
		}
		/*
		 * 项目在一定放在try-catch-finally中在非空的情况下关闭 br.close(); is.close();
		 * os.close(); s.close(); ss.close();
		 */
	}
}
