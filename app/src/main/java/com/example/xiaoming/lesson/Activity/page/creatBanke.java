package com.example.xiaoming.lesson.Activity.page;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.xiaoming.lesson.Activity.utils.JsonParse;
import com.example.xiaoming.lesson.Activity.utils.urlPathUtils;
import com.example.xiaoming.lesson.R;

import org.json.JSONException;

import java.net.MalformedURLException;
import java.util.Random;

public class creatBanke extends Activity {
    private EditText classinfo, courseinfo, yunjiaocai;
    private Button creat;
    private String classStr,courseStr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_banke);
        getMyRandom();
        init();
        initEvent();
    }

    private int getMyRandom() {
        Random random = new Random();
        int randNum = random.nextInt(9999);
        return randNum;
    }

    private void initEvent() {
        creat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                访问接口创建班课
                 */
                try {
                    if(onCreateBanke()){
                        Toast.makeText(creatBanke.this, "创建成功！", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(creatBanke.this,firstPage.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(creatBanke.this, "创建失败！", Toast.LENGTH_SHORT).show();
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                    Toast.makeText(creatBanke.this, "网络异常！", Toast.LENGTH_SHORT).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(creatBanke.this, "网络异常！", Toast.LENGTH_SHORT).show();
                }
            }

            private boolean onCreateBanke() throws MalformedURLException, JSONException {
                String urlPath = urlPathUtils.getUrl()+"/lesson/course";
                String param = "{\n" +
                        "\t\"cid\":null,\n" +
                        "\t\"num\":\""+getMyRandom()+"\",\n" +
                        "\t\"className\":\""+classStr+"\",\n" +
                        "\t\"courseName\":\""+courseStr+"\",\n" +
                        "\t\"isSchoolClass\":\"是\"\n" +
                        "}";
                return JsonParse.postCreateBanke(param,urlPath);
            }
        });
    }

    private void init() {
        classinfo = findViewById(R.id.creat_class);
        courseinfo = findViewById(R.id.creat_course);
        yunjiaocai = findViewById(R.id.creat_yunjiaocai);
        creat = findViewById(R.id.creat);
    }


}
