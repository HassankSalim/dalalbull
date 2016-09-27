package excelmec.dalalbull;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.TabLayout;
import android.view.View;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.tool_bar); // Attaching the layout to the toolbar object
        setSupportActionBar(toolbar);// Setting toolbar as the ActionBar with setSupportActionBar() call
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setupViewPager(viewPager);
        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        tabs.getTabAt(0).setIcon(R.drawable.graph);
        tabs.getTabAt(1).setIcon(R.drawable.list);
        tabs.getTabAt(2).setIcon(R.drawable.pro);
        tabs.getTabAt(3).setIcon(R.drawable.trophy);
        tabs.setOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager) {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                super.onTabSelected(tab);
                int position = tab.getPosition();
                switch(position){
                    case 0: tab.setIcon(R.drawable.arrowgreen);

                            break;
                    case 1: tab.setIcon(R.drawable.listgreen);
                        break;
                    case 2: tab.setIcon(R.drawable.progreen);
                        break;
                    case 3: tab.setIcon(R.drawable.trophygreen);
                        break;
                    default:
                }
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                super.onTabUnselected(tab);
                int position = tab.getPosition();
                switch(position){
                    case 0: tab.setIcon(R.drawable.graph);
                        break;
                    case 1: tab.setIcon(R.drawable.list);
                        break;
                    case 2: tab.setIcon(R.drawable.pro);
                        break;
                    case 3: tab.setIcon(R.drawable.trophy);
                        break;
                    default:
                }
            }
        });
    }


    private void setupViewPager(ViewPager viewPager) {
        Adapter adapter = new Adapter(getSupportFragmentManager());
        adapter.addFragment(new fragment_nifty(), "Nifty");
        adapter.addFragment(new fragment_stocklist(), "Stocklist");
        adapter.addFragment(new fragment_userstock(), "UserStock");
        adapter.addFragment(new fragment_leaderboard(), "Leaderboard");
        viewPager.setAdapter(adapter);
    }

    static class Adapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public Adapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

}