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

    /** Magnitude of the earthquake */
    private Bitmap mThumbnail;

    /** Location of the earthquake */
    private String mTitle;

    /** Time of the earthquake */
    private String mAuthor;

    /** Website URL of the earthquake */
    private String mUrl;

    /**
     * Constructs a new {@link Book} object.
     *
     * @param thumbnail is the thumbnail (size) of the earthquake
     * @param title is the location where the earthquake happened
     * @param author is the time in milliseconds (from the Epoch) when the
     *                           earthquake happened
     * @param url is the website URL to find more details about the book
     */
    public Book( Bitmap thumbnail, String title, String author, String url) {
        mThumbnail = thumbnail;
        mTitle = title;
        mAuthor = author;
        mUrl = url;
    }

    /**
     * Returns the magnitude of the earthquake.
     */
    public Bitmap getThumbnail() {
        return mThumbnail;
    }

    /** 
     * Returns the location of the earthquake.
     */
    public String getLocation() {
        return mTitle;
    }

    /**
     * Returns the time of the earthquake.
     */
    public String getAuthor() {
        return mAuthor;
    }

    /**
     * Returns the website URL to find more information about the earthquake.
     */
    public String getUrl() {
        return mUrl;
    }
}
