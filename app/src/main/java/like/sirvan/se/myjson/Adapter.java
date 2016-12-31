package like.sirvan.se.myjson;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.dataListHolder> {

    private List<Dateget> dategets;

    public Adapter(List<Dateget> dategets) {
        this.dategets = dategets;
    }

    @Override
    public dataListHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_view,parent,false);

        return new dataListHolder(view);
    }

    @Override
    public void onBindViewHolder(dataListHolder holder, int position) {

        Dateget dateget = dategets.get(position);

        holder.Id.setText(dateget.getId());
        holder.Locate.setText(dateget.getLocate());

    }

    public void addItem(List<Dateget> items) {

      //  dategets.clear();
        dategets.addAll(items);
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        return dategets.size();
    }

    public class dataListHolder extends RecyclerView.ViewHolder{

        public TextView Id;
        public TextView Locate;

        public dataListHolder(View itemView) {
            super(itemView);

            Id = (TextView) itemView.findViewById(R.id.Id);
            Locate = (TextView) itemView.findViewById(R.id.name);
        }
    }
}
