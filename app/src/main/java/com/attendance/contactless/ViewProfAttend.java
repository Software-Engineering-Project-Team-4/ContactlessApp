package com.attendance.contactless;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ViewProfAttend extends AppCompatActivity {

    // variables
    private ArrayList<Modal> modalArrayList;
    private DBHandler dbHandler;
    private ProfessorRVAdapter professorRVAdapter;
    private RecyclerView professorRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_profattend);

        // variables
        modalArrayList = new ArrayList<>();
        dbHandler = new DBHandler(ViewProfAttend.this);

        // reads attendance data
        modalArrayList = dbHandler.readAttendProf();

        // passes arraylist to adapter
        professorRVAdapter = new ProfessorRVAdapter(modalArrayList, ViewProfAttend.this);
        professorRV = findViewById(R.id.idRVAttendance);

        // sets layout manager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewProfAttend.this, RecyclerView.VERTICAL, false);
        professorRV.setLayoutManager(linearLayoutManager);

        // sets adapter to recycler view
        professorRV.setAdapter(professorRVAdapter);
    }
}
