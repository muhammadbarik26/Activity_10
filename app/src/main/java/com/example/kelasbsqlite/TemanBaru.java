package com.example.kelasbsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.kelasbsqlite.database.DBcontroller;
import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;

public class TemanBaru extends AppCompatActivity {

    private TextInputEditText tNama, tTelpon;
    private Button simpanBtn;
    String nma,tlp;
    DBcontroller controller = new DBcontroller(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teman_baru);

        tNama = (TextInputEditText) findViewById(R.id.tietNama);
        tTelpon = (TextInputEditText) findViewById(R.id.tietTelpon);
        simpanBtn = (Button) findViewById(R.id.buttonSave);

        simpanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tNama.getText().toString().isEmpty() || tTelpon.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(), "Data Belum komplit !", Toast.LENGTH_SHORT).show();

                }
                else{
                    nma = tNama.getText().toString();
                    tlp = tTelpon.getText().toString();

                    HashMap<String,String> qvalues = new HashMap<>();
                    qvalues.put("nama", nma);
                    qvalues.put("telpon", tlp);

                    controller.insertData(qvalues);
                    callHome();
                }
            }
        });
    }

    public  void  callHome(){
        Intent intent = new Intent(getApplicationContext(), com.example.kelasbsqlite.MainActivity.class);
        startActivity(intent);
        finish();
    }
}