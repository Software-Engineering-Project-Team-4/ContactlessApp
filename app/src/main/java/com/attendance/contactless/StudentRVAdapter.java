package com.attendance.contactless;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StudentRVAdapter extends RecyclerView.Adapter<StudentRVAdapter.ViewHolder> {

    // variable for our array list and context
    private ArrayList<Modal> modalArrayList;
    private Context context;

    // constructor
    public StudentRVAdapter(ArrayList<Modal> modalArrayList, Context context) {
        this.modalArrayList = modalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflates layout and returns
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // sets data
        Modal modal = modalArrayList.get(position);
        holder.firstNameTV.setText(modal.getFirstName());
        holder.professorTV.setText(modal.getProfessor());
        holder.lastNameTV.setText(modal.getLastName());
        holder.attendTV.setText(""+modal.getAttend());
    }

    @Override
    public int getItemCount() {
        // returns size of arraylist
        return modalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // variables.
        private TextView firstNameTV, professorTV, lastNameTV, attendTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // creates textviews
            firstNameTV = itemView.findViewById(R.id.idTVFirstName);
            professorTV = itemView.findViewById(R.id.idTVProfessor);
            lastNameTV = itemView.findViewById(R.id.idTVLastName);
            attendTV = itemView.findViewById(R.id.idTVAttend);
        }
    }
}
