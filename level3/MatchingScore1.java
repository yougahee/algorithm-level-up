package level3;

import java.util.ArrayList;
import java.util.HashMap;

public class MatchingScore1 {
    public static void main(String[] args) {
        String word = "blind";
        String[] pages = {"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">" +
                "\n<head>\n  " +
                "<meta charset=\"utf-8\">\n  " +
                "<meta property=\"og:url\" content=\"https://a.com\"/>\n" +
                "</head>  \n" +
                "<body>\n" +
                "Blind Lorem Blind ipsum dolor Blind test sit amet, consectetur adipiscing elit. \n" +
                "<a href=\"https://b.com\">" +
                " Link to b </a>\n</body>\n</html>"
                ,

                "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://b.com\"/>\n</head>  \n<body>\nSuspendisse potenti. Vivamus venenatis tellus non turpis bibendum, \n<a href=\"https://a.com\"> Link to a </a>\nblind sed congue urna varius. Suspendisse feugiat nisl ligula, quis malesuada felis hendrerit ut.\n<a href=\"https://c.com\"> Link to c </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://c.com\"/>\n</head>  \n<body>\nUt condimentum urna at felis sodales rutrum. Sed dapibus cursus diam, non interdum nulla tempor nec. Phasellus rutrum enim at orci consectetu blind\n<a href=\"https://a.com\"> Link to a </a>\n</body>\n</html>"};

        System.out.println(solution(word, pages));

        String word1 = "Muzi";
        String[] pages1 = {"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://careers.kakao.com/interview/list\"/>\n</head>  \n<body>\n<a href=\"https://programmers.co.kr/learn/courses/4673\"></a>#!MuziMuzi!)jayg07con&&\n\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://www.kakaocorp.com\"/>\n</head>  \n<body>\ncon%\tmuzI92apeach&2<a href=\"https://hashcode.co.kr/tos\"></a>\n\n\t^\n</body>\n</html>"};
        System.out.println(solution(word1, pages1));
    }

    static ArrayList<MatchingScore.webPage> webPages;

    public static int solution(String word, String[] pages) {
        int answer = 0;
        double max = Integer.MIN_VALUE;
        word = word.toLowerCase();

        ArrayList<String> links;
        String url;
        int basic_score = 0, link_score =0;
        webPages = new ArrayList<MatchingScore.webPage>();
        HashMap<String, Integer> urlIndex = new HashMap<>();
        int[][] connectedMap = new int[pages.length][pages.length];

        for(int i=0; i<pages.length; i++) {
            int start_index = 0, end_index =0;
            links = new ArrayList<>();
            basic_score = 0;

            start_index = pages[i].lastIndexOf("content=\"https://");
            end_index = pages[i].indexOf("/>");

            url = pages[i].substring(start_index + 8, end_index - 1);
            urlIndex.put(url, i);
            //System.out.println("url : " + url);

            start_index = pages[i].indexOf("<body>", end_index);
            end_index = pages[i].indexOf("</body>");
            String temp = pages[i].substring(start_index + 7, end_index);
            System.out.println(temp);
            System.out.println();

            int start = 0, end = -1;
            while (true) {
                end = temp.indexOf("<a href=\"https://", end + 1);

                if (end == -1)
                    break;

                System.out.println("=================");
                System.out.println("시작 index : " + end);
                System.out.println("영어만 : " + temp.substring(start, end));
                basic_score += sumBasicScore(temp.substring(start, end), word);
                System.out.println("기본 점수 : " + basic_score);

                int e_end = temp.indexOf(">", end);
                System.out.println("링크 : " + temp.substring(end+8, e_end));
                String externalLink = temp.substring(end+8, e_end);
                links.add(externalLink);

                start = temp.indexOf(">", e_end);
            }


        }





        return answer;
    }


    public static int sumBasicScore(String str, String word) {
        int cnt = -1;
        int j = -1;
        str = str.toLowerCase();

        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) < 'a' || str.charAt(i) > 'z')
                str = str.substring(0,i) + ' ' + str.substring(i+1);
        }

        while (true) {
            j = str.indexOf(word, j + 1);
            cnt++;

            if(j == -1)
                break;
        }

        return cnt;
    }

    public static class webPage {
        String url;
        ArrayList<String> links;
        int basic_score;
        int external_link_num;
        int index;

        public webPage( String url, ArrayList<String> links, int basic_score, int external_link_num, int index) {
            this.url = url;
            this.links = links;
            this.basic_score = basic_score;
            this.external_link_num = external_link_num;
            this.index = index;
        }
    }
}
