package com.qianyouba.observerdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.qianyouba.observerdemo.base.BaseObserverActivity;
import com.qianyouba.observerdemo.event.EventType;

public class MainActivity extends BaseObserverActivity {
    private TextView mLableTv;
    private ImageView mPicIv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLableTv=(TextView) findViewById(R.id.label_tv);
        mPicIv=(ImageView) findViewById(R.id.pic_iv);
    }

    @Override
    protected void onChange(String eventType) {
        if(EventType.UPDATE_MAIN==eventType){
            mPicIv.setImageResource(R.mipmap.ic_launcher);
        }else if(EventType.UPDATE_TEXT==eventType){
            mLableTv.setText("图片被更新");
        }
    }

    @Override
    protected String[] getObserverEventType() {
        return new String[]{
                EventType.UPDATE_MAIN,
                EventType.UPDATE_TEXT
        };
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id){
            case R.id.go_other_activity:
                goActivity(OtherActivity.class);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
    private void goActivity(Class<?> activity){
        Intent intent=new Intent(this,activity);
        startActivity(intent);
    }

}
