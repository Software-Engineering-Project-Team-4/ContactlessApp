package com.attendance.contactless;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProfessorRVAdapter extends RecyclerView.Adapter<ProfessorRVAdapter.ViewHolder> {
    // variable for our array list and context
    private ArrayList<Modal> modalArrayList;
    private Context context;

    // constructor
    public ProfessorRVAdapter(ArrayList<Modal> modalArrayList, Context context) {
        this.modalArrayList = modalArrayList;
        this.context = context;

    }
    @NonNull
    @Override
    public ProfessorRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflates layout and returns
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_rv_item, parent, false);
        return new ProfessorRVAdapter.ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ProfessorRVAdapter.ViewHolder holder, int position) {
        // sets data
        Modal modal = modalArrayList.get(position);
        holder.firstNameTV.setText(modal.getFirstName());
        holder.professorTV.setText(modal.getProfessor());
        holder.lastNameTV.setText(modal.getLastName());
        holder.attendTV.setText(""+modal.getAttend());
        holder.studentTV.setText(modal.getStudentID());
    }
    @Override
    public int getItemCount() {
        // returns size of arraylist
        return modalArrayList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {

        // variables.
        private TextView firstNameTV, professorTV, lastNameTV, attendTV,studentTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // creates textviews
            firstNameTV = itemView.findViewById(R.id.idTVFirstNameP);
            professorTV = itemView.findViewById(R.id.idTVProfessorP);
            lastNameTV = itemView.findViewById(R.id.idTVLastNameP);
            attendTV = itemView.findViewById(R.id.idTVAttendP);
            studentTV = itemView.findViewById(R.id.idTVStudentP);
        }
    }
}