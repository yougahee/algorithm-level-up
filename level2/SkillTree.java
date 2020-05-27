package level2;


import java.util.ArrayList;
import java.util.HashSet;

public class SkillTree {
    public static void main(String[] args) {
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};


        System.out.println(solution(skill, skill_trees));
    }


    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for(int i=0; i<skill_trees.length; i++){
            boolean flag = true;
            String[] skills = skill_trees[i].split("");
            int cnt=0;


            for(int j=0; j<skills.length; j++){
                if(cnt < skill.indexOf(skills[j])){
                    flag = false;
                    break;
                }
                //기술이 차례차례 들어가 있다면 cnt++
                else if(cnt == skill.indexOf(skills[j])){
                    cnt++;
                }
            }

            if(flag){
                answer++;
            }
        }
        return answer;
    }
}

