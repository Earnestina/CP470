package com.example.androidassignments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.util.Log;

public class StartActivity extends AppCompatActivity {
    protected static final String ACTIVITY_NAME="StartActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }

    public void OnClick(View view) {
        Log.i(ACTIVITY_NAME,"User clicked Start Chat");
    }
}