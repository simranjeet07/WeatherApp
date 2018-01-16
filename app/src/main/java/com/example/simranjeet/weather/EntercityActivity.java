package com.example.simranjeet.weather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EntercityActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entercity);
    }

    public void onClick(View view)
    {
        Intent i=new Intent(this,weatherActivity.class);
        final EditText ETcity=(EditText)findViewById(R.id.ETcity);
        String str=ETcity.getText().toString();
        i.putExtra("city",str);
        startActivity(i);
    }
}
