/*
package tff.agventure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.sql.Time;
import java.util.HashMap;
import java.util.List;

*/
/**
 * Created by Jackie on 1/6/2017.
 *//*

public class TimesOfOperationListFragment extends Fragment{
    private RecyclerView mTimesOfOperationsRecyclerView;
    private TimesOfOperationAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_destination_about, container, false);

        mTimesOfOperationsRecyclerView = (RecyclerView) view
                .findViewById(R.id.destination_recycler_view);
        mTimesOfOperationsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }

    private void updateUI(){
        Destinations destinations = Destinations.get(getActivity());
        List<Destination> destinationsList = destinations.getDestinations();

        mAdapter = new TimesOfOperationAdapter();
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
                    .inflate(R.layout.list_item_destination, parent, false);
            return new TimesOfOperationHolder(view);
        }

        @Override
        public void onBindViewHolder(TimesOfOperationHolder holder, int position) {
            TimeOfOperation timeOfOperation = mTimesOfOperation.get(position);
            holder.bindTimesOfOperations(timeOfOperation);

        }

        @Override
        public int getItemCount() {
            return 0;
        }
    }
}
*/
