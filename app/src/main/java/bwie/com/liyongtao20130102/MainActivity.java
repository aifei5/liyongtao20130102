package bwie.com.liyongtao20130102;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.google.gson.Gson;

import java.util.List;

import bwie.com.liyongtao20130102.adapter.HomeAdapter;
import bwie.com.liyongtao20130102.bean.FousBean;
import bwie.com.liyongtao20130102.home.presenter.HomePresenter;
import bwie.com.liyongtao20130102.home.view.IHomeView;

public class MainActivity extends AppCompatActivity implements IHomeView {
    private GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = findViewById(R.id.gv);
        HomePresenter presenter = new HomePresenter(MainActivity.this);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent =new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
        gridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                gridView.removeView(view);

                return false;
            }
        });
    }

    @Override
    public void getViewData(final String mViewData) {
            new Thread(){
                @Override
                public void run() {
                    super.run();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Gson gson = new Gson();
                            FousBean fousBean = gson.fromJson(mViewData, FousBean.class);
                            List<FousBean.DataBean.TuijianBean.ListBeanX> list=fousBean.getData().getTuijian().getList();
                            HomeAdapter homeAdapter =new HomeAdapter(list,MainActivity.this);
                            gridView.setAdapter(homeAdapter);
                        }
                    });
                }
            }.start();
    }
}
