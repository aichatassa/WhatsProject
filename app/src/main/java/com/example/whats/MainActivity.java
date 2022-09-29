package com.example.whats;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.net.URLEncoder;

public class MainActivity
        extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText messageEditText = findViewById(R.id.message);

        final EditText numberEditText = findViewById(R.id.editTextNumber);

        Button submit = findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view)
                    {
                        String message
                                = messageEditText
                                .getText()
                                .toString();
                        String number = numberEditText
                                .getText()
                                .toString();


                        sendMessage(message, number);
                    }
                });
    }

    private void sendMessage(String message, String number)
    {
        Intent sendIntent = new Intent(Intent.ACTION_VIEW);
        String url = "https://api.whatsapp.com/send?phone="+ number +"&text=" + message;
        sendIntent.setPackage("com.whatsapp");
        sendIntent.setData(Uri.parse(url));
        startActivity(sendIntent);
    }
}