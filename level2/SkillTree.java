package level2;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class SkillTree {
    public static void main(String[] args) {
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};


        System.out.println(solution2(skill, skill_trees));
    }

    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;

        ArrayList<Character> arrayList = new ArrayList<>();
        HashSet<Character> hashSet = new HashSet<>();

        for(int i=0; i<skill.length(); i++) {
            arrayList.add(skill.charAt(i));
            hashSet.add(skill.charAt(i));
        }

        for(int i=0; i<skill_trees.length; i++) {
            int index = 0;
            boolean isTrue = true;

            for(int j=0; j<skill_trees[i].length(); j++) {
                char a = skill_trees[i].charAt(j);

                if( hashSet.contains(a) ) {
                    if(arrayList.get(index) == a)  {
                        index++;
                    }
                    else {
                        isTrue = false;
                        break;
                    }
                }
            }

            if(isTrue)
                answer++;
        }

        return answer;
    }

    //solv2
    public static int solution2(String skill, String[] skill_trees) {
        ArrayList<String> skillArrayList = new ArrayList<>(Arrays.asList(skill_trees));
        Iterator<String> iterator = skillArrayList.iterator();

        while (iterator.hasNext()) {
            if(skill.indexOf(iterator.next().replaceAll("[^" + skill + "]", "")) !=0){
                iterator.remove();
            }
        }

        return skillArrayList.size();
    }
}

