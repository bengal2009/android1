package com.example.blin.myapplication;

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
    public void buttontest(View Source) throws IOException {
       Button bt = (Button)findViewById(R.id.BT1);
        if(Flag==false) {
            bt.setBackgroundColor(Color.rgb(0, 122, 0));
            SwitchPict("2.JPG");
            Flag=true;
        }
        else
        {
            bt.setBackgroundColor(Color.CYAN);
            SwitchPict("benny1.JPG");
            Flag=false;

        }

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


          ImageView jpgView = (ImageView)findViewById(R.id.jpgview);
        String myJpgPath = Environment.getExternalStorageDirectory().getPath()+ "/benny1.JPG";
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
}
