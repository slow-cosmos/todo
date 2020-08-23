package edu.swu.todo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.nio.file.WatchKey;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button add,remove;
    View dialogView;
    EditText title;
    DatePicker date;
    CheckBox dlgChk;
    CheckBox cb;
    ArrayList<String> midList;
    ArrayAdapter<String> adapter;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        midList  = new ArrayList<String>();
        final ListView list = (ListView)findViewById(R.id.listView);

        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_multiple_choice,midList);
        list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        list.setAdapter(adapter);

        add = (Button)findViewById(R.id.add);
        remove =(Button)findViewById(R.id.remove);

        title =(EditText)findViewById(R.id.title);
        date =(DatePicker)findViewById(R.id.date);
        dlgChk=(CheckBox)findViewById(R.id.dlgChk);

        img = (ImageView)findViewById(R.id.img);
        img.setImageResource(R.drawable.moon);
        


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivityForResult(intent,1);
            }
        });

        remove.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                SparseBooleanArray array = list.getCheckedItemPositions();
                int count = adapter.getCount();

                for(int i = count-1;i>=0;i--){
                    if(array.get(i)){
                        midList.remove(i);
                    }
                }
                list.clearChoices();
                adapter.notifyDataSetChanged();
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode==1){
            if(resultCode ==RESULT_OK){
                String todo = data.getStringExtra("Todo");
                midList.add(todo);
                adapter.notifyDataSetChanged();

            }
        }
    }


}
