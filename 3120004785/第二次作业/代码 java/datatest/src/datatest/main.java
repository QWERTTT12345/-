package datatest;

import java.util.List;
import java.util.Map;



public class main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//构建总词表，和每个文件的词表
		Map map = new one().WordList();
//		//基于词表构建个文档向量
		Map juzheng = new two2().juzheng(map);
//		//计算各文档相似度
		String[]  answer = new three2().answer(juzheng);
		//结果打印在文件上
		new print(answer);
	}

}
