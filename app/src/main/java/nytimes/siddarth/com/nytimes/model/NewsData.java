package nytimes.siddarth.com.nytimes.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NewsData implements Parcelable {

    private String url;

    @JsonProperty("adx_keywords")
    private String adcKeywords;

    private String byline;

    private String type;

    private String title;
    @JsonProperty("abstract")
    private String abst;

    @JsonProperty("published_date")
    private String publishedDate;

    private String source;

    private String id;

    @JsonProperty("asset_id")
    private String assetId;


    public ArrayList<NewsMedia> getMedia() {
        return media;
    }

    public void setMedia(ArrayList<NewsMedia> media) {
        this.media = media;
    }

    private ArrayList<NewsMedia> media;


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAdcKeywords() {
        return adcKeywords;
    }

    public void setAdcKeywords(String adcKeywords) {
        this.adcKeywords = adcKeywords;
    }

    public String getByline() {
        return byline;
    }

    public void setByline(String byline) {
        this.byline = byline;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbst() {
        return abst;
    }

    public void setAbst(String abst) {
        this.abst = abst;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public NewsData() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.url);
        dest.writeString(this.adcKeywords);
        dest.writeString(this.byline);
        dest.writeString(this.type);
        dest.writeString(this.title);
        dest.writeString(this.abst);
        dest.writeString(this.publishedDate);
        dest.writeString(this.source);
        dest.writeString(this.id);
        dest.writeString(this.assetId);
        dest.writeTypedList(this.media);
    }

    protected NewsData(Parcel in) {
        this.url = in.readString();
        this.adcKeywords = in.readString();
        this.byline = in.readString();
        this.type = in.readString();
        this.title = in.readString();
        this.abst = in.readString();
        this.publishedDate = in.readString();
        this.source = in.readString();
        this.id = in.readString();
        this.assetId = in.readString();
        this.media = in.createTypedArrayList(NewsMedia.CREATOR);
    }

    public static final Creator<NewsData> CREATOR = new Creator<NewsData>() {
        @Override
        public NewsData createFromParcel(Parcel source) {
            return new NewsData(source);
        }

        @Override
        public NewsData[] newArray(int size) {
            return new NewsData[size];
        }
    };
}
