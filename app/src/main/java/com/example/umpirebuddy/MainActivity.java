package com.example.umpirebuddy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    static int balls = 0;
    static int strikes = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar mTopToolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(mTopToolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_actions, menu);
        return  true;
    }

    public boolean onOptionsItemSelected(MenuItem clickedItem) {
        switch(clickedItem.getItemId()) {
            case R.id.menu_reset:
                // Update internal counters
                balls = 0;
                strikes = 0;

                // Update show counters
                final TextView ballCount = (TextView) findViewById(R.id.textView3);
                ballCount.setText(Integer.toString(0));
                final TextView strikeCount = (TextView) findViewById(R.id.textView2);
                strikeCount.setText(Integer.toString(0));
                return true;
            case R.id.menu_about:
                Intent intent = new Intent(this, AboutActivity.class);
                startActivity(intent);
            default:
                return super.onOptionsItemSelected(clickedItem);
        }
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

    public void onReset(View view) {
//      Update internal counters
        balls = 0;
        strikes = 0;

//      Update show counters
        final TextView ballCount = (TextView) findViewById(R.id.textView3);
        ballCount.setText(Integer.toString(0));
        final TextView strikeCount = (TextView) findViewById(R.id.textView2);
        strikeCount.setText(Integer.toString(0));
    }
}
