package com.founder.cxzx.mobilephonerefine.fragment;


import android.support.v4.app.Fragment;

/**
 * Created by hyyx on 16/11/7.
 */

public abstract class BaseFragment extends Fragment {


    /**
     * 初始化视图组件
     */
    public abstract void initView();

    /**
     * 操控布局
     */
    public abstract void dealView();

}
