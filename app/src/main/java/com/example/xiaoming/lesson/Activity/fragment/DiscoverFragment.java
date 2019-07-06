package com.example.xiaoming.lesson.Activity.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.xiaoming.lesson.Activity.page.remain;
import com.example.xiaoming.lesson.R;
public class DiscoverFragment extends Fragment {
    private View tab2view;
    private TextView titleText;
    /*
    课程圈
     */
    private LinearLayout kechengquan,secondCourse;
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,  Bundle savedInstanceState) {
        tab2view=inflater.inflate(R.layout.discover, container, false);
        titleText = tab2view.findViewById(R.id.title_text);
        titleText.setText("发现");
        kechengquan = tab2view.findViewById(R.id.kechengquan);
        secondCourse = tab2view.findViewById(R.id.secondCourse);
        kechengquan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tab2view.getContext(),remain.class);
                startActivity(intent);
            }
        });
        secondCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tab2view.getContext(),remain.class);
                startActivity(intent);
            }
        });

        return tab2view;
    }
}
