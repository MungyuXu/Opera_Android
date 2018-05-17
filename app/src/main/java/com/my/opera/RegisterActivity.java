package com.my.opera;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.my.opera.pojo.User;
import com.my.opera.service.user.UserService;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{
private EditText registerUsername,registerPwd,registerAddress;
private Button btn_register;
private Activity activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        registerAddress=findViewById(R.id.registerAddress);
        registerPwd=findViewById(R.id.registerPwd);
        registerUsername=findViewById(R.id.registerUsername);
        btn_register=findViewById(R.id.btn_register);
        activity = this;
       btn_register.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_register:
                User user = new User();
                user.setUsername(registerUsername.getText().toString());
                user.setPwd(registerPwd.getText().toString());
                user.setAddress(registerAddress.getText().toString());
                UserService userService =new UserService();
                userService.userRegister(user,activity);
                break;

            default:
                break;
        }
    }


}
