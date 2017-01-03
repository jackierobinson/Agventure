package tff.agventure;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class DestinationFragment extends Fragment{
    private Destination mDestination;
    private TextView mNameField;
    private TextView mDescriptionField;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDestination = new Destination();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_destination, container, false);
        mNameField = (TextView) v.findViewById(R.id.destination_name);
        mDescriptionField = (TextView) v.findViewById(R.id.destination_description);
        return v;
    }
}
