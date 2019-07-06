package com.example.xiaoming.lesson.Activity.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.xiaoming.lesson.Activity.bean.Course;
import com.example.xiaoming.lesson.Activity.bean.User;
import com.example.xiaoming.lesson.Activity.page.SigninActivity;
import com.example.xiaoming.lesson.Activity.page.joinSigninActivity;
import com.example.xiaoming.lesson.Activity.utils.JsonParse;
import com.example.xiaoming.lesson.Activity.utils.MemberAdapter;
import com.example.xiaoming.lesson.Activity.utils.urlPathUtils;
import com.example.xiaoming.lesson.R;

import org.json.JSONException;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

public class MemberFragment extends Fragment implements AdapterView.OnItemClickListener{
    private View tabMember;
    private List<User> memberList = new ArrayList<User>();
    private ListView list_member;
    private TextView count,join_signin;
     private LinearLayout qiandao;
    User user=null;
    Course banke=null;
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        tabMember=inflater.inflate(R.layout.member, container, false);
        Bundle bundle = getArguments();
        user = (User) bundle.getSerializable("user");
        banke = (Course) bundle.getSerializable("banke");
        init();
        qiandao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isCreateUser(user,banke)){
                    /*
                    跳往发起签到页面
                     */
                    Intent intent = new Intent(tabMember.getContext(),SigninActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("user", user);
                    bundle.putSerializable("banke",banke);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }else{
                    /*
                    跳往参与签到页面
                     */
                    Intent intent = new Intent(tabMember.getContext(),joinSigninActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("user", user);
                    bundle.putSerializable("banke",banke);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }

            }
        });

        /*
        根据当前用户和班课信息里的创建者来判断当前用户是否当前班课创建者
         */
        if(isCreateUser(user,banke)){
            join_signin.setText("发起签到");
        }else{
            join_signin.setText("参与签到");
        }

        MemberAdapter bankeAdapter = new MemberAdapter(tabMember.getContext(),R.layout.item_list_banke_member,memberList);
        list_member.setAdapter(bankeAdapter);
        list_member.setOnItemClickListener(this);
        return tabMember;
    }

    private boolean isCreateUser(User user,Course banke) {
        /*
        登录账号、用户名、用户ID相同，是同一个用户
         */
        if(user.getName().equals(banke.getCreater().getName()) && user.getPhone().equals(banke.getCreater().getPhone())){
            return true;
        }
        return false;
    }

    private void init() {
        list_member = tabMember.findViewById(R.id.banke_member);
        count = tabMember.findViewById(R.id.count_member);
        qiandao = tabMember.findViewById(R.id.qiandao);
        join_signin = tabMember.findViewById(R.id.join_signin);
         /*
        为ListView设置数据源
         */
        try {
            String urlPath = urlPathUtils.getUrl()+"/lesson/course/getStuByCourse/"+40;
            memberList = JsonParse.getBankeStudent(urlPath);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //count.setText(memberList.size());
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
