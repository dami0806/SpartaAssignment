package day1_recipe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
♀️ **요리 레시피 메모장 만들기**

- 입력값
    - 내가 좋아하는 요리 제목을 먼저 입력합니다.
    - 요리 별점을 1~5 사이의 소수점이 있는 실수로 입력해 주세요. (ex. 3.5)
    - 이어서 내가 좋아하는 요리 레시피를 한 문장씩 10문장을 입력합니다.
- 출력값
    - 입력이 종료되면 요리 제목을 괄호로 감싸서 먼저 출력해 줍니다.
    - 이어서, 요리 별점을 소수점을 제외한 정수로만 출력해 줍니다. (ex. 3)
    - 바로 뒤에 정수 별점을 5점 만점 퍼센트로 표현했을 때 값을 실수로 출력해 줍니다. (ex. 60.0%)
    - 이어서, 입력한 모든 문장 앞에 번호를 붙여서 모두 출력해 줍니다.
 */

// 상속될수도 있고, 구현 변화 가능성 열어두고 싶음 -> final 없이
public class RecipeNotebook {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        RecipeData data = readInput(br);
        RecipeNotebook notebook = new RecipeNotebook(); // static 없이 메서드에 접근

        notebook.printResult(data.getTitle(), data.getScore(), data.getRecipe());
    }

    /**
     * 입력값 받기 외부로부터 받고,새로운 객체를 생성하는 독립적인 작업을 한다고 판단
     *
     * @param br
     * @return RecipeData
     * @throws IOException
     */
    static RecipeData readInput(BufferedReader br) throws IOException {
        String title = br.readLine();
        double score = Double.parseDouble(br.readLine());
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