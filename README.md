# Kosta 알고리즘 스터디


## 체육복 빌려주기
https://programmers.co.kr/learn/courses/30/lessons/42862
<pre>
배열 그대로 비교하는걸 전제로 함.
체격 비교할때 앞번호 뒷번호만 비교하므로 예비로 가져온 학생 +1, -1만비교
첫번째 루프 : reserve로 lost를 비교하여 같은 값이 있으면 lost엔 100 reserve엔 200으로 쓰레기 값을 넣음. 
           (비교시 +1, -1로 비교하므로 만날수없음, 문제 내 최대 인원수도 넘어섬.)
두번째 루프 : reserve로 lost를 하나씩 비교하며 reserve보다 번호가 1작은 번호부터 빌려주고 answer++, 루프 빠져나옴(break)

answer = 총인원-(잃어버린수 - 빌려준수)
</pre>
<details><summary>[코드보기]</summary>
	

	
```java
public class ex0326 {
	    public static int solution(int n, int[] lost, int[] reserve) {  		    	
	        int answer = 0;
	        int ll = lost.length;
	        int rl = reserve.length;
	        for(int i=0; i<rl; i++){//자기가 잃어버리고 가져온 애들 지움 lost->100 reserve->200
	            for(int j=0; j<ll ;j++){
	            	if(lost[j]==reserve[i]) {
	            		lost[j]=100;
	            		reserve[i]=200;
	            		answer++;
	            		break;
	            	}	            	
	            }
	        }
	        for(int i=0; i<rl; i++){//이제 빌려줌-앞번호부터 받은애들 100
	            for(int j=0; j<ll ;j++){
	            	if(lost[j]==reserve[i]-1) {
	            		lost[j]=100;
	            		answer++;
	            		break;
	            	}else if(lost[j]==reserve[i]+1) {
	            		lost[j]=100;
	            		answer++;
	            		break;
	            	}
	            }
	        }
	        answer=n-(ll-answer); //총인원-(잃어버린수 - 빌려준수)
	        System.out.println(answer);
	        return answer;
	    }
	public static void main(String[] args) {
		int n1 = 5;
		int n2 = 5;
		int n3 = 3;
		int[] l1 = {2, 4};
		int[] r1 = {1, 3, 5};		
		int[] l2 = {2, 4};
		int[] r2 = {3};		
		int[] l3 = {3};
		int[] r3 = {1};
		int re1 = solution(n1, l1, r1);
		System.out.println();
		int re2 = solution(n2, l2, r2);
		System.out.println();
		int re3 = solution(n3, l3, r3);
	}

}
 ```
 
 </details>
 
 ## 소수(Prime Number) 찾기
https://programmers.co.kr/learn/courses/30/lessons/12921
<pre>
1. 각 번호를 소수로 나누고 소수이면 추가.
</pre>
<details><summary>[코드보기]</summary>
	

	
```java
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
 ```
 
 </details>
 
 <pre>
2.에라토스테네스의 체 방식으로 풀기
  boolean배열로 각 숫자 표현함.
</pre>
<details><summary>[코드보기]</summary>
	

	
```java
public static int solution2(int n) {
			  int answer=0;
			  ArrayList<Boolean> primeList = new ArrayList<Boolean>(n+1);
			  primeList.add(false);
			  primeList.add(false);
			  
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
 ```
 
 </details>
 
 ## 수박수박수박수....
 <pre>
 char배열을 만들어서 홀수엔 '수' 짝수엔 '박'넣어서 String Constructor로 String 만들어 반환
 </pre>
 <details><summary>코드보기</summary>
	
 ```java
 class Solution {
		  public String solution(int n) {
			  char[] cr = new char[n];
		      for(int i=0; i<n; i+=2){
		          cr[i]='수';
		      }
		      for(int i=1; i<n; i+=2){
		          cr[i]='박';
		      }
		      return new String(cr);
		  }
	}
 ```
 
 </details>
 
 ## 시저 암호
 <pre>
 1. 알파벳을 char 배열로 만들어서 뽑아쓰기 위해 생성해둠
 2. 받은 스트링을 String.charAt()메소드로 각각 비교하면서 변환.
    해석된 문자의 순번 = 받은문자 - (a or A) + N % 26
 3. 문자의 순번을 index로 lower나 upper배열에서 참조해 answerArr 배열에 하나하나 담음.
 4. String Constructor에 answerArr을 매개변수로 String을 생성후 리턴.
 
 </pre>
 <details><summary>코드보기</summary>
	
 ```java
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
	  }
	}
 ```
 
 </details>
 
 ## 크레인
 
 ```java
 
 package algorithm_study.ex0413;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int counter = 0;
        int[] container = new int[moves.length];
        int N = board.length;
        
        for(int i : moves) {
        	i--;
        	
        	for(int j=0; j<N; j++) {
        		if(board[j][i]!=0) {
        			container[counter]=board[j][i];
        			counter++;
        			break;
        		}
        	}
        	int before = (counter-2 < 0) ? -20 : container[counter-2];
			if(container[counter-1] == before) {
				counter--;
				answer++;
			}
			
        	
        	
        	
        }
        System.out.println("ans:"+answer);
        return answer;
    }
    
    public static void main(String[] args) {
		Solution s = new Solution();
		int board[][] = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int[] moves = {1,5,3,5,1,2,1,4};
		s.solution(board, moves);
	}
}

 
 ```

 예제는 https://programmers.co.kr/ 의 문제를 사용하였습니다. 예제의 저작권은 (주)그랩에 있습니다
