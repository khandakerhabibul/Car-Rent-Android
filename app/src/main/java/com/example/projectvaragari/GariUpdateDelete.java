package com.example.projectvaragari;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class GariUpdateDelete extends AppCompatActivity {

    EditText drivername, garimodel , seatnumber , driverphnnumber , minimumgarivara;

    DatabaseReference databaseReference;

    Button update;
    Button delete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gari_update_delete);

        drivername = findViewById(R.id.driverNameUD);
        garimodel = findViewById(R.id.gariModelUD);
        seatnumber = findViewById(R.id.seatNumberUD);
        driverphnnumber = findViewById(R.id.driverPhnNumberUD);
        minimumgarivara = findViewById(R.id.minimumGariVaraUD);

        update = findViewById(R.id.gariUpdate);
        delete = findViewById(R.id.gariDelete);

        drivername.setText(getIntent().getStringExtra("drivername"));
        garimodel.setText(getIntent().getStringExtra("carmodel"));
        seatnumber.setText(getIntent().getStringExtra("stnumber"));
        driverphnnumber.setText(getIntent().getStringExtra("drvphnnumber"));
        minimumgarivara.setText(getIntent().getStringExtra("garivara"));



        //databaseReference = FirebaseDatabase.getInstance().getReference();

        //final String carId = getIntent().getStringExtra("carId");
        final String carId = getIntent().getExtras().get("carId").toString();
        //Log.d(TAG, "onCreate: debug",carId);
        databaseReference = FirebaseDatabase.getInstance().getReference("carInfo").child(carId);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //databaseReference.child("drivername").setValue(drivername.getText().toString());
                databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String s = drivername.getText().toString();
                        dataSnapshot.getRef().child("drivername").setValue(drivername.getText().toString());
                        dataSnapshot.getRef().child("carmodel").setValue(garimodel.getText().toString());
                        dataSnapshot.getRef().child("stnumber").setValue(seatnumber.getText().toString());
                        dataSnapshot.getRef().child("drvphnnumber").setValue(driverphnnumber.getText().toString());
                        dataSnapshot.getRef().child("garivara").setValue(minimumgarivara.getText().toString());

                        Toast.makeText(GariUpdateDelete.this,"Gari Info Updated",Toast.LENGTH_SHORT).show();

                        Intent i = new Intent(GariUpdateDelete.this,GariVaraNiboActivity.class);
                        startActivity(i);

                        GariUpdateDelete.this.finish();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseReference.removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(GariUpdateDelete.this,"Gari Info Deleted",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(GariUpdateDelete.this,"Gari Info is not Deleted",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                //Toast.makeText(GariUpdateDelete.this,"Gari Info Deleted",Toast.LENGTH_SHORT).show();

                Intent i = new Intent(GariUpdateDelete.this,GariVaraNiboActivity.class);
                startActivity(i);

                GariUpdateDelete.this.finish();
            }
        });

    }
}
