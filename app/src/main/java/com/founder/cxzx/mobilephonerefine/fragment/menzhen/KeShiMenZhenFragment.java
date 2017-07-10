package com.founder.cxzx.mobilephonerefine.fragment.menzhen;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.founder.cxzx.mobilephonerefine.R;
import com.founder.cxzx.mobilephonerefine.adapter.HorizontalBarGraphAdapter;
import com.founder.cxzx.mobilephonerefine.adapter.KeShiMenZhenAdapter;
import com.founder.cxzx.mobilephonerefine.fragment.BaseFragment;


/**
 * Created by hyyx on 16/11/8.
 */

public class KeShiMenZhenFragment extends BaseFragment {


    private View view;
    private RecyclerView xrc;
    private RelativeLayout rlTitle;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.framgent_menzhen_keshimenzhen, null);

        initView();
        dealView();

        return view;
    }

    @Override
    public void initView() {

        xrc = ((RecyclerView) view.findViewById(R.id.xrc_keshimenzhen));
        rlTitle = ((RelativeLayout) view.findViewById(R.id.rl_titile));


    }

    private int height;

    @Override
    public void dealView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        xrc.setLayoutManager(linearLayoutManager);
        KeShiMenZhenAdapter adapter = new KeShiMenZhenAdapter(getContext());
        xrc.setAdapter(adapter);
        xrc.setOverScrollMode(View.OVER_SCROLL_NEVER);

//        ViewTreeObserver vto2 = rlTitle.getViewTreeObserver();
//        vto2.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
//
//
//            @Override
//            public void onGlobalLayout() {
//                rlTitle.getViewTreeObserver().removeGlobalOnLayoutListener(this);
//                height = rlTitle.getMeasuredHeight();
//            }
//        });
//        int w = View.MeasureSpec.makeMeasureSpec(0,
//                View.MeasureSpec.UNSPECIFIED);
//        int h = View.MeasureSpec.makeMeasureSpec(0,
//                View.MeasureSpec.UNSPECIFIED);
//        rlTitle.measure(w, h);

        WindowManager wm = (WindowManager) getContext()
                .getSystemService(Context.WINDOW_SERVICE);

        int width = wm.getDefaultDisplay().getWidth();
        int height = wm.getDefaultDisplay().getHeight();
        adapter.setMaxHeight(height);

    }
}
