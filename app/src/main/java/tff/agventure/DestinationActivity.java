package tff.agventure;

import android.support.v4.app.Fragment;

public class DestinationActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment(){
        return new DestinationFragment();
    }
}
