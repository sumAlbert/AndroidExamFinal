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

import entity.TableItem;

/**
 * Created by dell2 on 2017/6/17.
 */

public class Test8_Adapt extends ArrayAdapter<TableItem> {
    private int resourceId;
    public Test8_Adapt(@NonNull Context context, @LayoutRes int resource, @NonNull List<TableItem> objects) {
        super(context, resource, objects);
        resourceId=resource;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        TableItem item=getItem(position);
        View view;
//        ----加快加载速度  不用重复加载 滑动更流畅
        if(convertView==null){
            view= LayoutInflater.from(getContext()).inflate(resourceId,null);
        }else{
            view=convertView;
        }
//        ----
        TextView test8_textView=(TextView)view.findViewById(R.id.test8_textView);
        test8_textView.setVisibility(View.GONE);
        TextView test8_textView_id=(TextView)view.findViewById(R.id.test8_textView_id);
        TextView test8_textView_price=(TextView)view.findViewById(R.id.test8_textView_price);
//        test8_textView.setText(item.getName());
        test8_textView_id.setText(item.getCreateTIME());
        test8_textView_price.setText(item.getLog());
        return view;
    }
}
