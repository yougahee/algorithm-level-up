package level2;



class CenterString {

    public static void main(String[] args) {

        String s = "qwer";
        System.out.println(solution(s));
    }


    public static String solution(String s) {

        int share = s.length()/2;
        int remainder = s.length()%2;

        //짝수
        if(remainder ==0) {
            return s.substring(share-1, share+1);
        }
        //홀수
        else {
            return s.substring(share, share+1);
        }

    }

}