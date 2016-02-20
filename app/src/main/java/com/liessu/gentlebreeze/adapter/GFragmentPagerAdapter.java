package com.liessu.gentlebreeze.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.LinkedList;

/**
 * 主页ViewPager适配器
 */
public class GFragmentPagerAdapter extends FragmentPagerAdapter{
    private LinkedList<Fragment> fragmentList;
    private LinkedList<String> titleList;

    public GFragmentPagerAdapter(FragmentManager fm,LinkedList<Fragment> fragmentList,
                                 LinkedList<String> titleList) {
        super(fm);
        if(titleList ==null || fragmentList == null)
            return;

        if(titleList.size() == fragmentList.size()){
            this.fragmentList = fragmentList;
            this.titleList = titleList;
        }
    }

    public boolean addFragment(Fragment fragment,String title){
        if(fragmentList == null){
            fragmentList = new LinkedList<>();
            titleList = new LinkedList<>();
        }

        return fragmentList.add(fragment)&&titleList.add(title);
    }

    @Override
    public Fragment getItem(int position) {
        if(fragmentList != null)
            return fragmentList.get(position);
        else
            return null;
    }

    @Override
    public int getCount() {
        if(fragmentList != null)
            return fragmentList.size();
        else
            return 0;
    }

    /**
     * 将适配器传递到TabLayout时，TabLayout会清空自己的TabTitle，并调用该方法获得新TabTitle
     */
    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }
}
