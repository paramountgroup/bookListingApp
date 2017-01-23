package us.theparamountgroup.android.booklistingapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static us.theparamountgroup.android.booklistingapp.R.id;
import static us.theparamountgroup.android.booklistingapp.R.layout;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_TITLE = "us.theparamountgroup.android.booklistingapp.TITLE";
    public final static String EXTRA_AUTHOR = "us.theparamountgroup.android.booklistingapp.AUTHOR";
    public final static String EXTRA_SUBJECT = "us.theparamountgroup.android.booklistingapp.SUBJECT";
    private static final String LOG_TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(id.toolbar);
        setSupportActionBar(toolbar);
    }

    /*
    The Google Books API returns all entries that match all of the search terms (like using AND between terms).
    Like Google's web search, the API searches on complete words (and related words with the same stem),
    not substrings. To search for an exact phrase, enclose the phrase in quotation marks: q="exact phrase".
     */

    public void getBookQuery(View v) {
        EditText titleEditText = (EditText) findViewById(id.edit_title);
        final String titleString = formatEditText(titleEditText.getText().toString().trim());

        titleEditText.setText("");
        EditText authorEditText = (EditText) findViewById(id.edit_author);
        final String authorString = formatEditText(authorEditText.getText().toString().trim());
        authorEditText.setText("");
        EditText subjectEditText = (EditText) findViewById(id.edit_subject);
        final String subjectString = formatEditText(subjectEditText.getText().toString().trim());
        subjectEditText.setText("");

        if (titleString.equals("") && authorString.equals("") && subjectString.equals("")) {
            Toast.makeText(MainActivity.this, "Please enter a search term: Title, Author, or Subject", Toast.LENGTH_LONG).show();
        } else {
            Intent intent = new Intent(MainActivity.this, BookActivity.class);
            intent.putExtra(EXTRA_TITLE, titleString);
            intent.putExtra(EXTRA_AUTHOR, authorString);
            intent.putExtra(EXTRA_SUBJECT, subjectString);
            startActivity(intent);
        }


    }

    // Format the input string change " " to "+" and add quotes if more than one word. This is
    // required formating for Google books search query with more than one word.

    private String formatEditText(String string) {
        String trimmedString;
        boolean foundSpaceChar = string.contains(" ");
        // if string contains a space character replace with "+" and add quotes.
        if (!foundSpaceChar) {
            return string;
        } else {
            do {
                trimmedString = string.replace(" ", "+");
            } while (trimmedString.contains(" "));
            trimmedString = '"' + trimmedString + '"';
            return trimmedString;
        }
    }
}
