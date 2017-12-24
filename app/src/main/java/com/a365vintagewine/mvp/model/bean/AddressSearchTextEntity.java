package com.a365vintagewine.mvp.model.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.amap.api.services.core.LatLonPoint;


/**
 * @Destription:地理位置搜索实体
 * @auther:lstreamlet
 * @date:2017/3/10
 */
public class AddressSearchTextEntity implements Parcelable {

    /**省名称*/
    private String ProvinceName;
    /**城市名称*/
    private String cityName;
    /**区名称*/
    private String RegionName;
    /**位置（标志性位置）*/
    private String tittle;
    /**位置详细描述(包括门牌号)*/
    private String adress;
    /**是否选择当前位置*/
    private boolean isChoose;
    /**该实体的位置经纬度*/
    private LatLonPoint latLonPoint;

    public AddressSearchTextEntity(String provinceName, String cityName, String regionName, String tittle, String adress, boolean isChoose, LatLonPoint latLonPoint) {
        ProvinceName = provinceName;
        this.cityName = cityName;
        RegionName = regionName;
        this.tittle = tittle;
        this.adress = adress;
        this.isChoose = isChoose;
        this.latLonPoint = latLonPoint;
    }

    protected AddressSearchTextEntity(Parcel in) {
        ProvinceName = in.readString();
        cityName = in.readString();
        RegionName = in.readString();
        tittle = in.readString();
        adress = in.readString();
        isChoose = in.readByte() != 0;
        latLonPoint = in.readParcelable(LatLonPoint.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(ProvinceName);
        dest.writeString(cityName);
        dest.writeString(RegionName);
        dest.writeString(tittle);
        dest.writeString(adress);
        dest.writeByte((byte) (isChoose ? 1 : 0));
        dest.writeParcelable(latLonPoint, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<AddressSearchTextEntity> CREATOR = new Creator<AddressSearchTextEntity>() {
        @Override
        public AddressSearchTextEntity createFromParcel(Parcel in) {
            return new AddressSearchTextEntity(in);
        }

        @Override
        public AddressSearchTextEntity[] newArray(int size) {
            return new AddressSearchTextEntity[size];
        }
    };

    public String getProvinceName() {
        return ProvinceName;
    }

    public void setProvinceName(String provinceName) {
        ProvinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getRegionName() {
        return RegionName;
    }

    public void setRegionName(String regionName) {
        RegionName = regionName;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public boolean isChoose() {
        return isChoose;
    }

    public void setChoose(boolean choose) {
        isChoose = choose;
    }

    public LatLonPoint getLatLonPoint() {
        return latLonPoint;
    }

    public void setLatLonPoint(LatLonPoint latLonPoint) {
        this.latLonPoint = latLonPoint;
    }
}
