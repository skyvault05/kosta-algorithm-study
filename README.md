# kosta-algorithm-study
algorithm study

##3월27일 체육복 빌려주기
<detail>
<summary>코드</summary>
<p>
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
</p>

</detail>
