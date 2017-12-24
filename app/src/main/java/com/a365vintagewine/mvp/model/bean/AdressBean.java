package com.a365vintagewine.mvp.model.bean;

import com.commsdk.common.StringUtils;

import java.io.Serializable;

/**
 * 描述：地址实体
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年08月30日  2:44
 * 版本：3.0
 */

public class AdressBean implements Serializable{
    /**
     * Client_Id : 1952
     * Address_Id : 17
     * Name : 林校章
     * Province_Id : 1
     * ProvinceName : 0
     * City_Id : 3596
     * CityName : 北京市
     * Region_Id : 3596
     * RegionName : 密云县
     * Street : 西统路
     * Address : 北京北京市密云县西统路
     * Mobile : 15810846124
     * IsDefaultAddress : 1
     * Longitude : 0
     * Latitude : 0
     */

    private int Client_Id;
    private int Address_Id;
    private String Name= StringUtils.EMPTY;
    private int Province_Id;
    private String ProvinceName= StringUtils.EMPTY;
    private int City_Id;
    private String CityName= StringUtils.EMPTY;
    private int Region_Id;
    private String RegionName= StringUtils.EMPTY;
    private String Street= StringUtils.EMPTY;
    private String Address= StringUtils.EMPTY;
    private String Mobile= StringUtils.EMPTY;
    private int IsDefaultAddress;
    private long Longitude;
    private long Latitude;

    public int getClient_Id() {
        return Client_Id;
    }

    public void setClient_Id(int Client_Id) {
        this.Client_Id = Client_Id;
    }

    public int getAddress_Id() {
        return Address_Id;
    }

    public void setAddress_Id(int Address_Id) {
        this.Address_Id = Address_Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getProvince_Id() {
        return Province_Id;
    }

    public void setProvince_Id(int Province_Id) {
        this.Province_Id = Province_Id;
    }

    public String getProvinceName() {
        return ProvinceName;
    }

    public void setProvinceName(String ProvinceName) {
        this.ProvinceName = ProvinceName;
    }

    public int getCity_Id() {
        return City_Id;
    }

    public void setCity_Id(int City_Id) {
        this.City_Id = City_Id;
    }

    public String getCityName() {
        return CityName;
    }

    public void setCityName(String CityName) {
        this.CityName = CityName;
    }

    public int getRegion_Id() {
        return Region_Id;
    }

    public void setRegion_Id(int Region_Id) {
        this.Region_Id = Region_Id;
    }

    public String getRegionName() {
        return RegionName;
    }

    public void setRegionName(String RegionName) {
        this.RegionName = RegionName;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String Street) {
        this.Street = Street;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String Mobile) {
        this.Mobile = Mobile;
    }

    public int getIsDefaultAddress() {
        return IsDefaultAddress;
    }

    public void setIsDefaultAddress(int IsDefaultAddress) {
        this.IsDefaultAddress = IsDefaultAddress;
    }

    public long getLongitude() {
        return Longitude;
    }

    public void setLongitude(int Longitude) {
        this.Longitude = Longitude;
    }

    public long getLatitude() {
        return Latitude;
    }

    public void setLatitude(int Latitude) {
        this.Latitude = Latitude;
    }




}
