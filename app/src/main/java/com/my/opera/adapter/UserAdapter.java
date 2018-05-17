package com.my.opera.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.my.opera.R;
import com.my.opera.pojo.User;

import java.util.List;

//getCount : 要绑定的条目的数目，比如格子的数量
//        getItem : 根据一个索引（位置）获得该位置的对象
//        getItemId : 获取条目的id
//        getView : 获取该条目要显示的界面
public class UserAdapter extends BaseAdapter {
    private LayoutInflater mInflater;
    private List<User> users;
//LayoutInflater activity;
    public UserAdapter(Activity mInflater, List<User> users) {
        this.mInflater = LayoutInflater.from(mInflater);
        this.users = users;
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int i) {
        return users.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    //i位置
    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.lv1, null);
            viewHolder.showUsername = convertView.findViewById(R.id.showUsername);
            viewHolder.showAddress = convertView.findViewById(R.id.showAddress);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        User user=users.get(i);
       // viewHolder.img.setImageResource(R.drawable.ic_launcher_background);
        viewHolder.showUsername.setText(user.getUsername());
        viewHolder.showAddress.setText(user.getAddress());
        return convertView;
    }

    static class ViewHolder {
        TextView showUsername;
        TextView showAddress;
        Button editUser;
    }
}
