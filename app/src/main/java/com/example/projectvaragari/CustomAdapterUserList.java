package com.example.projectvaragari;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class CustomAdapterUserList extends ArrayAdapter<UserList> {
    private Activity context;
    private List<UserList> userInfoList;

    public CustomAdapterUserList(Activity context,List<UserList> userInfoList){
        super(context, R.layout.user_show_sample_layout, userInfoList);
        this.context = context;
        this.userInfoList = userInfoList;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = context.getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.user_show_sample_layout, null,true);

        //CarInfo carInfo = carInfoList.get(position);

        UserList userList = userInfoList.get(position);

        TextView t1 = view.findViewById(R.id.userEmail);
        TextView t2 = view.findViewById(R.id.userID);
        /*TextView t3 = view.findViewById(R.id.garirSeat);
        TextView t4 = view.findViewById(R.id.driverErPhn);
        TextView t5 = view.findViewById(R.id.garirVara);*/

        t1.setText("User Email : "+userList.getEmail());
        t2.setText("User ID : "+userList.getUserID());
        /*t3.setText("People Can Seat : "+carInfo.getStnumber());
        t4.setText("Driver Contact Number : "+carInfo.getDrvphnnumber());
        t5.setText("Garir Minimum Vara : "+carInfo.getGarivara());*/



        return view;
    }
}
