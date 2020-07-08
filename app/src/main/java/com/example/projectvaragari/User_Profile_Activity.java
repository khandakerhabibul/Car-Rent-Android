package com.example.projectvaragari;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class User_Profile_Activity extends AppCompatActivity {

    ListView listView;
    List<UserErProfile> userErProfiles;
    CustomAdapterUserProfile customAdapterUserProfile;
    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__profile_);

        databaseReference = FirebaseDatabase.getInstance().getReference("UserProfile");

        firebaseDatabase = FirebaseDatabase.getInstance();

        userErProfiles = new ArrayList<>();

        customAdapterUserProfile = new CustomAdapterUserProfile(User_Profile_Activity.this, userErProfiles);

        listView = findViewById(R.id.userErProfileShow);
    }

    @Override
    protected void onStart() {

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                userErProfiles.clear();

                for (DataSnapshot dataSnapshot1:dataSnapshot.getChildren()){
                    UserErProfile userErProfile = dataSnapshot1.getValue(UserErProfile.class);
                    userErProfiles.add((userErProfile));
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
