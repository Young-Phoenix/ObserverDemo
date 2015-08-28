package com.qianyouba.observerdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.qianyouba.observerdemo.R;
import com.qianyouba.observerdemo.event.EventType;
import com.qianyouba.observerdemo.event.Notify;

/**
 * Created by Administrator on 2015/8/28 0028.
 */
public class OtherActivity extends AppCompatActivity {
    private Button mUpdateBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.other_activity);
        mUpdateBtn=(Button) findViewById(R.id.update_edit_btn);
        mUpdateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Notify.getInstance().notifyActivity(EventType.UPDATE_TEXT);
                Notify.getInstance().notifyActivity(EventType.UPDATE_MAIN);
            }
        });
    }
}
