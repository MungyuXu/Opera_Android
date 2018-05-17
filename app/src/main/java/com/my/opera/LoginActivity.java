package com.my.opera;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.my.opera.pojo.User;
import com.my.opera.service.user.UserService;

//Activity -> AppCompatActivity -> Fragment
public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText username, pwd;
    private Button login, register,visit;
//    private Button login, register, delete, update,aaa;
    private Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = findViewById(R.id.username);
        pwd = findViewById(R.id.pwd);
        login = findViewById(R.id.login);
        register = findViewById(R.id.register);
        visit=findViewById(R.id.visit);
//        delete = findViewById(R.id.delete);
//        update = findViewById(R.id.update);
//        aaa=findViewById(R.id.aaa);
        activity = this;
        //监听
        login.setOnClickListener(this);
        register.setOnClickListener(this);
        visit.setOnClickListener(this);
//        delete.setOnClickListener(this);
//        update.setOnClickListener(this);
//        aaa.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login:
                User user = new User();
                user.setUsername(username.getText().toString());
                user.setPwd(pwd.getText().toString());
                UserService userService = new UserService();
                userService.userLogin(user, activity);
                break;
            case R.id.register:
                Intent intent = new Intent(activity, RegisterActivity.class);
                startActivity(intent);
                // activity.finish();
                break;
            case R.id.visit:
                Intent intent2 = new Intent(activity, MainActivity.class);
                startActivity(intent2);
                break;
//            case R.id.delete:
//                Intent intent1 = new Intent(activity, DeleteActivity.class);
//                startActivity(intent1);
//                // activity.finish();
//                break;
//            case R.id.update:
//                Intent intent3 = new Intent(activity, UpdateActivity.class);
//                startActivity(intent3);
//                break;
//            case R.id.aaa:
//                Intent intent4 = new Intent(activity, OperaActivity.class);
//                startActivity(intent4);
//                break;
            default:
                break;
        }
    }
}
