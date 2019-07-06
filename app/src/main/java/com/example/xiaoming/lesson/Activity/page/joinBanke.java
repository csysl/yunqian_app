package com.example.xiaoming.lesson.Activity.page;

import android.app.Activity;
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

public class joinBanke extends Activity {
    private EditText banke_id;
    private Button join_commit;
    String id = "";
    String urlPath = urlPathUtils.getUrl()+"/lesson/course/join/";

    public joinBanke() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.join_banke);
        init();
    }

    private void init() {
        banke_id = findViewById(R.id.join_class_id);
        join_commit = findViewById(R.id.join_commit);

        join_commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = String.valueOf(banke_id.getText());
                if(id.equals("")){
                    Toast.makeText(joinBanke.this,"请先输入班课号",Toast.LENGTH_SHORT).show();
                }else{
                    //调用方法
                    urlPath = urlPath + id;
                    try {
                        Toast.makeText(joinBanke.this, JsonParse.joinBanke(urlPath), Toast.LENGTH_SHORT).show();
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }
        });

    }
}
