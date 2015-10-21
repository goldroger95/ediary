package com.example.devanksriram.ediary;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;


public class PostHomework extends Activity {

    private EditText hw;
    private Button post,viewhw;
    String homework;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_homework);

        hw=(EditText)findViewById(R.id.hw);
        post=(Button)findViewById(R.id.post);
        viewhw=(Button)findViewById(R.id.viewhw);

        post.setOnClickListener(new Button.OnClickListener(){

            public void onClick(View v){
               homework=getHomeWork();
                //connect to required url
                URL url= new URL();
                try {
                    URLConnection con=url.openConnection();
                    con.setDoOutput(true);
                    OutputStreamWriter or=new OutputStreamWriter(con.getOutputStream());
                    or.write(homework);
                    or.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        viewhw.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(this,ViewHomework.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public String getHomeWork(){
        return hw.getText().toString();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_post_homework, menu);
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
