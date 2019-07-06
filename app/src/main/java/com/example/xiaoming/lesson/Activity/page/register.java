package com.example.xiaoming.lesson.Activity.page;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.xiaoming.lesson.Activity.utils.JsonParse;
import com.example.xiaoming.lesson.R;

import org.json.JSONException;

import java.net.MalformedURLException;


/**
 * Created by chenbo on 2019/5/23.
 */
public class register extends Activity{

    public EditText Student_JobNum,PhoneNum,UserName,Email,PassWord,Comfirm;
    public RadioGroup rg,role;
    public Button submit;
    public String NoStr="",NameStr="",RoleIdStr="",PhoneStr="",EmailStr="",PasswordStr="",SexStr="女";
    public int RoleId = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        rg = (RadioGroup) findViewById(R.id.rg);
        role = (RadioGroup) findViewById(R.id.role);
        submit = (Button) findViewById(R.id.Submit);
        Student_JobNum = (EditText) findViewById(R.id.Student_JobNum);
        PhoneNum = (EditText) findViewById(R.id.PhoneNum);
        UserName = (EditText) findViewById(R.id.UserName);
        Email = (EditText) findViewById(R.id.Email);
        PassWord = (EditText) findViewById(R.id.PassWord);
        Comfirm = (EditText) findViewById(R.id.Comfirm);



        role.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.teacher){
                    RoleId = 1;
                }else {
                    RoleId = 2;
                }
            }
        });


        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.male){
                    SexStr = "男";
                }else {
                    SexStr = "女";
                }
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkForm()){

                    String param = "{\n" +
                            "\t\"no\":\""+NoStr+"\",\n" +
                            "\t\"name\":\""+NameStr+"\",\n" +
                            "\t\"roleId\":"+RoleId+",\n" +
                            "\t\"phone\":\""+PhoneStr+"\",\n" +
                            "\t\"email\":\""+EmailStr+"\",\n" +
                            "\t\"password\":\""+PasswordStr+"\",\n" +
                            "\t\"sex\":\""+SexStr+"\"\n" +
                            "}";
                    try {
                        /*
                        调用提交注册信息表单的方法
                         */
                        String result = JsonParse.postRegisterData(param);
                        Toast.makeText(register.this,result,Toast.LENGTH_SHORT).show();
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                    Intent intent = new Intent(register.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    private boolean checkForm() {
        String studentNum = this.Student_JobNum.getText().toString().trim();
        String userTel = this.PhoneNum.getText().toString().trim();
        String userName = this.UserName.getText().toString().trim();
        String userPwd = this.PassWord.getText().toString().trim();
        String userPwdAgain = this.Comfirm.getText().toString().trim();
        String Email = this.Email.getText().toString().trim();

        NoStr = studentNum;
        PhoneStr = userTel;
        NameStr = userName;
        PasswordStr = userPwd;
        EmailStr = Email;


        if (studentNum.equals("")) {
            Toast.makeText(this, "学工号不能为空", Toast.LENGTH_SHORT).show();
            this.Student_JobNum.requestFocus();
            return false;
        }else if (userTel.length() != 11 && !JudgeTel()) {
            Toast.makeText(this, "手机号输入有误", Toast.LENGTH_SHORT).show();
            this.PhoneNum.requestFocus();
            return false;
        } else if (!JudgeTel()) {
            Toast.makeText(this, "手机号输入有误", Toast.LENGTH_SHORT).show();
            this.PhoneNum.requestFocus();
            return false;
        } else if(userName.equals("")){
            Toast.makeText(this, "用户名不能为空", Toast.LENGTH_SHORT).show();
            this.UserName.requestFocus();
            return false;
        }else if(Email.equals("")){
            Toast.makeText(this, "邮箱不能为空", Toast.LENGTH_SHORT).show();
            this.Email.requestFocus();
            return false;
        }else if (userPwd.equals("")) {
            Toast.makeText(this,"密码不能为空" , Toast.LENGTH_SHORT).show();
            this.PassWord.requestFocus();
            return false;
        } else if (userPwd.length() < 6) {
            Toast.makeText(this, "密码长度不得小于六位", Toast.LENGTH_SHORT).show();
            this.PassWord.requestFocus();
            return false;
        } else if (userPwdAgain.equals("")) {
            Toast.makeText(this, "请再次输入密码", Toast.LENGTH_SHORT).show();
            this.Comfirm.requestFocus();
            return false;
        } else if (!userPwdAgain.equals(userPwd)) {
            Toast.makeText(this, "两次输入密码不一致", Toast.LENGTH_SHORT).show();
            this.PassWord.requestFocus();
            return false;
        }
        return true;
    }

    public boolean JudgeTel() {
        String userTel = this.PhoneNum.getText().toString().trim();
        String[] nk = new String[] { "130", "131", "132", "133", "134", "135",
                "136", "137", "138", "139", "150", "151", "152", "153", "154",
                "155", "156", "157", "158", "159", "170", "180", "181", "182",
                "183", "184", "185", "186", "187", "188", "189" };
        if (userTel.length() == 11) {
            String num = userTel.substring(0, 3);
            int i;
            for (i = 0; i < nk.length; i++)
                if (nk[i].equals(num))
                    break;
            if (i < nk.length) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
