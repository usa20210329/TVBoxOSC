package com.github.tvbox.osc.ui.adapter;

import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.github.tvbox.osc.R;
import com.github.tvbox.osc.api.ApiConfig;
import com.github.tvbox.osc.bean.VodInfo;
import com.github.tvbox.osc.picasso.RoundTransformation;
import com.github.tvbox.osc.util.DefaultConfig;
import com.github.tvbox.osc.util.MD5;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import me.jessyan.autosize.utils.AutoSizeUtils;
import android.view.View;
import com.github.tvbox.osc.util.LOG;
import com.google.gson.Gson;
import com.github.tvbox.osc.util.*;

/**
 * @author pj567
 * @date :2020/12/21
 * @description:
 */
public class HistoryAdapter extends BaseQuickAdapter<VodInfo, BaseViewHolder> {
    public HistoryAdapter() {
        super(R.layout.item_grid, new ArrayList<>());
    }

    @Override
    protected void convert(BaseViewHolder helper, VodInfo item) {

        showText(helper, R.id.tvYear, ApiConfig.get().getSource(item.sourceKey).getName());

        showText(helper, R.id.tvArea, "");

        showText(helper, R.id.tvLang, TextUtils.isEmpty(item.playNote)?"":item.playNote);
    
        showText(helper, R.id.tvNote, item.note);

        showText(helper, R.id.tvName, item.name);


        ImageView ivThumb = helper.getView(R.id.ivThumb);
        //由于部分电视机使用glide报错
        if (!TextUtils.isEmpty(item.pic)) {
            Picasso.get()
                    .load(DefaultConfig.checkReplaceProxy(item.pic))
                    .transform(new RoundTransformation(MD5.string2MD5(item.pic + item.name))
                            .centerCorp(true)
                            .override(AutoSizeUtils.mm2px(mContext, 300), AutoSizeUtils.mm2px(mContext, 400))
                            .roundRadius(AutoSizeUtils.mm2px(mContext, 10), RoundTransformation.RoundType.ALL))
                    .placeholder(R.drawable.img_loading_placeholder)
                    .error(R.drawable.img_loading_placeholder)
                    .into(ivThumb);
        } else {
            ivThumb.setImageResource(R.drawable.img_loading_placeholder);
        }
    }

    private void showText(BaseViewHolder helper, int id, String text){
        if(TextUtils.isEmpty(text)){
            helper.setVisible(id, false);
        }else{
            helper.setVisible(id, true);
            helper.setText(id, text);
        }
    }
}