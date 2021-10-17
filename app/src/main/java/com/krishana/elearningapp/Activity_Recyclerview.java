package com.krishana.elearningapp;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.krishana.elearningapp.recyclerview.Adapter.RecyclerviewAdapter;
import com.krishana.elearningapp.recyclerview.Adapter.model.chapternames;

import java.util.ArrayList;
import java.util.List;

public class Activity_Recyclerview extends AppCompatActivity {
    RecyclerView chapterrecyclerview;
    RecyclerviewAdapter recyclerviewAdapter;
    EditText searchview;
    CharSequence search = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        searchview = findViewById(R.id.edittext_searchbar);

        List<chapternames> chapternamesList = new ArrayList<>();
        chapternamesList.add(new chapternames("Algebra","let us learn algebra",R.drawable.algebra));
        chapternamesList.add(new chapternames("Geometry","let us learn Geometry",R.drawable.geometrytools));
        chapternamesList.add(new chapternames("statistics","let us learn statistics",R.drawable.statistics));
        chapternamesList.add(new chapternames("logic", "let us learn logic", R.drawable.logic));
        chapternamesList.add(new chapternames("matrix","let us learn matrix",R.drawable.matrix));
        chapternamesList.add(new chapternames("probability","let us learn probability",R.drawable.dice));
        chapternamesList.add(new chapternames("summationimg","let us learn summationimg",R.drawable.summationimg));
        chapternamesList.add(new chapternames("algebra","let us learn algebra",R.drawable.algebra));chapternamesList.add(new chapternames("Algebra","let us learn algebra",R.drawable.algebra));
        chapternamesList.add(new chapternames("Geometry","let us learn Geometry",R.drawable.geometrytools));
        chapternamesList.add(new chapternames("statistics","let us learn statistics",R.drawable.statistics));
        chapternamesList.add(new chapternames("logic", "let us learn logic", R.drawable.logic));
        chapternamesList.add(new chapternames("matrix","let us learn matrix",R.drawable.matrix));
        chapternamesList.add(new chapternames("probability","let us learn probability",R.drawable.dice));
        chapternamesList.add(new chapternames("summationimg","let us learn summationimg",R.drawable.summationimg));
        chapternamesList.add(new chapternames("algebra","let us learn algebra",R.drawable.algebra));chapternamesList.add(new chapternames("Algebra","let us learn algebra",R.drawable.algebra));
        chapternamesList.add(new chapternames("Geometry","let us learn Geometry",R.drawable.geometrytools));
        chapternamesList.add(new chapternames("statistics","let us learn statistics",R.drawable.statistics));
        chapternamesList.add(new chapternames("logic", "let us learn logic", R.drawable.logic));
        chapternamesList.add(new chapternames("matrix","let us learn matrix",R.drawable.matrix));
        chapternamesList.add(new chapternames("probability","let us learn probability",R.drawable.dice));
        chapternamesList.add(new chapternames("summationimg","let us learn summationimg",R.drawable.summationimg));
        chapternamesList.add(new chapternames("algebra","let us learn algebra",R.drawable.algebra));
        setChapterrecyclerview(chapternamesList);
        searchview.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                recyclerviewAdapter.getfilter().filter(charSequence);
                search = charSequence;
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private void setChapterrecyclerview(List<chapternames> chapternamesList) {
        chapterrecyclerview = findViewById(R.id.chapterrecyclerview);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        chapterrecyclerview.setLayoutManager(layoutManager);
        recyclerviewAdapter = new RecyclerviewAdapter(this, chapternamesList);
        chapterrecyclerview.setAdapter(recyclerviewAdapter);
    }
}
