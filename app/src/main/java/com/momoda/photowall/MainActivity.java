package com.momoda.photowall;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;


public class MainActivity extends Activity {

    /**
     * 用于展示照片墙的GridView
     */
    private GridView mPhotoWall;

    /**
     * GridView的适配器
     */
    private PhotoWallAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPhotoWall = (GridView) findViewById(R.id.photo_wall);
        adapter = new PhotoWallAdapter(this, 0, Images.imageThumbUrls, mPhotoWall);
        mPhotoWall.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 退出程序时结束所有的下载任务
        adapter.cancelAllTasks();
    }
}
