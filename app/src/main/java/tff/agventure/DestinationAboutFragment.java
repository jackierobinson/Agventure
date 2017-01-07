package tff.agventure;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DestinationAboutFragment extends Fragment{
    private TextView mNameTextView;
    private TextView mHoursTextView;
    private TextView mAddressTextView;
    private TextView mPhoneTextView;
    private TextView mEmailTextView;
    private TextView mAboutTextView;
    private Destination mDestination;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_destination_about, container, false);

        mNameTextView = (TextView) view
                .findViewById(R.id.about_destination_name);

        mHoursTextView = (TextView) view
                .findViewById(R.id.about_destination_hours);

        mAddressTextView = (TextView) view
                .findViewById(R.id.about_destination_address);

        mEmailTextView = (TextView) view
                .findViewById(R.id.about_destination_email);

        mPhoneTextView = (TextView) view
                .findViewById(R.id.about_destination_phone_number);

        mAboutTextView = (TextView) view
                .findViewById(R.id.about_destination);

        mDestination = (Destination) getActivity().getIntent().getSerializableExtra("tff.agventure.destination_list.destination");

        setTextViews();

        return view;
    }

    private void setTextViews(){
        mNameTextView.setText(mDestination.getName());
        mHoursTextView.setText(mDestination.getContactInfo().getHours());
        mAddressTextView.setText(mDestination.getContactInfo().getAddress());
        mEmailTextView.setText(mDestination.getContactInfo().getEmail());
        mPhoneTextView.setText(mDestination.getContactInfo().getPhoneNumber());
        mAboutTextView.setText(mDestination.getAbout());


    }

}
