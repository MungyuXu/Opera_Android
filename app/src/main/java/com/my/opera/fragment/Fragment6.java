package com.my.opera.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.my.opera.DeleteActivity;
import com.my.opera.OperaActivity;
import com.my.opera.R;
import com.my.opera.RegisterActivity;
import com.my.opera.UpdateActivity;
import com.my.opera.pojo.User;
import com.my.opera.service.user.UserService;

public class Fragment6 extends Fragment implements  View.OnClickListener{
    @Override
    public void onClick(View v) {

    }

//    private EditText username, pwd;
//    private Button login, register, delete, update,aaa;
//    private Activity activity;
//    private View rootView;
//
//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//    }
//
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
//                             @Nullable Bundle savedInstanceState) {
//        rootView = inflater.inflate(R.layout.activity_manage, container, false);
//        init();
//        return rootView;
//    }
//
//    @Override
//    public void onPause() {
//        super.onPause();
//    }
//
//    private void init(){
//        activity = getActivity();
//        username = rootView.findViewById(R.id.username);
//        pwd = rootView.findViewById(R.id.pwd);
//        login = rootView.findViewById(R.id.login);
//        register = rootView.findViewById(R.id.register);
//        delete = rootView.findViewById(R.id.delete);
//        update = rootView.findViewById(R.id.update);
//        aaa=rootView.findViewById(R.id.aaa);
//
//        //监听
//        login.setOnClickListener(this);
//        register.setOnClickListener(this);
//        delete.setOnClickListener(this);
//        update.setOnClickListener(this);
//        aaa.setOnClickListener(this);
//    }
//
//    @Override
//    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.login:
//                User user = new User();
//                user.setUsername(username.getText().toString());
//                user.setPwd(pwd.getText().toString());
//                UserService userService = new UserService();
//                userService.userLogin(user, activity);
//                break;
//            case R.id.register:
//                Intent intent = new Intent(activity, RegisterActivity.class);
//                startActivity(intent);
//                // activity.finish();
//                break;
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
//            default:
//                break;
//        }
//    }
}
