package com.nam.mymodernui;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private String LOGTAG = "X42";

    private SeekBar mSeekBar;

    private TextView mTextView00;
    private TextView mTextView01;
    private TextView mTextView10;
    private TextView mTextView11;
    private TextView mTextView12;

    private int c00;
    private int c01;
    private int c10;
    private int c11;
    private int c12;


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

        c00 = ((ColorDrawable)mTextView00.getBackground()).getColor();
        c01 = ((ColorDrawable)mTextView01.getBackground()).getColor();
        c10 = ((ColorDrawable)mTextView10.getBackground()).getColor();
        c11 = ((ColorDrawable)mTextView11.getBackground()).getColor();
        c12 = ((ColorDrawable)mTextView12.getBackground()).getColor();

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
        //c00 = HackColor(progress, c00);
      //  mTextView00.setBackgroundColor(c00);
        //c01 = HackColor(progress, c01);
       // mTextView01.setBackgroundColor(c01);
       // mTextView10.setBackgroundColor(HackColor(progress, c10));
        //mTextView11.setBackgroundColor(HackColor(progress, c11));
        mTextView12.setBackgroundColor((int)HackColor(progress, c12));
    }

    private long HackColor(int progress, int color)
    {

        //Log.i(LOGTAG, "Progress " + progress);

        int red = (color >> 16) & 0xFF;
        int green = (color >> 8) & 0xFF;
        int blue = (color >> 0) & 0xFF;

        Log.i(LOGTAG, "R " + red + " G " + green + " B " + blue);

        red = (red + (0xFF - red) * progress / 100) & 0xFF;
        green = (green + (0xFF - green) * progress / 100) & 0xFF;
        blue = (blue + (0xFF - blue) * progress / 100) & 0xFF;

        Log.i(LOGTAG, "R " + red + " G " + green + " B " + blue);

        long ret = 0;
        ret = 0xFF000000;
        ret = ret + red * 0xFFFF;
        ret = ret + green * 0xFF;
        ret = ret + blue;





        ret = 0xFFFFFFFF;

        Log.i(LOGTAG, "Color rr " + ret);
        return ret;
        //return Color.argb(255.f,(float)red * p, (float)green * p, (float)blue * p);
    }

}
