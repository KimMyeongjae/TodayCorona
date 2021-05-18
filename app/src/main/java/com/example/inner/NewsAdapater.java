package com.example.inner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NewsAdapater extends BaseAdapter {

    Context mContext = null;
    private ViewHolder mViewHolder;
    ArrayList<String> news;

    public NewsAdapater(Context mContext, ArrayList<String> news) {
        this.mContext = mContext;
        this.news = news;
    }

    @Override
    public int getCount() {
        return news.size();
    }

    @Override
    public Object getItem(int position) {
        return news.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {

            convertView = LayoutInflater.from(mContext).inflate(R.layout.news, parent, false);
            mViewHolder = new ViewHolder(convertView);
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }
        mViewHolder.newsContent.setText(news.get(position));
        return convertView;
    }
    public class ViewHolder {

        private TextView newsContent;

        public ViewHolder(View convertView) {

            newsContent = (TextView) convertView.findViewById(R.id.newsContent);

        }

    }
}
