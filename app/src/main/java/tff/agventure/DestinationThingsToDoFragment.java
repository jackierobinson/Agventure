package tff.agventure;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class DestinationThingsToDoFragment extends Fragment {
    private RecyclerView mThingsToDoRecyclerView;
    private ThingsToDoAdapter mThingsToDoAdapter;
    private Destination mDestination;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_destination_things_to_do, container, false);

        mThingsToDoRecyclerView = (RecyclerView) view
                .findViewById(R.id.things_to_do_recycler_view);
        mThingsToDoRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mDestination = (Destination) getActivity().getIntent().getSerializableExtra("tff.agventure.destination_list.destination"); //

        mThingsToDoAdapter = new ThingsToDoAdapter(mDestination.getThingsToDo());
        mThingsToDoRecyclerView.setAdapter(mThingsToDoAdapter);
        return view;
    }

    private class ThingsToDoHolder extends RecyclerView.ViewHolder{
        private TextView mNameTextView;
        private TextView mDescriptionTextView;

        public ThingsToDoHolder(View itemView) {
            super(itemView);

            mNameTextView = (TextView) itemView
                    .findViewById(R.id.list_item_thing_to_do_name);

            mDescriptionTextView = (TextView) itemView
                    .findViewById(R.id.list_item_thing_to_do_description);
        }

        private void bindThingToDo(ThingToDo thingToDo){
            mNameTextView.setText(thingToDo.getName());
            mDescriptionTextView.setText(thingToDo.getDescription());
        }
    }

    private class ThingsToDoAdapter extends RecyclerView.Adapter<ThingsToDoHolder>{

        private List<ThingToDo> mThingsToDo;

        public ThingsToDoAdapter(List<ThingToDo> thingsToDo){
            mThingsToDo = thingsToDo;
        }

        @Override
        public ThingsToDoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            View view = inflater.inflate(R.layout.list_item_things_to_do, parent, false);
            return new ThingsToDoHolder(view);
        }

        @Override
        public void onBindViewHolder(ThingsToDoHolder holder, int position) {
            ThingToDo thingToDo = mThingsToDo.get(position);
            holder.bindThingToDo(thingToDo);
        }

        @Override
        public int getItemCount() {
            return mThingsToDo.size();
        }
    }
}
