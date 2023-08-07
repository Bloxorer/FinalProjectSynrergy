package viewmodel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalprojectsynrergy.R;

import java.util.List;

import model.Bottles;

public class BottleAdapter extends RecyclerView.Adapter<BottleAdapter.ViewHolder> {
    private Context context;
    private final List<Bottles> bottles;

    public BottleAdapter(Context context, List<Bottles> bottles) {
        this.context = context;
        this.bottles = bottles;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Bottles bottle = bottles.get(position);
        holder.name.setText(bottle.getName());
        holder.number.setText(bottle.getNumber());
    }

    @Override
    public int getItemCount() {
        return bottles.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        final TextView number, name;
        ConstraintLayout item_list;
        public ViewHolder(View itemView) {
            super(itemView);
            number = itemView.findViewById(R.id.number_bottle);
            name = itemView.findViewById(R.id.name_bottle);
            item_list = itemView.findViewById(R.id.item_list);
        }
    }

}
