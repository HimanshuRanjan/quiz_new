package in.ac.iiitd.psingh.mc16.objectivequiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class cheat extends AppCompatActivity {
    private TextView cheatText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        cheatText=(TextView)findViewById(R.id.cheatText);
        int in=getIntent().getIntExtra("ans",1);
        if(in==1)
        {
            cheatText.setText("Prime");

        }
        else
            cheatText.setText("Not Prime");
    }

    @Override
    public void onBackPressed() {
        Intent MainActivityIntent=new Intent(getApplicationContext(),QuizActivity.class);
        MainActivityIntent.putExtra("CheatUsed",true);
        setResult(1,MainActivityIntent);
        super.onBackPressed();
    }
}
