package com.my.opera;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.my.opera.R;
import com.my.opera.pojo.Opera;
import com.my.opera.service.opera.OperaService;

public class OperaActivity extends AppCompatActivity implements View.OnClickListener{
    private Button addOpera, deleteOpera, updateOpera,music,xj;
    private ListView lv2;
    private Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opera);
        addOpera = findViewById(R.id.addOpera);
        deleteOpera = findViewById(R.id.deleteOpera);
        updateOpera = findViewById(R.id.updateOpera);
        music=findViewById(R.id.music);
        xj=findViewById(R.id.xj);
        lv2 = findViewById(R.id.lv2);
        lv2.setOnItemClickListener(new OICL());
        activity = this;
        addOpera.setOnClickListener(this);
        deleteOpera.setOnClickListener(this);
        updateOpera.setOnClickListener(this);
        music.setOnClickListener(this);
        xj.setOnClickListener(this);
        init();
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.addOpera:
                Intent intent1 = new Intent(activity, AddOperaActivity.class);
                startActivity(intent1);
                break;
            case R.id.deleteOpera:
                Intent intent2 = new Intent(activity, DeleteOperaActivity.class);
                startActivity(intent2);
                break;
            case R.id.updateOpera:
                Intent intent3 = new Intent(activity, UpdateOperaActivity.class);
                startActivity(intent3);
                break;
            case R.id.music:
                Intent intent4 = new Intent(activity, MusicActivity.class);
                startActivity(intent4);
                break;
            case R.id.xj:
                Intent intent5 = new Intent(activity, RatActivity.class);
                startActivity(intent5);
                break;

            default:
                break;
        }
    }

    private void init() {
        Opera opera = new Opera();
        OperaService operaService = new OperaService();
        operaService.findAllOpera(opera, activity);
    }

    class OICL implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            System.out.println("!!!!!!!!!!!");
            Intent intent = new Intent(activity, LzActivity.class);
            startActivity(intent);
        }
    }

}
