package cn.itcast.web.base;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

//ʹ��JavaSocket��̣���ȡabc.html�ļ���д��ÿ��������ͻ���
public class Demo1 {
	public static void main(String[] args) throws Exception {
		ServerSocket ss = new ServerSocket(9999);
		while (true) {
			Socket s = ss.accept();
			// �õ�������
			InputStream is = s.getInputStream();
			// ���ֽ�����װ�ɸ߼��ַ�����Ŀ�������ж�
			BufferedReader br = new BufferedReader(new FileReader(
					"d:\\abc.html"));
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
		}
		/*
		 * ��Ŀ��һ������try-catch-finally���ڷǿյ�����¹ر� br.close(); is.close();
		 * os.close(); s.close(); ss.close();
		 */
	}
}
