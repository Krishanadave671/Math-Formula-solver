package com.krishana.elearningapp.recyclerview.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.krishana.elearningapp.Activity_homepage;
import com.krishana.elearningapp.Activity_problemsolver;
import com.krishana.elearningapp.R;
import com.krishana.elearningapp.itemAnimation;
import com.krishana.elearningapp.recyclerview.Adapter.model.chapternames;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.RecyclerviewHolder> {
    Context context;
    List<chapternames> chapternamesList;
    List<chapternames> filteredchapterlist;

    public RecyclerviewAdapter(Context context, List<chapternames> chapternamesList) {
        this.context = context;
        this.chapternamesList = chapternamesList;
        this.filteredchapterlist = chapternamesList;

    }

    @NonNull
    @Override
    public RecyclerviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_row_item,parent,false);
        return new RecyclerviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerviewHolder holder, int position) {
        holder.chaptertitle.setText(filteredchapterlist.get(position).getChaptername());
        holder.chapterdescription.setText(filteredchapterlist.get(position).getDescription());
        holder.chapterimage.setImageResource(filteredchapterlist.get(position).getImageUrl());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Item clicked " + filteredchapterlist.get(holder.getAdapterPosition()).getChaptername(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, Activity_homepage.class);
                context.startActivity(intent);

            }
        });
        holder.chapterimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "chapter image selected", Toast.LENGTH_SHORT).show();
            }
        });



    }

    @Override
    public int getItemCount() {
        return filteredchapterlist.size();
    }


    public static final class RecyclerviewHolder extends RecyclerView.ViewHolder{
        ImageView chapterimage;
        TextView chaptertitle , chapterdescription;
        public RecyclerviewHolder(@NonNull View itemView) {
            super(itemView);
            chapterimage = itemView.findViewById(R.id.chapterimage);
            chaptertitle = itemView.findViewById(R.id.chaptertitle);
            chapterdescription = itemView.findViewById(R.id.chapterdesc);
        }
    }

    public Filter getfilter(){
     return new Filter() {
         @Override
         protected FilterResults performFiltering(CharSequence charSequence) {
             String key = charSequence.toString();
             if(key.isEmpty()){
                 filteredchapterlist = chapternamesList;
             }
             else{
                 List<chapternames> isfiltered = new ArrayList<>();
                 for(chapternames row : chapternamesList){
                     if(row.getChaptername().toLowerCase().contains(key.toLowerCase())){
                        isfiltered.add(row);
                     }
                 }
                 filteredchapterlist = isfiltered;
             }
             FilterResults filterResults = new FilterResults();
             filterResults.values = filteredchapterlist;
             return filterResults;
         }

         @Override
         protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
             filteredchapterlist = (List<chapternames>)filterResults.values;
             notifyDataSetChanged();

         }
     };


    }

}
