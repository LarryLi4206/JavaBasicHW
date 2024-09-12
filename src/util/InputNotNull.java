package util;

public class InputNotNull<E> {

	public static void main(String[] args) {
		String s1="";
		String s2="123456";
		Integer int1=456;
		
		System.out.println(new InputNotNull().InputNotNullFunction(s1));
		System.out.println(new InputNotNull().InputNotNullFunction(s2));
		System.out.println(new InputNotNull().InputNotNullFunction(int1));
		

	}
	
	public E InputNotNullFunction(E string) {
		if(string=="") {
			
			return string=(E) "輸入不能為空";
		}else {
			
			return string;
		}
		
	}

}
