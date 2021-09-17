package g.gomez.actividadandroids1.adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import g.gomez.actividadandroids1.R;
import g.gomez.actividadandroids1.classes.RecetaPizza;

public class RecetaAdapter extends RecyclerView.Adapter<RecetaAdapter.ViewHolder> {

    ArrayList<RecetaPizza> recetasArrayList;

    public RecetaAdapter(ArrayList<RecetaPizza> recetasArrayList) {

        this.recetasArrayList = recetasArrayList;
    }


    @NonNull
    @Override
    public RecetaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_receta, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecetaAdapter.ViewHolder holder, int position) {
        holder.printInfo(recetasArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return recetasArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewNombre, textViewPrincipal,
                 textViewBase, textViewIngredientes,
                 textViewAlinios, textViewPrecio;
        ImageView imageViewPrincipal;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewNombre = itemView.findViewById(R.id.textViewNombre);
            textViewPrincipal = itemView.findViewById(R.id.textViewPrincipal);
            textViewBase = itemView.findViewById(R.id.textViewBase);
            imageViewPrincipal = itemView.findViewById(R.id.imageViewPrincipal);
            textViewIngredientes = itemView.findViewById(R.id.textViewIngredientes);
            textViewAlinios = itemView.findViewById(R.id.textViewAlinios);
            textViewPrecio = itemView.findViewById(R.id.textViewPrecio);
        }

        @SuppressLint("SetTextI18n")
        public void printInfo(RecetaPizza re) {
            textViewNombre.setText(re.getNombre());
            textViewPrincipal.setText(re.getPrincipal());
            textViewBase.setText(re.getBase());

            // Ingredientes
            textViewIngredientes.setText(re.getIngredientes().toString()
                    .replace("[", "")
                    .replace("]", "")
            );
            // ------
            textViewAlinios.setText(re.getAlinios().toString()
                    .replace("[", "")
                    .replace("]", "")
            );

            textViewPrecio.setText("$" + String.valueOf(re.getPrecio()));

            if(re.getPrincipal().equals("Carne")) {
                imageViewPrincipal.setImageResource(R.drawable.pizza_meat);
            }
            if(re.getPrincipal().equals("Pollo")) {
                imageViewPrincipal.setImageResource(R.drawable.pizza_chicken);
            }
            if(re.getPrincipal().equals("Mix")) {
                imageViewPrincipal.setImageResource(R.drawable.pizza_mix);
            }
        }

    }
}
