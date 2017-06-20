package db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by dell2 on 2017/6/17.
 */

//帮助打开sqlite的东西
public class DbHelp extends SQLiteOpenHelper {
//    建表的string 到某个地方执行就能建表
//     sqLiteDatabase.execSQL(CREATE_NAME);中执行
    public static final String CREATE_NAME="create table MyTable_test("
            +"id integer primary key autoincrement,"
            +"createTime text,"
            +"log text)";
//    context即为activity.this
    private Context context;
    public DbHelp(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context=context;
    }
//数据库中表建立时 调用的函数
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_NAME);
        Toast.makeText(context,"Create succeeded",Toast.LENGTH_SHORT).show();
    }
//数据库更新时 调用的函数
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
