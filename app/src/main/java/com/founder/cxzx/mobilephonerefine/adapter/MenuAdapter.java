package com.founder.cxzx.mobilephonerefine.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.founder.cxzx.mobilephonerefine.R;

/**
 * 抽屉菜单的适配器
 * Created by Tony on 16/10/12.
 */

public class MenuAdapter extends BaseAdapter {
    private int[] menuIcon;
    private String[] menuTitle;
    private Context context;

    public MenuAdapter(int[] menuIcon, String[] menuTitle, Context context) {
        this.menuIcon = menuIcon;
        this.menuTitle = menuTitle;
        this.context = context;
    }

    @Override
    public int getCount() {
        return menuIcon.length;
    }

    @Override
    public Object getItem(int position) {
        return menuTitle[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_menu, null);
            holder = new ViewHolder();
            holder.img = (ImageView) convertView.findViewById(R.id.img_memu);
            holder.tv = (TextView) convertView.findViewById(R.id.tv_menu);
            holder.tvLine = (TextView) convertView.findViewById(R.id.tv_item_menu_line);
            holder.llItem = ((LinearLayout) convertView.findViewById(R.id.ll_tem_menu));
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.img.setImageResource(menuIcon[position]);
        holder.tv.setText(menuTitle[position]);
        if (position == 0) {
            holder.tvLine.setVisibility(View.VISIBLE);
            holder.llItem.setBackgroundColor(context.getResources().getColor(R.color.item_background));
        } else {
            holder.tvLine.setVisibility(View.INVISIBLE);
            holder.llItem.setBackgroundColor(context.getResources().getColor(R.color.white));

        }


        return convertView;
    }

    class ViewHolder {
        ImageView img;
        TextView tv;
        TextView tvLine;
        LinearLayout llItem;
    }


}
