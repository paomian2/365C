package com.a365vintagewine.mvp.activity.personal;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.a365vintagewine.R;
import com.a365vintagewine.adapter.LbsAdressAdapter;
import com.a365vintagewine.mvp.model.bean.AddressSearchTextEntity;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.core.SuggestionCity;
import com.amap.api.services.geocoder.GeocodeResult;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.RegeocodeQuery;
import com.amap.api.services.geocoder.RegeocodeResult;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch;
import com.commsdk.base.AppActivityManager;
import com.commsdk.base.BaseActivity;
import com.commsdk.common.LogUtil;
import com.commsdk.common.NumberUtils;
import com.commsdk.common.StringUtils;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
public class LBSLatLngLocationActivity extends BaseActivity implements LocationSource, AMapLocationListener {

    //基本地图
    private AMap aMap;
    private MapView mapView;
    private OnLocationChangedListener mListener;
    private AMapLocationClient mlocationClient;
    private AMapLocationClientOption mLocationOption;
    public static final int RequestCode = 1;
    private ImageView img_location;
    /**
     * 当前定位经纬度（用户切换到当前位置）
     */
    private LatLonPoint currentLatLongPoint;
    //poi搜索
    @Bind(R.id.ivBack)
    ImageView ivBack;
    @Bind(R.id.tvConfirm)
    TextView tvConfirm;
    @Bind(R.id.ivSearch)
    TextView ivSearch;
    @Bind(R.id.map)
    MapView map;
    @Bind(R.id.img_location)
    ImageView imgLocation;
    @Bind(R.id.lvPoi)
    ListView lvPoi;
    private LatLng mFinalChoosePosition;//最终选择的点
    private PoiResult poiResult;
    private ArrayList<PoiItem> poiItems;
    private AddressSearchTextEntity mAddressEntityFirst;
    private List<AddressSearchTextEntity> mDatas = new ArrayList<>();
    private LbsAdressAdapter lbsAdressAdapter;
    //地理位置周边搜索（定位成功后根据当前经纬度获取周边地理信息）
    private PoiSearch.Query query;

    private boolean isFirstLocation = true;
    /**
     * 是否重新进行了定位
     */
    private boolean isHandDrag = true;
    /***/
    private boolean isFirstLoadList = true;

    private PoiSearch poiSearch;
    private int currentPage = 0;
    /**省名称*/
    private String ProvinceName;
    /**城市名称*/
    private String cityName="北京";
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
    private LatLonPoint lp;//用于关键字搜索

    //地理逆向搜索
    private GeocodeSearch geocoderSearch;
    private String tittleName;
    private String addressName;
    //传回上一个页面的详细地址信息
    private String maddressName;

    public static final int RESULT_PAY_SUCCESS = 1008;

    public static void launch(BaseActivity activity) {
        Intent intent = new Intent();
        intent.setClass(activity, LBSLatLngLocationActivity.class);
        AppActivityManager.getInstance().goFoResult(activity, intent, RequestCode);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lbs_location_activity);
        ButterKnife.bind(this);
        mapView = (MapView) findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);// 此方法必须重写
        if (ContextCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(activity, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(activity, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            //申请定位需要的权限
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE,
                            Manifest.permission.READ_PHONE_STATE}, 3);
        } else {
            init();
        }
    }

    /**
     * 权限
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (3 == requestCode) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                // 授权
                init();
            } else {
                // 未授权
                showToast("未授权");
                finish();
            }
        }
    }

    @Override
    protected void initUI() {
        // TODO Auto-generated method stub
    }


    @Override
    protected void initData() {
        // TODO Auto-generated method stub
    }


    @Override
    public String setTag() {
        // TODO Auto-generated method stub
        return null;
    }


    /**
     * 初始化AMap对象
     */
    private void init() {
        if (aMap == null) {
            aMap = mapView.getMap();
            iniPoi();
            setUpMap();
        }
        img_location = (ImageView) findViewById(R.id.img_location);
    }


    /**
     * 设置一些amap的属性
     */
    private void setUpMap() {
        // 自定义系统定位小蓝点
        MyLocationStyle myLocationStyle = new MyLocationStyle();
        myLocationStyle.myLocationIcon(BitmapDescriptorFactory
                .fromResource(R.drawable.img_location_now));// 设置小蓝点的图标
        myLocationStyle.strokeColor(Color.argb(0, 0, 0, 0));// 设置圆形的边框颜色
        myLocationStyle.radiusFillColor(Color.argb(0, 0, 0, 0));// 设置圆形的填充颜色
        // myLocationStyle.anchor(int,int)//设置小蓝点的锚点
        myLocationStyle.strokeWidth(1.0f);// 设置圆形的边框粗细
        aMap.setMyLocationStyle(myLocationStyle);
        aMap.setLocationSource(this);// 设置定位监听
        aMap.getUiSettings().setMyLocationButtonEnabled(false);// 设置默认定位按钮是否显示
        aMap.setMyLocationEnabled(true);// 设置为true表示显示定位层并可触发定位，false表示隐藏定位层并不可触发定位，默认是false
        aMap.getUiSettings().setZoomControlsEnabled(false);// 设置手动改变比例尺
        // aMap.setMyLocationType()
        aMap.moveCamera(CameraUpdateFactory.zoomTo(15));
        // aMap.setOnMapClickListener(this);// 对amap添加单击地图事件监听器
        aMap.setOnCameraChangeListener(mOnCameraChangeListener);//获取地图中心点
        geocoderSearch = new GeocodeSearch(this);
        geocoderSearch.setOnGeocodeSearchListener(mtOnGeocodeSearchListener);
    }

    /**
     * 方法必须重写
     */
    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    /**
     * 方法必须重写
     */
    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
        deactivate();
    }

    /**
     * 方法必须重写
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    /**
     * 方法必须重写
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mlocationClient != null)
            mlocationClient.stopLocation();
        if (mapView != null)
            mapView.onDestroy();
    }

    @Override
    protected void setActivityView(Bundle bundle) {

    }


    /**
     * 激活定位
     */
    @Override
    public void activate(OnLocationChangedListener listener) {
        mListener = listener;
        if (mlocationClient == null) {
            mlocationClient = new AMapLocationClient(this);
            mLocationOption = new AMapLocationClientOption();
            //设置定位监听
            mlocationClient.setLocationListener(this);
            //设置为高精度定位模式
            mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
            //设置定位参数
            mlocationClient.setLocationOption(mLocationOption);
            // 此方法为每隔固定时间会发起一次定位请求，为了减少电量消耗或网络流量消耗，
            // 注意设置合适的定位时间的间隔（最小间隔支持为2000ms），并且在合适时间调用stopLocation()方法来取消定位请求
            // 在定位结束后，在合适的生命周期调用onDestroy()方法
            // 在单次定位情况下，定位无论成功与否，都无需调用stopLocation()方法移除请求，定位sdk内部会移除
            mlocationClient.startLocation();
        }
    }

    /**
     * 停止定位
     */
    @Override
    public void deactivate() {
        mListener = null;
        if (mlocationClient != null) {
            mlocationClient.stopLocation();
            mlocationClient.onDestroy();
        }
        mlocationClient = null;
    }

    /**
     * 定位成功后回调函数
     */
    @Override
    public void onLocationChanged(AMapLocation amapLocation) {
        if (mListener != null && amapLocation != null) {
            if (amapLocation != null
                    && amapLocation.getErrorCode() == 0) {
                currentLatLongPoint = new LatLonPoint(amapLocation.getLatitude(), amapLocation.getLongitude());
                mListener.onLocationChanged(amapLocation);// 显示系统小蓝点
                ProvinceName=amapLocation.getProvince();
                cityName = amapLocation.getCity();
                RegionName=amapLocation.getCountry();
                if (isFirstLoadList) {//手动去拖动地图
                    Animation anim = AnimationUtils.loadAnimation(activity,
                            R.anim.anim_jump);
                    img_location.startAnimation(anim);
                    aMap.moveCamera(CameraUpdateFactory.zoomTo(15));
                    lp = new LatLonPoint(amapLocation.getLatitude(), amapLocation.getLongitude());
                    mFinalChoosePosition = convertToLatLng(lp);
                    mAddressEntityFirst = new AddressSearchTextEntity(ProvinceName,cityName, RegionName,
                            tittle,tittle,true, convertToLatLonPoint(mFinalChoosePosition));
                    //地理逆向搜索
                    getAddress();
                    doSearchQuery();
                }
                isFirstLoadList = false;
            } else {
                String errText = "定位失败," + amapLocation.getErrorCode() + ": " + amapLocation.getErrorInfo();
                Log.e("AmapErr", errText);
            }
        }
    }


    /**
     * 把LatLonPoint对象转化为LatLon对象
     */
    public LatLng convertToLatLng(LatLonPoint latLonPoint) {
        return new LatLng(latLonPoint.getLatitude(), latLonPoint.getLongitude());
    }

    /**
     * 把LatLng对象转化为LatLonPoint对象
     */
    public static LatLonPoint convertToLatLonPoint(LatLng latlon) {
        return new LatLonPoint(latlon.latitude, latlon.longitude);
    }


    /**
     * poi搜索列表选择位置监听器
     */
    private AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            mFinalChoosePosition = convertToLatLng(mDatas.get(position).getLatLonPoint());
            for (AddressSearchTextEntity entity : mDatas) {
                entity.setChoose(false);
            }
            mDatas.get(position).setChoose(true);
            lbsAdressAdapter.notifyDataSetChanged();

            LogUtil.d("", "点击后的最终经纬度：  纬度" + mFinalChoosePosition.latitude + " 经度 " + mFinalChoosePosition.longitude);
            maddressName=mDatas.get(position).getAdress();
            isHandDrag = false;
            // 点击之后，我利用代码指定的方式改变了地图中心位置，所以也会调用 onCameraChangeFinish
            // 只要地图发生改变，就会调用 onCameraChangeFinish ，不是说非要手动拖动屏幕才会调用该方法
            aMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(mFinalChoosePosition.latitude, mFinalChoosePosition.longitude), 20));
        }
    };


    /**
     * 地图中心位置经纬度改变监听
     */
    private AMap.OnCameraChangeListener mOnCameraChangeListener = new AMap.OnCameraChangeListener() {
        @Override
        public void onCameraChange(CameraPosition cameraPosition) {

        }

        /**
         * 拖动地图 结束回调
         *
         * @param cameraPosition 当地图位置发生变化，就重新查询数据（手动拖动或者代码改变地图位置都会调用）
         */
        @Override
        public void onCameraChangeFinish(CameraPosition cameraPosition) {
            if (isHandDrag) {//手动去拖动地图
                mFinalChoosePosition=cameraPosition.target;
                //地理逆向搜索
                getAddress();
                doSearchQuery();
            } else {
                //搜索证明地图中心点已经移动过，默认是是手动触发
                isHandDrag = true;
                isFirstLoadList = false;
            }

        }
    };


    /**----------------------以下poi搜索（经纬度==>周边位置信息）----------------------------------*/


    /**
     * 初始化POI搜索
     */
    private void iniPoi() {
        lbsAdressAdapter = new LbsAdressAdapter(activity);
        lvPoi.setAdapter(lbsAdressAdapter);
        lbsAdressAdapter.setMlist(mDatas);
        lvPoi.setOnItemClickListener(onItemClickListener);
    }

    /**
     * 开始进行poi搜索   重点
     * 通过经纬度获取附近的poi信息
     * <p>
     * 1、keyword 传 ""
     * 2、poiSearch.setBound(new PoiSearch.SearchBound(lpTemp, 5000, true)); 根据
     */
    private void searchAroundAdress(String city) {
        currentPage = 0;
        query = new PoiSearch.Query("", "", city);// 第一个参数表示搜索字符串，第二个参数表示poi搜索类型，第三个参数表示poi搜索区域（空字符串代表全国）
        query.setPageSize(20);// 设置每页最多返回多少条poiitem
        query.setPageNum(currentPage);// 设置查第一页

        LatLonPoint lpTemp = convertToLatLonPoint(mFinalChoosePosition);
        if (lpTemp != null) {
            poiSearch = new PoiSearch(this, query);
            poiSearch.setOnPoiSearchListener(mOnPoiSearchListener);  // 实现  onPoiSearched  和  onPoiItemSearched
            poiSearch.setBound(new PoiSearch.SearchBound(lpTemp, 500, true));//
            // 设置搜索区域为以lp点为圆心，其周围500米范围
            poiSearch.searchPOIAsyn();// 异步搜索
        }
    }

    /**
     * 开始进行poi搜索   重点
     * 通过经纬度获取附近的poi信息
     * <p>
     * 1、keyword 传 ""
     * 2、poiSearch.setBound(new PoiSearch.SearchBound(lpTemp, 5000, true)); 根据
     */
    protected void doSearchQuery() {
        currentPage = 0;
        query = new PoiSearch.Query("", "", cityName);// 第一个参数表示搜索字符串，第二个参数表示poi搜索类型，第三个参数表示poi搜索区域（空字符串代表全国）
        query.setPageSize(50);// 设置每页最多返回多少条poiitem
        query.setPageNum(currentPage);// 设置查第一页

        LatLonPoint lpTemp = convertToLatLonPoint(mFinalChoosePosition);

        if (lpTemp != null) {
            poiSearch = new PoiSearch(this, query);
            poiSearch.setOnPoiSearchListener(mOnPoiSearchListener);  // 实现  onPoiSearched  和  onPoiItemSearched
            poiSearch.setBound(new PoiSearch.SearchBound(lpTemp, 500, true));//
            // 设置搜索区域为以lp点为圆心，其周围500米范围
            poiSearch.searchPOIAsyn();// 异步搜索
        }
    }

    /**
     * 地理位置周边搜索监听
     * poi 附近数据搜索
     *
     * @param result
     * @param rcode
     */
    private PoiSearch.OnPoiSearchListener mOnPoiSearchListener = new PoiSearch.OnPoiSearchListener() {
        @Override
        public void onPoiSearched(PoiResult result, int rcode) {
            if (rcode == 0 || rcode == 1000) {
                if (result != null && result.getQuery() != null) {// 搜索poi的结果
                    if (result.getQuery().equals(query)) {// 是否是同一条
                        poiResult = result;
                        poiItems = poiResult.getPois();// 取得第一页的poiitem数据，页数从数字0开始
                        List<SuggestionCity> suggestionCities = poiResult
                                .getSearchSuggestionCitys();// 当搜索不到poiitem数据时，会返回含有搜索关键字的城市信息
                        mDatas.clear();
                        mDatas.add(mAddressEntityFirst);// 第一个元素
                        maddressName=mAddressEntityFirst.getAdress();
                        AddressSearchTextEntity addressEntity = null;
                        for (PoiItem poiItem : poiItems) {
                            LogUtil.d("lbs:省",poiItem.getProvinceName());
                            LogUtil.d("lbs:市",poiItem.getCityName());
                            LogUtil.d("lbs:区",poiItem.getAdName());
                            cityName=poiItem.getCityName();
                            addressEntity = new AddressSearchTextEntity(poiItem.getProvinceName(),poiItem.getCityName(),
                                    poiItem.getAdName(),poiItem.getTitle(), poiItem.getSnippet(), false, poiItem.getLatLonPoint());
                            mDatas.add(addressEntity);
                        }
                        if (isHandDrag) {
                            mDatas.get(0).setChoose(true);
                        }
                        lbsAdressAdapter.notifyDataSetChanged();
                    }
                } else {
                    showToast("对不起，没有搜索到相关数据！");
                }
            }

        }

        @Override
        public void onPoiItemSearched(PoiItem poiItem, int rcode) {

        }
    };

    /**
     * 按照关键字搜索附近的poi信息
     *
     * @param key
     */
    protected void doSearchQueryWithKeyWord(String key) {
        currentPage = 0;
        query = new PoiSearch.Query(key, "", cityName);// 第一个参数表示搜索字符串，第二个参数表示poi搜索类型，第三个参数表示poi搜索区域（空字符串代表全国）
        query.setPageSize(20);// 设置每页最多返回多少条poiitem
        query.setPageNum(currentPage);// 设置查第一页

        if (lp != null) {
            poiSearch = new PoiSearch(this, query);
            poiSearch.setOnPoiSearchListener(mOnPoiSearchListener);   // 实现  onPoiSearched  和  onPoiItemSearched
            poiSearch.setBound(new PoiSearch.SearchBound(lp, 5000, true));//
            // 设置搜索区域为以lp点为圆心，其周围5000米范围
            poiSearch.searchPOIAsyn();// 异步搜索
        }
    }

    /**----------------------以上poi搜索（经纬度==>周边位置信息）----------------------------------*/


    /**----------------------以下地理搜索（经纬度==详细位置)----------------------------------*/

    /**
     * 响应逆地理编码（根据经纬度得到地址）,搜索用户最终选择的点的经纬度
     */
    public void getAddress() {
        // 第一个参数表示一个Latlng，第二参数表示范围多少米，第三个参数表示是火系坐标系还是GPS原生坐标系
        RegeocodeQuery query = new RegeocodeQuery(convertToLatLonPoint(mFinalChoosePosition), 200, GeocodeSearch.AMAP);
        geocoderSearch.getFromLocationAsyn(query);// 设置同步逆地理编码请求
    }

    /**
     * 地理编码查询回调
     */
    private GeocodeSearch.OnGeocodeSearchListener mtOnGeocodeSearchListener = new GeocodeSearch.OnGeocodeSearchListener() {

        @Override
        public void onGeocodeSearched(GeocodeResult result, int rCode) {

        }

        /**
         * 逆地理编码回调
         */
        @Override
        public void onRegeocodeSearched(RegeocodeResult result, int rCode) {
            Log.d("LJAPP", "" + result.toString() + rCode);
            if (rCode == 0 || rCode == 1000) {
                if (result != null && result.getRegeocodeAddress() != null
                        && result.getRegeocodeAddress().getFormatAddress() != null) {
                    ProvinceName=result.getRegeocodeAddress().getProvince();
                    cityName=result.getRegeocodeAddress().getCity();
                    RegionName=result.getRegeocodeAddress().getDistrict();
                    tittleName = result.getRegeocodeAddress().getFormatAddress();
                    addressName = result.getRegeocodeAddress().getFormatAddress(); // 逆转地里编码不是每次都可以得到对应地图上的opi
                    mAddressEntityFirst = new AddressSearchTextEntity(ProvinceName,cityName,RegionName,addressName, addressName, true, convertToLatLonPoint(mFinalChoosePosition));
                } else {
                    showToast("没有搜索到该位置");
                }
            } else if (rCode == 27) {
                showToast("网络异常");
            } else if (rCode == 32) {
                showToast("key错误");
            } else {
                showToast("其他错误类型" + rCode);
            }
        }
    };

    /**----------------------以上地理搜索（经纬度==详细位置)----------------------------------*/


    /**
     * 切换到当前位置
     */
    @OnClick(R.id.lvCurrentLocation)
    public void go2CurrenLocation() {
        aMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(currentLatLongPoint.getLatitude(), currentLatLongPoint.getLongitude()), 20));
    }

    @OnClick(R.id.ivSearch)
    public void ivSearchClick() {
        LatLng latLng=new LatLng(currentLatLongPoint.getLatitude(),currentLatLongPoint.getLongitude());
        LBSSearchActivity.lunch(activity,latLng);
    }

    /**
     * 确定位置
     */
    @OnClick(R.id.tvConfirm)
    public void tvConfirmClick() {
        double[] lbs = NumberUtils.bd_encrypt(mFinalChoosePosition.latitude, mFinalChoosePosition.longitude);
        LogUtil.d("高德-->百度", lbs[0] + "----" + lbs[1]);
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("ProvinceName",ProvinceName);
        params.put("CityName",cityName);
        params.put("RegionName",RegionName);
        params.put("Latitude", lbs[0]);
        params.put("Longitude", lbs[1]);
        params.put("addressName", maddressName);
        String json = StringUtils.transMapToString(params);
        Intent intent = new Intent();
        intent.putExtra("lbsLocation", json);
        activity.setResult(RESULT_OK, intent);
        activity.finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_PAY_SUCCESS && resultCode == RESULT_OK) {
            if (data != null && data.getExtras() != null) {
                String json=data.getExtras().getString("SerachLocation");
                AddressSearchTextEntity addressSearchTextEntity=new Gson().fromJson(json,AddressSearchTextEntity.class);
                cityName=addressSearchTextEntity.getCityName();
                mFinalChoosePosition =convertToLatLng(addressSearchTextEntity.getLatLonPoint());
                //移动到指定位置
                doSearchQuery();
                aMap.moveCamera(CameraUpdateFactory.newLatLngZoom(
                        new LatLng(addressSearchTextEntity.getLatLonPoint().getLatitude(), addressSearchTextEntity.getLatLonPoint().getLongitude()), 20));
            }
        }
    }
}

