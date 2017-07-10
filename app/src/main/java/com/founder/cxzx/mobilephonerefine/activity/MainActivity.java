package com.founder.cxzx.mobilephonerefine.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.founder.cxzx.mobilephonerefine.R;
import com.founder.cxzx.mobilephonerefine.adapter.MenuAdapter;
import com.founder.cxzx.mobilephonerefine.fragment.drag.IncomeFragment;
import com.founder.cxzx.mobilephonerefine.fragment.drag.ManageFragment;
import com.founder.cxzx.mobilephonerefine.fragment.drag.MenZhenFragment;
import com.founder.cxzx.mobilephonerefine.fragment.drag.QualityFragment;
import com.founder.cxzx.mobilephonerefine.fragment.drag.ShouShuFragment;
import com.founder.cxzx.mobilephonerefine.fragment.drag.ZhenDuanFragment;
import com.founder.cxzx.mobilephonerefine.fragment.drag.ZhuYuanFragment;
import com.founder.cxzx.mobilephonerefine.widget.DragLayout;

/**
 * 主界面
 */
public class MainActivity extends BaseActivity {
    /**
     * 抽屉布局
     */
    private DragLayout dl;
    private ImageView ivIcon;
    /**
     * 抽屉中的菜单布局
     */
    private ListView lvMenu;
    /**
     * 菜单的icon
     */
    private int[] menuPic = {R.mipmap.icon_menzhen_xh, R.mipmap.icon_zhuyuan_xh, R.mipmap.icon_shoushu_xh, R.mipmap.icon_quality_xh, R.mipmap.icon_shouru_xh, R.mipmap.icon_yibao_xh, R.mipmap.icon_menzhen_xh};
    /**
     * 菜单的title
     */
    private String[] menuTitle = {"门诊统计", "住院统计", "手术信息", "质量与效率", "医疗收入", "医保管理", "诊断统计"};

    private MenZhenFragment menZhenFragment;
    private ZhuYuanFragment zhuYuanFragment;
    private ShouShuFragment shouShuFragment;
    private QualityFragment qualityFragment;
    private IncomeFragment incomeFragment;
    private ManageFragment manageFragment;
    private ZhenDuanFragment zhenDuanFragment;
    private TextView tvTitleName;
    private RelativeLayout rlMore;
    private RelativeLayout rlRefresh;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        dealView();
        initDragLayout();
    }

    @Override
    public void initView() {
        lvMenu = (ListView) findViewById(R.id.lv_leftview);
        setSelector(0);
        tvTitleName = ((TextView) findViewById(R.id.tv_commonTitle_titleName));
        tvTitleName.setText("门诊统计");
        rlMore = ((RelativeLayout) findViewById(R.id.rl_commonTitle_more));
        rlRefresh = ((RelativeLayout) findViewById(R.id.rl_commonTitle_refresh));


    }

    @Override
    public void initData() {


    }

    @Override
    public void dealView() {
        lvMenu.setDivider(null);
        lvMenu.setAdapter(new MenuAdapter(menuPic, menuTitle, this));
        lvMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                setSelector(i);
                tvTitleName.setText(menuTitle[i]);
                dl.close();
                for (int j = 0; j < adapterView.getCount(); j++) {
                    View childAt = adapterView.getChildAt(j);
                    TextView tvLine = (TextView) childAt.findViewById(R.id.tv_item_menu_line);
                    LinearLayout llItem = (LinearLayout) childAt.findViewById(R.id.ll_tem_menu);
                    if (i == j) {
                        tvLine.setVisibility(View.VISIBLE);
                        llItem.setBackgroundColor(getResources().getColor(R.color.item_background));

                    } else {
                        tvLine.setVisibility(View.INVISIBLE);
                        llItem.setBackgroundColor(getResources().getColor(R.color.white));

                    }
                }


            }
        });
        rlMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dl.open();
            }
        });


    }

    private void initDragLayout() {
        dl = (DragLayout) findViewById(R.id.dl);
        dl.setDragListener(new DragLayout.DragListener() {
            //界面打开的时候
            @Override
            public void onOpen() {
            }

            //界面关闭的时候
            @Override
            public void onClose() {
            }

            //界面滑动的时候
            @Override
            public void onDrag(float percent) {

            }
        });
    }


    public void setSelector(int selector) {
        FragmentManager manager = this.getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        hideFragment(transaction);
        switch (selector) {
            case 0:
                if (menZhenFragment == null) {
                    menZhenFragment = new MenZhenFragment();
                    transaction.add(R.id.fl_contain, menZhenFragment, "MenZhenFragment");
                } else {
                    transaction.show(menZhenFragment);
                }
                break;

            case 1:
                if (zhuYuanFragment == null) {
                    zhuYuanFragment = new ZhuYuanFragment();
                    transaction.add(R.id.fl_contain, zhuYuanFragment, "ZhuYuanFragment");
                } else {
                    transaction.show(zhuYuanFragment);
                }
                break;
            case 2:
                if (shouShuFragment == null) {
                    shouShuFragment = new ShouShuFragment();
                    transaction.add(R.id.fl_contain, shouShuFragment, "ShouShuFragment");
                } else {
                    transaction.show(shouShuFragment);
                }
                break;
            case 3:
                if (qualityFragment == null) {
                    qualityFragment = new QualityFragment();
                    transaction.add(R.id.fl_contain, qualityFragment, "QualityFragment");
                } else {
                    transaction.show(qualityFragment);
                }
                break;
            case 4:
                if (incomeFragment == null) {
                    incomeFragment = new IncomeFragment();
                    transaction.add(R.id.fl_contain, incomeFragment, "IncomeFragment");
                } else {
                    transaction.show(incomeFragment);
                }
                break;
            case 5:
                if (manageFragment == null) {
                    manageFragment = new ManageFragment();
                    transaction.add(R.id.fl_contain, manageFragment, "ManageFragment");
                } else {
                    transaction.show(manageFragment);
                }
                break;
            case 6:
                if (zhenDuanFragment == null) {
                    zhenDuanFragment = new ZhenDuanFragment();
                    transaction.add(R.id.fl_contain, zhenDuanFragment, "ZhenDuanFragment");
                } else {
                    transaction.show(zhenDuanFragment);
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

        if (menZhenFragment != null) {
            transaction.hide(menZhenFragment);
        }

        if (zhuYuanFragment != null) {
            transaction.hide(zhuYuanFragment);
        }
        if (shouShuFragment != null) {
            transaction.hide(shouShuFragment);
        }
        if (qualityFragment != null) {
            transaction.hide(qualityFragment);
        }
        if (incomeFragment != null) {
            transaction.hide(incomeFragment);
        }
        if (manageFragment != null) {
            transaction.hide(manageFragment);
        }
        if (zhenDuanFragment != null) {
            transaction.hide(zhenDuanFragment);
        }


    }

}
