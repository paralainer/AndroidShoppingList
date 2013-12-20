package com.paralainer.android.shoppinglist;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.view.inputmethod.CompletionInfo;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.LinkedList;
import java.util.List;

public class GoodsListActivity extends ActionBarActivity {

    private List<String> goods;
    private ListView goodsListView;
    private EditText goodAddText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.goods_list);

        goodsListView = (ListView) findViewById(R.id.goodsList);
        goodAddText = (EditText) findViewById(R.id.goodAddText);

        goods = new LinkedList<String>();
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, goods);
        goodsListView.setAdapter(adapter);
    }

    public void onAddClick(View view) {
        goodAddText.setVisibility(View.VISIBLE);
        goodAddText.requestFocusFromTouch();
        goodAddText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                addGood("good");
                goodAddText.setVisibility(View.INVISIBLE);
            }
        });
    }

    public void onRecordClick(View view) {

    }

    private void addGood(String name) {
        goods.add(name);
        ((ArrayAdapter) goodsListView.getAdapter()).notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.goods_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
