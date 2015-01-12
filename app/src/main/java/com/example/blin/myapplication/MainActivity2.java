package com.example.blin.myapplication;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//http://blog.csdn.net/zhyl8157121/article/details/7992274
//http://www.oschina.net/question/54100_32486

public class MainActivity2 extends ActionBarActivity {
    protected void dialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity2.this);
        builder.setMessage("确认退出吗？");
        builder.setTitle("提示");
        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
              public void onClick(DialogInterface dialog, int which) {
             dialog.dismiss();
                  MainActivity2.this.finish();
            }
             });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
              public void onClick(DialogInterface dialog, int which) {
               dialog.dismiss();
              }
             });
         builder.create().show();
        }
    void Dialog_3B(){
        Dialog dialog = new AlertDialog.Builder(this).setIcon(
              android.R.drawable.btn_star).setTitle("喜好调查").setMessage(
              "你喜欢李连杰的电影吗？").setPositiveButton("很喜欢",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub
                        Toast.makeText(MainActivity2.this, "我很喜欢他的电影。",
                                Toast.LENGTH_LONG).show();
                    }
                }).setNegativeButton("不喜欢", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                Toast.makeText(MainActivity2.this, "我不喜欢他的电影。", Toast.LENGTH_LONG)
                        .show();
            }
        }).setNeutralButton("一般", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                Toast.makeText(MainActivity2.this, "谈不上喜欢不喜欢。", Toast.LENGTH_LONG)
                        .show();
            }
        }).create();
        dialog.show();

    }
    void Dialog_Input(){
        new AlertDialog.Builder(this).setTitle("请输入").setIcon(
                android.R.drawable.ic_dialog_info).setView(
                new EditText(this)).setPositiveButton("确定", null)
                .setNegativeButton("取消", null).show();

    }


    protected void onCreate(Bundle savedInstanceState) {
        Button progress,progress2,progress3,progress4;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2);
        progress=(Button)findViewById(R.id.BT3);
        progress2=(Button)findViewById(R.id.BT4);
        progress3=(Button)findViewById(R.id.BT5);
        progress4=(Button)findViewById(R.id.BT6);
        progress.setOnClickListener(new View.OnClickListener() {

           		@Override
           		public void onClick(View arg0) {
               			// TODO Auto-generated method stub

               		//	showDialog(flagProgress);

                    dialog();

               		}
            		});
           progress2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                //	showDialog(flagProgress);

                Dialog_3B();

            }
        });

        progress3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                //	showDialog(flagProgress);
                Dialog_Input();
//                Toast.makeText(MainActivity2.this, "我很喜欢他的电影。",
//                        Toast.LENGTH_LONG).show();
            }
        });
        progress4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                //	showDialog(flagProgress);

                Toast.makeText(MainActivity2.this, "1111",
                        Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        try {

            new AlertDialog.Builder(this).setTitle("确认退出吗？")
//                    .setIcon(android.R.drawable.ic_dialog_info)
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // 点击“确认”后的操作
                            MainActivity2.this.finish();

                        }
                    })
                    .setNegativeButton("返回", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // 点击“返回”后的操作,这里不设置没有任何操作
                        }
                    }).show();
            // super.onBackPressed();
        }
        catch (Exception e)
        {
            System.err.print(e.toString());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity2, menu);
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
