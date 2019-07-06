package com.example.xiaoming.lesson.Activity.page;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.xiaoming.lesson.Activity.bean.Course;
import com.example.xiaoming.lesson.Activity.bean.User;
import com.example.xiaoming.lesson.Activity.fragment.MemberFragment;
import com.example.xiaoming.lesson.Activity.fragment.activityFragment;
import com.example.xiaoming.lesson.Activity.fragment.detailFragment;
import com.example.xiaoming.lesson.R;

public class bankeDetail extends FragmentActivity implements View.OnClickListener {
    private LinearLayout layout1;
    private LinearLayout layout2;
    private LinearLayout layout3;

    private ImageView image1,image2,image3;

    private Fragment tab1;
    private Fragment tab2;
    private Fragment tab3;

    User user = null;
    Course banke = null;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.bankedetail);
        Intent intent = this.getIntent();
        user=(User)intent.getSerializableExtra("user");
        banke=(Course) intent.getSerializableExtra("banke");
        initView();
        initEvent();
        setSelect(0);

    }
    private void initView() {
        layout1 = (LinearLayout) findViewById(R.id.tab_member);
        layout2 = (LinearLayout) findViewById(R.id.tab_activity);
        layout3 = (LinearLayout) findViewById(R.id.tab_detail);

        image1 = (ImageView) findViewById(R.id.image_member);
        image2 = (ImageView) findViewById(R.id.image_activity);
        image3 = (ImageView) findViewById(R.id.image_detail);
    }

    private void initEvent() {
        layout1.setOnClickListener(this);
        layout2.setOnClickListener(this);
        layout3.setOnClickListener(this);
    }

    private void setSelect(int i) {
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction trs=fm.beginTransaction();

        //隐藏Fragment
        hideFragment(trs);

        // 把text 切换为选中
        switch (i) {
            case 0:
                if(tab1==null)
                {
                    tab1=new MemberFragment();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("user",user);//这里的values就是我们要传的值
                    bundle.putSerializable("banke",banke);
                    tab1.setArguments(bundle);
                    trs.add(R.id.banke_detail_content, tab1);
                }else
                {
                    trs.show(tab1);
                }

                image1.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.member_fill));
                break;
            case 1:
                if(tab2==null)
                {
                    tab2=new activityFragment();
                    trs.add(R.id.banke_detail_content, tab2);
                }else
                {
                    trs.show(tab2);
                }

                image2.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.activity_fill));
                break;

            case 2:
                if(tab3==null)
                {
                    tab3=new detailFragment();
                    trs.add(R.id.banke_detail_content, tab3);
                }else
                {
                    trs.show(tab3);
                }

                image3.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.detail_fill));
                break;

            default:
                break;
        }
        trs.commit();
    }

    public void reset() {
        image1.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.member));
        image2.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.activity));
        image3.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.detail));
    }


    private void hideFragment(FragmentTransaction trs) {

        if(tab1!=null)
        {
            trs.hide(tab1);
        }
        if(tab2!=null)
        {
            trs.hide(tab2);
        }
        if(tab3!=null)
        {
            trs.hide(tab3);
        }

    }


    @Override
    public void onClick(View v) {
        reset();
        switch (v.getId()) {
            case R.id.tab_member:
                setSelect(0);
                break;
            case R.id.tab_activity:
                setSelect(1);

                break;
            case R.id.tab_detail:
                setSelect(2);
                break;

            default:
                break;
        }
    }
}
