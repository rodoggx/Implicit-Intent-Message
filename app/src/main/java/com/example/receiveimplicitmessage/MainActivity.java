package com.example.receiveimplicitmessage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static android.R.attr.action;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view) {
        EditText sEditText = (EditText) findViewById(R.id.subjectEditText);
        EditText mEditText = (EditText) findViewById(R.id.messageEditText);
        String subText = sEditText.getText().toString();
        String msgText = mEditText.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, subText);
        intent.putExtra(Intent.EXTRA_TEXT, msgText);

        String chooserTitle = getString(R.string.chooser);
        Intent choserIntent = Intent.createChooser(intent, chooserTitle);
        startActivity(choserIntent);
    }
}
