package com.example.xiaoming.lesson.Activity.page;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.xiaoming.lesson.Activity.bean.User;
import com.example.xiaoming.lesson.Activity.utils.JsonParse;
import com.example.xiaoming.lesson.Activity.utils.urlPathUtils;
import com.example.xiaoming.lesson.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    List<User> userList = null;
    User user = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //login button
        final Button login = (Button) findViewById(R.id.button);
        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String username = "";
                EditText editText1 = (EditText)findViewById(R.id.editText);
                username = editText1.getText().toString();
                String password = "";
                EditText editText2 = (EditText)findViewById(R.id.editText2);
                password = editText2.getText().toString();
                if (requestForLogin(username,password) && user!=null) {
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, firstPage.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("user", user);
                    intent.putExtras(bundle);
                    startActivity(intent);
                    finish();
                }
                else {
                    new AlertDialog.Builder(MainActivity.this).setTitle("Error!").setMessage("用户名或密码有误，请重新输入")
                            .setNegativeButton("OK",null)
                            .show();
                }
            }
        });
        //register button
        final Button register = (Button) findViewById(R.id.button2);
        register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, register.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private boolean requestForLogin(String username, String password) {
        String urlPath = urlPathUtils.getUrl()+"/lesson/passport/vueLogin?userName=" + username + "&passWord="+ password;
        try{
            userList = JsonParse.getLogin(urlPath);
            List<HashMap<String, Object>> data = new ArrayList<HashMap<String, Object>>();
            for (int i = 0; i < userList.size(); i++) {
                user = userList.get(i);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
}