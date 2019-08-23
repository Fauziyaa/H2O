package com.example.h2o;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;



public class Signup extends AppCompatActivity {


    private EditText First,Last,Email,Password;
    private Button register;
    private TextView tv;
    private FirebaseAuth firebaseAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        First = (EditText) findViewById(R.id.fname);
        Last = (EditText) findViewById(R.id.lname);
        Email = (EditText) findViewById(R.id.email);
        Password = (EditText) findViewById(R.id.psd);
        register = (Button) findViewById(R.id.regis);


        firebaseAuth = FirebaseAuth.getInstance();


       register.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view)
            {
                if(check())
                {
                  String user_email = Email.getText().toString().trim();
                  String user_password= Password.getText().toString().trim();

                  firebaseAuth.createUserWithEmailAndPassword(user_email,user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                      @Override
                      public void onComplete(@NonNull Task<AuthResult> task)
                      {
                           if(task.isSuccessful())
                           {
                               Toast.makeText(Signup.this,"Registration Successful",Toast.LENGTH_SHORT).show();
                               startActivity(new Intent(Signup.this,home.class));

                           }
                           else
                           {
                               Toast.makeText(Signup.this,"Registration Failed",Toast.LENGTH_SHORT).show();
                           }
                      }
                  });


                }
            }
        });

  /**      tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
`
                Intent intent = new Intent(Signup.this,SignInn.class);
                startActivity(intent);

            }
        }); **/

    }

    private boolean check()
    {
        boolean result = false;


        String Fname = First.getText().toString();
        //String Lname = Last.getText().toString();
        String email = Email.getText().toString();
        String pass = Password.getText().toString();


        if((email.isEmpty())&&(pass.isEmpty()))
        {
            Toast.makeText(this,"Please Enter All Details",Toast.LENGTH_SHORT).show();
        }
        else
        {
            result= true;
        }
        return result;
    }


}
