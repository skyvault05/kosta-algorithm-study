package algorithm_study;

public class ex0317 {
	
	public static String[] solution(int n, int[] arr1, int[] arr2) {
	      String[] answer = new String[n];
	      StringBuilder builder = new StringBuilder();
	      int j = 1;
	      for(int i=0; i<n; i++){
	          builder.delete(0, n);
	          for(j=0; j<n; j++){
	              if((arr1[i]%2 + arr2[i]%2) == 0){
	                  builder.append(' ');
	              }else{
	                  builder.append('#');
	              }
	              arr1[i]=arr1[i]/2;
	              arr2[i]=arr2[i]/2;
	          }
	          builder.reverse();
	          answer[i] = builder.toString();
	          System.out.println(answer[i]);
	      }
	      return answer;

	  }//char배열로 넣어서 처리하자
	  

	public static void main(String[] args) {
		int[] arr1 = {9, 20, 28, 18, 11};
		int[] arr2 = {30, 1, 21, 17, 28};

		solution(5, arr1, arr2);
		System.out.println("-------------------");
		int[] arr3= {46, 33, 33 ,22, 31, 50};
		int[] arr4= {27 ,56, 19, 14, 14, 10};
		
		solution(6, arr3, arr4);
	}

}
