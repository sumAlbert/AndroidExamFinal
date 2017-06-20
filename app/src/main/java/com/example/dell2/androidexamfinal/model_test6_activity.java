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
//        布局文件
        init();
//        初始化
    }
    public void init(){
//        在string数组data中添加 最后显示在listview里面（左滑菜单里面）
        data.add("数学");
        data.add("物理");
        data.add("计算机");
        test6_ListView=(ListView)findViewById(R.id.test6_ListView);
        test6_textView=(TextView)findViewById(R.id.test6_textView);
        test6_DrawerLayout=(DrawerLayout)findViewById(R.id.test6_DrawerLayout);

//        非隐藏部分的内容
        test6_textView.setText("fragment1");

        Model_Test6_Adapt model_test6_adapt=new Model_Test6_Adapt(model_test6_activity.this,R.layout.listview_model_test6,data);
        test6_ListView.setAdapter(model_test6_adapt);
        test6_ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//               i是第几项
                String str=data.get(i);
                test6_textView.setText(str);
                if(str.equals("数学")){
                    str=str+"我爱数学";
                }
                if(str.equals("物理")){
                    str=str+"我爱物理";
                }
                if(str.equals("计算机")){
                    str=str+"我爱计算机";
                }
//                从底下弹出的小提示
//                第一个为activity 第二个弹出内容 第三个固定 最后一定要 .show()
                Toast.makeText(model_test6_activity.this,str,Toast.LENGTH_SHORT).show();
//    最后要自动关闭
                test6_DrawerLayout.closeDrawers();
            }
        });
}
    public static void actionStart(Context context){
//        打开这个activity的函数
//       其他activity可以通过调用这个函数来运行该activity
//        每次新建一个activity只需要改动下面的第二个参数xx.class
//        content是出发地，第二个目的地
        Intent intent=new Intent(context,model_test6_activity.class);
        context.startActivity(intent);
    }
}
