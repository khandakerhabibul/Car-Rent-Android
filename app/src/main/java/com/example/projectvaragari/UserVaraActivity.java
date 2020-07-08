package com.example.projectvaragari;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.net.URI;
import java.util.HashMap;

public class UserVaraActivity extends AppCompatActivity {

    TextView drivName, gariModel , seatNumber , phnNumber, gariVara;

    DatabaseReference databaseReference;

    Button btnAdd;
    Button btnCall;
    Button btnUserProfile;

    private static final int REQUEST_CALL = 1;

    UserInfo userInfo;

    String id;

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CALL){
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                makePhoneCall();
            }
            else{
                Toast.makeText(this, "Permission Denied",Toast.LENGTH_SHORT).show();
            }
        }
    }

    /*@Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode==REQUEST_CALL){
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){

            }
        }
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_vara);

        drivName = findViewById(R.id.driverName_Vara);
        gariModel = findViewById(R.id.gariModel_Vara);
        seatNumber = findViewById(R.id.seatNumber_Vara);
        phnNumber = findViewById(R.id.driverPhnNumber_Vara);
        gariVara = findViewById(R.id.minimumGariVara_Vara);

        btnAdd = findViewById(R.id.userAddKorbe);
        btnCall = findViewById(R.id.userCallDibe);
        btnUserProfile = findViewById(R.id.userProfile);

        drivName.setText(getIntent().getStringExtra("drivername"));
        gariModel.setText(getIntent().getStringExtra("carmodel"));
        seatNumber.setText(getIntent().getStringExtra("stnumber"));
        phnNumber.setText(getIntent().getStringExtra("drvphnnumber"));
        gariVara.setText(getIntent().getStringExtra("garivara"));

        id = getIntent().getExtras().get("carId").toString();


        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("carInfo").child(id);

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*String callNumber = phnNumber.getText().toString().trim();

                //Intent call = new Intent(Intent.ACTION_CALL);
                //call.setData(Uri.parse(callNumber));

                if (ContextCompat.checkSelfPermission(UserVaraActivity.this,Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED ){
                    ActivityCompat.requestPermissions(UserVaraActivity.this, new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL);
                    //return;
                }else {
                    String dial ="tel: "+callNumber;
                    startActivity(new Intent(Intent.ACTION_CALL,Uri.parse(dial)));
                }*/
                makePhoneCall();

                //startActivity(call);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*databaseReference =FirebaseDatabase.getInstance().getReference().child("UserInfo");
                userInfo = new UserInfo();

                userInfo.setDrivername(drivName.getText().toString().trim());
                userInfo.setCarmodel(gariModel.getText().toString().trim());
                userInfo.setStnumber(seatNumber.getText().toString().trim());
                userInfo.setDrvphnnumber(phnNumber.getText().toString().trim());
                userInfo.setGarivara(gariVara.getText().toString().trim());

                databaseReference.push().setValue(userInfo);*/

                DatabaseReference reference = FirebaseDatabase.getInstance().getReference();

                String arr[] = Current_User.email.split("@",2);
                String userID =  arr[0];
                HashMap<String,Object> users = new HashMap<>();
                users.put("userID",userID);
                users.put("email",Current_User.email);
                users.put("driverName",drivName.getText().toString());
                users.put("carmodel",gariModel.getText().toString());
                users.put("seat",seatNumber.getText().toString());
                users.put("DriverPhnNumber",phnNumber.getText().toString());
                users.put("gariVara",gariVara.getText().toString());
                reference.child("UserProfile").child(userID).updateChildren(users);

                Toast.makeText(UserVaraActivity.this, "User Data Saved", Toast.LENGTH_SHORT).show();
            }
        });

        btnUserProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(UserVaraActivity.this,Single_User_Profile_Activity.class);
                startActivity(intent);
            }
        });


    }

    public void makePhoneCall(){
        String callNumber = phnNumber.getText().toString().trim();

        //Intent call = new Intent(Intent.ACTION_CALL);
        //call.setData(Uri.parse(callNumber));

        if (ContextCompat.checkSelfPermission(UserVaraActivity.this,Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED ){
            ActivityCompat.requestPermissions(UserVaraActivity.this, new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL);
            //return;
        }else {
            String dial ="tel: "+callNumber;
            startActivity(new Intent(Intent.ACTION_CALL,Uri.parse(dial)));
        }
    }
}
