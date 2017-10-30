package com.example.administrator.OurPersion.View.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.OurPersion.Model.Bean.AreaOldMan;
import com.example.administrator.OurPersion.Model.Bean.MeQJWork;
import com.example.administrator.OurPersion.Model.Bean.OkHttpURL;
import com.example.administrator.OurPersion.Presenter.FirstMainQJAdapter;
import com.example.administrator.OurPersion.R;
import com.example.administrator.OurPersion.SelfView.CircleImageView;
import com.example.administrator.OurPersion.SelfView.MyHorizontalScrollView;
import com.example.administrator.OurPersion.Utils.ToastUtils;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/9/29 0029.
 */

public class FirstMainQjActivity extends BaseActivity implements View.OnClickListener {
    //--菜单
    TextView user_name;
    CircleImageView menu_circleimage;

    MyHorizontalScrollView firstmainqj_scrollview;
    CircleImageView firstmainqjback_menu;
    RecyclerView firstmain_qj_rv;
    int page = 1;
    MeQJWork meQJWork;
    MeQJWork meQJWorktwo;
    FirstMainQJAdapter adapter;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if ((int) msg.obj == 1) {
                if (page == 1) {
                    adapter = new FirstMainQJAdapter(FirstMainQjActivity.this, meQJWork);
                    adapter.state = 3;
                    firstmain_qj_rv.setHasFixedSize(true);
                    firstmain_qj_rv.setLayoutManager(new LinearLayoutManager(FirstMainQjActivity.this));
                    firstmain_qj_rv.setAdapter(adapter);
                } else if (page > 1) {
                    if (meQJWorktwo != null && meQJWorktwo.getMeQJWork().getDatas().size() > 0) {


                        for (int i = 0; i < meQJWorktwo.getMeQJWork().getDatas().size(); i++) {

                            meQJWork.getMeQJWork().getDatas().add(meQJWorktwo.getMeQJWork().getDatas().get(i));
                        }

                        adapter.state = 1;
                        adapter.notifyDataSetChanged();

                    } else {
                        adapter.state = 2;
                        adapter.notifyDataSetChanged();

                    }
                }


            } else if ((int) msg.obj == 2) {
                ToastUtils.show(FirstMainQjActivity.this, "请求数据失败", Toast.LENGTH_SHORT);


            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstmain_qj);
        SetZTL();
        initview();
        gethttp();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.firstmainqjback_menu:
                if (!firstmainqj_scrollview.isopen()) {
                    firstmainqj_scrollview.openmenu();
                }
                break;
            case R.id.nurseadmin_btn:
                if (firstmainqj_scrollview.isopen()) {
                    Intent nurseintent = new Intent(FirstMainQjActivity.this, NurseAdminActivity.class);
                    startActivity(nurseintent);
                    FirstMainQjActivity.this.finish();
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }
                break;
            case R.id.oldmanadmin_btn:
                if (firstmainqj_scrollview.isopen()) {
                    Intent oldmanintent = new Intent(FirstMainQjActivity.this, OldManListActivity.class);
                    startActivity(oldmanintent);
                    FirstMainQjActivity.this.finish();
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }
                break;
            case R.id.staffadmin_btn:
                if (firstmainqj_scrollview.isopen()) {
                    Intent staffintent = new Intent(FirstMainQjActivity.this, StaffAdminActivity.class);
                    startActivity(staffintent);
                    FirstMainQjActivity.this.finish();
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }
                break;
            case R.id.bedadmin_btn:
                if (firstmainqj_scrollview.isopen()) {
                    Intent staffintent = new Intent(FirstMainQjActivity.this, BedAdminActivity.class);
                    startActivity(staffintent);
                    FirstMainQjActivity.this.finish();
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }
                break;
            case R.id.messagesend_btn:
                if (firstmainqj_scrollview.isopen()) {
                    Intent staffintent = new Intent(FirstMainQjActivity.this, MessageActivity.class);
                    startActivity(staffintent);
                    FirstMainQjActivity.this.finish();
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }
                break;
        }

    }

    public void initview() {
        user_name = (TextView) findViewById(R.id.user_name);
        user_name.setText(user.getEmployeeName());
        menu_circleimage = (CircleImageView) findViewById(R.id.menu_circleimage);
        Picasso.with(FirstMainQjActivity.this).load(OkHttpURL.ImageURL + user.getImgPath()).placeholder(R.mipmap.default_image).into(menu_circleimage);
        firstmainqj_scrollview = (MyHorizontalScrollView) findViewById(R.id.firstmainqj_scrollview);
        firstmainqjback_menu = (CircleImageView) findViewById(R.id.firstmainqjback_menu);
        firstmainqjback_menu.setOnClickListener(this);
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
        firstmain_qj_rv = (RecyclerView) findViewById(R.id.firstmain_qj_rv);
        RvScrollBottom();
    }

    public void gethttp() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(15, TimeUnit.SECONDS).readTimeout(15, TimeUnit.SECONDS).build();
        Request request = new Request.Builder().get().url("http://192.168.10.7:7006/api/Employee/GetAskForLeaveFormList?employeeId=+" + user.getId() + "&pageIndex=+" + page + "&pageSize=10").build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                if (result.contains("Message")) {
                    Message message = new Message();
                    message.obj = 2;
                    handler.sendMessage(message);
                    return;
                }
                String s = "{\"MeQJWork\":";
                StringBuffer sb = new StringBuffer(result);
                sb.insert(0, s);
                String data = sb.toString() + "}".trim();
                if (page == 1) {
                    Gson gson = new Gson();
                    meQJWork = gson.fromJson(data, MeQJWork.class);
                    Message message = new Message();
                    message.obj = 1;
                    handler.sendMessage(message);
                } else {
                    Gson gson = new Gson();
                    meQJWorktwo = gson.fromJson(data, MeQJWork.class);
                    Message message = new Message();
                    message.obj = 1;
                    handler.sendMessage(message);

                }

            }
        });
    }

    public void RvScrollBottom() {
        firstmain_qj_rv.addOnScrollListener(new RecyclerView.OnScrollListener() {
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
                    if (lastPosition == recyclerView.getLayoutManager().getItemCount() - 1) {
                        page = page + 1;
                        gethttp();
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

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (firstmainqj_scrollview.isopen()) {
                firstmainqj_scrollview.closemenu();

            } else {
                FirstMainQjActivity.this.finish();
                overridePendingTransition(R.animator.animation_in, R.animator.animation_out);
            }

        }

        return false;

    }
}
