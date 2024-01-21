package com.example.timelineview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    TimelineAdapter timelineAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<CustomKeyframe> keyframesList = generateKeyframes();
        timelineAdapter = new TimelineAdapter(this,keyframesList);
        recyclerView.setAdapter(timelineAdapter);
    }

    private List<CustomKeyframe> generateKeyframes() {
        List<CustomKeyframe> keyframesList = new ArrayList<>();
        keyframesList.add(new CustomKeyframe(R.drawable.black_dot));
        keyframesList.add(new CustomKeyframe(R.drawable.black_dot));
        return keyframesList;
    }
}