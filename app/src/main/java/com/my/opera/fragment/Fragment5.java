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

import com.my.opera.ManageActivity;
import com.my.opera.R;
import com.my.opera.SecondActivity;

public class Fragment5 extends Fragment implements View.OnClickListener{

    private Button btn_yjt;
    private Activity activity;
    private View rootView;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        rootView= inflater.inflate(R.layout.fragment5, container, false);
        init();
        return rootView;
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onClick(View view) {


        switch (view.getId()){
            case R.id.btn_yjt:
                Intent intent4 = new Intent(activity, SecondActivity.class);
                startActivity(intent4);
                break;
            default:
                break;
        }
    }
    private  void  init(){
        // getActivity == AppCompatActivity里面的this
        //这个东西相当于是上下文状态,操作某些页面元素或者组件应用需要找到这个东西。然后用让去找东西。
        activity=getActivity();
        btn_yjt=rootView.findViewById(R.id.btn_yjt);
        btn_yjt.setOnClickListener(this);
    }

}
