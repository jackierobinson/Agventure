package tff.agventure;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DestinationFaqsFragment extends Fragment{
    List<String> mGroupItems;
    HashMap<String, List<String>> mChildItems;
    ExpandableListView mFaqsExpandableListView;
    ExpandableListAdapter mFaqsExpandableListAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_destination_faqs, container, false);

        createGroups();
        createChildren();

        mFaqsExpandableListView = (ExpandableListView) view
                .findViewById(R.id.faqs);

        mFaqsExpandableListAdapter = new ExpandableListAdapter(getActivity(), mGroupItems, mChildItems);
        mFaqsExpandableListView.setAdapter(mFaqsExpandableListAdapter);
        return view;
    }

    private void createGroups (){
        mGroupItems = new ArrayList<>();
        mGroupItems.add( "Is housing provided?");
        mGroupItems.add("Do you offer disability accommodations?");
        mGroupItems.add("What food options are available?");
    }

    private void createChildren(){
        mChildItems = new HashMap<>();
        List<String> child1 = new ArrayList<>();
        List<String> child2 = new ArrayList<>();
        List<String> child3 = new ArrayList<>();
        child1.add("No, but there is a nearby hotel.");
        child2.add("Yes, we can accommodate wheelchairs and service dogs.");
        child3.add("We have vegan, gluten free, and meat options");
        mChildItems.put("Is housing provided?", child1);
        mChildItems.put("Do you offer disability accommodations?", child2);
        mChildItems.put("What food options are available?", child3);
    }

    private class ExpandableListAdapter extends BaseExpandableListAdapter{
        private Context mContext;
        private List<String> mGroupItems;
        private HashMap<String, List<String>> mChildItems;

        public ExpandableListAdapter(Context context, List<String> groupItems,
                                     HashMap<String, List<String>> childItems) {
            mContext = context;
            mGroupItems = groupItems;
            mChildItems = childItems;
        }

        @Override
        public int getGroupCount() {
            return mGroupItems.size();
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            String groupItem = mGroupItems.get(groupPosition);
            return mChildItems.get(groupItem).size();
        }

        @Override
        public Object getGroup(int groupPosition) {
            return mGroupItems.get(groupPosition);
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            String groupItem = mGroupItems.get(childPosition);
            return mChildItems.get(groupItem).get(childPosition);
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
            String groupItem = (String) getGroup(groupPosition);
            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) mContext
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.group_item, null);
            }

            TextView groupItemTextView = (TextView) convertView
                    .findViewById(R.id.group_item);
            groupItemTextView.setText(groupItem);

            return convertView;
        }

        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
            final String childItem = (String) getChild(groupPosition, childPosition);

            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) mContext
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.child_item, null);
            }

            TextView childItemTextView = (TextView) convertView
                    .findViewById(R.id.child_item);

            childItemTextView.setText(childItem);
            return convertView;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return false;
        }
    }
}
