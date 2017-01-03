package tff.agventure;

import android.support.v4.app.Fragment;

public class DestinationListActivity extends SingleFragmentActivity{

    @Override
    protected Fragment createFragment() {
        return new DestinationListFragment();
    }
}
