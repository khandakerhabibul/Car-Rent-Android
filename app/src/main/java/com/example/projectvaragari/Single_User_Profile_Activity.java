package com.example.projectvaragari;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Single_User_Profile_Activity extends AppCompatActivity {

    ListView listView;
    List<UserErProfile> userErProfiles;
    CustomAdapterUserProfile customAdapterUserProfile;
    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single__user__profile_);

        databaseReference = FirebaseDatabase.getInstance().getReference("UserProfile");//.child(Current_User.userID);

        firebaseDatabase = FirebaseDatabase.getInstance();

        userErProfiles = new ArrayList<>();

        customAdapterUserProfile = new CustomAdapterUserProfile(Single_User_Profile_Activity.this, userErProfiles);

        listView = findViewById(R.id.listViewUserShow);


    }

    @Override
    protected void onStart() {

        //Toast.makeText(this,Current_User.userID,Toast.LENGTH_LONG).show();

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                userErProfiles.clear();

                for (DataSnapshot dataSnapshot1:dataSnapshot.getChildren()){
                    UserErProfile userErProfile = dataSnapshot1.getValue(UserErProfile.class);

                    if (userErProfile.getUserID().equals(Current_User.userID)){
                        userErProfiles.add((userErProfile));
                    }

                    //userErProfiles.add((userErProfile));

                }

                listView.setAdapter(customAdapterUserProfile);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        super.onStart();
    }
}
