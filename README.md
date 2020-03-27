# Kosta 알고리즘 스터디


## 3월27일 체육복 빌려주기
https://programmers.co.kr/learn/courses/30/lessons/42862
<pre>
배열 그대로 비교하는걸 전제로 함.
체격 비교할때 앞번호 뒷번호만 비교하므로 예비로 가져온 학생 +1, -1만비교
첫번째 루프 : reserve로 lost를 비교하여 같은 값이 있으면 lost엔 100 reserve엔 200으로 쓰레기 값을 넣음. 
           (비교시 +1, -1로 비교하므로 만날수없음, 문제 내 최대 인원수도 넘어섬.)
두번째 루프 : reserve로 lost를 하나씩 비교하며 reserve보다 번호가 1작은 번호부터 빌려주고 answer++, 루프 빠져나옴(break)

answer = 총인원-(잃어버린수 - 빌려준수)
</pre>
<details><summary><bold>코드보기</summary>
	

	
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
 
 예제는 https://programmers.co.kr/ 의 문제를 사용하였습니다. 예제의 저작권은 (주)그랩에 있습니다
