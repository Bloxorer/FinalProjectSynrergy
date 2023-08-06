package viewmodel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalprojectsynrergy.R;

import java.util.List;

import model.Bottles;

public class BottleAdapter extends RecyclerView.Adapter<BottleAdapter.ViewHolder> {
    private final LayoutInflater inflater;
    private final List<Bottles> bottles;

    public BottleAdapter(LayoutInflater inflater, List<Bottles> bottles) {
        this.inflater = inflater;
        this.bottles = bottles;
    }


    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Bottles bottle = bottles.get(position);
        holder.imageView.setImageResource(bottle.getBottleResourse());
        holder.number.setText(bottle.getNumber());
        holder.name.setText(bottle.getName());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        final ImageView imageView;
        final TextView number, name;
        public ViewHolder(View itemView) {
            super(itemView);
            number = itemView.findViewById(R.id.number_bottle);
            name = itemView.findViewById(R.id.name_bottle);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }

}
