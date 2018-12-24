package com.example.chevasso.ihm_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

public class FormActivity extends AppCompatActivity {

    public final static String KEY_USERNAME = "key_username";

    Button buttonBack;
    TextView editTextName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        editTextName = findViewById(R.id.activity_form_plainText_enterName);
        buttonBack = findViewById(R.id.activity_form_button_back);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveForm();
            }
        });
    }

    private void saveForm() {
        String name = editTextName.getText().toString();

        if (name.isEmpty()) {
            DataManager.getInstance().addName(name);
        }
        finish();
    }



}
