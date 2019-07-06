package com.example.xiaoming.lesson.Activity.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xiaoming.lesson.Activity.bean.User;
import com.example.xiaoming.lesson.Activity.page.contactMeActivity;
import com.example.xiaoming.lesson.Activity.page.remain;
import com.example.xiaoming.lesson.R;

public class MineFragment extends Fragment implements View.OnClickListener {
    private View tab3view;
    private TextView titleText,userName;
    User user = null;
    private LinearLayout my_zoom,my_collection,my_heart,my_setting,my_details,my_contact;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,  Bundle savedInstanceState) {
        tab3view=inflater.inflate(R.layout.mine, container, false);
        Bundle bundle = getArguments();
        user = (User) bundle.getSerializable("user");
        userName = tab3view.findViewById(R.id.user_name);
        init();
        if(user.getName()!=null) {
            userName.setText(user.getName());
        }else{
            Toast.makeText(tab3view.getContext(),"网络异常",Toast.LENGTH_SHORT).show();
        }
        titleText = tab3view.findViewById(R.id.title_text);
        titleText.setText("我的");
        return tab3view;
    }

    private void init() {
        my_zoom = tab3view.findViewById(R.id.my_zoom);
        my_collection = tab3view.findViewById(R.id.my_collection);
        my_heart = tab3view.findViewById(R.id.my_heart);
        my_setting = tab3view.findViewById(R.id.my_setting);
        my_details = tab3view.findViewById(R.id.my_details);
        my_contact = tab3view.findViewById(R.id.my_contact);

        my_zoom.setOnClickListener(this);
        my_collection.setOnClickListener(this);
        my_heart.setOnClickListener(this);
        my_setting.setOnClickListener(this);
        my_details.setOnClickListener(this);
        my_contact.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.my_zoom:
                jumpToRemain();
                break;
            case R.id.my_collection:
                jumpToRemain();
                break;
            case R.id.my_heart:
                jumpToRemain();
                break;
            case R.id.my_setting:
                jumpToRemain();
                break;
            case R.id.my_contact:
                Intent intent =  new Intent(tab3view.getContext(),contactMeActivity.class);
                startActivity(intent);
                break;
                default:
                    jumpToRemain();
                    break;

        }
    }

    private void jumpToRemain() {
        Intent intent = new Intent(tab3view.getContext(), remain.class);
        startActivity(intent);
    }
}