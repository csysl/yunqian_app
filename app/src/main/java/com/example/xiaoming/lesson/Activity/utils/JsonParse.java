package com.example.xiaoming.lesson.Activity.utils;

import android.util.Log;

import com.example.xiaoming.lesson.Activity.bean.Course;
import com.example.xiaoming.lesson.Activity.bean.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class JsonParse {

    /**

     * 解析Json数据

     *

     * @return mlists

     * @throws Exception

     */


    /*
    访问登录接口
     */
    public static List<User> getLogin(String urlPath) throws Exception {

        List<User> mlists = new ArrayList<User>();
        User user = new User();
        String data = getJsonByUrl(urlPath);
        JSONObject jsonObject = new JSONObject(data);
        JSONObject dataObject = jsonObject.getJSONObject("data");
        JSONObject accountObject = dataObject.getJSONObject("account");

        user.setName(accountObject.getString("name"));
        user.setPhone(accountObject.getString("phone"));
        user.setNo(accountObject.getString("no"));
        user.setId(accountObject.getInt("id"));
        user.setEmail(accountObject.getString("email"));
        user.setPassword(accountObject.getString("password"));
        user.setRoleId(accountObject.getInt("roleId"));
        user.setSex(accountObject.getString("sex"));

        mlists.add(user);

        return mlists;

    }


    /*
    POST发送注册的表单数据给后端
     */
    public static String postRegisterData(String param) throws MalformedURLException, JSONException {
        String result = "";
        String postPath = urlPathUtils.getUrl()+"/lesson/user/create";
        URL url = null;
        BufferedReader reader = null;
        try {
            url = new URL(postPath);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(false);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Connection", "Keep-Alive");
            //connection.setRequestProperty("Content-Length", String.valueOf(parma.length()));
            connection.setRequestProperty("Content-Type","application/json; charset=UTF-8");
            connection.setRequestProperty("accept","application/json");

            OutputStream out = connection.getOutputStream();
            out.write(param.getBytes());
            out.flush();
            out.close();
            if (connection.getResponseCode()==200){
                reader = new BufferedReader(
                        new InputStreamReader(connection.getInputStream()));
                result = reader.readLine();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        JSONObject jsonObject = new JSONObject(new String(result));
        String isSuccess = jsonObject.getString("message");
        return isSuccess;
    }


    /*
    访问查询所有班课接口获取某个用户的所有班课
     */
    public static List<Course> getBankeList() throws Exception {
        String urlPath = urlPathUtils.getUrl()+"/lesson/course/getCourseUserVO/1/15";
        List<Course> bankeList = new ArrayList<>();
        Course course = null;
        User createUser = null;
        String json = getJsonByUrl(urlPath);
        JSONObject record = null;

        JSONObject data = new JSONObject(json);
        JSONObject data1 = data.getJSONObject("data");
        JSONObject data2 = data1.getJSONObject("data");
        JSONArray records = data2.getJSONArray("records");

        for(int i=0;i<records.length();i++){
            course = new Course();
            createUser = new User();
            record = records.getJSONObject(i);
            JSONObject user = record.getJSONObject("createUser");
            course.setClassName(record.getString("className"));
            course.setCourseName(record.getString("courseName"));

            createUser.setName(user.getString("name"));
            createUser.setId(user.getInt("id"));
            createUser.setPhone(user.getString("phone"));
            createUser.setEmail(user.getString("email"));
            createUser.setPassword(user.getString("password"));
            createUser.setRoleId(user.getInt("roleId"));

            course.setCreater(createUser);
            course.setNum(record.getString("num"));
            course.setId(record.getInt("cid"));
            bankeList.add(course);
        }
        return bankeList;
    }


    /*
     访问添加班课的接口来创建班课
     */
    public static Boolean postCreateBanke(String param,String urlPath) throws MalformedURLException, JSONException {
        try {
            String json = getJsonByUrl(urlPath);
            JSONObject data = new JSONObject(json);
            Boolean isSuccess = data.getBoolean("success");
            return isSuccess;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }



    /*
    访问加入班课接口，使用班课号加入班课
     */
    public static String joinBanke(String urlPath) throws MalformedURLException, JSONException {
        try {
            String json = getJsonByUrl(urlPath);
            JSONObject data = new JSONObject(json);
            String message = data.getString("message");
            return message;
        } catch (Exception e) {
            e.printStackTrace();
            return "网络错误";
        }
    }



    /*
     访问发起签到接口，根据返回值确认是否成功发起签到
     */
    public static String postStartSignup(String param) throws MalformedURLException, JSONException {
        String result = "";
        String postPath = urlPathUtils.getUrl()+"/lesson/launch_signin";
        URL url = null;
        BufferedReader reader = null;
        try {
            url = new URL(postPath);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            if (session_id != null) {
                connection.setRequestProperty("Cookie", session_id);//设置sessionid
            }
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(false);
            connection.setConnectTimeout(3000);
            connection.setRequestMethod("POST");
            //connection.setRequestProperty("Content-Length", String.valueOf(parma.length()));
            connection.setRequestProperty("Content-Type","application/json; charset=UTF-8");
            connection.setRequestProperty("accept","application/json");

            OutputStream out = connection.getOutputStream();
            out.write(param.getBytes());
            out.flush();
            out.close();
            String cookieval = connection.getHeaderField("Set-Cookie");
            if (cookieval != null) {
                session_id = cookieval.substring(0, cookieval.indexOf(";"));//获取sessionid
            }
            Log.i("test", String.valueOf(connection.getResponseCode()));
            if (connection.getResponseCode()==200){
                reader = new BufferedReader(
                        new InputStreamReader(connection.getInputStream()));
                result = reader.readLine();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        JSONObject jsonObject = new JSONObject(new String(result));
        String isSuccess = jsonObject.getString("message");
        return isSuccess;
    }


    /*
    访问参与签到的接口
     */
    public static String postJoinSignup(String param) throws MalformedURLException, JSONException {
        String result = "";
        String postPath = urlPathUtils.getUrl()+"/lesson/signin/join";
        URL url = null;
        BufferedReader reader = null;
        try {
            url = new URL(postPath);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            if (session_id != null) {
                connection.setRequestProperty("Cookie", session_id);//设置sessionid
            }
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(false);
            connection.setConnectTimeout(3000);
            connection.setRequestMethod("POST");
            //connection.setRequestProperty("Content-Length", String.valueOf(parma.length()));
            connection.setRequestProperty("Content-Type","application/json; charset=UTF-8");
            connection.setRequestProperty("accept","application/json");

            OutputStream out = connection.getOutputStream();
            out.write(param.getBytes());
            out.flush();
            out.close();
            String cookieval = connection.getHeaderField("Set-Cookie");
            if (cookieval != null) {
                session_id = cookieval.substring(0, cookieval.indexOf(";"));//获取sessionid
            }
            Log.i("test", String.valueOf(connection.getResponseCode()));
            if (connection.getResponseCode()==200){
                reader = new BufferedReader(
                        new InputStreamReader(connection.getInputStream()));
                result = reader.readLine();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        JSONObject jsonObject = new JSONObject(new String(result));
        String isSuccess = jsonObject.getString("message");
        return isSuccess;
    }



    /*
    访问接口查询某个班课中的所有学生
     */
    public static List<User> getBankeStudent(String urlPath) throws MalformedURLException, JSONException {

        List<User> studentList = new ArrayList<>();
        User user = null;
        JSONObject job = null;
        try {
            String json = getJsonByUrl(urlPath);
            JSONObject data = new JSONObject(json);
            JSONObject data1 = data.getJSONObject("data");
            JSONArray data2 = data1.getJSONArray("data");

            for(int i=0;i<data2.length();i++){
                job = data2.getJSONObject(i);
                user = new User();
                user.setName(job.getString("name"));
                studentList.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return studentList;
    }


    /**

     * 从指定的url中获取字节数组

     *

     * @param urlPath

     * @return 字节数组

     * @throws Exception

     */

    public static byte[] readParse(String urlPath) throws Exception {

        ByteArrayOutputStream outStream = new ByteArrayOutputStream();

        byte[] data = new byte[1024];

        int len = 0;

        URL url = new URL(urlPath);

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        int code = conn.getResponseCode();
        Log.i("响应码", "响应码是" + code);

        InputStream inStream = conn.getInputStream();

        while ((len = inStream.read(data)) != -1) {

            outStream.write(data, 0, len);

        }

        inStream.close();

        return outStream.toByteArray();

    }


     /*
    通过URL访问获取返回的JSON数据
     */

    private static String session_id = null;
    public static String getJsonByUrl(String urlPath) throws Exception {
        String result = null;// 请求返回的字符串
        try {
            URL url = new URL(urlPath);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            if (session_id != null) {
                con.setRequestProperty("Cookie", session_id);//设置sessionid
            }
            InputStream is = con.getInputStream();
            String cookieval = con.getHeaderField("Set-Cookie");
            if (cookieval != null) {
                session_id = cookieval.substring(0, cookieval.indexOf(";"));//获取sessionid
                Log.i("SESSION", "session_id=" + session_id);
            }
            int resquestCode = con.getResponseCode();
            Log.i("响应码", "响应码是" + resquestCode);


            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = is.read(buffer)) > 0) {
                bos.write(buffer, 0, len);
            }
            bos.flush();
            is.close();
            byte[] resultbyte = bos.toByteArray();
            result = bos.toString();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;

    }

}