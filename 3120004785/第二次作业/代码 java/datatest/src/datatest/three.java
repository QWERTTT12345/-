package datatest;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Map;

public class three {
	/*
	 * @see ʹ���������ƶȷ����ó��������
	 * @return answer
	 */
	public double ab=0.0,aa=0.0,bb=0.0,cosvalue=0.0;
	public String[] answer = new String[10];
	public String[] answer(Map map){
		for(int i=1;i<=10;i++){
			answer[i-1]="";
			for(int j=1;j<=10;j++){
				ArrayList a = (ArrayList) map.get((i+""));
				ArrayList b = (ArrayList) map.get((j+""));
				//System.out.println(a.get(4).toString()+b.get(9).toString());
				ab=0.0;aa=0.0;bb=0.0;
				for(int log = 0;log<a.size();log++){
					//�жϸô��Ƿ�ͬʱӵ��
					
					if(a.get(log).toString().equals("1")&&b.get(log).toString().equals("1"))
					{   //ͬʱӵ�� +1
						ab = ab + 1.0;
					}
					if(a.get(log).toString().equals("1"))aa = aa + 1.0;
					if(b.get(log).toString().equals("1"))bb = bb + 1.0;
				}
				System.out.println(ab+" "+aa+" "+bb);
				cosvalue=ab/(Math.sqrt(aa)*Math.sqrt(bb));
				DecimalFormat df = new DecimalFormat( "0.0000 ");
				answer[i-1] = answer[i-1] + df.format(cosvalue) + "  ";
			}
			System.out.println(answer[i-1]);
			//cosvalue=ab/(Math.sqrt(aa)*Math.sqrt(bb));
		}
		return answer;
	}

}
