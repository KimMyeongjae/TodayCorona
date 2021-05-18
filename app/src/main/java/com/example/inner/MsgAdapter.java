package com.example.inner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MsgAdapter extends BaseAdapter {

    Context mContext = null;
    private ViewHolder mViewHolder;
    ArrayList<String> msg;

    public  MsgAdapter(Context mContext, ArrayList<String> msg){
        this.mContext = mContext;
        this.msg = msg;
    }
    @Override
    public int getCount() {
        return msg.size();
    }

    @Override
    public Object getItem(int position) {
        return msg.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {

            convertView = LayoutInflater.from(mContext).inflate(R.layout.msg, parent, false);
            mViewHolder = new ViewHolder(convertView);
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }
        mViewHolder.msgContent.setText(msg.get(position));
        return convertView;
    }
    public class ViewHolder {

        private TextView msgContent;

        public ViewHolder(View convertView) {

            msgContent = (TextView) convertView.findViewById(R.id.msgContent);

        }

    }
}

