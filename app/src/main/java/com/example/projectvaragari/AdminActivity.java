package com.example.projectvaragari;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

public class AdminActivity extends AppCompatActivity implements View.OnClickListener {

    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        mAuth = FirebaseAuth.getInstance();
        findViewById(R.id.gariVaraDibo).setOnClickListener(this);
        findViewById(R.id.gariUpdateDelete).setOnClickListener(this);
        findViewById(R.id.userShowAdmin).setOnClickListener(this);
        findViewById(R.id.userDeatilsProfileShow).setOnClickListener(this);
        //findViewById(R.id.gariDeleteAdmin).setOnClickListener(this);
        //findViewById(R.id.signoutForAdmin).setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_layout,menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==R.id.signOutMenuId){
            FirebaseAuth.getInstance().signOut();
            finish();

            Intent i = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);

    }

    public void onClick(View v) {
        switch (v.getId()){
            case R.id.gariVaraDibo:
                startActivity(new Intent(this,GariVaraDiboActivity.class));
                break;


            case R.id.gariUpdateDelete:
                startActivity(new Intent(this,GariVaraNiboActivity.class));
                break;

            case R.id.userShowAdmin:
                startActivity(new Intent(this, User_Show_Activity.class));
                break;

            case R.id.userDeatilsProfileShow:
                startActivity(new Intent(this,User_Profile_Activity.class));
                break;

            /*case R.id.signoutForAdmin:
                startActivity(new Intent(this,MainActivity.class));
                break;

             */
        }
    }
}
