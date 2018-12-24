package com.example.chevasso.ihm_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

/**
 *
 */
public class MainActivity extends AppCompatActivity implements NameItemListener {

    public final static int CODE_USERNAME = 123;

    private Button buttonNext;
    private RecyclerView reciclerViewNames;

    ListNameAdapter listNameAdapter;

    final MainActivity mainActivity = this;

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    @Override
    protected void onResume() {
        super.onResume();

        List<String> nameList = DataManager.getInstance().getNameList();
    }

    private void initViews() {
        buttonNext = findViewById(R.id.activity_main_button_next);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayForm();
            }
        });
    }

    private void displayForm() {
        Intent intent = new Intent(this, FormActivity.class);
        startActivity(intent);

    }

    private void initList() {
        final LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(this);

        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        reciclerViewNames.setAdapter(listNameAdapter);
        reciclerViewNames.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void clickOnItem(String name) {
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
    }
}
