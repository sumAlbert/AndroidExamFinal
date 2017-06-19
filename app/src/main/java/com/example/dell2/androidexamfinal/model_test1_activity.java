package com.example.dell2.androidexamfinal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import collector.BaseActivity;

/**
 * Created by wangyan on 2017/6/19.
 */

public class model_test1_activity extends BaseActivity {
    private static final String[] blood={"A型","B型","O型","AB型","其他血型"};
    String bloodString=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_model_test1);
        Spinner spinner=(Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,blood);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setVisibility(View.VISIBLE);
        Button button=(Button)findViewById(R.id.button);
        final EditText name=(EditText)findViewById(R.id.name);
        final RadioGroup radioGroup=(RadioGroup)findViewById(R.id.radiogroup);
        final CheckBox checkBox1=(CheckBox)findViewById(R.id.hob1);
        final CheckBox checkBox2=(CheckBox)findViewById(R.id.hob1);
        final CheckBox checkBox3=(CheckBox)findViewById(R.id.hob1);



        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(model_test1_activity.this,model_test1_activity2.class);
                String nameString=name.getText().toString();
                intent.putExtra("name",nameString);
                String sexString=null;
                String hobbyString="";
                for(int i=0;i<radioGroup.getChildCount();i++){
                    RadioButton sex=(RadioButton)radioGroup.getChildAt(i);
                    if(sex.isChecked()){
                        sexString=sex.getText().toString();
                        break;
                    }
                }
                intent.putExtra("sex",sexString);
                if(checkBox1.isChecked()){
                    hobbyString=hobbyString+checkBox1.getText().toString()+" ";
                }
                if(checkBox2.isChecked()){
                    hobbyString=hobbyString+checkBox2.getText().toString()+" ";
                }
                if(checkBox3.isChecked()){
                    hobbyString=hobbyString+checkBox3.getText().toString()+" ";
                }
                intent.putExtra("hobby",hobbyString);

                intent.putExtra("blood",bloodString);

                startActivity(intent);
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                bloodString=blood[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                bloodString=null;
            }
        });
    }
    public static void actionStart(Context context){
        Intent intent=new Intent(context,model_test1_activity.class);
        context.startActivity(intent);
    }

}
