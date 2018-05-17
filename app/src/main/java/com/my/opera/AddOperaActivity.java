package com.my.opera;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.my.opera.pojo.Opera;
import com.my.opera.service.opera.OperaService;

public class AddOperaActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText addOperaName, addOperaInfo;
    private Button btn_addOpera;
    private Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_opera);
        addOperaName = findViewById(R.id.addOperaName);
        addOperaInfo = findViewById(R.id.addOperaInfo);
        btn_addOpera = findViewById(R.id.btn_addOpera);
        activity = this;
        btn_addOpera.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_addOpera:
                Opera opera = new Opera();
                opera.setOperaName(addOperaName.getText().toString());
                opera.setOperaInfo(addOperaInfo.getText().toString());
                OperaService operaService = new OperaService();
                operaService.addOpera(opera, activity);
                break;
            default:
                break;
        }
    }


}
