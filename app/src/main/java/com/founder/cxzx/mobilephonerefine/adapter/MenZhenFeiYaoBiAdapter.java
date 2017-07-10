package com.founder.cxzx.mobilephonerefine.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.founder.cxzx.mobilephonerefine.R;
import com.founder.cxzx.mobilephonerefine.bean.MenZhenFeiYaoBiBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hyyx on 16/12/2.
 */

public class MenZhenFeiYaoBiAdapter extends BaseAdapter {


    private Context context;
    private LayoutInflater inflater;
    private List<MenZhenFeiYaoBiBean> data = new ArrayList<>();


    public MenZhenFeiYaoBiAdapter(Context context) {
        this.context = context;
        inflater = ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE));
        data.add(new MenZhenFeiYaoBiBean("妇科", "10%"));
        data.add(new MenZhenFeiYaoBiBean("产科", "20%"));
        data.add(new MenZhenFeiYaoBiBean("儿科", "30%"));
        data.add(new MenZhenFeiYaoBiBean("呼吸科", "40%"));
        data.add(new MenZhenFeiYaoBiBean("内分泌科", "50%"));

    }

    @Override
    public int getCount() {
        return data != null ? data.size() : 0;
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

            view = inflater.inflate(R.layout.item_menzhenfeiyaobi, null);
            holder = new ViewHolder(view);
            view.setTag(holder);

        } else {

            holder = ((ViewHolder) view.getTag());

        }

        holder.tvWardName.setText(data.get(i).getDeptName());
        holder.tvNumber.setText(data.get(i).getDeptNum());


        if (i % 2 == 0) {
            holder.llItem.setBackgroundColor(context.getResources().getColor(R.color.item_background));
        } else {
            holder.llItem.setBackgroundColor(context.getResources().getColor(R.color.white));

        }


        return view;
    }


    class ViewHolder {


        private final LinearLayout llItem;
        private final TextView tvWardName;
        private final TextView tvNumber;

        public ViewHolder(View view) {

            llItem = ((LinearLayout) view.findViewById(R.id.ll_feiyaobi));
            tvWardName = ((TextView) view.findViewById(R.id.tv_item_feiyaobi_wardName));
            tvNumber = ((TextView) view.findViewById(R.id.tv_item_feiyaobi_number));


        }


    }


}
