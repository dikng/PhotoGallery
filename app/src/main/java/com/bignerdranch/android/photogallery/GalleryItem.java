package com.bignerdranch.android.photogallery;

import android.net.Uri;

import androidx.annotation.NonNull;

public class GalleryItem {
    private String mCaption;
    private String mId;
    private String mUrl;
    private String mOwner;

    public void setOwner(String owner) {
        mOwner = owner;
    }

    public String getOwner() {
        return mOwner;
    }
    public Uri getPhotoPageUri(){
        return Uri.parse("https://flickr.com/photos/")
                .buildUpon()
                .appendPath(mOwner)
                .appendPath(mId)
                .build();
    }

    @NonNull
    @Override
    public String toString() {
        return mCaption;
    }

    public String getCaption() {
        return mCaption;
    }

    public String getId() {
        return mId;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setCaption(String caption) {
        mCaption = caption;
    }

    public void setId(String id) {
        mId = id;
    }

    public void setUrl(String url) {
        mUrl = url;
    }
}
