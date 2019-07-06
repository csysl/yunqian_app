package com.example.xiaoming.lesson.Activity.page;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import com.example.xiaoming.lesson.Activity.bean.Course;
import com.example.xiaoming.lesson.Activity.bean.User;
import com.example.xiaoming.lesson.Activity.utils.JsonParse;
import com.example.xiaoming.lesson.R;

import org.json.JSONException;

import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SigninActivity extends Activity {
    private Button startSignin;
    User user;
    Course banke;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.start_signin);

        Intent intent = this.getIntent();
        user=(User)intent.getSerializableExtra("user");
        banke=(Course) intent.getSerializableExtra("banke");
        startSignin = findViewById(R.id.start_signin);

        startSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// HH:mm:ss 获取当前时间
                Date date = new Date(System.currentTimeMillis());
                String param = "{\n" +
                        "\t\"currentTime\":\""+simpleDateFormat.format(date)+"\",\n" +
                        "\t\"cid\":"+banke.getId()+"\n" +
                        "}";
                try {
                    Toast.makeText(SigninActivity.this, JsonParse.postStartSignup(param), Toast.LENGTH_SHORT).show();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
