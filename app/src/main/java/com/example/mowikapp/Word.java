package com.example.mowikapp;

class Word {

    private String mDefaultTranslation;

    private String mMiwokTranslation;

    private int mMediaPlayer;

    private int mImageResourceId = NO_IMAGE_PROVIDED;

    private static final int NO_IMAGE_PROVIDED = -1;


    Word(String defaultTranslation, String miwokTranslation, int mediaPlayer) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mMediaPlayer = mediaPlayer;
    }

    Word(String defaultTranslation, String mowikTranslation, int imageResourceId, int mediaPlayer) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = mowikTranslation;
        mImageResourceId = imageResourceId;
        mMediaPlayer = mediaPlayer;
    }

    String getmDefaultTranslation() {
        return mDefaultTranslation;
    }

    String getmMiwokTranslation() {
        return mMiwokTranslation;
    }

    int getmImageResourceId() {
        return mImageResourceId;
    }

    public int getmAudioResourceId() { return mMediaPlayer; }

    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}
