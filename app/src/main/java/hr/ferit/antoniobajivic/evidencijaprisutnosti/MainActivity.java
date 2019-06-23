package hr.ferit.antoniobajivic.evidencijaprisutnosti;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements PictureClickListener {

    private RecyclerView recycler;
    private RecyclerAdapter adapter;
    private EditText etAdd;
    private Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupRecycler();
        Initialize();
    }


    public void Initialize(){
        etAdd=(EditText)findViewById(R.id.etAdd);
        btnAdd=(Button)findViewById(R.id.btnAdd);
    }

    private void setupRecycler(){
        recycler=findViewById(R.id.recyclerView);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        adapter= new RecyclerAdapter(this);
        recycler.setAdapter(adapter);
    }

    public void addCell(View view){
        String name=etAdd.getText().toString();
        if (name.isEmpty()){
            Toast.makeText(this,"Warning, empty input!", Toast.LENGTH_SHORT).show();
        }
        else adapter.addNewCell(name);
        etAdd.getText().clear();
    }



    @Override
    public void onPictureClick (int position){
        adapter.removeCell(position);
        Toast.makeText(this,"Student was removed from position: " + position + "!",Toast.LENGTH_SHORT ).show();
    }
}
