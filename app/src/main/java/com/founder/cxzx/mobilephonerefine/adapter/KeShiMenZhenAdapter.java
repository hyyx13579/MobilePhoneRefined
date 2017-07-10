package com.founder.cxzx.mobilephonerefine.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.founder.cxzx.mobilephonerefine.R;
import com.founder.cxzx.mobilephonerefine.bean.KeShiMenZhenBean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by hyyx on 16/12/2.
 */

public class KeShiMenZhenAdapter extends RecyclerView.Adapter<KeShiMenZhenAdapter.ViewHolder> {


    private final int maxData;
    private Context context;
    private int mScreenHeigh;
    private List<KeShiMenZhenBean> data = new ArrayList<>();
    private float k;


    public KeShiMenZhenAdapter(Context context) {
        this.context = context;
        data.add(new KeShiMenZhenBean("妇科", "100", "10", "35"));
        data.add(new KeShiMenZhenBean("产科", "12", "25", "30"));
        data.add(new KeShiMenZhenBean("儿科", "15", "21", "11"));
        data.add(new KeShiMenZhenBean("呼吸科", "10", "22", "30"));
        data.add(new KeShiMenZhenBean("口腔科", "20", "21", "10"));
        maxData = getMaxData();

    }

    public void setMaxHeight(int hight) {
        mScreenHeigh = hight;
        k = (mScreenHeigh * 0.3f) / maxData;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {


        //private final RelativeLayout rlShape;
        private TextView tvLineGray;
        private TextView tvLineBlue;
        private TextView tvLineGreen;
        private TextView tvExpert;
        private TextView tvDirector;
        private TextView tvDoctor;
        private TextView tvDeptName;


        public ViewHolder(View itemView) {
            super(itemView);
            //rlShape = ((RelativeLayout) itemView.findViewById(R.id.rl_kenshimenzhen_shape));
//            int w = View.MeasureSpec.makeMeasureSpec(0,
//                    View.MeasureSpec.UNSPECIFIED);
//            int h = View.MeasureSpec.makeMeasureSpec(0,
//                    View.MeasureSpec.UNSPECIFIED);
//            rlShape.measure(w, h);


//            ViewTreeObserver vto2 = rlShape.getViewTreeObserver();
//            vto2.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
//                @Override
//                public void onGlobalLayout() {
//                    rlShape.getViewTreeObserver().removeGlobalOnLayoutListener(this);
//                    mScreenHeigh = rlShape.getMeasuredHeight();
//                }
//            });
            tvLineGray = ((TextView) itemView.findViewById(R.id.tv_line_gray));
            tvLineBlue = ((TextView) itemView.findViewById(R.id.tv_line_blue));
            tvLineGreen = ((TextView) itemView.findViewById(R.id.tv_line_green));


            tvDeptName = ((TextView) itemView.findViewById(R.id.tv_kenshimenzhen_wardName));
            tvExpert = ((TextView) itemView.findViewById(R.id.tv_kenshimenzhen_zhuanjia));
            tvDirector = ((TextView) itemView.findViewById(R.id.tv_kenshimenzhen_zhuren));
            tvDoctor = ((TextView) itemView.findViewById(R.id.tv_kenshimenzhen_zhuzhi));

            //mScreenWidth = rlShape.getMeasuredWidth();
            //  Log.e("ViewHolder", "height:" + height);

        }
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_kenshenmenzhen, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // k = mScreenHeigh / maxData;

        holder.tvDeptName.setText(data.get(position).getDepartName());
        holder.tvExpert.setText(data.get(position).getExpertNum());
        holder.tvDirector.setText(data.get(position).getDirectorNum());
        holder.tvDoctor.setText(data.get(position).getDoctorNum());

        holder.tvLineGray.getLayoutParams().height = ((int) (k * Integer.valueOf(data.get(position).getExpertNum())));
        holder.tvLineBlue.getLayoutParams().height = ((int) (k * Integer.valueOf(data.get(position).getDirectorNum())));
        holder.tvLineGreen.getLayoutParams().height = ((int) (k * Integer.valueOf(data.get(position).getDoctorNum())));

//        // holder.tvLineGray.setHeight(((int) (k * Integer.valueOf(data.get(position).getExpertNum()))));
//        holder.tvLineBlue.setHeight(((int) (k * Integer.valueOf(data.get(position).getDirectorNum()))));
//        holder.tvLineGreen.setHeight(((int) (k * Integer.valueOf(data.get(position).getDoctorNum()))));


    }

    private int getMaxData() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            list.add(Integer.valueOf(data.get(i).getExpertNum()));
            list.add(Integer.valueOf(data.get(i).getDirectorNum()));
            list.add(Integer.valueOf(data.get(i).getDoctorNum()));
        }
        Collections.sort(list);
        return list.get(list.size() - 1);

    }


    @Override
    public int getItemCount() {
        return data != null ? data.size() : 0;
    }
}
