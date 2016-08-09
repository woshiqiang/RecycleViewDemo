package com.sanmiao.recycleviewdemo;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by Administrator on 2016/8/8 0008.
 */
public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ViewHolder> {

    private LayoutInflater mInflater;
    private List<String> mDatas;

    public GalleryAdapter(LayoutInflater mInflater, List<String> mDatas) {
        this.mInflater = mInflater;
        this.mDatas = mDatas;
    }

    //创建ViewHolder
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_1,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.mImg = (SimpleDraweeView) view.findViewById(R.id.id_index_gallery_item_image);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mImg.setAspectRatio(1.0f);
        Uri parse = Uri.parse(mDatas.get(position));
//        holder.mImg.setImageURI(parse);
        ControllerListener listener = new BaseControllerListener();

//        DraweeController controller = Fresco.newDraweeControllerBuilder()
//                .setUri(parse)
//                .setTapToRetryEnabled(true)
//                .setOldController(holder.mImg.getController())
//                .setControllerListener(listener)
//                .build();
//
//        holder.mImg.setController(controller);

//        ImageRequest request = ImageRequestBuilder.newBuilderWithSource(parse)
//                .setProgressiveRenderingEnabled(true)
//                .build();
//        DraweeController controller = Fresco.newDraweeControllerBuilder()
//                .setImageRequest(request)
//                .setOldController(  holder.mImg.getController())
//                .build();


        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(parse)
                .setAutoPlayAnimations(true)
               // . // 其他设置（如果有的话）
        .build();
        holder.mImg.setController(controller);
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View arg0) {
            super(arg0);
        }

        SimpleDraweeView mImg;
        TextView mTxt;
    }


}
