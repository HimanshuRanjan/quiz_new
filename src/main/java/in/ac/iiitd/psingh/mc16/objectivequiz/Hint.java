package in.ac.iiitd.psingh.mc16.objectivequiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Hint extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hint);
    }
    @Override
    public void onBackPressed() {
        Intent MainActivityIntent=new Intent(getApplicationContext(),QuizActivity.class);
        MainActivityIntent.putExtra("HintUsed",true);
        setResult(1,MainActivityIntent);
        super.onBackPressed();
    }
}
