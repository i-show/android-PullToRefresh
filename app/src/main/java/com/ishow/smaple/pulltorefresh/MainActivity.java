package com.ishow.smaple.pulltorefresh;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ishow.pulltorefresh.OnPullToRefreshListener;
import com.ishow.pulltorefresh.PullToRefreshView;
import com.ishow.pulltorefresh.test.TestFooter;
import com.ishow.pulltorefresh.test.TestHeader;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TestHeader header = new TestHeader(this);
        header.setMinHeight(150);
        header.setBackgroundColor(Color.GREEN);
        header.setText("Header");


        TestAdapter adapter = new TestAdapter(this);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        final PullToRefreshView pullToRefreshView = (PullToRefreshView) findViewById(R.id.pulltorefresh);
        pullToRefreshView.setHeader(header);
        pullToRefreshView.setFooter(adapter);
        pullToRefreshView.setOnPullToRefreshListener(new OnPullToRefreshListener() {
            @Override
            public void onRefresh(View v) {
                v.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        pullToRefreshView.setRefreshSuccess();
                    }
                }, 3000);
            }

            @Override
            public void onLoadMore(View v) {

            }
        });




    }

}
