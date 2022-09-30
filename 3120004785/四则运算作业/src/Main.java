import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main{

	private static int fNum, sNum, tNum, result;

	private static String firstOperator, secondOperator;
	
	private final static String ADD = "+";
	private final static String SUB = "-";
	private final static String MUL = "*";
	private final static String DIV = "/";
	

	private final static String[] OPERATOR = { "+", "-", "*", "/" };

	private static int ac=1;
	public static void main(String[] args) throws IOException {
		
		File file = new File("TiMu.txt");
		File file2 = new File("Answers.txt");
		if(file.exists()||file2.exists()) {
			file.delete();
			file2.delete();
		}
		System.out.println("输入题目数量:");
		Scanner sc = new Scanner(System.in);
			int a=sc.nextInt();
			//ArrayList<Integer> List = new ArrayList<Integer>();
			System.out.println("输入最大范围:");
			Scanner sc2 = new Scanner(System.in);
				int x=sc2.nextInt();
				for (int i = 0; i < a; i++) 
				 {
					compute(x);					
				 }
		ZuoDa();
        YanZheng();
	}

	public static boolean compute(int x) {

		while (true) {
			fNum = generateRandomNum(1, x);

			sNum = generateRandomNum(1, x);

			tNum = generateRandomNum(1, x);

			firstOperator = OPERATOR[generateRandomNum(0, 3)];

			secondOperator = OPERATOR[generateRandomNum(0, 3)];

			if (firstOperator.equals(secondOperator)) {
				continue;
			}
			
			try {
				if (secondOperator.equals(MUL)
						|| secondOperator.equals(DIV)) {
					int preResult = ys(sNum, tNum, secondOperator);
					if (preResult < 0) {
						continue;
					}
					result = ys(fNum, preResult, firstOperator);
				} else {
					int preResult = ys(fNum, sNum, firstOperator);
					if (preResult < 0) {
						continue;
					}
					result = ys(preResult, tNum, secondOperator);
				}
			} catch (Exception e) {
				// TODO: handle exception
				continue;
			}
			

			if (result < 0) {
				continue;
			} else {

				StringBuffer buffer = new StringBuffer();
				StringBuffer buffer2 = new StringBuffer();
				buffer.append(fNum).append(firstOperator).append(sNum).append(secondOperator).append(tNum)
						.append("=").append("\n");
				buffer2.append(result).append("\n");
				//System.out.println(buffer);
				//System.out.println(buffer2);

				if (writeToTiMuFile(buffer.toString())&&writeToAnswerFile(buffer2.toString())) {

					return true;

				} else {

					return false;

				}

			}
		}
	}

	public static int generateRandomNum(int min, int max) {

		Random random = new Random();

		return random.nextInt(max - min + 1) + min;

	}

	public static boolean writeToTiMuFile(String result) {
		
		try {
		     FileWriter fw = new FileWriter("TiMu.txt", true);
    	     fw.write(result);
    	     fw.flush();
    	     fw.close();

			return true;

		} catch (IOException e) {

			e.printStackTrace();

			return false;

		}

	}
	public static boolean writeToAnswerFile(String result) {
		
		try {
		     FileWriter fw = new FileWriter("Answers.txt", true);
    	     fw.write(result);
    	     fw.flush();
    	     fw.close();

			return true;

		} catch (IOException e) {

			e.printStackTrace();

			return false;

		}

	}
	public static boolean writeToGradeFile(String result) {
		
		try {
		     FileWriter fw = new FileWriter("Grade.txt", true);
    	     fw.write(result);
    	     fw.flush();
    	     fw.close();

			return true;

		} catch (IOException e) {

			e.printStackTrace();

			return false;

		}

	}
	@SuppressWarnings("resource")
	public static void ZuoDa() throws IOException{
		FileWriter writer=new FileWriter("ZuoDa.txt",true);	
		System.out.println("依次输入答案(答完一题回车,*结束):");
	    try {
	    	new FileWriter("ZuoDa.txt");
	    	Scanner sc = new Scanner(System.in);
	    	BufferedWriter buffer=new BufferedWriter(writer);
	    	String x=new String();
			 while(true) 
			 {
			 x=sc.nextLine();
             if (x.equals("*"))
              {
                break;
              }           
			 buffer.write(x);
			 buffer.flush();
			 buffer.newLine();
			 }
			}catch(Exception E){
	            E.printStackTrace();
	        }
		
	}
	public static void YanZheng() throws IOException {
		try {
			BufferedReader buffer1=new BufferedReader(new FileReader("Answers.txt"));
			BufferedReader buffer2=new BufferedReader(new FileReader("ZuoDa.txt"));			
			int sum1=0,sum2=0;
			int count=1;
			String s1="",s2="";
			ArrayList<Integer> arrayList1 = new ArrayList<Integer>();
			ArrayList<Integer> arrayList2 = new ArrayList<Integer>();
			while(true) {
				s1=buffer1.readLine();
				s2=buffer2.readLine();
				if(s1==null||s2==null) break;
				if(s1.equals(s2)) {
					arrayList1.add(count);
					sum1++;
				}
				if(!s1.equals(s2)) {
					arrayList2.add(count);
					sum2++;
				}
				count++;
			}
			System.out.println("Correct:"+sum1+"("+arrayList1+")");
			System.out.println("Wrong:"+sum2+"("+arrayList2+")");
		    StringBuffer buffer = new StringBuffer();
		    StringBuffer buffer12 = new StringBuffer();
		    buffer.append("Correct:").append(sum1).append("(").append(arrayList1).append(")").append("\n");
		    buffer.append("Wrong:").append(sum2).append("(").append(arrayList2).append(")").append("\n");
		    writeToGradeFile(buffer.toString());
		    writeToGradeFile(buffer12.toString());
		} catch (FileNotFoundException e) {		
			e.printStackTrace();
		}
	
	}

	public static Integer ys(int firstNum, int secNum, String operator) throws Exception{

		switch (operator) {

		case ADD: {

			return firstNum + secNum;

		}

		case SUB: {

			return firstNum - secNum;

		}

		case MUL: {

			return firstNum * secNum;

		}

		case DIV: {
			if (firstNum % secNum == 0) {
				return firstNum / secNum;
			}
			else {
				throw new Exception("");
			}

			

		}

		default: {

			return null;

		}

		}

	}

}