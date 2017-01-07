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
    private List<String> mGroupItems;
    private HashMap<String, List<String>> mChildItems;
    private ExpandableListView mFaqsExpandableListView;
    private ExpandableListAdapter mFaqsExpandableListAdapter;
    private Destination mDestination;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_destination_faqs, container, false);

        mDestination = (Destination) getActivity().getIntent().getSerializableExtra("tff.agventure.destination_list.destination");

        mFaqsExpandableListView = (ExpandableListView) view
                .findViewById(R.id.faqs);

        mFaqsExpandableListAdapter = new ExpandableListAdapter(getActivity(), mDestination.getFaqs().getFaqsQuestions(), mDestination.getFaqs().getFaqsAnswers());
        mFaqsExpandableListView.setAdapter(mFaqsExpandableListAdapter);
        return view;
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
