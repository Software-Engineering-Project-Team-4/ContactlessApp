package com.attendance.contactless;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //mydb = new DBHelper(this);
        //ArrayList array_list = mydb.getAllContacts();
        //ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1, array_list);

        Spinner mySpinner = (Spinner) findViewById(R.id.TeacherList);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Teacher, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(adapter);
    }
    /* Connecting the UI to Database

    obj = (ListView)findViewById(R.id.TeacherList);
    obj.setAdapter(arrayAdapter);
    obj.setOnItemClickListener(new OnItemClickListener(){
        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3) {
                // TODO Auto-generated method stub
                int id_To_Search = arg2 + 1;
                Bundle Spinner = new Spinner();
                Spinner.putInt("id", id_To_Search);
                Intent intent = new Intent(getApplicationContext(),DisplayContact.class);
                intent.putExtras(Spinner);
                startActivity(intent);
             }
       }
     */
}