/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package us.theparamountgroup.android.booklistingapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * An {@link BookAdapter} knows how to create a list item layout for each book
 * in the data source (a list of {@link Book} objects).
 * <p>
 * These list item layouts will be provided to an adapter view like ListView
 * to be displayed to the user.
 */
public class BookAdapter extends ArrayAdapter<Book> {

    private static final String LOG_TAG = BookAdapter.class.getSimpleName();

    /**
     * Constructs a new {@link BookAdapter}.
     *
     * @param context of the app
     * @param books   is the list of books, which is the data source of the adapter
     */
    public BookAdapter(Context context, List<Book> books) {
        super(context, 0, books);
    }

    /**
     * Returns a list item view that displays information about the book thumbnail, title and author in the list of books.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.book_list_item, parent, false);
        }

        // Find the Book at the given position in the list of Books
        Book currentBook = getItem(position);

        // Find the TextView with view ID thumbnail

        ImageView thumbnailView = (ImageView) listItemView.findViewById(R.id.thumbnail);
        thumbnailView.setImageBitmap(currentBook.getThumbnail());

        // Get the title string from the Book object,

        String titleCurrentBook = currentBook.getTitle();

        // Find the TextView with view ID location
        TextView primaryLocationView = (TextView) listItemView.findViewById(R.id.primary_location);
        // Display the title of the current book in that TextView
        primaryLocationView.setText(titleCurrentBook);

        // Find the TextView with view ID author
        TextView authorView = (TextView) listItemView.findViewById(R.id.author);

        // Display the author of the current book in that TextView
        authorView.setText(currentBook.getAuthor());

        // Return the list item view that is now showing the appropriate data
        return listItemView;
    }
}
