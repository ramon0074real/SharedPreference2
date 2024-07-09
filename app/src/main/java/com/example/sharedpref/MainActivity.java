package com.example.sharedpref;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText ed1=findViewById(R.id.ed1);
        EditText ed2=findViewById(R.id.ed2);
        TextView tv=findViewById(R.id.tv);
        Button save= findViewById(R.id.btn1);
        Button retrieve =findViewById(R.id.btn2);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                SharedPreferences sp=getSharedPreferences("Stdinfo",MODE_PRIVATE);
                SharedPreferences.Editor editor= sp.edit();
                editor.putString("username",ed1.getText().toString());
                editor.putString("email",ed2.getText().toString());
                editor.commit();
                tv.setText("Values stored Successfully");
                Toast.makeText(MainActivity.this,
                        "Success",Toast.LENGTH_SHORT).show();
            }
        });

        retrieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sp=getSharedPreferences("Stdinfo",MODE_PRIVATE);
                String username =sp.getString("username","");
                String email=sp.getString("email","");
                ed1.setText(username);
                ed2.setText(email);

                tv.setText("Username: "+username+"\n"+"Email"+email);
            }
        });


    }
}