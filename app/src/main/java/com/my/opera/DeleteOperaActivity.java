package com.my.opera;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.my.opera.pojo.Opera;
import com.my.opera.service.opera.OperaService;

public class DeleteOperaActivity extends AppCompatActivity implements View.OnClickListener{
private EditText deleteOperaName;
private Button btn_deleteOpera;
private Activity activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_opera);
        deleteOperaName=findViewById(R.id.deleteOperaName);
        btn_deleteOpera=findViewById(R.id.btn_deleteOpera);
        activity=this;
        btn_deleteOpera.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_deleteOpera:
                Opera opera = new Opera();
                opera.setOperaName(deleteOperaName.getText().toString());
                OperaService operaService = new OperaService();
                operaService.deleteOpera(opera, activity);
                break;
        }
    }
}
