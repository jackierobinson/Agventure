package tff.agventure;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class DestinationAboutFragment extends Fragment{
    private TextView mNameTextView;
    private TextView mAddressTextView;
    private TextView mPhoneTextView;
    private TextView mEmailTextView;
    private TextView mAboutTextView;
    private Destination mDestination;
    private RecyclerView mTimesOfOperationsRecyclerView;
    private TimesOfOperationAdapter mAdapter;

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

        mAddressTextView = (TextView) view
                .findViewById(R.id.about_destination_address);

        mEmailTextView = (TextView) view
                .findViewById(R.id.about_destination_email);

        mPhoneTextView = (TextView) view
                .findViewById(R.id.about_destination_phone_number);

        mAboutTextView = (TextView) view
                .findViewById(R.id.about_destination);

        mTimesOfOperationsRecyclerView = (RecyclerView) view
                .findViewById(R.id.time_of_operation_recycler_view);
        mTimesOfOperationsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mDestination = (Destination) getActivity().getIntent().getSerializableExtra("tff.agventure.destination_list.destination");

        setTextViews();
        setUpRecyclerView();

        return view;
    }



    private void setTextViews(){
        mNameTextView.setText(mDestination.getName());
        mAddressTextView.setText(mDestination.getContactInfo().getAddress());
        mEmailTextView.setText(mDestination.getContactInfo().getEmail());
        mPhoneTextView.setText(mDestination.getContactInfo().getPhoneNumber());
        mAboutTextView.setText(mDestination.getAbout());
    }

    private void setUpRecyclerView(){
        mAdapter = new TimesOfOperationAdapter(mDestination.getContactInfo().getTimesofOperation());
        mTimesOfOperationsRecyclerView.setAdapter(mAdapter);
    }

    private class TimesOfOperationHolder extends RecyclerView.ViewHolder
    {
        private TimeOfOperation mTimeOfOperation;
        private TextView mDayTextView;
        private TextView mHourTextView;


        public TimesOfOperationHolder(View itemView){
            super(itemView);
            mDayTextView = (TextView) itemView
                    .findViewById(R.id.list_item_day);

            mHourTextView = (TextView) itemView
                    .findViewById(R.id.list_item_hour);
        }

        public void bindTimesOfOperations(TimeOfOperation timeOfOperation){
            mTimeOfOperation = timeOfOperation;
            mDayTextView.setText(mTimeOfOperation.getDay());
            mHourTextView.setText(mTimeOfOperation.getHour());
        }
    }

    private class TimesOfOperationAdapter extends RecyclerView.Adapter<TimesOfOperationHolder>{
        private List<TimeOfOperation> mTimesOfOperation;

        public TimesOfOperationAdapter(List<TimeOfOperation> timesOfOperation){
            mTimesOfOperation = timesOfOperation;
        }

        @Override
        public TimesOfOperationHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater
                    .inflate(R.layout.list_item_time_of_operation, parent, false);
            return new TimesOfOperationHolder(view);
        }

        @Override
        public void onBindViewHolder(TimesOfOperationHolder holder, int position) {
            TimeOfOperation timeOfOperation = mTimesOfOperation.get(position);
            holder.bindTimesOfOperations(timeOfOperation);

        }

        @Override
        public int getItemCount() {
            return mTimesOfOperation.size();
        }
    }

}
