package com.attendance.contactless;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class TeacherActivity extends AppCompatActivity {
    private EditText firstNameEdt, lastNameEdt,professorIDEdt;
    private TextView pinEdt;
    private Button submitBtn,checkBtn;
    private DBHandler dbHandler;
    public static String lastnameIn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);
        // initializing variables.
        firstNameEdt = findViewById(R.id.firstName);
        lastNameEdt = findViewById(R.id.lastName);
        professorIDEdt = findViewById(R.id.professorID);
        pinEdt = findViewById(R.id.textView4);
        submitBtn = findViewById(R.id.submit);
        checkBtn = findViewById(R.id.checkAttend);
        dbHandler = new DBHandler(TeacherActivity.this);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // stores data inputted in app
                String firstName = firstNameEdt.getText().toString();
                String lastName = lastNameEdt.getText().toString();
                String professorID = professorIDEdt.getText().toString();
                lastnameIn = lastName;
                // checks if data was inputted
                if (firstName.isEmpty() && lastName.isEmpty() && professorID.isEmpty()) {
                    Toast.makeText(TeacherActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                //adds data to database
                Random rand = new Random();
                String pin = String.format("%04d", rand.nextInt(10000));
                if(dbHandler.getpin(lastName) == "not found")
                dbHandler.addNewProfessor(firstName, lastName, professorID,pin);
                else dbHandler.updateProfessor(pin);


                // displays confirmation that the data was added and resets text fields
                Toast.makeText(TeacherActivity.this, "Teacher has been added.", Toast.LENGTH_SHORT).show();
                firstNameEdt.setText("");
                lastNameEdt.setText("");
                professorIDEdt.setText("");
                pinEdt.setText("Pin: "+dbHandler.getpin(lastName));

            }
        });

        checkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // stores data inputted in app
                String firstName = firstNameEdt.getText().toString();
                String lastName = lastNameEdt.getText().toString();
                String professorID = professorIDEdt.getText().toString();
                if(!lastName.isEmpty())lastnameIn = lastName;
                // checks if data was inputted
                if (lastnameIn.isEmpty()) {
                    Toast.makeText(TeacherActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }
                //displays data
                Intent i = new Intent(TeacherActivity.this, ViewProfAttend.class);
                startActivity(i);
            }
        });
    }
}