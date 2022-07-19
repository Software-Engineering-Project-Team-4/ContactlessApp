package com.attendance.contactless;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

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
                String URL = "http://192.168.4.2/myproject/checkconnection.php";
                RequestQueue queue;

                queue = Volley.newRequestQueue(UsageActivity.this);

                StringRequest stringrequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(getApplicationContext(), "Response from server"+response,Toast.LENGTH_LONG).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "Error:"+error.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });
                queue.add(stringrequest);
            }

        });
        isTeacherButtonBtn = findViewById(R.id.isTeacherButton);

        isTeacherButtonBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UsageActivity.this, TeacherActivity.class));
                String URL = "http://192.168.4.2/myproject/checkconnection.php";
                RequestQueue queue;

                queue = Volley.newRequestQueue(UsageActivity.this);

                StringRequest stringrequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(getApplicationContext(), "Response from server"+response,Toast.LENGTH_LONG).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "Error:"+error.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });
                queue.add(stringrequest);
            }
        });
    }

}


