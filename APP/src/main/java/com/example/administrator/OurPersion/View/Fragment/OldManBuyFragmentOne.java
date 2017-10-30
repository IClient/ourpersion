package com.example.administrator.OurPersion.View.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.OurPersion.Model.Bean.OldManMonthBuy;
import com.example.administrator.OurPersion.Presenter.OldManBuyFragmentOneAdapter;
import com.example.administrator.OurPersion.R;
import com.example.administrator.OurPersion.Utils.ToastUtils;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/9/20 0020.
 */

public class OldManBuyFragmentOne extends Fragment {
    TextView oldman_buy_t;
    View view;
    RecyclerView recyclerView;
    OldManBuyFragmentOneAdapter adapter;
    String id;
    String result;
    OldManMonthBuy oldManBuy;
    //上啦加载更多
    int page = 1;
    OldManMonthBuy oldManBuytwo;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if ((int) msg.obj == 1) {
                if (oldManBuy.getOldManMonthBuy().getDatas().size() > 0 && page == 1) {
                    adapter = new OldManBuyFragmentOneAdapter(oldManBuy, getContext());
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                    recyclerView.setAdapter(adapter);
                    RvScrollBottom();

                } else if (page == 1 && oldManBuy.getOldManMonthBuy().getDatas().size() == 0) {
                    recyclerView.setVisibility(View.GONE);
                    //--没有消费记录显示的textview
                    oldman_buy_t.setVisibility(View.VISIBLE);
                } else if (page > 1) {
                    if (oldManBuytwo.getOldManMonthBuy().getDatas().size() > 0) {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                for (int i = 0; i < oldManBuytwo.getOldManMonthBuy().getDatas().size(); i++) {
                                    oldManBuy.getOldManMonthBuy().getDatas().add(oldManBuytwo.getOldManMonthBuy().getDatas().get(i));
                                }
                                adapter.state = 1;
                                adapter.notifyDataSetChanged();
                            }
                        }, 3000);

                    } else {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                adapter.state = 2;
                                adapter.notifyDataSetChanged();

                            }
                        }, 3000);

                    }
                }

            } else if ((int) msg.obj == 2)

            {
                ToastUtils.show(getContext(), "获取数据失败", Toast.LENGTH_SHORT);

            }

        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.oldmanbuy_fragmentone, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.oldmanbuy_fragmentone_rv);
        oldman_buy_t = (TextView) view.findViewById(R.id.oldman_buy_t);
        id = getArguments().getString("checkid");
        gethttp();
        return view;
    }

    public void gethttp() {
//        http://192.168.10.7:7006/api/FinanceManage/GetMonthlyFeePaymentRecordList?checkInId=87b46125-6fc9-4c5c-b696-2a4e20b08a81&beginTime=2016-09-16&endTime=3017-09-16&pageIndex=1&PageSize=4
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(15, TimeUnit.SECONDS).readTimeout(15, TimeUnit.SECONDS).build();
        Request request = new Request.Builder().get().url("http://192.168.10.7:7006/api/FinanceManage/GetMonthlyFeePaymentRecordList?checkInId=" + id + "&beginTime=2016-09-16&endTime=3017-09-16&pageIndex=" + page + "&PageSize=4").build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                result = response.body().string();
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
                String s = "{\"OldManMonthBuy\":";
                StringBuffer sb = new StringBuffer(result);
                sb.insert(0, s);
                String data = sb.toString() + "}";
                Gson gson = new Gson();
                if (page == 1) {
                    oldManBuy = gson.fromJson(data, OldManMonthBuy.class);
                    Message message = new Message();
                    message.obj = 1;
                    handler.sendMessage(message);
                } else {
                    oldManBuytwo = gson.fromJson(data, OldManMonthBuy.class);
                    Message message = new Message();
                    message.obj = 1;
                    handler.sendMessage(message);
                }
            }
        });
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
    }

    //找到数组中的最大值
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
