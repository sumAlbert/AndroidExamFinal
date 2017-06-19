package broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by dell2 on 2017/6/18.
 */

//接收器 不确定接受什么广播
public class Test5_BroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
//        收到广播后 调用的函数
        Toast.makeText(context,"received in Test5_BroadcastReceiver",Toast.LENGTH_SHORT).show();
    }
}
