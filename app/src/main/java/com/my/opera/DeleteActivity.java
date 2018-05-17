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

public class DeleteActivity extends AppCompatActivity implements View.OnClickListener{
 private EditText deleteUsername;
    private Button btn_delete;
private Activity activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
    deleteUsername=findViewById(R.id.deleteUsername);
    btn_delete=findViewById(R.id.btn_delete);
    activity=this;
    btn_delete.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_delete:
             User user = new User();
               user.setUsername(deleteUsername.getText().toString());
               UserService userService =new UserService();
              userService.userDelete(user,activity);
                break;

            default:
                break;
        }
    }
}
