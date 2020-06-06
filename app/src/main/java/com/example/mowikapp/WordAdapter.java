package com.example.mowikapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {
    private int mColorResourceId;

    WordAdapter(Activity context, ArrayList<Word> words, int colorResourceId) {

        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, words);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView miwokTextView = listItemView.findViewById(R.id.miwok_text_view);
        // Get the miwok from the default
        // set this text on the name TextView
        if (currentWord != null) {
            miwokTextView.setText(currentWord.getmMiwokTranslation());
        }

        // Find the TextView in the list_item.xml layout
        TextView defaultTextView = listItemView.findViewById(R.id.default_text_view);
        // Get the miwok from the english and
        // set this text on the number TextView
        if (currentWord != null) {
            defaultTextView.setText(currentWord.getmDefaultTranslation());
        }


        ImageView iconView = listItemView.findViewById(R.id.image);
        if (currentWord != null) {
            if (currentWord.hasImage()) {
                iconView.setImageResource(currentWord.getmImageResourceId());
            } else {
                iconView.setVisibility(View.GONE);
            }
        }

        View textContainer = listItemView.findViewById(R.id.textContainer);
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        textContainer.setBackgroundColor(color);


        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }

}
