package com.my.opera;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;

import com.my.opera.fragment.Fragment1;
import com.my.opera.fragment.Fragment6;
import com.my.opera.fragment.Fragment2;
import com.my.opera.fragment.Fragment3;
import com.my.opera.fragment.Fragment4;
import com.my.opera.fragment.Fragment5;


public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener{

    private FragmentManager fragmentManager;
    private Fragment F1;
    private Fragment F2;
    private Fragment F3;
    private Fragment F4;
    private Fragment F5;
    private Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = this;
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        RadioGroup tabGradio = findViewById(R.id.tab_radio);
        tabGradio.setOnCheckedChangeListener(this);
        if(F1 == null){
            F1 = new Fragment1();
        }
        fragmentManager.beginTransaction().add(R.id.fragment_container,F1,"oneFragment").commit();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        F1 = fragmentManager.findFragmentByTag("oneFragment");
        F2 = fragmentManager.findFragmentByTag("twoFragment");
        F3 = fragmentManager.findFragmentByTag("threeFragment");
        F4 = fragmentManager.findFragmentByTag("fourFragment");
        F5 = fragmentManager.findFragmentByTag("fiveFragment");
        if (F1 != null) {
            transaction.hide(F1);
        }
        if (F2 != null) {
            transaction.hide(F2);
        }
        if (F3 != null) {
            transaction.hide(F3);
        }
        if (F4 != null) {
            transaction.hide(F4);
        }
        if (F5 != null) {
            transaction.hide(F5);
        }

        switch (checkedId){
            case R.id.one:
                if(F1 == null){
                    F1 = new Fragment6();
                    transaction.add(R.id.fragment_container,F1,"oneFragment");
                } else{
                    transaction.show(F1);
                }
                break;
            case R.id.two:
                if(F2 == null){
                    F2 = new Fragment2();
                    transaction.add(R.id.fragment_container,F2,"twoFragment");
                }else{
                    transaction.show(F2);
                }
                transaction.show(F2);
                break;
            case R.id.three:
                if(F3 == null){
                    F3 = new Fragment3();
                    transaction.add(R.id.fragment_container,F3,"threeFragment");
                }
                transaction.show(F3);
                break;
            case R.id.four:
                if(F4 == null){
                    F4 = new Fragment4();
                    transaction.add(R.id.fragment_container,F4,"fourFragment");
                }
                transaction.show(F4);
                break;
            case R.id.five:
                if(F5 == null){
                    F5 = new Fragment5();
                    transaction.add(R.id.fragment_container, F5, "fiveFragment");
                }
                transaction.show(F5);
                break;
            default:
                break;
        }
        transaction.commit();
    }
}
