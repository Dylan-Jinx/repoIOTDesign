package com.example.nutritional.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nutritional.R;
import com.example.nutritional.bean.info.ItemInfo;
import com.example.nutritional.fragment.main.parent.ParentFragment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author 69182
 */
public
class ParentInfoAdapter extends RecyclerView.Adapter<ParentInfoAdapter.ViewHolder> implements View.OnClickListener {


    public ParentInfoAdapter(List<ItemInfo> infoList, List<ItemInfo> infoList1, Context mContext) {
        this.infoList = infoList;
        this.infoList1 = infoList1;
        this.mContext = mContext;
    }

    List<ItemInfo> infoList;
    List<ItemInfo> infoList1;
    Context mContext;
    int flag = 0;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main1, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        view.setOnClickListener(this);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        if (position % 2 != 0) {
//            holder.main1_img1.setImageResource(infoList.get(position+1).imgId);
//            holder.main1_text1.setText(infoList.get(position+1).text);
//            holder.main1_img.setImageResource(infoList.get(position).imgId);
//            holder.main1_text.setText(infoList.get(position).text);
//        } else {
//            holder.main1_img1.setImageResource(infoList.get(position).imgId);
//            holder.main1_text1.setText(infoList.get(position).text);
//            holder.main1_img.setImageResource(infoList.get(position + 1).imgId);
//            holder.main1_text.setText(infoList.get(position + 1).text);
//        }
        //将position保存在itemView的Tag中，以便点击时进行获取

        holder.itemView.getTag(position);
        holder.main1_img.setImageResource(infoList.get(position).imgId);
        holder.main1_text.setText(infoList.get(position).text);
        holder.main1_img1.setImageResource(infoList1.get(position).imgId);
        holder.main1_text1.setText(infoList1.get(position).text);
    }


    @Override
    public int getItemCount() {
        return infoList.size();
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView main1_img;
        public TextView main1_text;
        public LinearLayout line1;
        public ImageView main1_img1;
        public TextView main1_text1;
        public LinearLayout line2;
//        public ImageView main1_img2;
//        public TextView main1_text2;
//        public LinearLayout line3;
//        public ImageView main1_img3;
//        public TextView main1_text3;
//        public LinearLayout line4;

        public ViewHolder(View rootView) {
            super(rootView);
            this.main1_img = (ImageView) rootView.findViewById(R.id.main1_img);
            this.main1_text = (TextView) rootView.findViewById(R.id.main1_text);
            this.line1 = (LinearLayout) rootView.findViewById(R.id.line1);
            this.main1_img1 = (ImageView) rootView.findViewById(R.id.main1_img1);
            this.main1_text1 = (TextView) rootView.findViewById(R.id.main1_text1);
            this.line2 = (LinearLayout) rootView.findViewById(R.id.line2);
//            this.main1_img2 = (ImageView) rootView.findViewById(R.id.main1_img2);
//            this.main1_text2 = (TextView) rootView.findViewById(R.id.main1_text2);
//            this.line3 = (LinearLayout) rootView.findViewById(R.id.line3);
//            this.main1_img3 = (ImageView) rootView.findViewById(R.id.main1_img3);
//            this.main1_text3 = (TextView) rootView.findViewById(R.id.main1_text3);
//            this.line4 = (LinearLayout) rootView.findViewById(R.id.line4);
        }

    }

    private OnRecyclerViewItemClickListener mOnItemClickListener = null;

    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }


    public enum ViewName {
        ITEM,
        PRACTISE
    }


    public interface OnRecyclerViewItemClickListener {
        void onClick(View view, int position);
    }

    @Override
    public void onClick(View v) {
        int position = (int) v.getTag();
        if (mOnItemClickListener != null) {
            switch (v.getId()) {
                default:
                    mOnItemClickListener.onClick(v, position);
                    break;
            }
        }
    }
}
