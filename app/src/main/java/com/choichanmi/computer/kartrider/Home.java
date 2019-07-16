package com.choichanmi.computer.kartrider;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//import android.widget.Toolbar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Home extends AppCompatActivity {
    Toolbar myToolbar;
    String userName="최찬미";
    SeekBar seekBar;
    TextView mText;
    ListView productList;
    MyProductAdapter myProductAdapter;
    MyProductList[] myProductList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        seekBar = findViewById(R.id.seekBar1);
        mText = findViewById(R.id.curMoney);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                setText();
                mText.setText(""+progress+"원");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //ToorBar 생성
        myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        //추가된 소스코드, Toolbar의 왼쪽에 버튼을 추가하고 버튼의 아이콘을 바꾼다.
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.menu_three_line);
        getSupportActionBar().setTitle(userName + "님의 카트라이더");

        //내가 담은 상품 부분

        //이건 없애야해용
        myProductList = new MyProductList[6];

        for(int i=0;i<6;i++){
            myProductList[i] = new MyProductList(Integer.toString(i) +"번",Integer.toString(i)+"000",Integer.toString(i)+"0g","국산");
            /*myProductList[i].setName(Integer.toString(i) +"번");
            myProductList[i].setPrice(Integer.toString(i)+"000");
            myProductList[i].setCapacity(Integer.toString(i)+"0g");
            myProductList[i].setCountry("국산");*/
        }

        productList = findViewById(R.id.listViewProduct);
        myProductAdapter = new MyProductAdapter(Home.this, myProductList);
        productList.setAdapter(myProductAdapter);
    }
    //추가된 소스, ToolBar에 menu.xml을 인플레이트함
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    //추가된 소스, ToolBar에 추가된 항목의 select 이벤트를 처리하는 함수
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //return super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case R.id.action_settings:
                // User chose the "Settings" item, show the app settings UI...
                Toast.makeText(getApplicationContext(), "환경설정 버튼 클릭됨", Toast.LENGTH_LONG).show();
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                Toast.makeText(getApplicationContext(), "나머지 버튼 클릭됨", Toast.LENGTH_LONG).show();
                return super.onOptionsItemSelected(item);

        }
    }
    private void setText(){
        int progress = seekBar.getProgress();
        int max = seekBar.getMax();
        int offset = seekBar.getThumbOffset();
        float percent = ((float)progress)/(float)max;
        int width = seekBar.getWidth() - 2*offset;

        int answer =((int)(width*percent +offset - mText.getWidth()/2));
        mText.setX(answer);
    }
}
