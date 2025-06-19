package com.khy.example01;

public class Helloworld {
	public static void main(String[] args) {
		
		
		// 같은 참조일 떄 값을 바꾸면2
		
		  String[] oldStrArray2 = {"java", "array", "copy"}; // Stack에 변수 생성 -> Heap에 문자열 객체 생성 및 참조 
		  String[] newStrArray2 = new String[5]; // 새로운 문자 배열 객체 생성
		  
		  System.arraycopy(oldStrArray2, 0, newStrArray2, 0, oldStrArray2.length); // deep copy(깊은 복사)
		  
		  newStrArray2[1] = "python"; 
		  for(int i = 0; i < newStrArray2.length; i++) {
		  System.out.print(newStrArray2[i] + ", "); // 나는 왜 마지막에 null이 출력될까? 
		  }
		  System.out.println();
		  
		  for(int i = 0; i < oldStrArray2.length; i++) {
		  System.out.print(oldStrArray2[i] + ", "); 
		  }
		 
	}
}