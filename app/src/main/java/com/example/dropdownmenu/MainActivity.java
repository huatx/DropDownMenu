package com.example.dropdownmenu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private DropDownMenuView dropDownMenu;
    private GridView constellation;
    private ConstellationAdapter constellationAdapter;
    private String constellations[] = {"不限", "白羊座", "金牛座", "双子座", "巨蟹座", "狮子座", "处女座", "天秤座", "天蝎座", "射手座", "摩羯座", "水瓶座", "双鱼座"};
    private int constellationPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        constellationAdapter = new ConstellationAdapter(this, Arrays.asList(constellations));
        dropDownMenu = findViewById(R.id.dropDownMenu);
        constellation = findViewById(R.id.constellation);
        constellation.setAdapter(constellationAdapter);

        constellation.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                constellationAdapter.setCheckItem(position);
                constellationPosition = position;
                dropDownMenu.close();
            }
        });
        TextView textView = findViewById(R.id.view_filter);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!dropDownMenu.isOpen()) {
                    dropDownMenu.open();
                }
            }
        });
    }
}
