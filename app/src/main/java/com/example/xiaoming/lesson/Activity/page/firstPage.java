package com.example.xiaoming.lesson.Activity.page;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.xiaoming.lesson.Activity.bean.User;
import com.example.xiaoming.lesson.Activity.fragment.BankeFragment;
import com.example.xiaoming.lesson.Activity.fragment.DiscoverFragment;
import com.example.xiaoming.lesson.Activity.fragment.MineFragment;
import com.example.xiaoming.lesson.R;

public class firstPage extends FragmentActivity implements OnClickListener {
    private LinearLayout layout1;
    private LinearLayout layout2;
    private LinearLayout layout3;

    private ImageView image1,image2,image3;
    private TextView t1,t2,t3;

    private Fragment tab1;
    private Fragment tab2;
    private Fragment tab3;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.firstpage);

        Intent intent = this.getIntent();
        user=(User)intent.getSerializableExtra("user");

        initView();
        initEvent();
        setSelect(0);
    }
    /*
     * 初始化点击
     */
    private void initEvent() {
        // TODO Auto-generated method stub
        layout1.setOnClickListener(this);
        layout2.setOnClickListener(this);
        layout3.setOnClickListener(this);
    }
    //初始化
    @SuppressLint("WrongViewCast")
    private void initView() {
        layout1 = (LinearLayout) findViewById(R.id.tab_banke);
        layout2 = (LinearLayout) findViewById(R.id.tab_discover);
        layout3 = (LinearLayout) findViewById(R.id.tab_mine);

        image1 = (ImageView) findViewById(R.id.image_banke);
        image2 = (ImageView) findViewById(R.id.image_discover);
        image3 = (ImageView) findViewById(R.id.image_mine);

        t1 = (TextView) findViewById(R.id.tv_banke);
        t2 = (TextView) findViewById(R.id.tv_discover);
        t3 = (TextView) findViewById(R.id.tv_mine);
    }

    /**
     * 将tab 的text 初始化
     */
    public void reset() {
        image1.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.creative));
        image2.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.discover));
        image3.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.home));

        t1.setText("班课");
        t2.setText("发现");
        t3.setText("我的");
    }

    //设置Fragment内容区域
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
                    tab1=new BankeFragment();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("user",user);//这里的values就是我们要传的值
                    tab1.setArguments(bundle);
                    trs.add(R.id.id_content, tab1);
                }else
                {
                    trs.show(tab1);
                }

                image1.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.creative_fill));
                break;
            case 1:
                if(tab2==null)
                {
                    tab2=new DiscoverFragment();
                    trs.add(R.id.id_content, tab2);
                }else
                {
                    trs.show(tab2);
                }

                image2.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.discover_fill));
                break;

            case 2:
                if(tab3==null)
                {
                    tab3=new MineFragment();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("user",user);//这里的values就是我们要传的值
                    tab3.setArguments(bundle);
                    trs.add(R.id.id_content, tab3);
                }else
                {
                    trs.show(tab3);
                }

                image3.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.home_fill));
                break;

            default:
                break;
        }
        trs.commit();
    }
    /*
     * 隐藏所有的Fragment
     */
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
            case R.id.tab_banke:
                setSelect(0);
                break;
            case R.id.tab_discover:
                setSelect(1);

                break;
            case R.id.tab_mine:
                setSelect(2);
                break;

            default:
                break;
        }
    }
}