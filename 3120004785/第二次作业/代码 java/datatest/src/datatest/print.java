package datatest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
/*
 * @see ��ӡ����ļ�
 * @return �޷���ֵ
 */
public class print {
	public  print (String [] answer)throws Exception{
		File file = new File("C://abc//ansewer");
		FileOutputStream out = new FileOutputStream(file);
		PrintStream p = new PrintStream(out);
		for(int i=1;i<=10;i++){
			p.println("document" + i + "=> "+answer[i-1]);
		}
	}
}
