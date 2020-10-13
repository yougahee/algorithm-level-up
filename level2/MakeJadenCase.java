package level2;

public class MakeJadenCase {
    public static void main(String[] args) {
        System.out.println(solution("3people       unFollowed me "));
        System.out.println(develop("3people a unFollowed me"));

    }

    //내 first 코드
    public static String solution(String s) {
        String answer = "";
        String[] temp = s.split(" ");

        for(String word : temp) {
            if(word.equals("")) {
                answer += " ";
                continue;
            }
            answer += word.substring(0,1).toUpperCase() + word.substring(1).toLowerCase() + " ";
        }

        if(answer.charAt(answer.length()-1) == ' ' && s.charAt(s.length()-1) != ' ')
            return answer.substring(0, answer.length()-1);
        else return answer;
    }

    //develop 코드 ( 참고 )
    public static String develop(String s) {
        String answer = "";
        String[] temp = s.toLowerCase().split("");
        boolean isBlank = false;

        for(String charAt : temp) {
            answer += isBlank ? charAt.toUpperCase() : charAt;
            isBlank = charAt.equals(" ");
        }

        return answer;
    }
}
