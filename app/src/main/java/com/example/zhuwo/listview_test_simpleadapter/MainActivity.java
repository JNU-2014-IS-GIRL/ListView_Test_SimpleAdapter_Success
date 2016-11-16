package com.example.zhuwo.listview_test_simpleadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.lv);
        //定义一个动态数组
        ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>();
        //在数组中存放数据
        for(int i = 0; i < 10; i++)
        {
            HashMap<String, Object> map = new HashMap<String, Object>();
            //放入图片
            map.put("ItemImage", R.drawable.icon);
            map.put("ItemTitle", "第"+i+"行");
            map.put("ItemText", "这是第"+i+"行");
            listItem.add(map);
        }

        //需要绑定的数据
        //每一行的布局//动态数组中的数据源的键对应到定义布局的View中
        SimpleAdapter mSimpleAdapter = new SimpleAdapter(
                this,
                listItem,
                R.layout.activity_main,
                new String[] {"ItemImage","ItemTitle", "ItemText"},
                new int[] {R.id.ItemImage,R.id.ItemTitle,R.id.ItemText}
        );

        //为ListView绑定适配器
    lv.setAdapter(mSimpleAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                //设置标题栏显示点击的行
                setTitle("你点击了第"+arg2+"行");
            }
        });

    }
}
