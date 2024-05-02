package Score.models;

//점수,등급
public class Score {
    private int score;
    private String grade;

    public Score(int score, String grade) {
        this.score = score;
        this.grade = grade;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
