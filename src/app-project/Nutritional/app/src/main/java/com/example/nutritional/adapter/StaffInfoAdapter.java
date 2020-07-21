package com.example.nutritional.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.nutritional.R;
import com.example.nutritional.bean.info.ItemInfo;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author 69182
 */
public
class StaffInfoAdapter extends RecyclerView.Adapter<StaffInfoAdapter.ViewHolder> implements View.OnClickListener{

    public StaffInfoAdapter(List<ItemInfo> infoList) {
        this.infoList = infoList;
    }

    List<ItemInfo> infoList;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        view.setOnClickListener(this);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.itemView.setTag(position);
        holder.mainImg.setImageResource(infoList.get(position).imgId);
        holder.mainText.setText(infoList.get(position).text);
//        holder.setData(infoList.get(position), position);
    }


    @Override
    public int getItemCount() {
        return infoList.size();
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView mainImg;
        public TextView mainText;

        public ViewHolder(View rootView) {
            super(rootView);
            this.mainImg = (ImageView) rootView.findViewById(R.id.main_img);
            this.mainText = (TextView) rootView.findViewById(R.id.main_text);
        }

//        public void setData(ItemInfo imgId, int position) {
//            if (imgId != null) {
//                int id =  imgId.getImgId();
//                mainImg.setImageResource(id);
//                //需要Item高度不同才能出现瀑布流的效果，此处简单粗暴地设置一下高度
//                if (position % 2 == 0) {
//                    mainImg.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 200));
//                } else {
//                    mainImg.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 250));
//                }
//            }
//        }
    }

    private ParentInfoAdapter.OnRecyclerViewItemClickListener mOnItemClickListener = null;

    public void setOnItemClickListener(ParentInfoAdapter.OnRecyclerViewItemClickListener listener) {
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
        //注意这里使用getTag方法获取数据
        int position = (int) v.getTag();
        if (mOnItemClickListener != null) {
            switch (v.getId()) {
                case R.id.line1:
                    mOnItemClickListener.onClick(v, position);
                    break;
                default:
            }
        }
    }

}
