package com.founder.cxzx.mobilephonerefine.fragment.menzhen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.founder.cxzx.mobilephonerefine.R;
import com.founder.cxzx.mobilephonerefine.fragment.BaseFragment;
import com.founder.cxzx.mobilephonerefine.widget.LineChartView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hyyx on 16/11/8.
 */

public class NianDuMenZhenFragment extends BaseFragment {


    private View view;
    private LineChartView lineChariew;
    private Button btnWeek;
    private Button btnMouth;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.framgent_menzhen_niandumenzhen, null);

        initView();
        dealView();

        return view;
    }

    @Override
    public void initView() {
        lineChariew = ((LineChartView) view.findViewById(R.id.linechart));
        btnWeek = ((Button) view.findViewById(R.id.btn_week));
        btnMouth = ((Button) view.findViewById(R.id.btn_mouthl));


    }

    @Override
    public void dealView() {
        btnWeek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<String> pointData = new ArrayList<>();
                pointData.add("55");
                pointData.add("20");
                pointData.add("30");
                pointData.add("150");
                pointData.add("10");
                pointData.add("100");
                pointData.add("40");
                lineChariew.setPointdata(pointData);
                lineChariew.setLineCharType(LineChartView.BloodPressure_LineChart);
                lineChariew.setDateType(LineChartView.DateType_Week);
            }
        });

        btnMouth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<String> pointData = new ArrayList<>();
                pointData.add("60");
                pointData.add("60");
                pointData.add("80");
                pointData.add("100");
                pointData.add("40");
                pointData.add("100");
                pointData.add("70");

                pointData.add("60");
                pointData.add("60");
                pointData.add("80");
                pointData.add("100");
                pointData.add("40");
                pointData.add("100");
                pointData.add("70");

                pointData.add("60");
                pointData.add("60");
                pointData.add("80");
                pointData.add("100");
                pointData.add("40");
                pointData.add("100");
                pointData.add("70");


                pointData.add("60");
                pointData.add("60");
                pointData.add("80");
                pointData.add("100");
                pointData.add("40");
                pointData.add("100");
                pointData.add("70");

                pointData.add("40");
                pointData.add("100");
                pointData.add("70");

                lineChariew.setPointdata(pointData);
                lineChariew.setLineCharType(LineChartView.BloodPressure_LineChart);
                lineChariew.setDateType(LineChartView.DateType_Mouth);
            }
        });

        List<String> pointData = new ArrayList<>();
        pointData.add("55");
        pointData.add("20");
        pointData.add("30");
        pointData.add("100");
        pointData.add("10");
        pointData.add("100");
        pointData.add("40");

        lineChariew.setPointdata(pointData);
        lineChariew.setLineCharType(LineChartView.BloodSugar_LineChart);
        lineChariew.setDateType(LineChartView.DateType_Week);


        ((Button) view.findViewById(R.id.btn_pressure)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lineChariew.setLineCharType(LineChartView.BloodPressure_LineChart);
            }
        });

        ((Button) view.findViewById(R.id.btn_sugar)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lineChariew.setLineCharType(LineChartView.BloodSugar_LineChart);
            }
        });
    }
}
