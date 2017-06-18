package com.example.dell2.androidexamfinal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import adapt.Model_Test6_Adapt;
import adapt.Test6_ZQ_Adapt;
import collector.BaseActivity;

/**
 * Created by dell2 on 2017/6/19.
 */

public class model_test6_activity extends BaseActivity{
    private ListView test6_ListView;
    private TextView test6_textView;
    private DrawerLayout test6_DrawerLayout;
    private List<String> data=new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_model_test6);
        init();
    }
    public void init(){
        data.add("fragment1");
        data.add("fragment2");
        test6_ListView=(ListView)findViewById(R.id.test6_ListView);
        test6_textView=(TextView)findViewById(R.id.test6_textView);
        test6_DrawerLayout=(DrawerLayout)findViewById(R.id.test6_DrawerLayout);

        test6_textView.setText("fragment1");

        Model_Test6_Adapt model_test6_adapt=new Model_Test6_Adapt(model_test6_activity.this,R.layout.activity_model_test6,data);
        test6_ListView.setAdapter(model_test6_adapt);
        test6_ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String str=data.get(i);
                test6_textView.setText(str);
                Toast.makeText(model_test6_activity.this,str,Toast.LENGTH_SHORT).show();
                test6_DrawerLayout.closeDrawers();
            }
        });
    }
    public static void actionStart(Context context){
        Intent intent=new Intent(context,model_test6_activity.class);
        context.startActivity(intent);
    }
}
