package com.liessu.gentlebreeze.view;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
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
import com.liessu.gentlebreeze.adapter.GFragmentPagerAdapter;
import com.liessu.gentlebreeze.model.AQI;
import com.liessu.gentlebreeze.model.HeWeather;
import com.liessu.gentlebreeze.model.HeWeatherJson;
import com.liessu.gentlebreeze.model.NowWeather;
import com.liessu.gentlebreeze.model.Wind;
import com.liessu.gentlebreeze.service.HeWeatherService;
import com.liessu.gentlebreeze.util.FormatUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeActivity extends AppCompatActivity {

    @Bind(R.id.home_tb)
    Toolbar homeToolbar;
    @Bind(R.id.temperature_tv)
    TextView temperatureTextView;
    @Bind(R.id.code_iv)
    ImageView codeImageView;
    @Bind(R.id.left_info_tv)
    TextView leftInfoTextView;
    @Bind(R.id.right_info_tv)
    TextView rightInfoTextView;
    @Bind(R.id.update_time_tv)
    TextView updateTimeTextView;
    @Bind(R.id.home_abl)
    AppBarLayout homeAppBarLayout;
    @Bind(R.id.home_tl)
    TabLayout homeTabLayout;
    @Bind(R.id.home_vp)
    ViewPager homeViewPager;
    @Bind(R.id.city_home_lv)
    ListView cityHomeListView;
    @Bind(R.id.home_dl)
    DrawerLayout homeDrawerLayout;

    private ActionBarDrawerToggle homeDrawerToggle;
    private ArrayList<IUpdateUICallback> updateUIListeners;


    private String[] menuItem = {"城市01", "城市02", "城市03", "城市04", "城市05", "城市06", "城市01", "城市02", "城市03", "城市04", "城市05", "城市06"
            , "城市01", "城市02", "城市03", "城市04", "城市05", "城市06", "城市01", "城市02", "城市03", "城市04", "城市05", "城市06", "城市01", "城市02", "城市03", "城市04", "城市05", "城市06"
            , "城市01", "城市02", "城市03", "城市04", "城市05", "城市06"};

    /*************************************************
     * Listeners
     */
    private AdapterView.OnItemClickListener mOnDrawerItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Snackbar.make(homeDrawerLayout, menuItem[position], Snackbar.LENGTH_SHORT).show();
            homeDrawerLayout.closeDrawer(cityHomeListView);
            cityHomeListView.setItemChecked(position, true);

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setTitle("龙南");
        ButterKnife.bind(this);
        createTabViews();

        setSupportActionBar(homeToolbar);
        getSupportActionBar().setElevation(0);
        //创建抽屉状态开关
        homeDrawerToggle = new ActionBarDrawerToggle(this, homeDrawerLayout, homeToolbar,
                R.string.action_settings, R.string.action_settings);
        homeDrawerToggle.syncState();
        homeDrawerLayout.setDrawerListener(homeDrawerToggle);
        //TODO ： 将抽屉内布局改为NavigationView
        cityHomeListView.setAdapter(new ArrayAdapter<String>(this, R.layout.item_drawer_home,
                R.id.item_name, menuItem));
        cityHomeListView.setOnItemClickListener(mOnDrawerItemClickListener);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Snackbar.make(homeDrawerLayout, item.getTitle(), Snackbar.LENGTH_SHORT).show();
        String API_URL = "http://apis.baidu.com/heweather/weather/";

        Gson gson = new GsonBuilder().setFieldNamingPolicy(
                FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .setDateFormat("yyyy-MM-dd HH:mm:ss").create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        HeWeatherService heWeatherService = retrofit.create(HeWeatherService.class);
        Call<HeWeatherJson> weatherCall = heWeatherService.obtainForecast("08b8b9ebd408bcc85b3ac4190195b46e", "longnan");
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
     *
     * @param heWeather 气象对象
     */
    private void updateData(HeWeather heWeather) {
        if (heWeather == null) {
            return;
        }

        NowWeather nowWeather = heWeather.getNowWeather();
        temperatureTextView.setText(String.format(getString(R.string.temperature), nowWeather.getTmp()));
        updateHomeData(heWeather);

        String updateDate = FormatUtil.dateFormat(heWeather.getBasic().getUpdateDate().getLoc(),
                "yyyy-MM-dd HH:mm", "HH:mm");
        updateTimeTextView.setText(String.format(getString(R.string.release_time), updateDate));

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        int imageCodeID = FormatUtil.obtainImageIdentifier(this,nowWeather.getCond().getCode(),
                simpleDateFormat.format(new Date()));
        codeImageView.setImageResource(imageCodeID);

    }

    /**
     * 更新主页可伸缩区内容
     *
     * @param heWeather 天气对象
     */
    private void updateHomeData(HeWeather heWeather) {
        //TODO:更新天气ICON
        //TODO : 定制信息栏内容
        NowWeather nowWeather = heWeather.getNowWeather();
        rightInfoTextView.setText(String.format(getString(R.string.hum), nowWeather.getHum()));
        //该城市没有空气指数检测
        if (heWeather.getAqi() == null) {
            Wind wind = nowWeather.getWind();
            leftInfoTextView.setText(String.format(getString(R.string.wind), wind.getDir(), wind.getSc()));
        } else {//该城市有空气指数检测
            AQI.AqiCity aqiCity = heWeather.getAqi().getCity();
            leftInfoTextView.setText(Html.fromHtml(String.format(getString(R.string.aqi), aqiCity.getQlty(), aqiCity.getPm25())));
        }
    }


    /**
     * 设置TabLayout属性、创建VIewPager分页内容
     */
    private void createTabViews() {
        GFragmentPagerAdapter fragmentAdpaer = new GFragmentPagerAdapter(getSupportFragmentManager(), null, null);
        fragmentAdpaer.addFragment(new RealTimeFragment(), "实时天气");
        fragmentAdpaer.addFragment(new HourlyFragment(), "当天预报");
        fragmentAdpaer.addFragment(new DailyFragment(), "未来天气");
        fragmentAdpaer.addFragment(new IndexFragment(), "生活指数");
        homeViewPager.setAdapter(fragmentAdpaer);
        homeViewPager.setCurrentItem(0); //TODO：设置中设置默认分页
        homeTabLayout.setupWithViewPager(homeViewPager);
    }

    public void setUpdateUIListener(IUpdateUICallback callback){
        updateUIListeners.add(callback);
    }

}
