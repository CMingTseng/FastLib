package com.fast.library.sample.activity;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.fast.library.Adapter.recyclerview.BaseRecyclerAdapter;
import com.fast.library.sample.R;
import com.fast.library.sample.adapter.MainAdapter;
import com.fast.library.tools.BackExit;
import com.fast.library.tools.BackTools;
import com.fast.library.tools.RecyclerViewTools;
import com.fast.library.ui.ContentView;
import com.fast.library.utils.GsonUtils;
import com.fast.library.utils.LogUtils;
import com.fast.library.utils.UIUtils;

import org.json.JSONObject;

import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

@ContentView(R.layout.activity_main)
public class MainActivity extends CommonActivity implements BaseRecyclerAdapter.OnItemClickListener {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.recyclerview)
    RecyclerView recyclerView;

    private MainAdapter mAdapter;
    private RecyclerViewTools recyclerViewTools;
    private List<String> datas;

    @Override
    public void onInit(Bundle bundle) {
        super.onInit(bundle);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        initMainData();
    }

    private void initMainData() {
        datas = Arrays.asList(UIUtils.getStringArray(R.array.main));
        recyclerViewTools = new RecyclerViewTools(recyclerView);
        mAdapter = new MainAdapter(recyclerView,datas);
        recyclerViewTools.setHasFixedSize(true);
        mAdapter.setOnItemClickListener(this);
        recyclerView.setAdapter(mAdapter);
    }
    int a = 0;
    @OnClick(R.id.fab)
    public void onClick(View view) {
        if (a == 0){
            JSONObject object = new JSONObject();
            try {
                object.put("a0","b0");
            }catch (Exception e){

            }
            Snackbar.make(view, object.toString(), Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            a = 1;
            LogUtils.e("fanly0",object.toString());
        }
        if (a == 1){
            String json = "{'a1':'b1'}";
            try {
                JSONObject object = new JSONObject(json);
                Snackbar.make(view, GsonUtils.toJson(object), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                LogUtils.e("fanly1", GsonUtils.toJson(object));
            }catch (Exception e){

            }
            a = 2;
        }
        if (a == 2){
            String json = "{'a2':'b2'}";
            try {
                JSONObject object = new JSONObject(json);
                Snackbar.make(view,object.toString(), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                LogUtils.e("fanly2", object.toString());
            }catch (Exception e){

            }
            a = 3;
        }
        if (a == 3){
            String json = "{'a3':'b3'}";
            try {
//                JSONObject object = new JSONObject(json);
//                object.put("a0","b0");
                Snackbar.make(view,GsonUtils.toJson(json), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                LogUtils.e("fanly3", GsonUtils.toJson(json));
            }catch (Exception e){

            }
            a = 0;
        }
    }

    @Override
    public void onBackPressed() {
        BackTools.onBackPressed(new BackExit(){
            @Override
            public void showTips() {
                Snackbar.make(toolbar, R.string.exit_tip, Snackbar.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onItemClick(View view, int position) {
        switch (position){
            case 0:
                showActivity(BannerActivity.class);
                break;
            case 1:
                showActivity(HttpActivity.class);
                break;
            default:
                shortToast(datas.get(position));
                break;
        }
    }
}
