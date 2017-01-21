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

import android.graphics.Bitmap;

/**
 * An {@link Book} object contains information related to a single earthquake.
 */
public class Book {

    /** Bitmap thumbnail image of the book */
    private Bitmap mThumbnail;

    /** Title of the Book */
    private String mTitle;

    /** Author of the Book */
    private String mAuthor;

    /** Website URL of the book on Google Books */
    private String mUrl;

    /**
     * Constructs a new {@link Book} object.
     *
     * @param thumbnail is the thumbnail (size) of the book
     * @param title is the title of the book
     * @param author is the person who wrote the book
     * @param url is the website URL to find more details about the book
     */
    public Book( Bitmap thumbnail, String title, String author, String url) {
        mThumbnail = thumbnail;
        mTitle = title;
        mAuthor = author;
        mUrl = url;
    }

    /**
     * Returns the bitmap thumbnail image of the book.
     */
    public Bitmap getThumbnail() {
        return mThumbnail;
    }

    /** 
     * Returns the title of the book.
     */
    public String getTitle() {
        return mTitle;
    }

    /**
     * Returns the author of the book.
     */
    public String getAuthor() {
        return mAuthor;
    }

    /**
     * Returns the website URL to find more information about the book.
     */
    public String getUrl() {
        return mUrl;
    }
}
