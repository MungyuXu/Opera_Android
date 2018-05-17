package com.my.opera.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.my.opera.R;
import com.my.opera.pojo.Opera;

import java.util.List;

import javax.security.auth.callback.Callback;

//https://www.cnblogs.com/cheneasternsun/p/5614365.html
public class OperaAdapter extends BaseAdapter  {
    private LayoutInflater mInflater;
    private List<Opera> operas;
//    private Callback mCallback;//所有listview的item共用同一个

//    //自定义接口，用于回调按钮点击事件到activity
//    public interface Callback {
//        public void click(View v);
//    }


    public OperaAdapter(Activity mInflater, List<Opera> operas) {
        this.mInflater = LayoutInflater.from(mInflater);
        this.operas = operas;
//        mCallback = callback;
    }

    @Override
    public int getCount() {
        return operas.size();
    }

    @Override
    public Object getItem(int i) {
        return operas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.lv2, null);
            viewHolder.operaName = convertView.findViewById(R.id.operaName);
            viewHolder.operaInfo = convertView.findViewById(R.id.operaInfo);
//      viewHolder.operaImg=convertView.findViewById(R.id.operaImg);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Opera opera = operas.get(i);
        viewHolder.operaName.setText(opera.getOperaName());
        viewHolder.operaInfo.setText(opera.getOperaInfo());
//viewHolder.operaImg.setImageResource(a[0]);


        return convertView;
    }

//    @Override
//    public void onClick(View view) {
////        mCallback.click(view);
//    }

    static class ViewHolder {
        TextView operaName;
        TextView operaInfo;

//        ImageView operaImg;
    }
//    int b;
//    int[] a = {R.drawable.address_book,2,3,4,5};

}
