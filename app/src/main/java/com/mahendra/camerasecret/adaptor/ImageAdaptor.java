package com.mahendra.camerasecret.adaptor;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.mahendra.camerasecret.R;

import java.util.ArrayList;
import java.util.List;

public class ImageAdaptor extends RecyclerView.Adapter<ImageAdaptor.ImageViewHolder> {
    List<String> urls = new ArrayList<>();

    public ImageAdaptor(List<String> urls) {
        this.urls = urls;
    }

    public void addImageUrl(String url){
        urls.add(url);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_image_item,viewGroup,false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder imageViewHolder, int i) {
        String url = urls.get(i);
        if(url != null) {
            final Bitmap bitmap = BitmapFactory.decodeFile(urls.get(i));
            final int nh = (int) (bitmap.getHeight() * (512.0 / bitmap.getWidth()));
            final Bitmap scaled = Bitmap.createScaledBitmap(bitmap, 512, nh, true);
            imageViewHolder.imageView.setImageBitmap(scaled);

        }
    }

    @Override
    public int getItemCount() {
        return urls.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
        }
    }
}
