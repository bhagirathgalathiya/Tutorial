package com.app.tutorial12;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {

    JSONArray jsonArray;

    public StudentAdapter(JSONArray jsonArray) {
        this.jsonArray = jsonArray;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        JSONObject jsonObject= null;
        try {
            jsonObject = jsonArray.getJSONObject(position);
            holder.name.setText(jsonObject.getString("h_name"));
            if (jsonObject.getString("h_pgflag").equals("p")) {
                holder.genderImage.setImageResource(R.drawable.m);
            } else {
                holder.genderImage.setImageResource(R.drawable.f);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return jsonArray.length();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView genderImage ;
        TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            genderImage=itemView.findViewById(R.id.gender_image);
            name=itemView.findViewById(R.id.name);
        }
    }
}
