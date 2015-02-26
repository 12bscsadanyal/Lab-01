/**
 * 
 */
package pk.edu.seecs.advanceprogramming.Lab01;

/**
 * @author Abdul Subbooh Danyal
 *
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Vector;
public class matrixComputer {

	private String name;
	private int value;

	static String start;
	static Map<String, Integer> m1 = new HashMap<String, Integer>();
	static Map<String, Float> f1 = new HashMap<String, Float>();
	static Map<String, String> s1 = new HashMap<String, String>();
	@SuppressWarnings("rawtypes")
	static Vector lineArray=new Vector();
	/**
	 * @param args
	 * @throws IOException 
	 * 
	 */
	public static boolean isInteger( String input )
	{
		try
		{
			Integer.parseInt( input );
			return true;
		}
		catch( Exception e)
		{
			return false;
		}
	}

	public static void willPrintLine(String r){
		//(String) lineArray.get(i)
		Vector<String> val=new Vector<String>();
		//System.out.println(r);
		StringTokenizer st = new StringTokenizer(r," ");
		String temp;
		temp= st.nextToken();
		if(temp.contains("print")){

		}
		else{
			System.out.println("Wrong Syntax");
			return;
		}
		while (st.hasMoreTokens()) {  
			temp= st.nextToken();

			if(m1.containsKey(temp)){
				System.out.println(m1.get(temp));
			}else{
				System.out.println(temp);
			}
		}

	}

	@SuppressWarnings("unused")
	public static void solveSomeArithematic(String t){
		//System.out.println(t);
		Vector<String> opera=new Vector<String>();
		Vector<Integer> vari=new Vector<Integer>();
		StringTokenizer st = new StringTokenizer(t," ");
		String temp;
		String t1 , t2 ,t3;
		int temp1 , temp2, temp3;
		int assign =0, assigner=0;
		t1= st.nextToken();
		t2= st.nextToken();

		if(m1.containsKey(t1) || f1.containsKey(t1) || s1.containsKey(t1)){

		}else{
			System.out.println("Variable is undefined ");
			return;
		}

		while (st.hasMoreTokens()) {  
			temp= st.nextToken();
			//  System.out.println(start);
			/*	if(m1.containsKey(temp) && assign == 0){
				System.out.println(m1.get(temp));
				assign = m1.get(temp);
				//System.out.println("");
			}*/
			/*else*/ if(m1.containsKey(temp)){
				assigner = m1.get(temp);
				vari.add(m1.get(temp));
				//		System.out.println(assign+"  "+assigner);	
				//System.out.println(vari);
			}else if(f1.containsKey(temp)){

			}else if(s1.containsKey(temp)){

			}			
			else if(temp.contains("+") || temp.contains("-") || temp.contains("*") || temp.contains("/")){
				//	System.out.println(temp);
				opera.add(temp);
				//	System.out.println(opera);
			}
			else if(Character.isDigit(temp.charAt(0))){
				//	System.out.println(temp);
				vari.add(Integer.parseInt(temp));
			}
			else{
				//System.out.println("The variable is uninitialized");

			}
		}

		temp = opera.get(0);
		temp1 = vari.get(0);
		temp2 = vari.get(1);

		int num;
		while(!opera.isEmpty()){
			num=0;
			if(opera.contains("/")){
				num =opera.indexOf("/");
			}else if(opera.contains("*")){
				num =opera.indexOf("*");
			}else if(opera.contains("+")){
				num =opera.indexOf("+");
			}else{
				num =opera.indexOf("-");
			}

			temp = opera.get(num);
			temp1 = vari.get(num);
			temp2 = vari.get(num+1);
			vari.remove(num);
			opera.remove(num);
			switch (temp){
			case "+":
				temp3 = temp1 + temp2;
				vari.set(num,temp3);
				System.out.println("After operations  "+temp3);
				m1.put(t1, temp3);
				System.out.println(m1);
				break;
			case "-":
				temp3 = temp1 - temp2;
				vari.set(num,temp3);
				System.out.println("After operations  "+temp3);
				m1.put(t1, temp3);
				System.out.println(m1);
				break;
			case "*":
				temp3 = temp1 * temp2;
				vari.set(num,temp3);
				System.out.println("After operations  "+temp3);
				m1.put(t1, temp3);
				System.out.println(m1);
				break;
			case "/":
				temp3 = temp1 / temp2;
				vari.set(num,temp3);
				System.out.println("After operations  "+temp3);
				m1.put(t1, temp3);
				System.out.println(m1);
				break;
			default:

			}

		}
	}

	public static void declearVariable(String s){
		System.out.println(s);
		String temp = null , temp1 = null , temp2 = null;
		String temp3 = null;
		matrixComputer y = new matrixComputer();
		StringTokenizer st = new StringTokenizer(s," ");

		while (st.hasMoreTokens()) {  
			temp= st.nextToken();
			temp1= st.nextToken();
			temp2= st.nextToken();
			temp3= st.nextToken();
			// System.out.println(temp +"  "+temp1 +"  "+temp2 +"  "+temp3);
		}

		if(m1.containsKey(temp1) || f1.containsKey(temp1) || s1.containsKey(temp1)){
			System.out.println("Multiple Declerations are not allowed.");
			return;
		}

		if(temp.contains("Let") && temp2.equals("=") && temp3.contains(".") && isInteger(temp3) && !(isInteger(temp1))) {

			y.name = temp1;
			y.value = (int) Float.parseFloat(temp3);
			f1.put(y.name,(float) y.value);
			f1.put("integer", (float) 26.25);
			System.out.println("Float is initialized" );
			System.out.println(f1);
		}
		else if(temp.contains("Let") && temp2.equals("=") && temp3.contains("\"") && !(isInteger(temp1))) {

			s1.put(temp1,temp3);
			System.out.println("String is initialized...");
			System.out.println(s1);
		}
		else if(temp.contains("Let") && temp2.equals("=") && isInteger(temp3) && !(isInteger(temp1))) {

			y.name = temp1;
			y.value = Integer.parseInt(temp3);
			m1.put(y.name,y.value);
			System.out.println(m1);
		}
		else{
			System.out.println("wrong syntax  ");
			return;
		} 

	}

	@SuppressWarnings({ })
	static String l = "Let";
	@SuppressWarnings({ "unchecked", "unused" })
	public static void main(String[] args) throws IOException {

		matrixComputer t1 = new matrixComputer();

		String lineContents=null;
		int counter=0;
		try{
			@SuppressWarnings("resource")
			BufferedReader br=new BufferedReader(new FileReader("D:/interpreter.txt"));
			while((lineContents=br.readLine())!=null){
				lineArray.add(lineContents);
				counter++;
			}
		}
		catch(FileNotFoundException fne){
			fne.printStackTrace();
		}
		catch(IOException io){
			io.printStackTrace();
		}
		for (int i=0;i<lineArray.size();i++){
			//System.out.println(lineArray.get(i));

			StringTokenizer st = new StringTokenizer((String) lineArray.get(i)," ");  
			while (st.hasMoreTokens()) {  
				start= st.nextToken();
				//  System.out.println(start);
				if(((String) lineArray.get(i)).contains("Let")){
					System.out.println("Declaring new variable");  
					declearVariable((String) lineArray.get(i));
					break;
				}
				else if(((String) lineArray.get(i)).contains("print")){
					System.out.println("Will print line");
					willPrintLine((String) lineArray.get(i));
					break;
				}
				else{
					System.out.println("Get Some Arithematic");
					solveSomeArithematic((String) lineArray.get(i));
					break;
				}
			}
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
