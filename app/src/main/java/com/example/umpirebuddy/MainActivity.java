package com.example.umpirebuddy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toolbar;

import static com.example.umpirebuddy.R.id.toolbar;

public class MainActivity extends AppCompatActivity {

    static int balls = 0;
    static int strikes = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onStrike(View view) {
        strikes++;
        final TextView ballCount = (TextView) findViewById(R.id.textView2);
        ballCount.setText(Integer.toString(strikes));

        if(strikes == 3) {
//          Show strike_message and Clear button
            findViewById(R.id.textView6).setVisibility(view.VISIBLE);
            findViewById(R.id.button5).setVisibility(view.VISIBLE);
//          Hide Strike and Ball buttons
            findViewById(R.id.button).setVisibility(view.GONE);
            findViewById(R.id.button2).setVisibility(view.GONE);
        }
    }

    public void onBall(View view) {
        balls++;
        final TextView ballCount = (TextView) findViewById(R.id.textView3);
        ballCount.setText(Integer.toString(balls));
        if(balls == 4) {
//          Show walk_message and Clear button
            findViewById(R.id.textView7).setVisibility(view.VISIBLE);
            findViewById(R.id.button5).setVisibility(view.VISIBLE);
//          Hide Strike and Ball buttons
            findViewById(R.id.button).setVisibility(view.GONE);
            findViewById(R.id.button2).setVisibility(view.GONE);
        }
    }

    public void onClear(View view) {
//      Update internal counters
        balls = 0;
        strikes = 0;

//      Update show counters
        final TextView ballCount = (TextView) findViewById(R.id.textView3);
        ballCount.setText(Integer.toString(0));
        final TextView strikeCount = (TextView) findViewById(R.id.textView2);
        strikeCount.setText(Integer.toString(0));

//      Show Strike and Ball buttons
        findViewById(R.id.button).setVisibility(view.VISIBLE);
        findViewById(R.id.button2).setVisibility(view.VISIBLE);

//      Hide out_message, walk_message and Clear button
        findViewById(R.id.textView6).setVisibility(view.GONE);
        findViewById(R.id.textView7).setVisibility(view.GONE);
        findViewById(R.id.button5).setVisibility(view.GONE);
    }
}
