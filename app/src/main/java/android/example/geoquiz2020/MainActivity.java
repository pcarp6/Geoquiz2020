package android.example.geoquiz2020;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button mTrueButton;
    private Button mFalseButton;
    private TextView questionTextView;
    private ArrayList<Question> questionsBank = new ArrayList<>();
    private int currentIndex;
    private boolean isAnwserTrue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTrueButton = (Button) findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
            }
        });
        questionsBank.add(new Question(R.string.question_australia, true));
        questionsBank.add(new Question(R.string.question_ocean, true));
        questionsBank.add(new Question(R.string.question_mideast, false));
        questionsBank.add(new Question(R.string.question_africa, false));

        questionTextView = findViewById(R.id.question_text_view);
        questionTextView.setText(questionsBank.get(currentIndex).getTextResourceId());

        mFalseButton = (Button) findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                checkAnswer(false);
            }
        });
    }


    public void updateQuestion(View view) {
        currentIndex++;
        if (currentIndex == questionsBank.size()) {
            currentIndex = 0;
            Toast.makeText(this, "Back to the beginning", Toast.LENGTH_SHORT).show();
        }
        Question q = questionsBank.get(currentIndex);
        questionTextView.setText(q.getTextResourceId());
    }

    public void lastQuestion(View view) {
        currentIndex--;

        if (currentIndex == 0);{
            Toast.makeText(this, "This is the beginning", Toast.LENGTH_SHORT).show();
        }
        Question q = questionsBank.get(currentIndex);
        questionTextView.setText(q.getTextResourceId());
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(MainActivity.this, "this is only for rotation", Toast.LENGTH_SHORT).show();
    }

    private void checkAnswer(boolean userPressedTrue) {
        boolean correctAnswer = questionsBank.get(currentIndex).isAnswerTrue();
        if (userPressedTrue == correctAnswer) {
            Toast.makeText(this, R.string.correct_toast, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
        }
    }

    public void clickCheat(View view) {
        Intent goCheat = new Intent(this, CheatActivity.class);
        startActivity(goCheat);
    }

}