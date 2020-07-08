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

public class User_Show_Activity extends AppCompatActivity {

    ListView listView;

    List<UserList> userlists;
    CustomAdapterUserList customAdapterUserList;
    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__show_);

        databaseReference = FirebaseDatabase.getInstance().getReference("Users");

        firebaseDatabase = FirebaseDatabase.getInstance();

        userlists = new ArrayList<>();

        customAdapterUserList = new CustomAdapterUserList(User_Show_Activity.this, userlists);

        listView = findViewById(R.id.listViewUserShow);
    }

    @Override
    protected void onStart() {

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                userlists.clear();

                for (DataSnapshot dataSnapshot1:dataSnapshot.getChildren()){
                    UserList userList = dataSnapshot1.getValue(UserList.class);
                    userlists.add((userList));
                }

                listView.setAdapter(customAdapterUserList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        super.onStart();
    }
}
