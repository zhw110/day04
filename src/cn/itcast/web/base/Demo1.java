package cn.itcast.web.base;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.junit.Test;

// Use JavaSocket programming , read Demo1.html 
// and send to the browser to read it .
public class Demo1 {
	public static void main(String[] args) throws Exception {
		ServerSocket ss = new ServerSocket(9999);
//		while (true) {
			Socket s = ss.accept();
			// �õ�������
			InputStream is = s.getInputStream();
			// ���ֽ�����װ�ɸ߼��ַ�����Ŀ�������ж�
			BufferedReader br = new BufferedReader(
					new FileReader("WebRoot/Demo1.html"));
			// �õ������
			OutputStream os = s.getOutputStream();
			String line = null;
			// ѭ����ȡabc.html�ļ��е�����
			while ((line = br.readLine()) != null) {
				// �����ÿ�������
				os.write(line.getBytes());
			}
			br.close();
			os.close();
			s.close();
//		}
		/*
		 * ��Ŀ��һ������try-catch-finally���ڷǿյ�����¹ر� br.close(); is.close();
		 * os.close(); s.close(); ss.close();
		 */


	}

	/**
	 * @throws FileNotFoundException
	 */
	@Test
	 public void readFile() throws FileNotFoundException, IOException {
		System.out.println(System.getProperty("user.dir"));
		BufferedReader br = new BufferedReader(new FileReader("WebRoot/Demo1.html"));
		// �õ������
		String line = null;
		// ѭ����ȡabc.html�ļ��е�����
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
		br.close();
	}
}
