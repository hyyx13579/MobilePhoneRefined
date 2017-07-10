package com.founder.cxzx.mobilephonerefine.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.founder.cxzx.mobilephonerefine.R;

import java.util.List;

/**
 * Created by hyyx on 16/11/8.
 */

public class TitleBarAdapter extends BaseAdapter {

    private Context context;
    private List<String> data;
    private LayoutInflater inflater;
    private int mSelect = -1;


    public TitleBarAdapter(Context context) {
        this.context = context;
        inflater = ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE));
    }

    public void setData(List<String> data) {
        this.data = data;
        notifyDataSetChanged();
    }


    public void setClickChange(int pos) {
        if (mSelect != pos) {
            mSelect = pos;
            notifyDataSetChanged();
        }

    }


    @Override
    public int getCount() {
        return data != null ? data.size() : 0;
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            view = inflater.inflate(R.layout.item_likeppw_titilebar, null);
            holder = new ViewHolder(view);
            view.setTag(holder);

        } else {
            holder = ((ViewHolder) view.getTag());
        }

        holder.tvName.setText(data.get(i));
        if (i==0){

            holder.tvName.setTextColor(context.getResources().getColor(R.color.titile_blue));

        }else {
            holder.tvName.setTextColor(context.getResources().getColor(R.color.word_color_light));

        }



//        if (mSelect == i) {
//            holder.tvName.setTextColor(context.getResources().getColor(R.color.titile_blue));
//        } else {
//            holder.tvName.setTextColor(context.getResources().getColor(R.color.word_color_light));
//
//        }


        return view;
    }


    class ViewHolder {
        TextView tvName;

        public ViewHolder(View view) {

            tvName = ((TextView) view.findViewById(R.id.tv_item_likeppw));

        }


    }


}
