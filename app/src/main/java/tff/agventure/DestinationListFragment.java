package tff.agventure;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class DestinationListFragment extends Fragment {
    private RecyclerView mDestinationRecyclerView;
    private DestinationAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_destination_list, container, false);

        mDestinationRecyclerView = (RecyclerView) view
                .findViewById(R.id.destination_recycler_view);
        mDestinationRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }

    private void updateUI(){
        Destinations destinations = Destinations.get(getActivity());
        List<Destination> destinationsList = destinations.getDestinations();

        mAdapter = new DestinationAdapter(destinationsList);
        mDestinationRecyclerView.setAdapter(mAdapter);
    }

    private class DestinationHolder extends  RecyclerView.ViewHolder{
        private Destination mDestination;
        public TextView mNameTextView;
        public TextView mDescriptionTextView;
        public ImageView mImageView;

        public DestinationHolder(View itemView){
            super(itemView);
            mNameTextView = (TextView) itemView
                    .findViewById(R.id.list_item_destination_name);
            mDescriptionTextView = (TextView) itemView
                    .findViewById(R.id.list_item_destination_description);
            mImageView = (ImageView) itemView
                    .findViewById(R.id.list_item_destination_image);
        }

        public void bindDestination(Destination destination){
            mDestination = destination;
            mNameTextView.setText(mDestination.getName());
            mDescriptionTextView.setText(mDestination.getDescription());
            mImageView.setImageResource(mDestination.getImageId());
        }
    }

    private class DestinationAdapter extends RecyclerView.Adapter<DestinationHolder>{
        private List<Destination> mDestinations;

        public DestinationAdapter(List<Destination> destinations) {
            mDestinations = destinations;
        }


        @Override
        public DestinationHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater
                    .inflate(R.layout.list_item_destination, parent, false);
            return new DestinationHolder(view);
        }

        @Override
        public void onBindViewHolder(DestinationHolder holder, int position) {
            Destination destination = mDestinations.get(position);
            holder.bindDestination(destination);
        }

        @Override
        public int getItemCount() {
            return mDestinations.size();
        }
    }
}
