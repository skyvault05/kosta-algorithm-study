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
        // [����] ��ư�� ������ ��� ���� �� �� �ֽ��ϴ�.
        
        System.out.println(count);

        return answer;
    }
}
