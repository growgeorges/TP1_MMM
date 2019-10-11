package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tp1.R;

import java.util.List;

import Model.Client;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private Context context;
    private List<Client> mesClients;


    public RecyclerAdapter(Context context, List<Client> mesClients){
        this.context = context;
        this.mesClients = mesClients;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemv2, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nom.setText(mesClients.get(position).getNom());
        holder.prenom.setText(mesClients.get(position).getPrenom());
        holder.dob.setText(mesClients.get(position).getDob());
        holder.ville.setText(mesClients.get(position).getVille());
        holder.departement.setText(mesClients.get(position).getDepartement());
    }

    @Override
    public int getItemCount() {
        return mesClients.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nom;
        TextView prenom;
        TextView dob;
        TextView ville;
        TextView departement;

        public ViewHolder(View itemView){
            super(itemView);
            nom = itemView.findViewById(R.id.item_nom);
            prenom = itemView.findViewById(R.id.item_prenom);
            dob = itemView.findViewById(R.id.item_dob);
            ville = itemView.findViewById(R.id.item_ville);
            departement = itemView.findViewById(R.id.item_departement);

        }
    }
}
