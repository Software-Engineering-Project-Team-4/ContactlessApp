package com.attendance.contactless;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class UsageActivity extends AppCompatActivity {
    private Button isStudentButtonBtn;
    private Button isTeacherButtonBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usage);
        isStudentButtonBtn = findViewById(R.id.isStudentButton);

        isStudentButtonBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UsageActivity.this, MainActivity.class));
            }

        });
        isTeacherButtonBtn = findViewById(R.id.isTeacherButton);

        isTeacherButtonBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UsageActivity.this, TeacherActivity.class));
            }
        });
    }

}


