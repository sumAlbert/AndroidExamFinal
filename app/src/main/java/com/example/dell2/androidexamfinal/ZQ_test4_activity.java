package com.example.dell2.androidexamfinal;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


import adapt.Test8_Adapt;
import collector.BaseActivity;
import db.DbHelp;
import entity.TableItem;

/**
 * Created by wangyan on 2017/6/19.
 */

public class ZQ_test4_activity extends BaseActivity {
    private DbHelp dbHelp;
    private ListView test8_ListView;
    private Test8_Adapt test8_adapt;
    private List<TableItem> data=new ArrayList<>();
    private int pos=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_model_test8);
        init();
    }
    public void init(){
        dbHelp=new DbHelp(this,"MyDb_test.db",null,1);
        displayDb();
        test8_ListView=(ListView)findViewById(R.id.test8_ListView);
//        每一项适配
        test8_adapt=new Test8_Adapt(ZQ_test4_activity.this,R.layout.listview_model_test8,data);
        test8_ListView.setAdapter(test8_adapt);
//        点击listview每一项的触发函数
        test8_ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
//            i为第几项
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                AlertDialog.Builder dialog=new AlertDialog.Builder(ZQ_test4_activity.this);
                pos=i;
//               设置对话框的标题
                dialog.setTitle("Delete this item?");
//                设置对话框的内容
                dialog.setMessage(data.get(i).getLog());
//                设置是否取消
                dialog.setCancelable(false);
//                设置积极按钮
                dialog.setPositiveButton("OK",new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        deleteItem(data.get(pos).getLog());
//                        现在的data删除
                        data.clear();
//                        从新获取元素 从新适配
                        displayDb();
                        test8_adapt=new Test8_Adapt(ZQ_test4_activity.this,R.layout.listview_model_test8,data);
                        test8_ListView.setAdapter(test8_adapt);
                    }
                });
//                设置消极按钮
                dialog.setNegativeButton("Cancel",new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(ZQ_test4_activity.this,"delete cancel",Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();
            }
        });

    }
    public static void actionStart(Context context){
        Intent intent=new Intent(context,ZQ_test4_activity.class);
        context.startActivity(intent);
    }

    //    展示数据  把数据库的数据组装到data里面每一项
    public void displayDb(){
        SQLiteDatabase sqLiteDatabase=dbHelp.getWritableDatabase();
        Cursor cursor=sqLiteDatabase.query("MyTable_test",null,null,null,null,null,null);
        List<TableItem> data_temp=new ArrayList<>();
        int i=0;
        if(cursor.moveToFirst()){
            do{
                i++;
//                每读一项都得 new一项 不然都是改同一项
                TableItem tableItem=new TableItem();
                tableItem.setCreateTIME(cursor.getString(cursor.getColumnIndex("createTime")));
                tableItem.setLog(cursor.getString(cursor.getColumnIndex("log")));
//                tableItem.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex("id"))));
//                tableItem.setPrice(Double.parseDouble(cursor.getString(cursor.getColumnIndex("price"))));
                data_temp.add(tableItem);
            }while(cursor.moveToNext());
        }
        cursor.close();
        for(int m=0;m<data_temp.size();m++){
            data.add(data_temp.get(data_temp.size()-1-m));
        }
        Toast.makeText(ZQ_test4_activity.this,String.valueOf(i),Toast.LENGTH_SHORT).show();
    }
    public void deleteItem(String str){
        SQLiteDatabase sqLiteDatabase=dbHelp.getWritableDatabase();
//        " name = ?",new String[] {str} 是组装删除条件 name="str"的删除
        sqLiteDatabase.delete("MyTable_test"," log = ?",new String[] {str});
        Toast.makeText(ZQ_test4_activity.this,"delete success",Toast.LENGTH_SHORT).show();
    }
}
