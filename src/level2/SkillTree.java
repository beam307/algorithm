package level2;


public class SkillTree {
    public static void main(String[] args) {

        System.err.println(solution("CBD", new String[]{
                "BACDE", "CBADF", "AECB", "BDA"
        }));
    }

    public static int solution(String skill, String[] skill_trees) {
        int answer = skill_trees.length;

        for (String skillTree: skill_trees) {
            if (skill.indexOf(skillTree.replaceAll("[^" + skill + "]", "")) != 0) {
                answer--;
            }
        }


        return answer;
    }
}
