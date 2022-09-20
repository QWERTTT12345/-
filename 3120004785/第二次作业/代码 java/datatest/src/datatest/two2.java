//package datatest;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;
//
//
//public class two2 {
//	/*
//	 * @see test class!!!!!!!!!
//	 */
//	@SuppressWarnings("unchecked")
//	public Map juzheng(Map map){
//		Map<String,ArrayList> choose = new HashMap<String,ArrayList>();
//		ArrayList<String> all = (ArrayList<String>) map.get("all");
//		for(int i=0;i<all.size();i++){
//		//	System.out.println(all.get(i).toString()+"a");
//		}
//		for(int i = 1 ;i<=10;i++){
//			String name = (String)(""+i);
//			ArrayList<String> list = (ArrayList<String>) map.get(name);
//			ArrayList<Integer> test = new ArrayList<Integer>();
//			for(int j=0;j<all.size();j++){
//				test.add(0);
//			}
//			System.out.println(test.size());
//			for(int j=0;j<all.size();j++){
//				System.out.println(j+list.get(j));
//				int add = all.indexOf(list.get(j).toString());
//				System.out.println();
//				//if(add==-1){System.out.println("erry");}
//				test.set(add, test.get(add)+1);
//				//System.out.println(i+" "+all.get(j));
////		          if   (!list.contains(all.get(j).toString()))   
////		          {   
////		                      test.add(0); 
////		          } 
////		          else
////		          {
////		        	          test.add(1);
////		          }
//		          System.out.println(name+test.get(0));
//			}
//			choose.put(name, test);
//		}
//		return choose;
//	}
//}
package datatest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class two2 {
	/*
	 * @see 构建各文档向量
	 * return map
	 */
	
	@SuppressWarnings("unchecked")
	public Map juzheng(Map map){
		Map<String,ArrayList> choose = new HashMap<String,ArrayList>();
		ArrayList<String> all = (ArrayList<String>) map.get("all");
		for(int i = 1 ;i<=10;i++){
			String name = (String)(""+i);
			ArrayList<String> list = (ArrayList<String>) map.get(name);
			ArrayList<Integer> test = new ArrayList<Integer>();
			for(int j=0;j<all.size();j++){
				test.add(0);
			}
			System.out.println(test.size());
			for(int j=0;j<list.size();j++){
				for(int a = 0;a<all.size();a++){
					if(list.get(j).toString().equals(all.get(a).toString())){
						test.set(a, test.get(a)+1);
				//		System.out.println(test.get(a));
					}
				}
				//System.out.println(i+" "+all.get(j));
//		          if   (!list.contains(all.get(j).toString()))   
//		          {   
//		                      test.add(0); 
//		          } 
//		          else
//		          {
//		        	          test.add(1);
//		          }
		        //  System.out.println(name+test.get(j));
			}
			choose.put(name, test);
		}
		return choose;
	}
}