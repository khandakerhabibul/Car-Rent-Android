package com.example.projectvaragari;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mAuth = FirebaseAuth.getInstance();
        //findViewById(R.id.gariVaraDibo).setOnClickListener(this);
        findViewById(R.id.gariVaraNibo).setOnClickListener(this);
        //findViewById(R.id.signout).setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

         getMenuInflater().inflate(R.menu.menu_layout,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.signOutMenuId){
            FirebaseAuth.getInstance().signOut();
            finish();

            Intent i = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(i);

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //case R.id.gariVaraDibo:
                //startActivity(new Intent(this,GariVaraDiboActivity.class));
                //break;


            case R.id.gariVaraNibo:
                startActivity(new Intent(this,GariVaraNiboActivity.class));
                break;

            /*case R.id.signout:
                startActivity(new Intent(this,MainActivity.class));
                break;

             */
        }
    }
}
