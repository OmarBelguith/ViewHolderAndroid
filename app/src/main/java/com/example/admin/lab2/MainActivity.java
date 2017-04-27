package com.example.admin.lab2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    String[] students={"soumaya","fatma","omar","chaima","lilia"};
    HashMap<String,String[]> allGrades;
    ListView gradesList;
    AutoCompleteTextView tvAuto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gradesList=(ListView) findViewById(R.id.gradesList);
        tvAuto= (AutoCompleteTextView) findViewById(R.id.students);
        allGrades=new HashMap<>();
        allGrades.put("chaima",new String[]{"0","1","2","3"});
        allGrades.put("soumaya",new String[]{"4","5","6","7"});
        allGrades.put("omar",new String[]{"8","9","10","11"});
        allGrades.put("fatma",new String[]{"12","13","14","15"});
        allGrades.put("lilia",new String[]{"16","17","18","19","20"});
        ArrayAdapter<String> adapter2=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,students);
        tvAuto.setAdapter(adapter2);
        gradesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView gradeView = (TextView) view.findViewById(R.id.grade);
                float grade = Float.valueOf(gradeView.getText().toString());
                if(grade>=10) toast("pass");
                else toast("fail");
            }
        });
        tvAuto.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String studentName=((TextView)view).getText().toString();
                ListAdapter customAdapter = new CustomAdapter(MainActivity.this,allGrades.get(studentName));
                gradesList.setAdapter(customAdapter);
            }
        });
    }
    public void toast(String s){
        Toast.makeText(this,s,Toast.LENGTH_SHORT).show();
    }
}
