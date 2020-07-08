package com.example.projectvaragari;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class GariVaraNiboActivity extends AppCompatActivity {

    ListView listView;

    List<CarInfo> carInfoList;

    CustomAdapterGarirJonno customAdapterGarirJonno;

    DatabaseReference databaseReference;

    FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gari_vara_nibo);

        databaseReference = FirebaseDatabase.getInstance().getReference("carInfo");

        firebaseDatabase = FirebaseDatabase.getInstance();

        carInfoList = new ArrayList<>();

        customAdapterGarirJonno = new CustomAdapterGarirJonno(GariVaraNiboActivity.this, carInfoList);


        listView = findViewById(R.id.listViewId);

    }

    @Override
    protected void onStart() {

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                carInfoList.clear();

                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                    CarInfo carInfo = dataSnapshot1.getValue(CarInfo.class);
                    carInfo.setCarId(dataSnapshot1.getKey());
                    carInfoList.add(carInfo);
                }

                listView.setAdapter(customAdapterGarirJonno);

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                        Intent intent = new Intent(GariVaraNiboActivity.this,GariUpdateDelete.class);

                        //CarInfo carDetail = carInfoList.get(position);
                        //String key = carDetail.getCarId();
                        CarInfo carDetail = (CarInfo) adapterView.getItemAtPosition(position);

                        String key = carDetail.getCarId();

                        intent.putExtra("drivername",carDetail.getDrivername());
                        intent.putExtra("carmodel",carDetail.getCarmodel());
                        intent.putExtra("stnumber",carDetail.getStnumber());
                        intent.putExtra("drvphnnumber",carDetail.getDrvphnnumber());
                        intent.putExtra("garivara",carDetail.getGarivara());
                        intent.putExtra("carId",carDetail.getCarId());
                        //Toast.makeText(GariVaraNiboActivity.this,key,Toast.LENGTH_SHORT).show();

                        if(MainActivity._email.equals("admin@gmail.com")&&MainActivity._password.equals("admin12345")){

                            startActivity(intent);
                        }
                        else {
                            Intent m = new Intent(GariVaraNiboActivity.this,UserVaraActivity.class);
                            CarInfo detailCar = (CarInfo) adapterView.getItemAtPosition(position);

                            String key1 = carDetail.getCarId();

                            m.putExtra("drivername",detailCar.getDrivername());
                            m.putExtra("carmodel",detailCar.getCarmodel());
                            m.putExtra("stnumber",detailCar.getStnumber());
                            m.putExtra("drvphnnumber",detailCar.getDrvphnnumber());
                            m.putExtra("garivara",detailCar.getGarivara());
                            m.putExtra("carId",detailCar.getCarId());
                            startActivity(m);
                        }
                    }
                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        super.onStart();
    }
}










