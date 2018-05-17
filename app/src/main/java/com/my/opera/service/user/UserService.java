package com.my.opera.service.user;

import android.app.Activity;
import android.content.Intent;
import android.widget.Adapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.my.opera.MainActivity;
import com.my.opera.R;
import com.my.opera.adapter.UserAdapter;
import com.my.opera.pojo.User;
import com.my.opera.util.Connect;
import com.parkingwang.okhttp3.LogInterceptor.LogInterceptor;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by MY on 2018/5/6.
 */

public class UserService {
    //信工院 http://10.11.73.135:8080/User/register.do
    //edu 172.17.34.1:8080
    private OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .addInterceptor(new LogInterceptor()).build();

    public void userLogin(User user, final Activity activity) {
//        OkHttpClient okHttpClient=new OkHttpClient.Builder()
//                .readTimeout(5, TimeUnit.SECONDS)
//                .build();
        RequestBody body = new FormBody.Builder()
                .add("username", user.getUsername())
                .add("pwd", user.getPwd())
                .build();

        final Request request = new Request.Builder()
                .url(Connect.URL + "/User/login.do")
                .post(body).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("登陆失败");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                if (result.equals("success")) {
                    System.out.println("Y!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//                    Toast.makeText(activity,"登陆成功，即将跳转",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(activity, MainActivity.class);
                    activity.startActivity(intent);
                    activity.finish();//返回直接退出程序
                } else {
//                    Toast.makeText(activity,"登陆失败",Toast.LENGTH_SHORT).show();
                    System.out.println("NO!!!!!!!!!!!!!!!!");
                }

            }
        });
    }

    //信工院 http://10.11.73.135:8080/User/register.do
    //edu 172.17.34.1:8080
    public void userRegister(User user, final Activity activity) {
//        OkHttpClient okHttpClient=new OkHttpClient.Builder()
//                .readTimeout(5, TimeUnit.SECONDS)
//                .build();
        RequestBody body = new FormBody.Builder()
                .add("username", user.getUsername())
                .add("pwd", user.getPwd())
                .add("address", user.getAddress())
                .build();

        final Request request = new Request.Builder()
                .url(Connect.URL + "/User/register.do")
                .post(body).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("注册失败");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                if (result.equals("success")) {
                    System.out.println("YR!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

                    Intent intent = new Intent(activity, MainActivity.class);
                    activity.startActivity(intent);
                    activity.finish();//返回直接退出程序
                } else {

                    System.out.println("NoRegister!!!!!!!!!!!!!!!!");
                }

            }
        });
    }
    //删除
    public void userDelete(User user, final Activity activity) {
//    OkHttpClient okHttpClient=new OkHttpClient.Builder()
//            .readTimeout(5, TimeUnit.SECONDS)
//            .build();
        RequestBody body = new FormBody.Builder()
                .add("username", user.getUsername())
                .build();
        final Request request = new Request.Builder()
                .url(Connect.URL + "/User/delete.do")
                .post(body).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("删除失败");
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                if (result.equals("1")) {
                    System.out.println("YD!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

                    Intent intent = new Intent(activity, MainActivity.class);
                    activity.startActivity(intent);
                    activity.finish();//返回直接退出程序
                } else {

                    System.out.println("NoD!!!!!!!!!!!!!!!!");
                }

            }
        });
    }

    //修改用户
    public void userUpdate(User user, final Activity activity) {
        RequestBody body = new FormBody.Builder()
                .add("username", user.getUsername())
                .add("pwd", user.getPwd())
                .add("address", user.getAddress())
                .build();
        final Request request = new Request.Builder()
                .url(Connect.URL + "/User/update.do")
                .post(body).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("修改失败");
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                if (result.equals("1")) {
                    System.out.println("YU!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    Intent intent = new Intent(activity, MainActivity.class);
                    activity.startActivity(intent);
//                    activity.finish();//返回直接退出程序
                } else {
                    System.out.println("NoU!!!!!!!!!!!!!!!!");
                }
            }
        });
    }

    public void findAllUser(User user, final Activity activity) {
        RequestBody body = new FormBody.Builder()
                .build();
        final Request request = new Request.Builder()
                .url(Connect.URL + "/User/findAllUser.do")
                .post(body).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("查询失败");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final ListView lv1;
                String result = response.body().string();
                Gson gson = new Gson();
                Type lt = new TypeToken<List<User>>() {
                }.getType();
                List<User> users = gson.fromJson(result, lt);
                final Adapter adapter = new UserAdapter(activity, users);
                lv1 = activity.findViewById(R.id.lv1);
                // lv1.setAdapter((ListAdapter) adapter) ;
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        lv1.setAdapter((ListAdapter) adapter);
                    }
                });
            }
        });
    }
}
