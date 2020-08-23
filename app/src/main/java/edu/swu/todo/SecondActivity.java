package edu.swu.todo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.annotation.Nullable;

import java.util.Date;

public class SecondActivity extends Activity {

    CheckBox dlgChk;
    DatePicker date;
    Button dlgAdd, dlgCancel;
    EditText title;
    String todo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog1);

        dlgChk = (CheckBox)findViewById(R.id.dlgChk) ;
        title = (EditText)findViewById(R.id.title);
        date =(DatePicker) findViewById(R.id.date);
        dlgAdd =(Button)findViewById(R.id.dlgAdd);
        dlgCancel=(Button)findViewById(R.id.dlgCancel);

        dlgChk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { //다이얼로그 체크 박스
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(dlgChk.isChecked()==true){
                    date.setVisibility(android.view.View.VISIBLE);
                } else{
                    date.setVisibility(android.view.View.INVISIBLE);
                }
            }
        });


        dlgAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent();

                if(dlgChk.isChecked()==true){
                    intent.putExtra("Todo",date.getMonth()+1+"/"+date.getDayOfMonth()+"  "+title.getText().toString());
                }else{
                    intent.putExtra("Todo",title.getText().toString());
                }

                setResult(RESULT_OK,intent);
                finish();
            }
        });

        dlgCancel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}
