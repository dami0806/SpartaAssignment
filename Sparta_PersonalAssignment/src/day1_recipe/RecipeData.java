package day1_recipe;

/**
 * 불변성 객체로 사용
 */
public final class RecipeData {
    private String title;
    private double score;
    private String[] recipe;

    public RecipeData(String title, double score, String[] recipe) {
        this.title = title;
        this.score = score;
        this.recipe = recipe.clone();
    }

    public String getTitle() {
        return title;
    }

    public double getScore() {
        return score;
    }

    public String[] getRecipe() {
        return recipe.clone();
    }

}
