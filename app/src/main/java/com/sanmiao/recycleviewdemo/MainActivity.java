package com.sanmiao.recycleviewdemo;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshRecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private PullToRefreshRecyclerView mRecyclerView;
    private GalleryAdapter mAdapter;
    private List<String> mDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_main);
        initDatas();
        mRecyclerView = (PullToRefreshRecyclerView) findViewById(R.id.id_recyclerview_horizontal);

        mRecyclerView.setScrollingWhileRefreshingEnabled(true);
        mRecyclerView.setMode(PullToRefreshBase.Mode.BOTH);
        mRecyclerView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<RecyclerView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<RecyclerView> refreshView) {
                new Handler().postDelayed(new Runnable() {
                                              @Override
                                              public void run() {

                                                  mRecyclerView.onRefreshComplete();
                                              }
                                          }, 4000
                );
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<RecyclerView> refreshView) {
                new Handler().postDelayed(new Runnable() {
                                              @Override
                                              public void run() {

                                                  mRecyclerView.onRefreshComplete();
                                              }
                                          }, 4000
                );
            }
        });

        //设置布局管理器
//        FullyLinearLayoutManager linearLayoutManager = new FullyLinearLayoutManager(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        //设置适配器
        mAdapter = new GalleryAdapter(getLayoutInflater(), mDatas);
        mRecyclerView.setAdapter(mAdapter);

    }


    private void initDatas() {
        String[] imgs = new String[]{
                "http://www.sss007.com/uploads/allimg/160802/2-160P2093H4-50.jpg",
                "http://cms-bucket.nosdn.127.net/catchpic/3/3C/3C570DC9C404E811E6EBFE40A413833C.jpg",
                "http://www.skycn.com/up/2016-8/14700368538760023.jpg",
                "http://article.fd.zol-img.com.cn/t_s640x2000/g5/M00/02/08/ChMkJ1ehavuIb07QAAYosE6Y0wEAAUHRgIJ7boABijI225.png",
                "http://www.yoka.com/dna/pics//media/ba1daea1/4/d3da5dee15b517733b.jpg",
                "http://a0.att.hudong.com/31/52/19300001332062131244528987401_950.jpg",
                "http://pic5.nipic.com/20100228/3301946_114120327954_2.jpg",
                "http://ww3.sinaimg.cn/bmiddle/7a9c7569jw1ebs65rd8tmg20c806mh6r.gif",
                "http://ww3.sinaimg.cn/bmiddle/7a9c7569jw1ebs65rd8tmg20c806mh6r.gif",
                "res://com.sanmiao.recycleviewdemo/" + R.mipmap.dong,
                "http://cdnq.duitang.com/uploads/item/201505/31/20150531173730_XkfjF.thumb.700_0.gif"
        };
        mDatas = new ArrayList<String>(Arrays.asList(imgs));

    }
}
