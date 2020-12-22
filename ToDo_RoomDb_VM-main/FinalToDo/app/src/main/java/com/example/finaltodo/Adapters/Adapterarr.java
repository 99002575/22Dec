package com.example.finaltodo.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.finaltodo.Fragments.ThirdScreen;
import com.example.finaltodo.R;

import java.util.Collections;
import java.util.List;

public class Adapterarr extends ArrayAdapter<String> {
    ThirdScreen context;
    String[] mField;
    String msubField;
    int[] images;

    //   public Myadapter(){
//       super();
//
//   }
    public Adapterarr(ThirdScreen c, String[] field, String subfield, int[] img) {
//        super(c.getContext(),field,subfield,img);
        super(c.getActivity(), R.layout.row,R.id.heading, (List<String>) Collections.singletonList(field));

        //createFromResource(c,field,subfield,img);
        // super(c,field,subfield,img);
        this.context = c;
        this.mField = field;
        this.msubField = subfield;
        this.images = img;

    }

    @NonNull
    @Override
    public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View row = inflater.inflate(R.layout.row, parent, false);
        ImageView image = row.findViewById(R.id.image);
        TextView myField = row.findViewById(R.id.heading);
        TextView mysubField = row.findViewById(R.id.subtext);
        image.setImageResource(images[position]);
        myField.setText(mField[position]);
        mysubField.setText(msubField);


        return row;
    }
}

