package algorithm_study.ex0409;

class Solution {
	  public String solution(String s, int n) {
	      char[] answerArr = new char[s.length()];
	      char[] lower = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
	      char[] upper = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
	      for(int i=0;i<s.length();i++) {
	    	  if(s.charAt(i) == ' ') {
	    		  answerArr[i] = ' ';
	    	  }
	    	  else if(s.charAt(i) < 97) {
	    		  int temp = (int) ((s.charAt(i)+n-65)%26);
	    		  answerArr[i]=upper[temp];
	    	  }
	    	  else if(s.charAt(i) >= 97) {
	    		  int temp = (int) ((s.charAt(i)+n-97)%26);
	    		  answerArr[i]=lower[temp];
	    	  }
	      }
	      return new String(answerArr);
	      //char%25 로 z->a변환
	  }
	  
	  public static void main(String[] args) {
		  Solution s = new Solution();
		  int len = (int)('z'-'a');
		  int a = (int)'a';
		  int A = (int)'A';
	      char[] upper = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
	      System.out.println(upper.length);
		  System.out.println(len+" a:"+a+" A:"+A);
		  
		  System.out.println(s.solution("z", 1));
	}
}
