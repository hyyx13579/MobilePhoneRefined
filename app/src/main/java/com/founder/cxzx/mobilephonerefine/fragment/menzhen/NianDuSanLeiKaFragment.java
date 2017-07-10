package com.founder.cxzx.mobilephonerefine.fragment.menzhen;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.founder.cxzx.mobilephonerefine.R;
import com.founder.cxzx.mobilephonerefine.bean.PieData;
import com.founder.cxzx.mobilephonerefine.fragment.BaseFragment;
import com.founder.cxzx.mobilephonerefine.widget.HollowPieCharView;
import com.founder.cxzx.mobilephonerefine.widget.PieCharView;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;

/**
 * Created by hyyx on 16/11/8.
 */

public class NianDuSanLeiKaFragment extends BaseFragment {


    private View view;

    private LinkedHashMap kindsMap = new LinkedHashMap<String, Integer>();
    private ArrayList<Integer> colors = new ArrayList<>();

    private PieCharView pieCharView;
    private HollowPieCharView hollowPie;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.framgent_menzhen_niandusanlei, null);

        initView();
        dealView();

        return view;
    }

    @Override
    public void initView() {
        //  pieCharView = (PieCharView) view.findViewById(R.id.pie);
        hollowPie = ((HollowPieCharView) view.findViewById(R.id.hollowPie));
    }

    @Override
    public void dealView() {
//        kindsMap.put("新农合", 10);
//        kindsMap.put("自费及其他", 30);
//        kindsMap.put("省医保", 10);
//        kindsMap.put("市职工", 30);
//        kindsMap.put("其他医保", 10);
//        kindsMap.put("市居民", 30);
//        kindsMap.put("省市离休", 10);



//        pieCharView.setCenterTitle("总计");
//        pieCharView.setDataMap(kindsMap);
//        pieCharView.setColors(colors);
//        pieCharView.setMinAngle(50);
//        pieCharView.startDraw();

        List<PieData> data = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            int r = (new Random().nextInt(100) + 10) * i;
            int g = (new Random().nextInt(100) + 10) * 3 * i;
            int b = (new Random().nextInt(100) + 10) * 2 * i;
            int color = Color.rgb(r, g, b);
            if (Math.abs(r - g) > 10 && Math.abs(r - b) > 10 && Math.abs(b - g) > 10) {
                data.add(new PieData(i * 10, color));
            }
        }

        hollowPie.setPieDate(data);
        hollowPie.setCenterTitle("总记");
        hollowPie.startDraw();



    }


}

