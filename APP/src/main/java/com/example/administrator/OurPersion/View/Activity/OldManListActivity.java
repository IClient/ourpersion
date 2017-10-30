package com.example.administrator.OurPersion.View.Activity;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.OurPersion.Application.AllBedAdminActivity;
import com.example.administrator.OurPersion.Application.AllFirstMainActivity;
import com.example.administrator.OurPersion.Application.AllOldManActivity;
import com.example.administrator.OurPersion.Model.Bean.OkHttpURL;
import com.example.administrator.OurPersion.Model.Bean.OldMan;
import com.example.administrator.OurPersion.Presenter.OldManListAdapter;
import com.example.administrator.OurPersion.R;
import com.example.administrator.OurPersion.SelfView.CircleImageView;
import com.example.administrator.OurPersion.SelfView.MyHorizontalScrollView;
import com.example.administrator.OurPersion.Utils.ToastUtils;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OldManListActivity extends BaseActivity implements View.OnClickListener, OldManListAdapter.OnclickInterFace {
    MyHorizontalScrollView horizontalScrollView;
    //--菜单用户名字
    TextView textView;
    CircleImageView menu_image;
    CircleImageView oldmanlistback_menu;
    RecyclerView recyclerView;
    //--正常的数据
    OldMan oldMan;
    List<OldMan.OldManListBean.DatasBean> list = new ArrayList<>();
    OldManListAdapter adapter;
    int page = 1;
    OldMan oldMantwo;
    TextView oldmanlist_text;
    //--搜索时的数据
    List<OldMan.OldManListBean.DatasBean> searchlist;
    SearchView oldmanlist_searchView;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if ((int) msg.obj == 1) {
                if (page == 1 && oldMan != null && oldMan.getOldManList().getDatas().size() > 0) {
                    oldmanlist_text.setVisibility(View.GONE);
                    oldmanlist_searchView.setVisibility(View.VISIBLE);
                    for (int i = 0; i < oldMan.getOldManList().getDatas().size(); i++) {
                        list.add(oldMan.getOldManList().getDatas().get(i));
                    }
                    adapter = new OldManListAdapter(OldManListActivity.this, list);
                    adapter.SetInterface(OldManListActivity.this);
                    recyclerView.setLayoutManager(new LinearLayoutManager(OldManListActivity.this));
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setAdapter(adapter);
                } else if (page > 1 && oldMantwo != null) {
                    oldmanlist_text.setVisibility(View.GONE);
                    oldmanlist_searchView.setVisibility(View.VISIBLE);
                    if (oldMantwo.getOldManList().getDatas().size() > 0) {
                        for (int i = 0; i < oldMantwo.getOldManList().getDatas().size(); i++) {
                            list.add(oldMantwo.getOldManList().getDatas().get(i));
                        }
                        adapter.state = 1;
                        adapter.notifyDataSetChanged();
                    } else {
                        adapter.state = 2;
                        adapter.notifyDataSetChanged();

                    }
                } else if (page == 1 && oldMan == null && oldMan.getOldManList().getDatas().size() == 0) {
                    oldmanlist_searchView.setVisibility(View.GONE);
                    oldmanlist_text.setVisibility(View.VISIBLE);
                }

            } else if ((int) msg.obj == 2) {
                oldmanlist_searchView.setVisibility(View.GONE);
                ToastUtils.show(OldManListActivity.this, "获取数据失败", Toast.LENGTH_SHORT);

            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_old_man_list);
        SetZTL();
        AllOldManActivity.AddActivity(OldManListActivity.this);
        //初始化控件
        initview();
        getdatafromhttp();

    }

    public void initview() {
        nurseadmin_btn = (Button) findViewById(R.id.nurseadmin_btn);
        nurseadmin_btn.setOnClickListener(this);
        oldmanadmin_btn = (Button) findViewById(R.id.oldmanadmin_btn);
        oldmanadmin_btn.setOnClickListener(this);
        staffadmin_btn = (Button) findViewById(R.id.staffadmin_btn);
        staffadmin_btn.setOnClickListener(this);
        bedadmin_btn = (Button) findViewById(R.id.bedadmin_btn);
        bedadmin_btn.setOnClickListener(this);
        messagesend_btn = (Button) findViewById(R.id.messagesend_btn);
        messagesend_btn.setOnClickListener(this);
        horizontalScrollView = (MyHorizontalScrollView) findViewById(R.id.oldmanlist_scrollview);
        textView = (TextView) findViewById(R.id.user_name);
        textView.setText(user.getEmployeeName().trim());
        menu_image = (CircleImageView) findViewById(R.id.menu_circleimage);
        Picasso.with(OldManListActivity.this).load(OkHttpURL.ImageURL + user.getImgPath()).placeholder(R.mipmap.default_image).into(menu_image);
        oldmanlistback_menu = (CircleImageView) findViewById(R.id.oldmanlistback_menu);
        oldmanlistback_menu.setOnClickListener(this);
        Picasso.with(OldManListActivity.this).load(OkHttpURL.ImageURL + user.getImgPath()).placeholder(R.mipmap.default_image).into(oldmanlistback_menu);
        recyclerView = (RecyclerView) findViewById(R.id.oldmanlist_rv);
        RvScrollBottom();
        oldmanlist_text = (TextView) findViewById(R.id.oldmanlist_text);
        oldmanlist_searchView = (SearchView) findViewById(R.id.oldmanlist_searchView);
        oldmanlist_searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (TextUtils.isEmpty(newText)) {
                    searchlist = null;
                    adapter = new OldManListAdapter(OldManListActivity.this, list);
                    adapter.state = 1;
                    recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                    adapter.SetInterface(OldManListActivity.this);

                } else {
                    searchlist = new ArrayList<>();
                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).getCustomerName().startsWith(newText)) {
                            searchlist.add(list.get(i));


                        }

                    }
                    adapter = new OldManListAdapter(OldManListActivity.this, searchlist);
                    adapter.state = 3;
                    recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                    adapter.SetInterface(OldManListActivity.this);
                }

                return false;
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //--护理管理
            case R.id.nurseadmin_btn:
                if (horizontalScrollView.isopen()) {
                    AllBedAdminActivity.DestoryActivity();
                    AllOldManActivity.DestoryActivity();
                    AllFirstMainActivity.DestoryActivity();
                    Intent intent = new Intent(OldManListActivity.this, NurseAdminActivity.class);
                    startActivity(intent);
                    this.finish();
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }
                break;

            //--老人管理
            case R.id.oldmanadmin_btn:
                if (horizontalScrollView.isopen()) {
                    horizontalScrollView.closemenu();
                }
                break;
            //--员工
            case R.id.staffadmin_btn:
                if (horizontalScrollView.isopen()) {
                    AllBedAdminActivity.DestoryActivity();
                    AllOldManActivity.DestoryActivity();
                    AllFirstMainActivity.DestoryActivity();
                    Intent intent = new Intent(OldManListActivity.this, StaffAdminActivity.class);
                    startActivity(intent);
                    this.finish();
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }
                break;
            //--床位
            case R.id.bedadmin_btn:
                if (horizontalScrollView.isopen()) {
                    AllBedAdminActivity.DestoryActivity();
                    AllOldManActivity.DestoryActivity();
                    AllFirstMainActivity.DestoryActivity();
                    Intent intent = new Intent(OldManListActivity.this, BedAdminActivity.class);
                    startActivity(intent);
                    this.finish();
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }
                break;
            case R.id.messagesend_btn:
                if (horizontalScrollView.isopen()) {
                    AllBedAdminActivity.DestoryActivity();
                    AllOldManActivity.DestoryActivity();
                    AllFirstMainActivity.DestoryActivity();
                    Intent intent = new Intent(OldManListActivity.this, MessageActivity.class);
                    startActivity(intent);
                    this.finish();
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }
                break;
            //--打开菜单
            case R.id.oldmanlistback_menu:
                if (!horizontalScrollView.isopen()) {
                    horizontalScrollView.openmenu();

                }
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (horizontalScrollView.isopen()) {
                horizontalScrollView.closemenu();

            } else {
                this.finish();
                overridePendingTransition(R.animator.animation_in, R.animator.animation_out);
            }

        }
        return false;
    }

    public void getdatafromhttp() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(15, TimeUnit.SECONDS).readTimeout(15, TimeUnit.SECONDS).build();
        Request request = new Request.Builder().url("http://192.168.10.7:7006/api/Customer/GetCustomerList?pageIndex=" + page + "&PageSize=10").get().build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                try {
                    JSONObject jsonObject = new JSONObject(result);
                    if (jsonObject.has("Message")) {
                        Message message = new Message();
                        message.obj = 2;
                        handler.sendMessage(message);
                        return;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                String s = "{\"OldManList\":";
                StringBuffer sb = new StringBuffer(result);
                sb.insert(0, s);
                String data = sb.toString() + "}";
                if (page == 1) {
                    Gson gson = new Gson();
                    oldMan = gson.fromJson(data, OldMan.class);
                    Message message = new Message();
                    message.obj = 1;
                    handler.sendMessage(message);
                } else {
                    Gson gson = new Gson();
                    oldMantwo = gson.fromJson(data, OldMan.class);
                    Message message = new Message();
                    message.obj = 1;
                    handler.sendMessage(message);
                }

            }
        });

    }

    @Override
    public void Onclick(int position, List<OldMan.OldManListBean.DatasBean> list) {
        Intent intent = new Intent(OldManListActivity.this, OldManAdminActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("OldManListBean", list.get(position));
        intent.putExtras(bundle);
        startActivity(intent);
        overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);


    }

    public void RvScrollBottom() {
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                //当前RecyclerView显示出来的最后一个的item的position
                int lastPosition = -1;
                //当前状态为停止滑动状态SCROLL_STATE_IDLE时
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                    if (layoutManager instanceof GridLayoutManager) {
                        //通过LayoutManager找到当前显示的最后的item的position
                        lastPosition = ((GridLayoutManager) layoutManager).findLastVisibleItemPosition();
                    } else if (layoutManager instanceof LinearLayoutManager) {
                        lastPosition = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
                    } else if (layoutManager instanceof StaggeredGridLayoutManager) {
                        //因为StaggeredGridLayoutManager的特殊性可能导致最后显示的item存在多个，所以这里取到的是一个数组
                        //得到这个数组后再取到数组中position值最大的那个就是最后显示的position值了
                        int[] lastPositions = new int[((StaggeredGridLayoutManager) layoutManager).getSpanCount()];
                        ((StaggeredGridLayoutManager) layoutManager).findLastVisibleItemPositions(lastPositions);
                        lastPosition = findMax(lastPositions);
                    }  //时判断界面显示的最后item的position是否等于itemCount总数-1也就是最后一个item的position
                    //如果相等则说明已经滑动到最后了,并且page+1
                    if (lastPosition == recyclerView.getLayoutManager().getItemCount() - 1 && searchlist == null) {
                        page = page + 1;
                        getdatafromhttp();
                    }


                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {


            }

        });
    }  //找到数组中的最大值

    private int findMax(int[] lastPositions) {
        int max = lastPositions[0];
        for (int value : lastPositions) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }
}
