package level1;


public class NumString {
    public static void main(String[] args) {

        String s = "Pyy";
        boolean answer = true;

        int pnum=0;
        int ynum=0;
        char chars;


        for(int i=0; i<s.length(); i++) {
            chars = s.charAt(i);

            if(chars == 'p' || chars == 'P') {
                pnum++;
            }
            else if(chars == 'y' || chars == 'Y') {
                ynum++;
            }


        }

        if(pnum != ynum)
            answer = false;

        System.out.println(answer);

    }
}

