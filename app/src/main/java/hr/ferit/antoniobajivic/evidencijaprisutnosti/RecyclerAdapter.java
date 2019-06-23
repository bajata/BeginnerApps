package hr.ferit.antoniobajivic.evidencijaprisutnosti;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<NameViewHolder>{
    private List<String> dataList = new ArrayList<>();
    private PictureClickListener clickListener;
    public static int pos=0;

    public RecyclerAdapter(PictureClickListener listener) {
        this.clickListener = listener;
    }

    @NonNull
    @Override
    public NameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View cellView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_name, parent, false);
        return new NameViewHolder(cellView, clickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull NameViewHolder nameViewHolder, int position) {
        nameViewHolder.setName(dataList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void addNewCell(String name) {
        if(!name.isEmpty()) {
            dataList.add(pos, name);
            notifyItemInserted(pos);
            pos=pos+1;
        }
    }


    public void removeCell(int position) {
            dataList.remove(position);
            notifyItemRemoved(position);
            pos=pos-1;
    }
}


