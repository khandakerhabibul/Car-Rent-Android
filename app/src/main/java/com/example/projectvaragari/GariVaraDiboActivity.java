package com.example.projectvaragari;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class GariVaraDiboActivity extends AppCompatActivity implements View.OnClickListener {

    EditText driverName, gariModel , seatNumber , driverPhnNumber, gariVara;
    Button gariAddButton;

    DatabaseReference databaseCar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gari_vara_dibo);

        databaseCar = FirebaseDatabase.getInstance().getReference("carInfo");

        driverName = findViewById(R.id.driverName);
        gariModel = findViewById(R.id.gariModel);
        seatNumber = findViewById(R.id.seatNumber);
        driverPhnNumber = findViewById(R.id.driverPhnNumber);
        gariVara = findViewById(R.id.minimumGariVara);
        findViewById(R.id.gariAddButton).setOnClickListener(this);
        findViewById(R.id.addKoraGariDekhbo).setOnClickListener(this);

        /*gariAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //addCar();
            }
        });*/
    }

    public void addCar(){
        String drvName = driverName.getText().toString().trim();
        String carModel = gariModel.getText().toString().trim();
        String stNumber = seatNumber.getText().toString().trim();
        String drvPhnNumber = driverPhnNumber.getText().toString().trim();
        String garivara = gariVara.getText().toString().trim();

        if(!TextUtils.isEmpty(drvName)){
            String id = databaseCar.push().getKey();

            CarInfo carInfo = new CarInfo(id, drvName, carModel, stNumber , drvPhnNumber , garivara);

            databaseCar.child(id).setValue(carInfo);

            Toast.makeText(this,"Car Info Added",Toast.LENGTH_LONG).show();


        }
        else {
            Toast.makeText(this,"Give driver name", Toast.LENGTH_SHORT).show();
        }
        /*if(!TextUtils.isEmpty(carModel)){

        }
        else {
            Toast.makeText(this,"Give car model", Toast.LENGTH_SHORT).show();
        }
        if(!TextUtils.isEmpty(stNumber)){

        }
        else {
            Toast.makeText(this,"seat number din", Toast.LENGTH_SHORT).show();
        }
        if(!TextUtils.isEmpty(drvPhnNumber)){

        }
        else {
            Toast.makeText(this,"Give driver contact number", Toast.LENGTH_SHORT).show();
        }*/

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.gariAddButton:
                addCar();
                break;

            case R.id.addKoraGariDekhbo:
                startActivity(new Intent(this,GariVaraNiboActivity.class));
                break;
        }

    }
}
