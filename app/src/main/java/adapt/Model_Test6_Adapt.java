package adapt;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.dell2.androidexamfinal.R;

import java.util.List;

/**
 * Created by dell2 on 2017/6/17.
 */

//适配器 专门给listview_model_test6.xml使用
//    string可以换成自己定义的类（entity） 只改string
public class Model_Test6_Adapt extends ArrayAdapter<String>{

    private int resourceId;
//    context为activity.this
//    resource是listview单个项的布局
//    List<String> objects插入数据
    public Model_Test6_Adapt(@NonNull Context context, @LayoutRes int resource, @NonNull List<String> objects) {
        super(context, resource, objects);
        resourceId=resource;
//        最后一个参数可能改（看项放什么）
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        String str=getItem(position);
//        加载到第几个项
//        ---------------------
        View view;
        if(convertView==null){
            view= LayoutInflater.from(getContext()).inflate(resourceId,null);
        }else{
            view=convertView;
        }
//        ----------------------
//        完全不动上面
        TextView test6_textView=(TextView)view.findViewById(R.id.test6_textView);
        test6_textView.setText(str);
        return view;
    }
}
