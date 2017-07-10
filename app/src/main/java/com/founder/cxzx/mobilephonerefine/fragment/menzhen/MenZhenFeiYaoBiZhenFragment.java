package com.founder.cxzx.mobilephonerefine.fragment.menzhen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.founder.cxzx.mobilephonerefine.R;
import com.founder.cxzx.mobilephonerefine.adapter.MenZhenFeiYaoBiAdapter;
import com.founder.cxzx.mobilephonerefine.fragment.BaseFragment;

/**
 * Created by hyyx on 16/11/8.
 */

public class MenZhenFeiYaoBiZhenFragment extends BaseFragment {


    private View view;
    private ListView lv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.framgent_menzhen_menzhenfeiyao, null);

        initView();
        dealView();

        return view;
    }

    @Override
    public void initView() {
        lv = ((ListView) view.findViewById(R.id.lv_menzhenfeiyaobi));
    }

    @Override
    public void dealView() {
        MenZhenFeiYaoBiAdapter adapter = new MenZhenFeiYaoBiAdapter(getContext());
        lv.setAdapter(adapter);
    }
}
