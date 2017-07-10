package com.founder.cxzx.mobilephonerefine.adapter;

import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.founder.cxzx.mobilephonerefine.R;
import com.founder.cxzx.mobilephonerefine.bean.HorizontalBarGraphDataBean;
import com.founder.cxzx.mobilephonerefine.utils.CommonUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by hyyx on 16/11/8.
 */

public class HorizontalBarGraphAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private List<HorizontalBarGraphDataBean> data = new ArrayList<>();
    private Integer max;
    private int mScreenWidth;

    public HorizontalBarGraphAdapter(Context context) {
        this.context = context;
        inflater = ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE));
    }

    public void setData(List<HorizontalBarGraphDataBean> data) {
        this.data.clear();
        this.data.addAll(data);
        getMax();
        notifyDataSetChanged();

    }

    private void getMax() {
        List<HorizontalBarGraphDataBean> maxList = new ArrayList<>();
        maxList.addAll(data);
        Collections.sort(maxList, new Comparator<HorizontalBarGraphDataBean>() {
            @Override
            public int compare(HorizontalBarGraphDataBean horizontalBarGraphDataBean, HorizontalBarGraphDataBean t1) {
                if (Integer.parseInt(horizontalBarGraphDataBean.getDeptNum()) > Integer.parseInt(t1.getDeptNum())) {
                    return -1;
                }
                if (Integer.parseInt(horizontalBarGraphDataBean.getDeptNum()) < Integer.parseInt(t1.getDeptNum())) {
                    return 1;
                }

                return 0;
            }
        });

        max = Integer.parseInt(maxList.get(0).getDeptNum());


    }


    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder holder = null;
        if (view == null) {
            view = inflater.inflate(R.layout.item_horbargraph, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = ((ViewHolder) view.getTag());
        }

        if (Integer.parseInt(data.get(i).getDeptNum()) < max) {
            float v = Integer.parseInt(data.get(i).getDeptNum()) / (float) max;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(((int) (v * CommonUtils.Px2Dp(context, mScreenWidth))), CommonUtils.Dp2Px(context, 20));
            layoutParams.gravity = Gravity.CENTER_VERTICAL;
            holder.viewLine.setLayoutParams(layoutParams);
        } else {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(CommonUtils.Px2Dp(context, mScreenWidth), CommonUtils.Dp2Px(context, 20));
            layoutParams.gravity = Gravity.CENTER_VERTICAL;
            holder.viewLine.setLayoutParams(layoutParams);
        }
        holder.tvNumber.setText(data.get(i).getDeptNum());
        holder.tvName.setText(data.get(i).getDeptName());


        return view;
    }


    class ViewHolder {


        private final TextView tvName;
        private final TextView viewLine;
        private final TextView tvNumber;
        private final LinearLayout llItem;


        public ViewHolder(View view) {

            tvName = ((TextView) view.findViewById(R.id.tv_item_horbar_name));
            viewLine = ((TextView) view.findViewById(R.id.tv_item_horbar_line));
            tvNumber = ((TextView) view.findViewById(R.id.tv_item_horbar_number));

            llItem = ((LinearLayout) view.findViewById(R.id.ll_item_horbar));

            int w = View.MeasureSpec.makeMeasureSpec(0,
                    View.MeasureSpec.UNSPECIFIED);
            int h = View.MeasureSpec.makeMeasureSpec(0,
                    View.MeasureSpec.UNSPECIFIED);
            llItem.measure(w, h);
            mScreenWidth = llItem.getMeasuredWidth();
            Log.e("ViewHolder", "mScreenWidth:" + mScreenWidth);
            tvName.setWidth(mScreenWidth / 5);
            tvNumber.setWidth(mScreenWidth / 5);
            viewLine.setWidth(mScreenWidth / 5 * 3);
            viewLine.setHeight(CommonUtils.Dp2Px(context, 20));


        }


    }
}
