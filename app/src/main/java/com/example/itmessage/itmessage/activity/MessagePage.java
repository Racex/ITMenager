package com.example.itmessage.itmessage.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.itmessage.itmessage.R;
import com.example.itmessage.itmessage.data.User;

public class MessagePage extends Activity {

    private static String login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_page);
        String login = getIntent().getExtras().getString("Login");
        initWelcomeMessage(login);
        initSendButton();
    }


    private void initSendButton() {
        Button sendButton = findViewById(R.id.message_page_send_button);
        final EditText messageAreaToSend = findViewById(R.id.message_page_message_area_to_send_text_view);
        final TextView messageArea = findViewById(R.id.message_page_message_area_text_view);
        sendButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(!messageAreaToSend.getText().toString().equals("")) {
                  messageArea.append(login+" : "+messageAreaToSend.getText()+System.getProperty("line.separator"));
                }
                else
                    Toast.makeText(getApplicationContext(), "Nie poprawny login :(", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initWelcomeMessage(String login) {
        final TextView welcomeTextView = findViewById(R.id.message_page_welcome_text_view);
        welcomeTextView.setText("Witaj "+login+" :) Miłego pisania ziom");
        this.login = login;
    }
}
