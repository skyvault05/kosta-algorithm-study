package algorithm_study;

import java.util.ArrayList;
import java.util.List;

public class ex0330 {
	
	static class Solution {		  
		  public static int solution(int n) {
			  int answer = 1;
		      int flag = 0;
		      List<Integer> list = new ArrayList<>();
		      list.add(2);
		      for(int i=2; i<=n; i++){		            
		            for(int num : list) {
		            	if(i%num == 0) {
		            		flag++;
		            		break;
		            	}
		            }
		            if(flag==0) {
	            		answer++;
	            		list.add(i);
	            	} else {
	            		flag=0;
	            	}
		            
		      }
		      return answer;
		      //java.util.ConcurrentModificationException 도중에 list인덱스와 사이즈값이 변함
		  }
		  
		  public static int solution2(int n) {
			  int answer=0;
			  ArrayList<Boolean> primeList = new ArrayList<Boolean>(n+1);
			  primeList.add(false);
			  primeList.add(false);
			  for(int i=2; i<=n; i++ )
					primeList.add(i, true);
			  
			// 2 부터  ~ i*i <= n
				// 각각의 배수들을 지워간다.
				for(int i=2; (i*i)<=n; i++){
					if(primeList.get(i)){
						for(int j = i*2; j<=n; j+=i) primeList.set(j, false);
						//i*i 미만은 이미 처리되었으므로 j의 시작값은 i*i로 최적화할 수 있다.
					}
				}
				
				for(boolean b : primeList) {
					if(b) {
						answer++;
					}
				}
				
			  
			 return answer;
		  }
		  
		  public static int solution3(int n) {
			  int answer=0;
			  boolean[] prime = new boolean[n+1];
			  prime[0]=true;
			  prime[1]=true;
			  
			// 2 부터  ~ i*i <= n
				// 각각의 배수들을 지워간다.
				for(int i=2; (i*i)<=n; i++){
					if(!prime[i]){
						for(int j = i*2; j<=n; j+=i) prime[j]=true;
						//i*i 미만은 이미 처리되었으므로 j의 시작값은 i*i로 최적화할 수 있다.
					}
				}
				
				for(boolean b : prime) {
					if(!b) {
						answer++;
					}
				}
				
			  
			 return answer;
		  }
	}


	public static void main(String[] args) {
		Solution.solution(200);
		Solution.solution2(200);
	}

}
