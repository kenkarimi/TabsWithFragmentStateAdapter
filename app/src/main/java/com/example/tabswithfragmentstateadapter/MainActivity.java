package com.example.tabswithfragmentstateadapter;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    private CoordinatorLayout coordinatorLayout;
    private Toolbar toolbar;
    TabLayout tabLayout; //To make it accessible from fragments
    private ViewPager2 viewPager2;
    private ViewPagerAdapter viewPagerAdapter;
    private TabLayoutMediator tabLayoutMediator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.coordinator_activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager2 = (ViewPager2) findViewById(R.id.viewPager2);

        //Auto-generated with project when the option is New Project with Empty View Activity.

        /**
         * Tabs used to be done with ViewPager and FragmentPagerAdapter, which was deprecated in favor of FragmentStatePagerAdapter
         * FragmentStatePagerAdapter was then deprecated in 2022 in favor of using ViewPager2 and FragmentStateAdapter
         * They both offer improved performance, better memory management, and additional features like prefetching and recycling.
         * The primary reason to migrate is that ViewPager2 is receiving active development support and ViewPager is not.
         * ViewPager2 supports vertical paging(fragments swipe up & down) in addition to traditional horizontal paging(fragments swipe left & right). This is done by setting its android:orientation attribute.
         * ViewPager2 supports right-to-left (RTL) paging. RTL paging is enabled automatically where appropriate based on locale, but you can also manually enable RTL paging for a ViewPager2 element by setting its 'layoutDirection' attribute. LTR is the default. This attribute only works if the ViewPager2 'orientation' is horizontal.
         * ViewPager2 supports paging through a modifiable collection of fragments, calling notifyDatasetChanged() to update the UI when the underlying collection changes.
         * More on ViewPager2: https://developer.android.com/develop/ui/views/animations/vp2-migration
         * Sliding between fragments with ViewPager2 and FragmentStateAdapter: https://developer.android.com/develop/ui/views/animations/screen-slide-2#java
         * */
        viewPagerAdapter = new ViewPagerAdapter(MainActivity.this);
        viewPagerAdapter.addFragments(new Past(), "Past");
        viewPagerAdapter.addFragments(new Present(), "Present");
        viewPagerAdapter.addFragments(new Upcoming(), "Upcoming");

        viewPager2.setAdapter(viewPagerAdapter);
        tabLayoutMediator = new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() { //Replacement for tabLayout.setupWithViewPager(viewPager2); which is how we did it in ViewPager.
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(viewPagerAdapter.getPageTitle(position)); //Setting titles to the tabs.
            }
        });
        tabLayoutMediator.attach();

        tabLayout.setVisibility(View.VISIBLE);
        viewPager2.setVisibility(View.VISIBLE);
    }
}