package algorithm_study;

public class ex0403 {
	class Solution {
		  public String solution(int n) {
//		      String answer = "수박";
//		      StringBuilder sb = new StringBuilder();
//		      if(n%2==0){
//		          for(int i=0;i<n;i+=2){
//		              sb.append(answer);
//		          }          
//		      } else{
//		          for (int i=0; i<n-1; i+=2){
//		              sb.append(answer);
//		          }
//		          sb.append('수');
//		      }
//		      return sb.toString();
			  
			  char[] cr = new char[n];
			  System.out.println(cr[0]);
		      for(int i=0; i<n; i+=2){
		          cr[i]='수';
		      }
		      for(int i=1; i<n; i+=2){
		          cr[i]='박';
		      }
		      return new String(cr);
		  }
	}
}
