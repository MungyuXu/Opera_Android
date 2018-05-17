package com.my.opera;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.my.opera.pojo.Opera;
import com.my.opera.pojo.User;
import com.my.opera.service.opera.OperaService;
import com.my.opera.service.user.UserService;

public class UpdateOperaActivity extends AppCompatActivity implements View.OnClickListener{
private EditText updateOperaName,updateOperaInfo;
private Button btn_updateOpera;
private Activity activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_opera);
        updateOperaName=findViewById(R.id.updateOperaName);
        updateOperaInfo=findViewById(R.id.updateOperaInfo);
        btn_updateOpera=findViewById(R.id.btn_updateOpera);
        activity=this;
        btn_updateOpera.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_updateOpera:
                Opera opera=new Opera();
                opera.setOperaName(updateOperaName.getText().toString());
                opera.setOperaInfo(updateOperaInfo.getText().toString());
                OperaService operaService=new OperaService();
                operaService.updateOpera(opera,activity);
                break;

            default:
                break;
        }
    }


}
