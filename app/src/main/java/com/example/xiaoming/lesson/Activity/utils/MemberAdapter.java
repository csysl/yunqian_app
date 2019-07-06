package com.example.xiaoming.lesson.Activity.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xiaoming.lesson.Activity.bean.User;
import com.example.xiaoming.lesson.R;

import java.util.List;

public class MemberAdapter extends ArrayAdapter {
    private final int resourceId;
    public MemberAdapter(Context context, int textViewResourceId, List<User> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        User user = (User) getItem(position); // 获取当前项的Fruit实例
        View view = LayoutInflater.from(getContext()).inflate(resourceId, null);//实例化一个对象

        ImageView touxiangImage = (ImageView) view.findViewById(R.id.user_touxiang);//获取该布局内的图片视图
        TextView memberName = (TextView) view.findViewById(R.id.member_name);//获取该布局内的文本视图
        TextView memberNo = (TextView) view.findViewById(R.id.member_No);//获取该布局内的文本视图


        memberName.setText(user.getName());//为文本视图设置文本内容
        memberNo.setText(user.getNo());//为文本视图设置文本内容
        return view;
    }
}
