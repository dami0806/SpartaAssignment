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
public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            RecipeData data = RecipeNotebook.readInput(br); // 객체 생성시간전에

            RecipeNotebook notebook = new RecipeNotebook();

            notebook.printResult(data.getTitle(), data.getScore(), data.getRecipe());

        } catch (NumberFormatException e) {
            System.out.println("잘못된 숫자입니다. 정확한 숫자를 입력해야합니다");
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
