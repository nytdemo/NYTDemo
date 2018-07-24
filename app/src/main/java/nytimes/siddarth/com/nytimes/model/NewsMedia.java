package nytimes.siddarth.com.nytimes.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NewsMedia implements Parcelable {

    private String type;
    private String caption;

    @JsonProperty("media-metadata")
    private ArrayList<MediaMetaData> mediaMetaData;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public ArrayList<MediaMetaData> getMediaMetaData() {
        return mediaMetaData;
    }

    public void setMediaMetaData(ArrayList<MediaMetaData> mediaMetaData) {
        this.mediaMetaData = mediaMetaData;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.type);
        dest.writeString(this.caption);
        dest.writeList(this.mediaMetaData);
    }

    public NewsMedia() {
    }

    protected NewsMedia(Parcel in) {
        this.type = in.readString();
        this.caption = in.readString();
        this.mediaMetaData = new ArrayList<>();
        in.readList(this.mediaMetaData, MediaMetaData.class.getClassLoader());
    }

    public static final Parcelable.Creator<NewsMedia> CREATOR = new Parcelable.Creator<NewsMedia>() {
        @Override
        public NewsMedia createFromParcel(Parcel source) {
            return new NewsMedia(source);
        }

        @Override
        public NewsMedia[] newArray(int size) {
            return new NewsMedia[size];
        }
    };
}
