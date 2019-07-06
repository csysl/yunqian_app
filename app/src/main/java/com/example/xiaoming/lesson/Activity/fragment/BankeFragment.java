package com.example.xiaoming.lesson.Activity.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.xiaoming.lesson.Activity.bean.Course;
import com.example.xiaoming.lesson.Activity.bean.User;
import com.example.xiaoming.lesson.Activity.page.bankeDetail;
import com.example.xiaoming.lesson.Activity.page.creatBanke;
import com.example.xiaoming.lesson.Activity.page.joinBanke;
import com.example.xiaoming.lesson.Activity.utils.BankeAdapter;
import com.example.xiaoming.lesson.Activity.utils.JsonParse;
import com.example.xiaoming.lesson.R;

import java.util.ArrayList;
import java.util.List;

public class BankeFragment extends Fragment implements AdapterView.OnItemClickListener{
    private View tab1view;
    private TextView titleText;
    private ListView list_banke;
    private Button creat_banke;
    private PopupWindow popupWindow;
    User user=null;

    private List<Course> courseList = new ArrayList<Course>();

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,  Bundle savedInstanceState) {
        tab1view=inflater.inflate(R.layout.banke, container, false);
        Bundle bundle = getArguments();
        user = (User) bundle.getSerializable("user");
        init();
        BankeAdapter bankeAdapter = new BankeAdapter(tab1view.getContext(),R.layout.item_list_app,courseList);
        list_banke.setAdapter(bankeAdapter);
        list_banke.setOnItemClickListener(this);
        return tab1view;
    }



    private void init() {
        list_banke = tab1view.findViewById(R.id.list_banke);
        creat_banke = tab1view.findViewById(R.id.title_edit);

        creat_banke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowChoise();

            }
        });

        titleText = tab1view.findViewById(R.id.title_text);
        titleText.setText("班课");

        /*
        为ListView设置数据源
        */
        try {
            courseList = JsonParse.getBankeList();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void ShowChoise()
    {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(),android.R.style.Theme_Holo_Light_Dialog);
        //builder.setIcon(R.drawable.ic_launcher);
        builder.setTitle("请选择");
        //    指定下拉列表的显示数据
        final String[] options = {"新建班课", "加入已有班课"};
        //    设置一个下拉的列表选择项
        builder.setItems(options, new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                if (options[which].equals("新建班课")){
                    Intent intent = new Intent(tab1view.getContext(), creatBanke.class);
                    startActivity(intent);
                }else{
                    Intent intent = new Intent(tab1view.getContext(), joinBanke.class);
                    startActivity(intent);
                }
            }
        });
        builder.show();
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //通过位置获取所点击的item对应的Course
        Course banke = courseList.get(position);
        if(banke!=null){
            Intent intent = new Intent(tab1view.getContext(),bankeDetail.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("user", user);
            bundle.putSerializable("banke",banke);
            intent.putExtras(bundle);
            startActivity(intent);
        }

    }
}