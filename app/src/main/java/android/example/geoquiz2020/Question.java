package android.example.geoquiz2020;

public class Question {
    int textResourceId;
    boolean answerTrue;


    public Question(int textResourceId, boolean answerTrue) {
        this.textResourceId = textResourceId;
        this.answerTrue = answerTrue;
    }

    public int getTextResourceId() {
        return textResourceId;
    }

    public boolean isAnswerTrue() {
        return answerTrue;
    }
}
