package com.example.shopping2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class MyRecAdapter extends RecyclerView.Adapter<MyRecAdapter.ViewHolder> {
    Context context;
    ArrayList<DataBean> list = new ArrayList<>();
    SparseBooleanArray sparseBooleanArray=new SparseBooleanArray();
    public MyRecAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.rec_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final DataBean dataBean = list.get(i);
        viewHolder.rec_name.setText(dataBean.getTitle());
        viewHolder.rec_num.setText(dataBean.getNum()+"");
        Glide.with(context).load(dataBean.getPic()).into(viewHolder.rec_img);
        viewHolder.rec_check.setTag(i);
        viewHolder.rec_check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                int tag = (int) buttonView.getTag();
                if (isChecked){
                    sparseBooleanArray.put(tag,true);
                }else{
                    sparseBooleanArray.delete(tag);
                }
            }

        });
        viewHolder.rec_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onClickListener(v,dataBean);
            }
        });
        viewHolder.rec_check.setChecked(sparseBooleanArray.get(i));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addData(List<DataBean> data) {
        if (list!=null){
            list.clear();
            list.addAll(data);
            notifyDataSetChanged();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView rec_img;
        private TextView rec_name;
        private TextView rec_num;
        private CheckBox rec_check;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rec_img = itemView.findViewById(R.id.rec_img);
            rec_name = itemView.findViewById(R.id.rec_name);
            rec_num = itemView.findViewById(R.id.rec_num);
            rec_check = itemView.findViewById(R.id.rec_check);
        }
    }
    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener{
        void onClickListener(View v,DataBean dataBean);
    }
}
