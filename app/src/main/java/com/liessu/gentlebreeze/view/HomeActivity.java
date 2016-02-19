package com.liessu.gentlebreeze.view;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.liessu.gentlebreeze.R;
import com.liessu.gentlebreeze.adapter.ForecastAdapter;
import com.liessu.gentlebreeze.model.AQI;
import com.liessu.gentlebreeze.model.HeWeather;
import com.liessu.gentlebreeze.model.HeWeatherJson;
import com.liessu.gentlebreeze.model.NowWeather;
import com.liessu.gentlebreeze.model.Wind;
import com.liessu.gentlebreeze.service.HeWeatherService;
import com.liessu.gentlebreeze.util.FormatUtil;


import java.text.SimpleDateFormat;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeActivity extends AppCompatActivity {

    private TextView mTemperatureTextView;
    private ImageView mCodeImageView;
    private TextView mLeftTextView;
    private TextView mRightTextView;


    private TextView mUpdateTimeTextView;
    private TabLayout mHomeTabLayout;
    private RecyclerView mHomeRecyclerView;
    private ViewPager mHomeViewPager;
    private DrawerLayout mHomeDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private ListView mListmenuHomeListView;
    private Toolbar mHomeToolbar;
    private AppBarLayout mHomeAppBarLayout;

    private String[] menuItem = {"城市01", "城市02", "城市03", "城市04", "城市05", "城市06", "城市01", "城市02", "城市03", "城市04", "城市05", "城市06"
            , "城市01", "城市02", "城市03", "城市04", "城市05", "城市06", "城市01", "城市02", "城市03", "城市04", "城市05", "城市06", "城市01", "城市02", "城市03", "城市04", "城市05", "城市06"
            , "城市01", "城市02", "城市03", "城市04", "城市05", "城市06"};

    /*************************************************
     * Listeners
     */
    private AdapterView.OnItemClickListener mOnDrawerItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Snackbar.make(mHomeDrawerLayout, menuItem[position], Snackbar.LENGTH_SHORT).show();
            mHomeDrawerLayout.closeDrawer(mListmenuHomeListView);
            mListmenuHomeListView.setItemChecked(position, true);

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setTitle("赣州");
        bindViews();

        mHomeTabLayout.addTab(mHomeTabLayout.newTab().setText("实时天气"));
        mHomeTabLayout.addTab(mHomeTabLayout.newTab().setText("生活指数"));
        mHomeTabLayout.addTab(mHomeTabLayout.newTab().setText("当天预报"));
        mHomeTabLayout.addTab(mHomeTabLayout.newTab().setText("未来天气"));
//        mTabLayout.addTab(mTabLayout.newTab().setText("空气质量"));
        mHomeRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mHomeRecyclerView.setAdapter(new ForecastAdapter(menuItem));
        setSupportActionBar(mHomeToolbar);
        getSupportActionBar().setElevation(0);
        mDrawerToggle = new ActionBarDrawerToggle(this, mHomeDrawerLayout, mHomeToolbar,
                R.string.action_settings, R.string.action_settings);
        mDrawerToggle.syncState();
        mHomeDrawerLayout.setDrawerListener(mDrawerToggle);
        mListmenuHomeListView.setAdapter(new ArrayAdapter<String>(this, R.layout.item_drawer_home,
                R.id.item_name, menuItem));
        mListmenuHomeListView.setOnItemClickListener(mOnDrawerItemClickListener);


        mHomeAppBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {

//                if(verticalOffset < -400){
//                    mRelative01.setVisibility(View.GONE);
//                    mRelative02.setVisibility(View.VISIBLE);
////                    ViewGroup.LayoutParams layoutParams = mRelative02.getLayoutParams();
////                    layoutParams.height = 400;
////                    mRelative02.setLayoutParams(layoutParams);
//                    System.out.println("------------Up Offset : " + verticalOffset + "     height"+mRelative02.getHeight());
//                }else {
//                    mRelative01.setVisibility(View.VISIBLE);
//                    System.out.println("Down Offset : " + verticalOffset);
//                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Snackbar.make(mHomeDrawerLayout, item.getTitle(), Snackbar.LENGTH_SHORT).show();
        String API_URL = "http://apis.baidu.com/heweather/weather/";

        Gson gson = new GsonBuilder().setFieldNamingPolicy(
                FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .setDateFormat("yyyy-MM-dd HH:mm:ss").create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        HeWeatherService heWeatherService = retrofit.create(HeWeatherService.class);
        Call<HeWeatherJson> weatherCall = heWeatherService.obtainForecast("08b8b9ebd408bcc85b3ac4190195b46e","longnan");
        weatherCall.enqueue(new Callback<HeWeatherJson>() {
            @Override
            public void onResponse(Call<HeWeatherJson> call, Response<HeWeatherJson> response) {
                System.out.println("Finish");
                HeWeatherJson heWeathers = response.body();
                //TODO : 判断是否有多个结果

                updateData(heWeathers.getHeWeathers().get(0));

            }

            @Override
            public void onFailure(Call<HeWeatherJson> call, Throwable t) {

            }
        });


        return super.onOptionsItemSelected(item);
    }


    /**
     * 更新预报内容
     * @param heWeather  气象对象
     */
    private void updateData(HeWeather heWeather){
        if(heWeather == null ){return;}

        NowWeather nowWeather = heWeather.getNowWeather();
        mTemperatureTextView.setText(String.format(getString(R.string.temperature),nowWeather.getTmp()));
        updateHomeData(heWeather);

        String updateDate = FormatUtil.dateFormat(heWeather.getBasic().getUpdateDate().getLoc(),
                "yyyy-MM-dd HH:mm","HH:mm");
        mUpdateTimeTextView.setText(String.format(getString(R.string.release_time),updateDate));

    }

    /**
     * 更新主页可伸缩区内容
     * @param heWeather 天气对象
     */
    private void updateHomeData(HeWeather heWeather){
        //TODO:更新天气ICON
        //TODO : 定制信息栏内容
        NowWeather nowWeather = heWeather.getNowWeather();
        mRightTextView.setText(String.format(getString(R.string.hum), nowWeather.getHum()));
        //该城市没有空气指数检测
        if(heWeather.getAqi() == null ){
            Wind wind = nowWeather.getWind();
            mLeftTextView.setText(String.format(getString(R.string.wind), wind.getDir(), wind.getSc()));
        }else{//该城市有空气指数检测
            AQI.AqiCity aqiCity = heWeather.getAqi().getCity();
            mLeftTextView.setText(Html.fromHtml(String.format(getString(R.string.aqi),aqiCity.getQlty(),aqiCity.getPm25())));
        }
    }

    /**
     * 将控件变量与控件绑定
     */
   private void bindViews(){
       //内容控件
//       setContentView(R.layout.content_home);
       mTemperatureTextView = (TextView) findViewById(R.id.txt_temperature);
       mUpdateTimeTextView = (TextView) findViewById(R.id.txt_update_time);
       mCodeImageView = (ImageView) findViewById(R.id.img_code);
       mLeftTextView = (TextView) findViewById(R.id.txt_left_home);
       mRightTextView = (TextView) findViewById(R.id.txt_right_home);

       //架构控件
       mHomeToolbar = (Toolbar) findViewById(R.id.toolbar_home);
       mHomeAppBarLayout = (AppBarLayout) findViewById(R.id.appbar_home);
       mHomeTabLayout = (TabLayout) findViewById(R.id.tab_home);
       mHomeRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_home);
       mHomeViewPager = (ViewPager) findViewById(R.id.viewpager_home);
       mListmenuHomeListView = (ListView) findViewById(R.id.listmenu_home);
       mHomeDrawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout_home);
   }
}
