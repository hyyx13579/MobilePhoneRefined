package com.founder.cxzx.mobilephonerefine.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.founder.cxzx.mobilephonerefine.R;
import com.founder.cxzx.mobilephonerefine.bean.PieData;
import com.founder.cxzx.mobilephonerefine.widget.CircleView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hyyx on 2016/12/19.
 */

public class ManageTypeAdapter extends BaseAdapter {

    private final LayoutInflater inflater;
    private List<PieData> datas = new ArrayList<>();
    private Context context;


    public ManageTypeAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);


    }

    public void setData(List<PieData> datas) {
        if (datas != null) {
            this.datas.clear();
            this.datas.addAll(datas);
            notifyDataSetChanged();
        }
    }


    @Override
    public int getCount() {
        return datas != null ? datas.size() : 0;
    }

    @Override
    public Object getItem(int i) {
        return datas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            view = inflater.inflate(R.layout.item_managetype, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = ((ViewHolder) view.getTag());
        }


        holder.circleView.setColor(datas.get(i).getColor());
        holder.tvTypeNum.setText(datas.get(i).getValue() + "");
        int j = i + 1;
        holder.tvTypeName.setText("名称" + j);


        return view;
    }

    class ViewHolder {
        private CircleView circleView;
        private TextView tvTypeName;
        private TextView tvTypeNum;

        public ViewHolder(View view) {
            circleView = ((CircleView) view.findViewById(R.id.circleView));
            tvTypeName = ((TextView) view.findViewById(R.id.tv_managetype_name));
            tvTypeNum = ((TextView) view.findViewById(R.id.tv_managetype_num));

        }
    }


}
