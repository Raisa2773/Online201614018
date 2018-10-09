package com.example.wasee.onlinerepeat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class Save extends AppCompatActivity {

    EditText name,address;
    Button btn,btn1;
    DatePicker dob;
    RadioGroup grp;
    RadioButton btnradio;
    CheckBox cb1,cb2;
    String type,batch;
    Spinner spinner2;

    FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);

        name=findViewById(R.id.et1);
        address=findViewById(R.id.et2);
        btn=findViewById(R.id.btn);
        btn1=findViewById(R.id.btn1);
        grp=findViewById(R.id.grp);
        dob=findViewById(R.id.dob);
        cb1=findViewById(R.id.cb1);
        cb2=findViewById(R.id.cb2);
        spinner2=findViewById(R.id.spinner2);

        firebaseAuth=FirebaseAuth.getInstance();
        databaseReference=FirebaseDatabase.getInstance().getReference();
        addItemsOnSpinner2();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                savemyinfo();
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent k = new Intent(getApplicationContext(),retrievesingle.class);
                startActivity(k);
            }
        });
    }
    void addItemsOnSpinner2(){
        List<String> list;
        list = new ArrayList<String>();
        list.add("batch 1");
        list.add("batch 2");
        list.add("batch 3");
        list.add("batch 4");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(dataAdapter);
    }
    void savemyinfo(){

        String Name = name.getText().toString().trim();
        String Address=address.getText().toString().trim();
        int year=dob.getYear();
        int month=dob.getMonth()+1;
        int day=dob.getDayOfMonth();

        // Date date=new Date(year,month,day);
        //  SimpleDateFormat simple=new SimpleDateFormat("dd-mm-yyyy");

        // final String ndate=simple.format(date);
        final String mdate=new StringBuilder().append(year).append("-")
                .append(month).append("-")
                .append(day).append("").toString();

        int id=grp.getCheckedRadioButtonId();
        btn=findViewById(id);
        String gender=btn.getText().toString();

        FirebaseUser user = firebaseAuth.getCurrentUser();
        String userId = user.getUid();

        if (cb1.isChecked()){
            type = "Teacher";
        }
        if (cb2.isChecked()){
             type = "Student";
        }


        if(String.valueOf(spinner2.getSelectedItem())=="batch 1"){
            batch = "batch 1";
        }

         if(String.valueOf(spinner2.getSelectedItem())=="batch 2"){
             batch = "batch 2";
        }

        if(String.valueOf(spinner2.getSelectedItem())=="batch 3"){
            batch = "batch 3";
        }

          if(String.valueOf(spinner2.getSelectedItem())=="batch 4"){
              batch = "batch 4";
          }


        User ui = new User(Name,Address,gender,mdate,type,batch);
        databaseReference.child(userId).setValue(ui);

        Toast.makeText(getApplicationContext(),"Saved.",Toast.LENGTH_LONG).show();

    }
}
