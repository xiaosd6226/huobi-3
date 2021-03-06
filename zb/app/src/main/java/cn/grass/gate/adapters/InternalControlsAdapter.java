package cn.grass.gate.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;

import cn.grass.gate.R;
import cn.grass.gate.beans.BaseInfo;
import cn.grass.gate.inface.GItemClickListener;

/**
 * Created by linxc on 2017/7/24.
 */
public class InternalControlsAdapter extends RecyclerView.Adapter<InternalControlsHolder>{

    Context context;
    ArrayList<BaseInfo> data;
    public InternalControlsAdapter(Context c, ArrayList<BaseInfo> list){
        context =c;
        data = list;
    }

    public GItemClickListener listener;
    public void setItemClickListener(GItemClickListener l){
        this.listener = l;
    }


    @Override
    public InternalControlsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View vs= LayoutInflater.from(context).inflate(R.layout.item_internal_controls,null,false);
        return new InternalControlsHolder(vs,listener);
    }

    @Override
    public void onBindViewHolder(InternalControlsHolder holder, int position) {
        if (data!=null){
            holder.titleTv.setText(data.get(position).name);
            Glide.with(context).load(data.get(position).icon).asBitmap()
                    .centerCrop().diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(R.mipmap.icon_default_image)
                    .into(holder.iconIgv);

        }
    }

    @Override
    public int getItemCount() {
        return data==null?0:data.size();
    }
}
