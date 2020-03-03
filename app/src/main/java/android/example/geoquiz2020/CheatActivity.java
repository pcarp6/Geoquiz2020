package android.example.geoquiz2020;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CheatActivity extends AppCompatActivity {

    TextView answerTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        answerTextView= findViewById(R.id. answer_text_view);
        Intent goCheat = getIntent();
        String string = goCheat.getStringExtra("KEY_STRING");
        answerTextView.setText(string);
    }
}
