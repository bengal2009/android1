package com.example.blin.myapplication;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;


public class MainActivity extends ActionBarActivity {
private boolean Flag=false;
private static final int ID = 1213;
private static final String KEY_COUNT="keyCount";
private int count;

    public void buttontest(View Source) throws IOException {
       Button bt = (Button)findViewById(R.id.BT1);
        if(!Flag) {
            bt.setBackgroundColor(Color.rgb(0, 122, 0));
//            SwitchPict("2.JPG");
            SwitchPict("1.JPG");
            Flag=true;
        }
        else
        {
            bt.setBackgroundColor(Color.CYAN);
//            SwitchPict("benny1.JPG");
            SwitchPict("P1020072.JPG");
            Flag=false;

        }

    }
    public void TopNotify(View Source) {
        AddNotification();
        MainActivity.this.finish();

    }

    public void SwitchPict(String s)
    {

        try {
            ImageView jpgView1 = (ImageView) findViewById(R.id.jpgview);
            String myJpgPath = Environment.getExternalStorageDirectory().getPath() + "/"+s;
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 2;
            Bitmap bm = BitmapFactory.decodeFile(myJpgPath, options);
            jpgView1.setImageBitmap(bm);
        }
        catch(Exception  e)
        {
            System.err.print(e.toString());
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent=this.getIntent();
        count=intent.getIntExtra(KEY_COUNT,0);

        this.setTitle("这是第"+Integer.toString(count)+"个");


          ImageView jpgView = (ImageView)findViewById(R.id.jpgview);
//        String myJpgPath = Environment.getExternalStorageDirectory().getPath()+ "/benny1.JPG";
        String myJpgPath = Environment.getExternalStorageDirectory().getPath()+ "/1.JPG";
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 2;
        Bitmap bm = BitmapFactory.decodeFile(myJpgPath, options);
        jpgView.setImageBitmap(bm);

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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void AddNotification(){
        count++;
        //添加通知到顶部任务栏
        //获得NotificationManager实例
        String service = NOTIFICATION_SERVICE;
        NotificationManager nm = (NotificationManager)getSystemService(service);
        //实例化Notification
        Notification n = new Notification();
        //设置显示图标
        //设置提示信息
        String tickerText ="我的程序";
        //显示时间
        long when = System.currentTimeMillis();

        n.tickerText = tickerText;
        n.when = when;
        //显示在“正在进行中”
        //  n.flags = Notification.FLAG_ONGOING_EVENT;
        n.flags|=Notification.FLAG_AUTO_CANCEL; //自动终止
        //实例化Intent
        Intent it = new Intent(this,MainActivity.class);
        it.putExtra(KEY_COUNT, count);
        /*********************
         *获得PendingIntent
         *FLAG_CANCEL_CURRENT:
         *		如果当前系统中已经存在一个相同的PendingIntent对象，
         *		那么就将先将已有的PendingIntent取消，然后重新生成一个PendingIntent对象。
         *FLAG_NO_CREATE:
         *		如果当前系统中不存在相同的PendingIntent对象，
         *		系统将不会创建该PendingIntent对象而是直接返回null。
         *FLAG_ONE_SHOT:
         *		该PendingIntent只作用一次，
         *		如果该PendingIntent对象已经触发过一次，
         *		那么下次再获取该PendingIntent并且再触发时，
         *		系统将会返回一个SendIntentException，在使用这个标志的时候一定要注意哦。
         *FLAG_UPDATE_CURRENT:
         *		如果系统中已存在该PendingIntent对象，
         *		那么系统将保留该PendingIntent对象，
         *		但是会使用新的Intent来更新之前PendingIntent中的Intent对象数据，
         *		例如更新Intent中的Extras。这个非常有用，
         *		例如之前提到的，我们需要在每次更新之后更新Intent中的Extras数据，
         *		达到在不同时机传递给MainActivity不同的参数，实现不同的效果。
         *********************/

        PendingIntent pi = PendingIntent.getActivity(this, 0, it, PendingIntent.FLAG_UPDATE_CURRENT);

        //设置事件信息，显示在拉开的里面
        n.setLatestEventInfo(MainActivity.this,"我的软件"+Integer.toString(count), "我的软件正在运行……", pi);
        //发出通知
        nm.notify(ID,n);
    }

}
