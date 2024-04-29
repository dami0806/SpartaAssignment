package day1_recipe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 상속될수도 있고, 구현 변화 가능성 열어두고 싶음 -> final 없이
public class RecipeNotebook {

    /**
     * 입력값 받기 외부로부터 받고,새로운 객체를 생성하는 독립적인 작업을 한다고 판단
     *
     * @param br
     * @return RecipeData
     * @throws IOException
     */
    static RecipeData readInput(BufferedReader br) throws IOException {
        // 제목 입력
        System.out.println("제목을 입력하세요:");
        String title = br.readLine();
        double score = 0.0;
        // 별점 입력

        System.out.println("별점을 입력하세요 (1.0 ~ 5.0):");
        score = Double.parseDouble(br.readLine());
        if (score < 1.0 || score > 5.0) {
            throw new ScoreOutOfRangeException("별점은 (1.0 ~ 5.0)범위 여야합니다.");
        }

        String[] recipe = new String[10]; // 10개로 한정

        for (int index = 0; index < 10; index++) {
            recipe[index] = br.readLine();
        }
        return new RecipeData(title, score, recipe);
    }

    /**
     * 여기부터 모든 메서드 static 제거함 : 불변성을 굳이 원하지 않음, 객체 생성전 사용할 일 없음
     * 메모리 효율성을 위해 static없이 사용
     */
    void printResult(String title, double score, String[] recipe) {

        System.out.println(titleText(title));
        System.out.println(scoreText(score));

        for (int j = 0; j < recipe.length; j++) {
            System.out.println(recipeText(j + 1, recipe[j]));
        }
    }

    String titleText(String title) {

        return String.format("[%s]", title);
    }

    String scoreText(double score) {

        int score_int = (int) score;
        double percentage = calculate_Score(score);

        return String.format("별점 : %d (%.1f%%)", score_int, percentage);
    }

    String recipeText(int order, String text) {

        return String.format("%d. %s", order, text);
    }

    // 별점 계산
    double calculate_Score(double score) {

        int scoreInt = (int) score;
        double percentage = scoreInt / 5.0 * 100;

        return percentage;
    }
}