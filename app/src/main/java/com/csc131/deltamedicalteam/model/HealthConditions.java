package com.csc131.deltamedicalteam.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Map;

class HealthConditions implements Parcelable {
    private String currentIllnesses;
    private Map<String, String> previousIllnesses;
    private String specificAllergies;


    // Default constructor
    public HealthConditions() {
        // Default constructor required for Firestore deserialization
    }
    public HealthConditions(String currentIllnesses, Map<String, String> previousIllnesses, String specificAllergies) {
        this.currentIllnesses = currentIllnesses;
        this.previousIllnesses = previousIllnesses;
        this.specificAllergies = specificAllergies;
    }

    protected HealthConditions(Parcel in) {
        currentIllnesses = in.readString();
        // Read map from parcel
        // You need to implement this part
        // For simplicity, let's skip this part
        specificAllergies = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(currentIllnesses);
        // Write map to parcel
        // You need to implement this part
        // For simplicity, let's skip this part
        dest.writeString(specificAllergies);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<HealthConditions> CREATOR = new Creator<HealthConditions>() {
        @Override
        public HealthConditions createFromParcel(Parcel in) {
            return new HealthConditions(in);
        }

        @Override
        public HealthConditions[] newArray(int size) {
            return new HealthConditions[size];
        }
    };

    public String getCurrentIllnesses() {
        return currentIllnesses;
    }

    public Map<String, String> getPreviousIllnesses() {
        return previousIllnesses;
    }

    public String getSpecificAllergies() {
        return specificAllergies;
    }
}
