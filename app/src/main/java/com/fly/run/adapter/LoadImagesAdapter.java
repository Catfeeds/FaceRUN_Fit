package com.fly.run.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.fly.run.R;
import com.fly.run.utils.DisplayUtil;
import com.fly.run.utils.ImageLoaderOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xinzhendi-031 on 2016/12/14.
 */
public class LoadImagesAdapter extends BaseAdapter {

    private Context mContext;
    private List<String> datas = new ArrayList<>();

    public LoadImagesAdapter(Context context) {
        this.mContext = context;
    }

    public void setData(List<String> list) {
        datas.clear();
        if (list != null) {
            datas.addAll(list);
        }
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public String getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.adapter_load_image_item, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        String content = getItem(position);
        ImageLoader.getInstance().displayImage(content, viewHolder.imageView, ImageLoaderOptions.optionsLanuchHeader);
        return convertView;
    }

    private class ViewHolder {
        public ImageView imageView;

        public ViewHolder(View view) {
            this.imageView = (ImageView) view.findViewById(R.id.iv_icon);
            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) this.imageView.getLayoutParams();
            params.height = DisplayUtil.screenWidth / 3 * 2 / 3;
        }
    }
}