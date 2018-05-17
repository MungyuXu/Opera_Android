package com.my.opera;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.my.opera.adapter.UserAdapter;
import com.my.opera.pojo.User;
import com.my.opera.service.user.UserService;

import java.util.ArrayList;
import java.util.List;

public class UpdateActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText updateUsername, updateAddress, updatePwd;
    private Button btn_update;
    private Activity activity;
    private ListView lv1;


    //第一次加载时运行该方法
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        init();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_update:
                User user = new User();
                user.setUsername(updateUsername.getText().toString());
                user.setPwd(updatePwd.getText().toString());
                user.setAddress(updateAddress.getText().toString());
                UserService userService = new UserService();
                userService.userUpdate(user, activity);
                break;
            default:
                break;
        }
    }

    private void init() {
        updateUsername = findViewById(R.id.updateUsername);
        updatePwd = findViewById(R.id.updatePwd);
        updateAddress = findViewById(R.id.updateAddress);
        btn_update = findViewById(R.id.btn_update);
        lv1 = findViewById(R.id.lv1);
        lv1.setOnItemClickListener(new OICL());
        activity = this;
        btn_update.setOnClickListener(this);
        User user = new User();
        UserService userService = new UserService();
        userService.findAllUser(user, activity);
    }

    class OICL implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            System.out.println("!!!!!!!!!!!");
            Intent intent = new Intent(activity, MainActivity.class);
            startActivity(intent);


        }
    }
}
