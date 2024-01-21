package com.example.timelineview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TimelineAdapter extends RecyclerView.Adapter<TimelineAdapter.ViewHolder> {
    private final List<CustomKeyframe> keyframes;
    Context context;

    public TimelineAdapter(MainActivity mainActivity, List<CustomKeyframe> keyframes){
        this.keyframes = keyframes;
        this.context = mainActivity;
    }
    static class ViewHolder extends RecyclerView.ViewHolder{

        ImageButton keyframeImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            keyframeImage = itemView.findViewById(R.id.imageButton);
        }
        public void bind(CustomKeyframe keyframe){
            int imageResourceId = keyframe.getDrawableResource();
            keyframeImage.setImageResource(imageResourceId);
        }
    }
    @NonNull
    @Override
    public TimelineAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.keyframe,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TimelineAdapter.ViewHolder holder, int position) {
        CustomKeyframe keyframe = keyframes.get(position);
        holder.bind(keyframe);
    }

    @Override
    public int getItemCount() {
        return keyframes.size();
    }
}
