package com.example.examquation2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button mBtnAdd, mBtnRemove, mBtnView, mBtnRefresh;
    private LinearLayout mLinearLayout;
//    private EditText mEdtTxt;
    int count = 0;
    ArrayList<Integer> mValueList;
    // ArrayList<Integer> mEditTxt_values;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        init();


        mBtnAdd.setOnClickListener(new OnBtnAddClickListener());
        mBtnRemove.setOnClickListener(new OnBtnRemoveClickListener());
        mBtnView.setOnClickListener(new OnBtnViewClickListener());
        mBtnRefresh.setOnClickListener(new OnBtnRefreshClickListener());
    }

    public void init() {

        mBtnAdd = findViewById(R.id.mBtnAdd);
        mBtnRemove = findViewById(R.id.mBtnRemove);
        mBtnView = findViewById(R.id.mBtnView);
        mBtnRefresh= findViewById(R.id.mBtnRefresh);
        mLinearLayout = findViewById(R.id.mLinearLayout);
        mValueList = new ArrayList<Integer>();

    }

    class OnBtnAddClickListener implements View.OnClickListener {


        @Override
        public void onClick(View v) {
          //  Toast.makeText(MainActivity.this, "BtnAddClicked", Toast.LENGTH_SHORT).show();
            EditText mEdtTxt = new EditText(MainActivity.this);
           // mEdtTxt.setInputType(z);
            mEdtTxt.setInputType(4);
            mEdtTxt.setHint("Enter Integer Values");
            mLinearLayout.addView(mEdtTxt);
          // mValueList.add(count,mEdtTxt);
            //);
            count++;

         //    mValueList.add((EditText) mEdtTxt.getEditableText());
        }
    }

    class OnBtnRemoveClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {

         //   Toast.makeText(MainActivity.this, "Click on BtnRemove", Toast.LENGTH_SHORT).show();

            if (count != 0) {
                count--;

                mLinearLayout.removeViewAt(count);
               // mValueList.remove(count);
                //             mValueList.remove(count);
            }

            Toast.makeText(MainActivity.this, "Task Comleted", Toast.LENGTH_SHORT).show();
        }

    }

    class OnBtnViewClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            for (int i = 0; i <count; i++) {

                //mValueList.add((EditText) mLinearLayout.getChildAt(i));
                //  mValueList.add((EditText)mLinearLayout.getChildAt(i));

                //mEditTxt_values.add((mLinearLayout.getChildAt(i)).getTextAlignment());
                EditText editText;
                editText =(EditText) mLinearLayout.getChildAt(i);
                if ((editText.getText().toString()).equals("")){

                    Toast.makeText(MainActivity.this, "Edit Text is Empty", Toast.LENGTH_SHORT).show();
                }else  {
                    int j = Integer.parseInt(editText.getText().toString());
                    mValueList.add(j);
                    // Toast.makeText(MainActivity.this, ""+j, Toast.LENGTH_SHORT).show();
                }
            }

                if (count==(mValueList.size())) {
                    Intent intent = new Intent(MainActivity.this, GraphActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putIntegerArrayList("Values", mValueList);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }else {
                    Toast.makeText(MainActivity.this, "Plese Update Current Value", Toast.LENGTH_SHORT).show();
                }
        }
    }


    class OnBtnRefreshClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {

            mValueList.clear();
            Toast.makeText(MainActivity.this, "Update Process Completed", Toast.LENGTH_SHORT).show();
        }
    }


}
