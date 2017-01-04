package tff.agventure;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DestinationListActivity extends SingleFragmentActivity{

    private ListView mDrawerList;
    private ArrayAdapter<String> mAdapter;
    private DrawerLayout mDrawerLayout;
    String[] mItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        mDrawerList = (ListView) findViewById(R.id.drawer_list);
        mItems = getResources().getStringArray(R.array.drawer_items);
        mDrawerList.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, mItems));
    }

    @Override
    protected Fragment createFragment() {
        return new DestinationListFragment();
    }
}
