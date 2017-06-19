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

public class Model_Test6_Adapt extends ArrayAdapter<String>{

    private int resourceId;
    public Model_Test6_Adapt(@NonNull Context context, @LayoutRes int resource, @NonNull List<String> objects) {
        super(context, resource, objects);
        resourceId=resource;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        String str=getItem(position);
        View view;
        if(convertView==null){
            view= LayoutInflater.from(getContext()).inflate(resourceId,null);
        }else{
            view=convertView;
        }
        TextView test6_textView=(TextView)view.findViewById(R.id.test6_textView);
        test6_textView.setText(str);
        return view;
    }
}
