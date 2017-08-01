package com.ramotion.foldingcell.examples.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ramotion.foldingcell.FoldingCell;
import com.ramotion.foldingcell.examples.R;

import java.util.HashSet;
import java.util.List;

/**
 * Simple example of ListAdapter for using with Folding Cell
 * Adapter holds indexes of unfolded elements for correct work with default reusable views behavior
 */
public class FoldingCellListAdapter extends ArrayAdapter<App> {

    private HashSet<Integer> unfoldedIndexes = new HashSet<>();
    private View.OnClickListener defaultRequestBtnClickListener;


    public FoldingCellListAdapter(Context context, List<App> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // get item for selected view
        App app = getItem(position);
        // if cell is exists - reuse it, if not - create the new one from resource
        FoldingCell cell = (FoldingCell) convertView;
        ViewHolder viewHolder;
        if (cell == null) {
            viewHolder = new ViewHolder();
            LayoutInflater vi = LayoutInflater.from(getContext());
            cell = (FoldingCell) vi.inflate(R.layout.cell, parent, false);
            // binding view parts to view holder
         //   viewHolder.time = (TextView) cell.findViewById(R.id.title_time_label);
        //    viewHolder.date = (TextView) cell.findViewById(R.id.title_date_label);
            viewHolder.title = (TextView) cell.findViewById(R.id.textview_title);
            viewHolder.description = (TextView) cell.findViewById(R.id.textview_description);
        //    viewHolder.requestsCount = (TextView) cell.findViewById(R.id.title_requests_count);
        //    viewHolder.pledgePrice = (TextView) cell.findViewById(R.id.title_pledge);
       //   viewHolder.contentRequestBtn = (TextView) cell.findViewById(R.id.content_request_btn);
            viewHolder.content_title = (TextView) cell.findViewById(R.id.textview_content_title);
            viewHolder.content_description= (TextView) cell.findViewById(R.id.textview_content_description);
            viewHolder.content_details=(TextView)cell.findViewById(R.id.textview_content_detail);
            viewHolder.version=(TextView)cell.findViewById(R.id.textview_version_number);
            viewHolder.update=(TextView)cell.findViewById(R.id.textview_update_date);
            cell.setTag(viewHolder);
        } else {
            // for existing cell set valid valid state(without animation)
            if (unfoldedIndexes.contains(position)) {
                cell.unfold(true);
            } else {
                cell.fold(true);
            }
            viewHolder = (ViewHolder) cell.getTag();
        }

        // bind data from selected element to view through view holder
     //   viewHolder.price.setText(item.getPrice());
//        viewHolder.time.setText(item.getTime());
//        viewHolder.date.setText(item.getDate());

        viewHolder.title.setText(app.getTitle());
        viewHolder.description.setText(app.getDescription());
        viewHolder.content_title.setText(app.getTitle());
        viewHolder.content_description.setText(app.getDescription());
        viewHolder.content_details.setText(app.getDetail_description());
        viewHolder.version.setText(app.getVersion());
        viewHolder.update.setText(app.getUpdate());
     //   viewHolder.requestsCount.setText(String.valueOf(item.getRequestsCount()));
   //     viewHolder.pledgePrice.setText(item.getPledgePrice());
        // set custom btn handler for list item from that item

  /*      if (app.getRequestBtnClickListener() != null) {
            viewHolder.contentRequestBtn.setOnClickListener(app.getRequestBtnClickListener());
        } else {
            // (optionally) add "default" handler if no handler found in item
            viewHolder.contentRequestBtn.setOnClickListener(defaultRequestBtnClickListener);
        }
*/

        return cell;
    }

    // simple methods for register cell state changes
    public void registerToggle(int position) {
        if (unfoldedIndexes.contains(position))
            registerFold(position);
        else
            registerUnfold(position);
    }

    public void registerFold(int position) {
        unfoldedIndexes.remove(position);
    }

    public void registerUnfold(int position) {
        unfoldedIndexes.add(position);
    }

    public View.OnClickListener getDefaultRequestBtnClickListener() {
        return defaultRequestBtnClickListener;
    }

    public void setDefaultRequestBtnClickListener(View.OnClickListener defaultRequestBtnClickListener) {
        this.defaultRequestBtnClickListener = defaultRequestBtnClickListener;
    }

    // View lookup cache
    private static class ViewHolder {
        ImageView abc;
      //  TextView price;
    //    TextView contentRequestBtn;
        TextView pledgePrice;
        TextView title;
        TextView description;
        TextView content_title;
        TextView content_description;
        TextView content_details;
        TextView version;
        TextView update;

      //  TextView requestsCount;
        TextView date;
        TextView time;
    }
}
