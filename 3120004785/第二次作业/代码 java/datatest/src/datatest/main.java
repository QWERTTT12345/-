package datatest;

import java.util.List;
import java.util.Map;



public class main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//�����ܴʱ���ÿ���ļ��Ĵʱ�
		Map map = new one().WordList();
//		//���ڴʱ������ĵ�����
		Map juzheng = new two2().juzheng(map);
//		//������ĵ����ƶ�
		String[]  answer = new three2().answer(juzheng);
		//�����ӡ���ļ���
		new print(answer);
	}

}
