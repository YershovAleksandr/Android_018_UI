package com.nam.mymodernui;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private String LOGTAG = "X42";

    private SeekBar mSeekBar;

    private TextView mTextView00;
    private TextView mTextView01;
    private TextView mTextView10;
    private TextView mTextView11;
    private TextView mTextView12;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSeekBar = findViewById(R.id.seekBar);
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                ChangeColors(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {
               // Log.i(LOGTAG, "On Start");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {
                //Log.i(LOGTAG, "On Stop");
            }
        });

        mTextView00 = findViewById(R.id.textView00);
        mTextView01 = findViewById(R.id.textView01);
        mTextView10 = findViewById(R.id.textView10);
        mTextView11 = findViewById(R.id.textView11);
        mTextView12 = findViewById(R.id.textView12);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.more_info:
                GoInfo();
                return true;
            default:
                return super.onOptionsItemSelected(item);   //wtf???
        }
    }

    private void GoInfo()
    {
        Log.i(LOGTAG, "Go to Info");
    }

    private void ChangeColors(int progress)
    {
        Random r = new Random();

        mTextView00.setBackgroundColor(Color.argb(255, r.nextInt(256), r.nextInt(256), r.nextInt(256)));
        mTextView01.setBackgroundColor(Color.argb(255, r.nextInt(256), r.nextInt(256), r.nextInt(256)));
        mTextView10.setBackgroundColor(Color.argb(255, r.nextInt(256), r.nextInt(256), r.nextInt(256)));
        mTextView11.setBackgroundColor(Color.argb(255, r.nextInt(256), r.nextInt(256), r.nextInt(256)));
        mTextView12.setBackgroundColor(Color.argb(255, r.nextInt(256), r.nextInt(256), r.nextInt(256)));

    }

}
