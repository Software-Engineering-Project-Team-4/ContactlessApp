package com.attendance.contactless;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText firstNameEdt, lastNameEdt,studentIDEdt;
    private Button submitBtn,checkBtn,updateBtn;
    private DBHandler dbHandler;
    public static String studentIDIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // initializing variables.
        firstNameEdt = findViewById(R.id.FirstName);
        lastNameEdt = findViewById(R.id.LastName);
        studentIDEdt = findViewById(R.id.StudentID);
        submitBtn = findViewById(R.id.Submit);
        updateBtn = findViewById(R.id.update);
        checkBtn = findViewById(R.id.CheckAttendance);
        dbHandler = new DBHandler(MainActivity.this);

        //controls spinner
        Spinner mySpinner = (Spinner) findViewById(R.id.TeacherList);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Teacher, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(adapter);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // stores data inputted in app
                String firstName = firstNameEdt.getText().toString();
                String lastName = lastNameEdt.getText().toString();
                String studentID = studentIDEdt.getText().toString();
                studentIDIn = studentID;
                String professor = mySpinner.getSelectedItem().toString();
                // checks if data was inputted
                if (firstName.isEmpty() && lastName.isEmpty() && studentID.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                //adds data to database
                dbHandler.addNewStudent(firstName, lastName, professor,studentID);


                // displays confirmation that the data was added and resets text fields
                Toast.makeText(MainActivity.this, "Student has been added.", Toast.LENGTH_SHORT).show();
                firstNameEdt.setText("");
                lastNameEdt.setText("");
                studentIDEdt.setText("");

            }
        });
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // stores data inputted in app
                String firstName = firstNameEdt.getText().toString();
                String lastName = lastNameEdt.getText().toString();
                String studentID = studentIDEdt.getText().toString();
                studentIDIn = studentID;
                String professor = mySpinner.getSelectedItem().toString();
                // checks if data was inputted
                if (firstName.isEmpty() && lastName.isEmpty() && studentID.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                //updates attendance in database
                dbHandler.updateStudent();


                // displays confirmation that the data was added and resets text fields
                Toast.makeText(MainActivity.this, "Attendance has been updated.", Toast.LENGTH_SHORT).show();
                firstNameEdt.setText("");
                lastNameEdt.setText("");
                studentIDEdt.setText("");

            }
        });
        checkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // stores data inputted in app
                String firstName = firstNameEdt.getText().toString();
                String lastName = lastNameEdt.getText().toString();
                String studentID = studentIDEdt.getText().toString();
                if(!studentID.isEmpty())studentIDIn = studentID;
                String professor = mySpinner.getSelectedItem().toString();
                // checks if data was inputted
                if (studentIDIn.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }
                //displays data
                Intent i = new Intent(MainActivity.this, ViewAttend.class);
                startActivity(i);
            }
        });
    }
}