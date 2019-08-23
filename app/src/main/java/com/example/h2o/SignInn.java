package com.example.h2o;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignInn extends AppCompatActivity {


    private EditText Name, Password;
    private TextView Forward ,Survey;
    private Button button ;
    private int count = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_inn);

        Name = (EditText)findViewById(R.id.user);
        Password = (EditText)findViewById(R.id.pass);
        button = (Button)findViewById(R.id.log);
        Forward = (TextView)findViewById(R.id.alr);
        Survey = (TextView)findViewById(R.id.surv);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Name.getText().toString(), Password.getText().toString());
            }
        });

        Forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(SignInn.this,Signup.class);
                startActivity(intent);

            }
        });

        Survey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(SignInn.this,survey.class);
                startActivity(intent);

            }
        });





    }
    private void validate(String uname , String password)
    {
            if((uname.equals("admin"))&&(password.equals("123")))
            {
                Intent intent = new Intent(SignInn.this,home.class);
                startActivity(intent);
            }
            else
            {
                count--;
                if(count == 0)
                {
                    button.setEnabled(false);
                }
            }
    }



}
