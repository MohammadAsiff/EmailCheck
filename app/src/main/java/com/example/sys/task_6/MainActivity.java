package com.example.sys.task_6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    public EditText e1,e2;
    public final Pattern EMAIL_ADDRESS_PATTERN = Pattern.compile(
            "[a-zA-Z0-9+._%-+]{1,256}" +
                    "@" +
                    "[a-zA-Z0-9][a-zA-Z0-9-]{0,64}" +
                    "." +
                    "[a-zA-Z0-9][a-zA-Z0-9-]{0,25}"

    );
    public Button b1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.b);
        e1=(EditText)findViewById(R.id.e);
        e2=(EditText)findViewById(R.id.p);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=e1.getText().toString();
                if (checkEmail(email)) {
                    Toast.makeText(MainActivity.this, "valid email address", Toast.LENGTH_SHORT).show();
                    if (e2.getText().toString().length() == 0) {
                        Toast.makeText(MainActivity.this, "enter password", Toast.LENGTH_SHORT).show();
                        e2.setError("password is not entered");
                        e2.requestFocus();
                    }
                }
                else
                    Toast.makeText(MainActivity.this,"inavalid email",Toast.LENGTH_SHORT).show();



            }


            private boolean checkEmail(String email) {
                return EMAIL_ADDRESS_PATTERN.matcher(email).matches();
            }

        });

    }
}
