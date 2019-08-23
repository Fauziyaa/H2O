package com.example.h2o;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    protected Button help;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        help = (Button)findViewById(R.id.next);
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSignin();

            }
        });
    }

    public void openSignin(){

        Intent intent = new Intent(this,SignInn.class);
        startActivity(intent);
    }
}
