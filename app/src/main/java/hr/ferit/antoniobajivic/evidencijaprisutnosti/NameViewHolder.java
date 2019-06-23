package hr.ferit.antoniobajivic.evidencijaprisutnosti;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class NameViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    private TextView tvName;
    private ImageView ivName;
    private PictureClickListener clickListener;

    public NameViewHolder(@NonNull View itemView, PictureClickListener listener){
        super(itemView);
        tvName=(TextView)itemView.findViewById(R.id.tvName);
        ivName=(ImageView)itemView.findViewById(R.id.ivName);
        this.clickListener=listener;
        ivName.setOnClickListener(this);
    }

    public void setName(String name){
        tvName.setText(name);
    }

    @Override
    public void onClick(View view){
        clickListener.onPictureClick(getAdapterPosition());
    }
}
