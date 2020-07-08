package com.example.projectvaragari;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CustomAdapterGarirJonno extends ArrayAdapter<CarInfo> {

    private Activity context;
    private List<CarInfo> carInfoList;

    public CustomAdapterGarirJonno(Activity  context, List<CarInfo> carInfoList) {
        super(context, R.layout.gari_show_sample_layout, carInfoList);
        this.context = context;
        this.carInfoList = carInfoList;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = context.getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.gari_show_sample_layout, null,true);

        CarInfo carInfo = carInfoList.get(position);

        TextView t1 = view.findViewById(R.id.driverErName);
        TextView t2 = view.findViewById(R.id.garirModel);
        TextView t3 = view.findViewById(R.id.garirSeat);
        TextView t4 = view.findViewById(R.id.driverErPhn);
        TextView t5 = view.findViewById(R.id.garirVara);

        t1.setText("Name : "+carInfo.getDrivername());
        t2.setText("Car Model : "+carInfo.getCarmodel());
        t3.setText("People Can Seat : "+carInfo.getStnumber());
        t4.setText("Driver Contact Number : "+carInfo.getDrvphnnumber());
        t5.setText("Garir Minimum Vara : "+carInfo.getGarivara());



        return view;
    }
}
