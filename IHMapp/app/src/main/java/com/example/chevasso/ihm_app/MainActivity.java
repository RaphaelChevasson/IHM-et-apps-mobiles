package com.example.chevasso.ihm_app;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public final static int CODE_USERNAME = 123;

    private TextView textViewName;
    private Button buttonNext;
    final MainActivity mainActivity = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        textViewName = findViewById(R.id.activity_main_textView_name);

        buttonNext = findViewById(R.id.activity_main_button_next);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mainActivity, FormActivity.class);
                startActivityForResult(intent, CODE_USERNAME);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == CODE_USERNAME) {
            if (resultCode == RESULT_OK && data.getExtras() != null) {
                displayForm(data);
            }
            else {
                // handle errors
            }
        }
    }

    private void displayForm(Intent data) {
        String name = data.getStringExtra(FormActivity.KEY_USERNAME);
        textViewName.setText(name);
    }
}
