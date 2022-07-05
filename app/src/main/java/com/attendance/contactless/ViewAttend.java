package com.attendance.contactless;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ViewAttend extends AppCompatActivity {

    // variables
    private ArrayList<Modal> modalArrayList;
    private DBHandler dbHandler;
    private StudentRVAdapter studentRVAdapter;
    private RecyclerView studentRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_attendance);

        // variables
        modalArrayList = new ArrayList<>();
        dbHandler = new DBHandler(ViewAttend.this);

        // reads attendance data
        modalArrayList = dbHandler.readAttend();

        // passes arraylist to adapter
        studentRVAdapter = new StudentRVAdapter(modalArrayList, ViewAttend.this);
        studentRV = findViewById(R.id.idRVAttend);

        // sets layout manager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewAttend.this, RecyclerView.VERTICAL, false);
        studentRV.setLayoutManager(linearLayoutManager);

        // sets adapter to recycler view
        studentRV.setAdapter(studentRVAdapter);
    }
}
