package com.founder.cxzx.mobilephonerefine.fragment.drag;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.founder.cxzx.mobilephonerefine.R;
import com.founder.cxzx.mobilephonerefine.adapter.ManageTypeAdapter;
import com.founder.cxzx.mobilephonerefine.bean.PieData;
import com.founder.cxzx.mobilephonerefine.fragment.BaseFragment;
import com.founder.cxzx.mobilephonerefine.widget.HollowPieCharView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by hyyx on 16/11/7.
 */

public class ManageFragment extends BaseFragment {

    private View inflate;
    private HollowPieCharView hollowPie;
    private ListView lv;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        inflate = inflater.inflate(R.layout.fragment_manage, null);

        initView();
        dealView();

        return inflate;
    }

    @Override
    public void initView() {
        hollowPie = ((  HollowPieCharView) inflate.findViewById(R.id.manage_hollowPie));
        lv = ((ListView) inflate.findViewById(R.id.manage_lv));
    }

    @Override
    public void dealView() {
        ManageTypeAdapter adapter = new ManageTypeAdapter(getContext());
        lv.setAdapter(adapter);

        List<PieData> data = new ArrayList<>();
        for (int i = 1; i <=7; i++) {
            int r = (new Random().nextInt(100) + 10) * i;
            int g = (new Random().nextInt(100) + 10) * 3 * i;
            int b = (new Random().nextInt(100) + 10) * 2 * i;
            int color = Color.rgb(r, g, b);
            if (Math.abs(r - g) > 10 && Math.abs(r - b) > 10 && Math.abs(b - g) > 10) {
                data.add(new PieData(i * 10, color));
            }
        }
        adapter.setData(data);

        hollowPie.setPieDate(data);
        hollowPie.setCenterTitle("总记");
        hollowPie.startDraw();


    }
}
