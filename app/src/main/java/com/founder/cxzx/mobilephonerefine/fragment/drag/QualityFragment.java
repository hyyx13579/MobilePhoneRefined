package com.founder.cxzx.mobilephonerefine.fragment.drag;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.founder.cxzx.mobilephonerefine.R;
import com.founder.cxzx.mobilephonerefine.fragment.BaseFragment;

/**
 * Created by hyyx on 16/11/7.
 */

public class QualityFragment extends BaseFragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View inflate = inflater.inflate(R.layout.fragment_quality, null);

        initView();
        dealView();

        return inflate;
    }

    @Override
    public void initView() {

    }

    @Override
    public void dealView() {

    }
}
