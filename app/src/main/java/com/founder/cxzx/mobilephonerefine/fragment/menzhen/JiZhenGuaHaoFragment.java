package com.founder.cxzx.mobilephonerefine.fragment.menzhen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.founder.cxzx.mobilephonerefine.R;
import com.founder.cxzx.mobilephonerefine.adapter.HorizontalBarGraphAdapter;
import com.founder.cxzx.mobilephonerefine.bean.HorizontalBarGraphDataBean;
import com.founder.cxzx.mobilephonerefine.fragment.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hyyx on 16/11/8.
 */

public class JiZhenGuaHaoFragment extends BaseFragment {

    private ListView lvHorBarGraph;

    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.framgent_menzhen_jizhenguahao, null);

        initView();
        dealView();

        return view;
    }

    @Override
    public void initView() {

        lvHorBarGraph = ((ListView) view.findViewById(R.id.lv_keshimenzhen));


    }

    @Override
    public void dealView() {

        HorizontalBarGraphAdapter adapter = new HorizontalBarGraphAdapter(getContext());
        lvHorBarGraph.setAdapter(adapter);
        List<HorizontalBarGraphDataBean> data = new ArrayList<>();
        data.add(new HorizontalBarGraphDataBean("眼科门诊", "30100"));
        data.add(new HorizontalBarGraphDataBean("妇科门诊", "13011"));
        data.add(new HorizontalBarGraphDataBean("皮肤门诊", "17777"));
        data.add(new HorizontalBarGraphDataBean("慢性病门诊", "8000"));
        data.add(new HorizontalBarGraphDataBean("神经科门诊", "1500"));
        data.add(new HorizontalBarGraphDataBean("儿科门诊", "80000"));
        adapter.setData(data);


    }
}
