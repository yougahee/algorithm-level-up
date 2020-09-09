package level3;

import java.util.ArrayList;
import java.util.HashMap;

public class MatchingScore {
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

    public static class webPage {
        String url;
        ArrayList<String> links;
        int basic_score;
        int external_link_num;

        public webPage( String url, ArrayList<String> links, int basic_score, int external_link_num) {
            this.url = url;
            this.links = links;
            this.basic_score = basic_score;
            this.external_link_num = external_link_num;
        }
    }

    static ArrayList<webPage> webPages;

    public static int solution(String word, String[] pages) {
        int answer = 0;
        double max = Integer.MIN_VALUE;

        ArrayList<String> links;
        String url;
        int basic_score = 0, link_score =0;
        webPages = new ArrayList<webPage>();
        HashMap<String, Integer> urlIndex = new HashMap<>();
        int[][] connectedMap = new int[pages.length][pages.length];

        //기본점수, 외부개수까지만
        for (int i = 0; i < pages.length; i++) {
            links = new ArrayList<>();
            basic_score = 0;

            int start_index = 0, end_index =0, posl = 0, posr = 0;
            while(start_index <= posl) {
                posl = pages[i].indexOf("<meta", posl+1);
                posr = pages[i].indexOf(">", posl);
                start_index = pages[i].lastIndexOf("https://", posr);
                end_index = pages[i].indexOf("/>");
            }

            url = pages[i].substring(start_index -1, end_index );
            urlIndex.put(url, i);
            //System.out.println("url : " + url);

            start_index = pages[i].indexOf("<body>");
            end_index = pages[i].indexOf("</body>");
            String temp = pages[i].substring(start_index + 6, end_index);
            //System.out.println("body 사이의 string : " + temp);

            //basic_score = sumBasicScore(temp, word);

            int start = 0, end = 0;
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

            link_score = links.size();
            System.out.println("외부링크 수 : " + link_score);

            webPages.add(new webPage(url, links, basic_score, link_score));
        }

        //
        for(int i=0; i<pages.length; i++) {
            ArrayList<String> link = webPages.get(i).links;

            for(String linkUrl : link) {
                if(urlIndex.containsKey(linkUrl)) {
                    int index = urlIndex.get(linkUrl);
                    connectedMap[i][index] = 1;
                }
            }
        }

        //링크점수, 매칭점수 구해서 넣기..
        for(int i=0; i < pages.length; i++) {
            System.out.println("******************");
            double linkScore = 0;
            for(int j=0; j< pages.length; j++) {

                if(connectedMap[j][i] == 1) {
                    //i번째의
                    linkScore += (double) webPages.get(j).basic_score/webPages.get(j).external_link_num;
                    System.out.println("url :  " + webPages.get(j).url + " 외부링크 점수 : " + linkScore);
                }
            }

            double matchingScore = linkScore + webPages.get(i).basic_score;

            if(max < matchingScore) {
                answer = i;
                max = matchingScore;
            }
        }

        return answer;
    }

    public static int sumBasicScore(String str, String word) {
        int cnt = -1;
        int j = 0;
        str = str.toLowerCase();
        word = word.toLowerCase();

        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) < 'a' || str.charAt(i) > 'z')
                str = str.substring(0,i) + ' ' + str.substring(i+1);
        }

        while (j >= 0) {
            j = str.indexOf(word, j + 1);
            cnt++;
        }

        return cnt;
    }
}
