package com.my.opera.service.opera;

import android.app.Activity;
import android.content.Intent;
import android.widget.Adapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.my.opera.OperaActivity;
import com.my.opera.R;
import com.my.opera.adapter.OperaAdapter;
import com.my.opera.pojo.Opera;
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

public class OperaService {

    private OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .addInterceptor(new LogInterceptor()).build();

    public  void  findAllOpera(final Opera opera, final Activity activity){
        RequestBody body=new FormBody.Builder()
                .build();
        final Request request =new Request.Builder()
                .url(Connect.URL+"/Opera/findAll.do")
                .post(body).build();
        Call call= okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("查询失败");
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final ListView lv2;
                String result = response.body().string();
                Gson gson=new Gson();
                Type lt=new TypeToken<List<Opera>>(){}.getType();
                List<Opera> operas=gson.fromJson(result,lt);
                final Adapter adapter=new OperaAdapter(activity,operas);
                lv2=activity.findViewById(R.id.lv2);
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        lv2.setAdapter((ListAdapter) adapter) ;
                    }
                });

            }
        });
    }

    public void addOpera(Opera opera, final Activity activity){
        RequestBody body=new FormBody.Builder()
                .add("operaName",opera.getOperaName())
                .add("operaInfo",opera.getOperaInfo())
                .build();
        final Request request =new Request.Builder()
                .url(Connect.URL+"/Opera/add.do")
                .post(body).build();
        Call call= okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("添加失败");
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                if(result.equals("1")){
                    System.out.println("Y!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    Intent intent = new Intent(activity, OperaActivity.class);
                    activity.startActivity(intent);
                }
                else{
                    System.out.println("NO!!!!!!!!!!!!!!!!");
                }

            }
        });}


    public void deleteOpera(Opera opera, final Activity activity){
        RequestBody body=new FormBody.Builder()
                .add("operaName",opera.getOperaName())
                .build();
        final Request request =new Request.Builder()
                .url(Connect.URL+"/Opera/delete.do")
                .post(body).build();
        Call call= okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("删除失败");
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                if(result.equals("1")){
                    System.out.println("Y!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    Intent intent = new Intent(activity, OperaActivity.class);
                    activity.startActivity(intent);
                }
                else{
                    System.out.println("NO!!!!!!!!!!!!!!!!");
                }
            }
        });}

    public void updateOpera(Opera opera, final Activity activity){
        RequestBody body=new FormBody.Builder()
                .add("operaName",opera.getOperaName())
                .add("operaInfo",opera.getOperaInfo())
                .build();
        final Request request =new Request.Builder()
                .url(Connect.URL+"/Opera/update.do")
                .post(body).build();
        Call call= okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("修改失败");
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                if(result.equals("1")){
                    System.out.println("Y!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    Intent intent = new Intent(activity, OperaActivity.class);
                    activity.startActivity(intent);
                }
                else{
                    System.out.println("NO!!!!!!!!!!!!!!!!");
                }
            }
        });}
}
