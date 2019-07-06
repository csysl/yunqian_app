package com.example.xiaoming.lesson.Activity.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xiaoming.lesson.R;

public class activityFragment extends Fragment {
    private View tabActivity;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        tabActivity=inflater.inflate(R.layout.banke_activity, container, false);
        return tabActivity;
    }
}
