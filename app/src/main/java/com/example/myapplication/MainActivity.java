package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private MagiskIconChecker mic;

    public void init() {
        textView = findViewById(R.id.text1);
        mic = new MagiskIconChecker(this);
    }

    public void addText(String msg) {
        textView.setText(textView.getText() + "\n" +  msg );
        final int scrollAmount = textView.getLayout().getLineTop(textView.getLineCount()) - textView.getHeight();
        textView.scrollTo(0,scrollAmount);
    }

    public void runCheck() {
        new Thread(new Runnable() {
            public void run() {
                mic.checkIcons();
            }
        }).start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        runCheck();
    }

}
