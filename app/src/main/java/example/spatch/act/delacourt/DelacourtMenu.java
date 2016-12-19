package example.spatch.act.delacourt;

import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class DelacourtMenu implements Parcelable {
    String id;
    @SerializedName("title_kor")
    String koreanTitle;
    @SerializedName("title_eng")
    String englishTitle;
    String kcal;
    boolean soldout;
    @SerializedName("very_low_cal")
    boolean veryLowCal;
    @SerializedName("low_cal")
    boolean lowCal;
    @SerializedName("high_cal")
    boolean highCal;
    String price;
    String payments;
    @SerializedName("img_src")
    String imgSrc;
    String corner;
    String floor;

    protected DelacourtMenu(Parcel in) {
        id = in.readString();
        koreanTitle = in.readString();
        englishTitle = in.readString();
        kcal = in.readString();
        soldout = in.readByte() != 0;
        veryLowCal = in.readByte() != 0;
        lowCal = in.readByte() != 0;
        highCal = in.readByte() != 0;
        price = in.readString();
        payments = in.readString();
        imgSrc = in.readString();
        corner = in.readString();
        floor = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(koreanTitle);
        dest.writeString(englishTitle);
        dest.writeString(kcal);
        dest.writeByte((byte) (soldout ? 1 : 0));
        dest.writeByte((byte) (veryLowCal ? 1 : 0));
        dest.writeByte((byte) (lowCal ? 1 : 0));
        dest.writeByte((byte) (highCal ? 1 : 0));
        dest.writeString(price);
        dest.writeString(payments);
        dest.writeString(imgSrc);
        dest.writeString(corner);
        dest.writeString(floor);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<DelacourtMenu> CREATOR = new Creator<DelacourtMenu>() {
        @Override
        public DelacourtMenu createFromParcel(Parcel in) {
            return new DelacourtMenu(in);
        }

        @Override
        public DelacourtMenu[] newArray(int size) {
            return new DelacourtMenu[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKoreanTitle() {
        return koreanTitle;
    }

    public void setKoreanTitle(String koreanTitle) {
        this.koreanTitle = koreanTitle;
    }

    public String getEnglishTitle() {
        return englishTitle;
    }

    public void setEnglishTitle(String englishTitle) {
        this.englishTitle = englishTitle;
    }

    public String getKcal() {
        return kcal;
    }

    public void setKcal(String kcal) {
        this.kcal = kcal;
    }

    public boolean isSoldout() {
        return soldout;
    }

    public void setSoldout(boolean soldout) {
        this.soldout = soldout;
    }

    public boolean isVeryLowCal() {
        return veryLowCal;
    }

    public void setVeryLowCal(boolean veryLowCal) {
        this.veryLowCal = veryLowCal;
    }

    public boolean isLowCal() {
        return lowCal;
    }

    public void setLowCal(boolean lowCal) {
        this.lowCal = lowCal;
    }

    public boolean isHighCal() {
        return highCal;
    }

    public void setHighCal(boolean highCal) {
        this.highCal = highCal;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPayments() {
        return payments;
    }

    public void setPayments(String payments) {
        this.payments = payments;
    }

    public String getCorner() {
        return corner;
    }

    public void setCorner(String corner) {
        this.corner = corner;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public int decorateKcalTextColor() {
        if (isHighCal()) return Color.RED;
        if (isLowCal()) return Color.BLUE;
        if (isVeryLowCal()) return Color.GREEN;
        return Color.BLACK;
    }
}
