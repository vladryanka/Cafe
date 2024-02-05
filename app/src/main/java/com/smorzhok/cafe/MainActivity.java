package com.smorzhok.cafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextPassword;
    private Button signIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editTextName.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();
               if (!name.equals("") && !password.equals("")) {
                    launchNextScreen(name);
                }
                else {
                    Toast.makeText(MainActivity.this, R.string.field_is_empty, Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    private  void launchNextScreen(String name){
        Intent intent = MakeOrderActivity.newIntent(this, name);
        startActivity(intent);
    }
    private void initViews(){
        editTextName = findViewById(R.id.editTextName);
        editTextPassword = findViewById(R.id.editTextPassword);
        signIn = (Button) findViewById(R.id.buttonSignIn);
    }

}