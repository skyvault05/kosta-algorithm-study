package algorithm_study;

class ex0311 {
    boolean solution(String s) {
        boolean answer = true;
        int length = s.length();
        int count = 0;
        for(int i=0; i<length; i++){
            if(Character.toLowerCase(s.charAt(i)) == 121){
                count++;
            }else if(Character.toLowerCase(s.charAt(i)) == 112){
                count--;
            }
        }
        if(count != 0){
            answer = false;
        }
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        
        System.out.println(count);

        return answer;
    }
}
