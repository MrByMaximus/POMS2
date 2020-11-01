package com.example.poms2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.graphics.Color.rgb;

public class MainActivity extends AppCompatActivity {
    private EditText Name;
    private EditText Surname;
    private TextView Result;
    private String TextResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Name=(EditText)findViewById(R.id.Input1);
        Surname=(EditText)findViewById(R.id.Input2);
        Result=(TextView)findViewById(R.id.textResult);
        if(savedInstanceState!=null){
            Result.setText(savedInstanceState.getString("Result"));
        }
    }

    public void OnClickRes(View v){
        if (Name.getText().toString().equals("") || Surname.getText().toString().equals("")) {
            Result.setText("Данные не введены");
            Toast.makeText(MainActivity.this,Result.getText(),Toast.LENGTH_SHORT).show();
        }
        else {
            String username = Name.getText().toString();
            String usersurname = Surname.getText().toString();
            TextResult = "Здравствуйте, "+username+" "+usersurname+"!";
            Result.setText(TextResult);
            Toast.makeText(MainActivity.this,Result.getText(),Toast.LENGTH_SHORT).show();
        }
    }

    protected void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("Result",TextResult);
    }
}