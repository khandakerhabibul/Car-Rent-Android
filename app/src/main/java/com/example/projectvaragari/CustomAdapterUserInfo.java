package com.example.projectvaragari;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class CustomAdapterUserInfo extends ArrayAdapter<UserInfo> {
    private Activity context;
    private List<UserInfo> userInfos;

    public CustomAdapterUserInfo(Activity context, List<UserInfo> userInfoList){
        super(context, R.layout.user_info_sample_layout, userInfoList);
        this.context = context;
        this.userInfos = userInfoList;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = context.getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.user_show_sample_layout, null,true);


        UserInfo userInfo = userInfos.get(position);
        //UserList userList = userInfoList.get(position);

        TextView t1 = view.findViewById(R.id.driverErNameUserInfo);
        TextView t2 = view.findViewById(R.id.garirModelUserInfo);
        TextView t3 = view.findViewById(R.id.garirSeatUserInfo);
        TextView t4 = view.findViewById(R.id.driverErPhnUserInfo);
        TextView t5 = view.findViewById(R.id.garirVaraUserInfo);

        t1.setText("User Email : "+userInfo.getDrivername());
        t2.setText("User ID : "+userInfo.getCarmodel());
        t3.setText("People Can Seat : "+userInfo.getStnumber());
        t4.setText("Driver Contact Number : "+userInfo.getDrvphnnumber());
        t5.setText("Garir Minimum Vara : "+userInfo.getGarivara());



        return view;
    }
}


