package db;

import android.os.Handler;
import android.os.Message;

import com.example.dell2.androidexamfinal.Model_test7_activity;

import java.lang.ref.WeakReference;

import collector.BaseActivity;

/**
 * Created by dell2 on 2017/6/17.
 */

public class DBHandler extends Handler {
    public static final int START=1;
    public static final int DOING=2;
    public static final int OVER=3;
    private WeakReference<BaseActivity> wr;
    public DBHandler(WeakReference<BaseActivity> wr){
        this.wr=wr;
    }
    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        Model_test7_activity activity=(Model_test7_activity)wr.get();
        if(activity==null)
            return;
        if(activity.getHandler().hasMessages(DOING))
            activity.getHandler().removeMessages(DOING);
        switch (msg.what){
            case START:
                activity.insertDb();
                activity.getHandler().sendEmptyMessageDelayed(DOING,5000);
                break;
            case DOING:
                activity.insertDb();
                activity.getHandler().sendEmptyMessageDelayed(DOING,5000);
                break;
            case OVER:
                break;
            default:
                break;
        }
    }
}
