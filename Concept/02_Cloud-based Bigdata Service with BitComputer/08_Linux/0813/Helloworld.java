package com.khy.example01;

public class Helloworld {
	public static void main(String[] args) {
		
		
		// ���� ������ �� ���� �ٲٸ�2
		
		  String[] oldStrArray2 = {"java", "array", "copy"}; // Stack�� ���� ���� -> Heap�� ���ڿ� ��ü ���� �� ���� 
		  String[] newStrArray2 = new String[5]; // ���ο� ���� �迭 ��ü ����
		  
		  System.arraycopy(oldStrArray2, 0, newStrArray2, 0, oldStrArray2.length); // deep copy(���� ����)
		  
		  newStrArray2[1] = "python"; 
		  for(int i = 0; i < newStrArray2.length; i++) {
		  System.out.print(newStrArray2[i] + ", "); // ���� �� �������� null�� ��µɱ�? 
		  }
		  System.out.println();
		  
		  for(int i = 0; i < oldStrArray2.length; i++) {
		  System.out.print(oldStrArray2[i] + ", "); 
		  }
		 
	}
}