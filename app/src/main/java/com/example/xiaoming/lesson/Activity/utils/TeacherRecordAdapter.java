package com.example.xiaoming.lesson.Activity.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.xiaoming.lesson.Activity.bean.Course;
import com.example.xiaoming.lesson.R;

import java.util.List;

public class TeacherRecordAdapter extends ArrayAdapter {
    private final int resourceId;
    public TeacherRecordAdapter(Context context, int textViewResourceId, List<Course> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        Course course = (Course) getItem(position); // 获取当前项的Fruit实例
        View view = LayoutInflater.from(getContext()).inflate(resourceId, null);//实例化一个对象

        ImageView courseImage = (ImageView) view.findViewById(R.id.item_image);//获取该布局内的图片视图
        TextView className = (TextView) view.findViewById(R.id.ClassName);//获取该布局内的文本视图
        TextView courseName = (TextView) view.findViewById(R.id.CourseName);//获取该布局内的文本视图
        TextView creater = (TextView) view.findViewById(R.id.creater);//获取该布局内的文本视图


        className.setText(course.getClassName());//为文本视图设置文本内容
        courseName.setText(course.getCourseName());//为文本视图设置文本内容
        creater.setText(course.getCreater().getName());//为文本视图设置文本内容
        return view;
    }
}
