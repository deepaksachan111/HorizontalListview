package com.deepak.qserver.horizontallistview;

import android.app.AlertDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
       String[] dataObjects = new String[]{ "Text #1", "Text #2", "Text #3","Text #4","Text #5","Text #6","Text #7","Text #8","Text #9","Text #10" };

        HorizontalListView listview = (HorizontalListView) findViewById(R.id.listview);

        Adapter mAdapter = new Adapter(this,R.layout.viewitem,dataObjects);
        listview.setAdapter(mAdapter);

    }


    private class Adapter extends ArrayAdapter {
        String[] dataObjects;

        public Adapter(Context context, int resource, String[] a) {
            super(context, resource);
            this.dataObjects = a;
        }


        @Override
        public int getCount() {
            return dataObjects.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View retval = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewitem, null);
            TextView title = (TextView) retval.findViewById(R.id.title);
            Button button = (Button) retval.findViewById(R.id.clickbutton);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("hello from " + v);
                    builder.setPositiveButton("Cool", null);
                    builder.show();
                }
            });
            title.setText(dataObjects[position]);

            return retval;
        }

    };

}
