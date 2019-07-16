package com.example.itmessage.itmessage.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.itmessage.itmessage.R;
import com.example.itmessage.itmessage.data.User;

public class LoginPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        initStartButton();
    }

    private void initStartButton() {
        Button loginButton = findViewById(R.id.login_page_start_button);
        final EditText loginEditText = findViewById(R.id.login_page_login_edit_text);
        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(!loginEditText.getText().toString().equals("")) {
                    User user = new User();
                    user.setLogin(loginEditText.getText().toString());
                    Intent messagePageIntent = new Intent(getBaseContext(), MessagePage.class);
                    messagePageIntent.putExtra("Login", user.getLogin());
                    startActivity(messagePageIntent);
                }
                else
                Toast.makeText(getApplicationContext(), "Nie poprawny login :(", Toast.LENGTH_SHORT).show();
            }
        });
    }
        }
