package in.ac.iiitd.psingh.mc16.objectivequiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

public class QuizActivity extends AppCompatActivity {

    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton,cheat,hint;
    private int mNumber;
    private static final String TAG = "QuizActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        Random r=new Random();
        mNumber= (r.nextInt(1000) + 2);
        TextView tv = (TextView) findViewById(R.id.textViewer);
        tv.setText("Is "+mNumber+" Prime?");
        mTrueButton = (Button) findViewById(R.id.TrueButton);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Clicked True");
                if(isPrime(mNumber))
                {
                    final Toast toast = Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT);
                    toast.show();

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            toast.cancel();
                        }
                    }, 500);
                }
                else
                {
                    final Toast toast = Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT);
                    toast.show();

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            toast.cancel();
                        }
                    }, 500);
                }

            }

            private boolean isPrime(int mNumber) {
                int c=0,i;
                for(i=2;i<mNumber/2;i++)
                {
                    if(mNumber%i==0)
                    {
                        c++;
                        break;
                    }
                }
                if(c==0)
                    return true;
                else
                    return false;
            }


        });
        mFalseButton = (Button) findViewById(R.id.FalseButton);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Clicked False");
                if(! isPrime(mNumber))
                {
                    final Toast toast = Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT);
                    toast.show();

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            toast.cancel();
                        }
                    }, 500);
                }
                else
                {
                    final Toast toast = Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT);
                    toast.show();

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            toast.cancel();
                        }
                    }, 500);
                }

            }
            private boolean isPrime(int mNumber) {
                int c=0,i;
                for(i=2;i<mNumber/2;i++)
                {
                    if(mNumber%i==0)
                    {
                        c++;
                        break;
                    }
                }
                if(c==0)
                    return true;
                else
                    return false;
            }

        });
        hint = (Button) findViewById(R.id.hint);
        hint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Hint.class);

                startActivityForResult(i,1);
            }
        });
        cheat = (Button) findViewById(R.id.cheat);
        cheat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), cheat.class);

                i.putExtra("ans",isPrime(mNumber));
                startActivityForResult(i,1);
            }
            private int isPrime(int mNumber) {
                int c=0,i;
                for(i=2;i<mNumber/2;i++)
                {
                    if(mNumber%i==0)
                    {
                        c++;
                        break;
                    }
                }
                if(c==0)
                    return 1;
                else
                    return 2;
            }
        });

        mNextButton = (Button) findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Clicked Next");
                Random r=new Random();
                mNumber= (r.nextInt(1000) + 2);
                TextView tv = (TextView) findViewById(R.id.textViewer);
                tv.setText("Is "+mNumber+" Prime?");
            }
        });


    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        boolean hintcheck=data.getBooleanExtra("HintUsed",false);
        boolean cheatcheck=data.getBooleanExtra("CheatUsed",false);
        if(cheatcheck==true)
        {
            Toast.makeText(getApplicationContext(),"Cheat Used",Toast.LENGTH_SHORT).show();
        }

    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "Inside onSaveInstance");
    }
    public void onRestoreInstanceState(Bundle savedInstanceSatate){
        super.onRestoreInstanceState(savedInstanceSatate);
    }

    @Override
    public void onPause()
    {
        super.onPause();
        Log.d(TAG,"Inside OnPause");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.d(TAG,"Inside OnREsume");

    }

    @Override
    public void onStop(){
        super.onStop();
        Log.d(TAG, "Inside OnSTop");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "Inside OnDestroy");
    }
}
