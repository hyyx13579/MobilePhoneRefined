package com.founder.cxzx.mobilephonerefine.fragment.drag;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.founder.cxzx.mobilephonerefine.R;
import com.founder.cxzx.mobilephonerefine.adapter.TitleBarAdapter;
import com.founder.cxzx.mobilephonerefine.fragment.BaseFragment;
import com.founder.cxzx.mobilephonerefine.fragment.menzhen.JiZhenGuaHaoFragment;
import com.founder.cxzx.mobilephonerefine.fragment.menzhen.KeShiMenZhenFragment;
import com.founder.cxzx.mobilephonerefine.fragment.menzhen.MenZhenFeiYaoBiZhenFragment;
import com.founder.cxzx.mobilephonerefine.fragment.menzhen.NianDuMenZhenFragment;
import com.founder.cxzx.mobilephonerefine.fragment.menzhen.NianDuSanLeiKaFragment;
import com.founder.cxzx.mobilephonerefine.utils.CommonUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by hyyx on 16/11/7.
 */

public class MenZhenFragment extends BaseFragment implements View.OnClickListener {


    private View inflate;
    private LinearLayout llTitleBar;
    private TextView tvTitleBarOne;
    private TextView tvTitleBarTwo;
    private TextView tvTitleBarThree;
    private TextView tvTitleBarFour;
    private TextView tvTitleBarFive;
    private HorizontalScrollView horScrollTitleBar;
    private ImageView ivTitleBarZhanKai;
    private LinearLayout llContain;
    private ListView lvContain;
    private RelativeLayout llBackGround;
    private FrameLayout flContain;
    private KeShiMenZhenFragment keShiMenZhenFragment;
    private MenZhenFeiYaoBiZhenFragment menZhenFeiYaoBiZhenFragment;
    private NianDuSanLeiKaFragment nianDuSanLeiKaFragment;
    private NianDuMenZhenFragment nianDuMenZhenFragment;
    private JiZhenGuaHaoFragment jiZhenGuaHaoFragment;
    private TextView tvTimeChoose;
    private Calendar calendar;
    private DatePicker dpStartTime;
    private DatePicker dpStopTime;
    private String mStartTime;
    private String mStopTime;
    private TitleBarAdapter adapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        inflate = inflater.inflate(R.layout.fragment_menzhen, null);

        initView();
        dealView();

        return inflate;
    }

    @Override
    public void initView() {

        llTitleBar = ((LinearLayout) inflate.findViewById(R.id.ll_menzhenBar));
        TextView childAt = (TextView) llTitleBar.getChildAt(0);
        childAt.setTextSize(16);
        childAt.setAlpha(1);
        tvTitleBarOne = ((TextView) inflate.findViewById(R.id.tv_menzhenBar_one));
        tvTitleBarTwo = ((TextView) inflate.findViewById(R.id.tv_menzhenBar_two));
        tvTitleBarThree = ((TextView) inflate.findViewById(R.id.tv_menzhenBar_three));
        tvTitleBarFour = ((TextView) inflate.findViewById(R.id.tv_menzhenBar_four));
        tvTitleBarFive = ((TextView) inflate.findViewById(R.id.tv_menzhenBar_five));
        horScrollTitleBar = ((HorizontalScrollView) inflate.findViewById(R.id.horscroll_menzhen));
        ivTitleBarZhanKai = ((ImageView) inflate.findViewById(R.id.iv_commonTitle_zhankai));
        llContain = ((LinearLayout) inflate.findViewById(R.id.ll_menzhen_contain));
        lvContain = ((ListView) inflate.findViewById(R.id.lv_menzhen_contain));
        llBackGround = ((RelativeLayout) inflate.findViewById(R.id.ll_menzhen_background));
        flContain = ((FrameLayout) inflate.findViewById(R.id.fl_menzhen_contain));

        tvTimeChoose = ((TextView) inflate.findViewById(R.id.tv_menzhen_timeChoose));

        calendar = Calendar.getInstance();


    }

    @Override
    public void dealView() {
        adapter = new TitleBarAdapter(getContext());
        lvContain.setAdapter(adapter);
        List<String> data = new ArrayList<>();
        data.add("科室门诊挂号人次");
        data.add("门诊费药比");
        data.add("年度三类卡统计");
        data.add("年度门诊量统计");
        data.add("门急诊挂号人次");
        adapter.setData(data);
        tvTitleBarOne.setOnClickListener(this);
        tvTitleBarTwo.setOnClickListener(this);
        tvTitleBarThree.setOnClickListener(this);
        tvTitleBarFour.setOnClickListener(this);
        tvTitleBarFive.setOnClickListener(this);
        ivTitleBarZhanKai.setOnClickListener(this);
        setSelector(0);


        tvTimeChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTimeChoose();
            }
        });

    }

    private void showTimeChoose() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View inflate = getActivity().getLayoutInflater().inflate(R.layout.dialog_time_choose, null);
        dpStartTime = ((DatePicker) inflate.findViewById(R.id.dp_dialog_one));
        dpStopTime = ((DatePicker) inflate.findViewById(R.id.dp_dialog_two));
        calendar.setTimeInMillis(System.currentTimeMillis());
        dpStartTime.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH), null);
        dpStopTime.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH), null);
        builder.setView(inflate);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                StringBuffer sbStartTime = new StringBuffer();
                sbStartTime.append(String.format("%d-%02d-%02d",
                        dpStartTime.getYear(),
                        dpStartTime.getMonth() + 1,
                        dpStartTime.getDayOfMonth()));
                StringBuffer sbStopTime = new StringBuffer();
                sbStopTime.append(String.format("%d-%02d-%02d",
                        dpStopTime.getYear(),
                        dpStopTime.getMonth() + 1,
                        dpStopTime.getDayOfMonth()));

                mStartTime = sbStartTime.toString();
                mStopTime = sbStopTime.toString();

                if (!TextUtils.isEmpty(mStartTime) && !TextUtils.isEmpty(sbStopTime)) {
                    if (CommonUtils.CompareDate(mStartTime, mStopTime) <= 0) {
                        tvTimeChoose.setText(mStartTime + " 至 " + mStopTime);
                        dialogInterface.dismiss();
                    } else {
                        Toast.makeText(getContext(), "停止时间需要大于开始时间", Toast.LENGTH_SHORT).show();
                    }


                }


            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        builder.create().show();


    }

    public void setTitleBarStatus(View view) {

        for (int i = 0; i < llTitleBar.getChildCount(); i++) {

            TextView childAt = (TextView) llTitleBar.getChildAt(i);
            childAt.setTextSize(14);
            childAt.setAlpha(0.5f);
        }

        ((TextView) view).setTextSize(16);
        ((TextView) view).setAlpha(1);
        int i = llTitleBar.indexOfChild(view);
        horScrollTitleBar.smoothScrollTo(i * ((TextView) view).getWidth(), 0);


    }

    public void setLikePpwForChooseTitle() {

        llContain.setVisibility(View.VISIBLE);
        lvContain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //adapter.setClickChange(i);
                setTitleBarStatus(llTitleBar.getChildAt(i));
                llContain.setVisibility(View.GONE);
                flContain.setVisibility(View.VISIBLE);
                ivTitleBarZhanKai.setBackgroundDrawable(getResources().getDrawable(R.mipmap.zhankai_xhdpi));
                setSelector(i);
                for (int j = 0; j < adapterView.getCount(); j++) {
                    View childAt = adapterView.getChildAt(j);
                    TextView tvName = (TextView) childAt.findViewById(R.id.tv_item_likeppw);
                    if (i == j) {
                        tvName.setTextColor(getResources().getColor(R.color.titile_blue));
                    } else {
                        tvName.setTextColor(getResources().getColor(R.color.word_color_light));

                    }

                }
            }
        });
        llBackGround.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                llContain.setVisibility(View.GONE);
                flContain.setVisibility(View.VISIBLE);
                ivTitleBarZhanKai.setBackgroundDrawable(getResources().getDrawable(R.mipmap.zhankai_xhdpi));

            }
        });


    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.tv_menzhenBar_one:
                setTitleBarStatus(view);
                setSelector(0);
                break;
            case R.id.tv_menzhenBar_two:
                setTitleBarStatus(view);
                setSelector(1);
                break;
            case R.id.tv_menzhenBar_three:
                setTitleBarStatus(view);
                setSelector(2);
                break;
            case R.id.tv_menzhenBar_four:
                setTitleBarStatus(view);
                setSelector(3);
                break;
            case R.id.tv_menzhenBar_five:
                setTitleBarStatus(view);
                setSelector(4);
                break;
            case R.id.iv_commonTitle_zhankai:
                ivTitleBarZhanKai.setBackgroundDrawable(getResources().getDrawable(R.mipmap.shousuo_xhdpi));
                setLikePpwForChooseTitle();
                break;


        }


    }

    public void setSelector(int selector) {
        FragmentManager manager = getChildFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        hideFragment(transaction);
        switch (selector) {
            case 0:
                if (keShiMenZhenFragment == null) {
                    keShiMenZhenFragment = new KeShiMenZhenFragment();
                    transaction.add(R.id.fl_menzhen_contain, keShiMenZhenFragment, "KeShiMenZhenFragment");
                } else {
                    transaction.show(keShiMenZhenFragment);
                }
                break;

            case 1:
                if (menZhenFeiYaoBiZhenFragment == null) {
                    menZhenFeiYaoBiZhenFragment = new MenZhenFeiYaoBiZhenFragment();
                    transaction.add(R.id.fl_menzhen_contain, menZhenFeiYaoBiZhenFragment, "MenZhenFeiYaoBiZhenFragment");
                } else {
                    transaction.show(menZhenFeiYaoBiZhenFragment);
                }
                break;
            case 2:
                if (nianDuSanLeiKaFragment == null) {
                    nianDuSanLeiKaFragment = new NianDuSanLeiKaFragment();
                    transaction.add(R.id.fl_menzhen_contain, nianDuSanLeiKaFragment, "NianDuSanLeiKaFragment");
                } else {
                    transaction.show(nianDuSanLeiKaFragment);
                }
                break;
            case 3:
                if (nianDuMenZhenFragment == null) {
                    nianDuMenZhenFragment = new NianDuMenZhenFragment();
                    transaction.add(R.id.fl_menzhen_contain, nianDuMenZhenFragment, "NianDuMenZhenFragment");
                } else {
                    transaction.show(nianDuMenZhenFragment);
                }
                break;
            case 4:
                if (jiZhenGuaHaoFragment == null) {
                    jiZhenGuaHaoFragment = new JiZhenGuaHaoFragment();
                    transaction.add(R.id.fl_menzhen_contain, jiZhenGuaHaoFragment, "JiZhenGuaHaoFragment");
                } else {
                    transaction.show(jiZhenGuaHaoFragment);
                }
                break;


        }
        transaction.commit();
    }

    /**
     * 隐藏fragment
     *
     * @param transaction
     */
    private void hideFragment(FragmentTransaction transaction) {

        if (keShiMenZhenFragment != null) {
            transaction.hide(keShiMenZhenFragment);
        }

        if (menZhenFeiYaoBiZhenFragment != null) {
            transaction.hide(menZhenFeiYaoBiZhenFragment);
        }
        if (nianDuSanLeiKaFragment != null) {
            transaction.hide(nianDuSanLeiKaFragment);
        }
        if (nianDuMenZhenFragment != null) {
            transaction.hide(nianDuMenZhenFragment);
        }
        if (jiZhenGuaHaoFragment != null) {
            transaction.hide(jiZhenGuaHaoFragment);
        }


    }


}
