package datatest;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
 * @version 1.2
 * @see
 */
public class one {
	/*
	 *@see �ļ�����ȥ��װ��
	 *@return map
	 */
	public Map WordList()throws Exception{
		String[][] array = AllfileString();
		
		Map<String,ArrayList> map = new HashMap<String,ArrayList>();
		
		String[] list = {"1","10","2","3","4","5","6","7","8","9"};

		for(int ii=0;ii<10;ii++){
			ArrayList<String> list1 = new ArrayList<String>();
		  for   (int   i = 0;i < array[ii].length;i++)   
		  {       
		                      list1.add(array[ii][i]);   
		  }
		  System.out.println(list1.size());
		  map.put(list[ii], list1);
		  
		 } 
		//ȫ�����ı���		
		String allword = "all";
		String[] array2 = AllfileString2();int i=0;
		ArrayList<String> list1 = new ArrayList<String>();
		for   (i=0;i < array2.length;i++)   
		  {      
		          if   (!list1.contains(array2[i]))   
		          {   
		                      list1.add(array2[i]);    
		          }   
		  }
		  System.out.println(list1.size());
		  map.put(allword, list1);
//		  List a = map.get(allword);
//		  System.out.println(a.get(0).toString());
		  //
		  return   map;
	}
	
	/*
	 *@see �ļ����ݷָ�
	 *@return arr
	 */
	public String[][] AllfileString()throws Exception{
		File AllFile = new File("C://abc"+File.separator);
		 String[] filecontent=new String[11];
		String[][] arr = new String[11][];
		int i=0;
		if(AllFile!=null){
			System.out.println("�ļ���ȡ�ɹ���");
		}
		for(File f:AllFile.listFiles())
		{
			filecontent[i]="";
			//��ȡ�ļ���ȡ˳��
			//System.out.println(f.getName());
			filecontent[i] = ReadAllFile(f);
			//����ļ����ݶ�ȡ
			//System.out.println(filecontent[i]+i);
			i++;
		}
		//System.out.println(filecontent);
		for(int ii=0;ii<10;ii++){
		    filecontent[ii] = filecontent[ii].replace(" ", "");
		    filecontent[ii] = filecontent[ii].replace("", "");
	    arr[ii] = filecontent[ii].split("\\/[a-z]");
		System.out.println(arr[ii].length+arr[ii][0]);
		}
//		String[] str2 = System.Text.RegularExpressions.Regex.Split(filecontent,@[*]+);
		return arr; 
	}
	
	
	
	public String[] AllfileString2()throws Exception{
		File AllFile = new File("C://abc"+File.separator);
		 String filecontent="";
		
		int i=0;
		if(AllFile!=null){
			System.out.println("�ļ���ȡ�ɹ���");
		}
		for(File f:AllFile.listFiles())
		{
			//��ȡ�ļ���ȡ˳��
			//System.out.println(f.getName());
			filecontent += ReadAllFile(f);
			//����ļ����ݶ�ȡ
			//System.out.println(filecontent);
			
		}
		//��������ļ�����
		//System.out.println(filecontent);
		    filecontent = filecontent.replace(" ", "");
		    filecontent = filecontent.replace("", "");
			String[]  arr = filecontent.split("\\/[a-z]");
		return arr; 
	}
	/*
	 *@see �ļ����ݶ�ȡ
	 *@return content
	 */
	public String ReadAllFile(File f)throws Exception{
		String content;
		InputStream fis = new FileInputStream("C://abc"+File.separator+f.getName().toString());
		byte data[] = new byte[Integer.parseInt(f.length()+"")];
		fis.read(data);
		return content = new String(data,"UTF-8");
	}
}
