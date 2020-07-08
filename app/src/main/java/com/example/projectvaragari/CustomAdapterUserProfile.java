package com.example.projectvaragari;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class CustomAdapterUserProfile extends ArrayAdapter<UserErProfile> {
    private Activity context;
    private List<UserErProfile> userErProfiles ;

    public CustomAdapterUserProfile(Activity context,List<UserErProfile> userErProfiles){
        super(context, R.layout.user_er_profile_sample_layout, userErProfiles);
        this.context = context;
        this.userErProfiles = userErProfiles;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = context.getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.user_er_profile_sample_layout, null,true);

        //UserList userList = userInfoList.get(position);
        UserErProfile userErProfile = userErProfiles.get(position);

        TextView t1 = view.findViewById(R.id.userEmailUserProfile);
        TextView t2 = view.findViewById(R.id.userIDUserProfile);
        TextView t3 = view.findViewById(R.id.driverErNameUserProfile);
        TextView t4 = view.findViewById(R.id.garirModelUserProfile);
        TextView t5 = view.findViewById(R.id.garirSeatUserProfile);
        TextView t6 = view.findViewById(R.id.driverErPhnUserProfile);
        TextView t7 = view.findViewById(R.id.garirVaraUserProfile);

        t1.setText("User Email : "+userErProfile.getEmail());
        t2.setText("User ID : "+userErProfile.getUserID());
        t3.setText("Driver Name : "+userErProfile.getDriverName());
        t4.setText("Garir Model : "+userErProfile.getCarmodel());
        t5.setText("Seat Number : "+userErProfile.getSeat());
        t6.setText("Driver Contarct Number : "+userErProfile.getDriverPhnNumber());
        t7.setText("Garir Minimum Vara : "+userErProfile.getGariVara());



        return view;
    }
}
