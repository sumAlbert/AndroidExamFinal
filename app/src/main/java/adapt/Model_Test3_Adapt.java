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

import entity.Touch;

/**
 * Created by dell2 on 2017/6/18.
 */

public class Model_Test3_Adapt extends ArrayAdapter<Touch> {
    private int resourceId;
    public Model_Test3_Adapt(@NonNull Context context, @LayoutRes int resource, @NonNull List<Touch> objects) {
        super(context, resource, objects);
        resourceId=resource;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Touch item=getItem(position);
        View view;
        if(convertView==null){
            view= LayoutInflater.from(getContext()).inflate(resourceId,null);
        }else{
            view=convertView;
        }
        TextView model_test3_name=(TextView)view.findViewById(R.id.model_test3_name);
        TextView model_test3_tel=(TextView)view.findViewById(R.id.modeL_test3_tel);
        model_test3_name.setText(item.getName());
        model_test3_tel.setText(item.getTel());
        return view;
    }
}
