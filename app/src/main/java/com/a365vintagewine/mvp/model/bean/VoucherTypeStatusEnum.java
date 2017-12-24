package com.a365vintagewine.mvp.model.bean;

/**
 * @Destription:采购订单状态，展示专用
 * @auther:lstreamlet
 * @date:2017/2/14
 */
public enum VoucherTypeStatusEnum {


    VOUCHER_STATUS_0("未使用", "0"),
    VOUCHER_STATUS_1("使用记录", "1"),
    VOUCHER_STATUS_2("已过期","2");

    private String statusStr;
    private String statusInt;

    VoucherTypeStatusEnum(String statusStr, String statusInt) {
        this.statusInt = statusInt;
        this.statusStr = statusStr;
    }

    public String getStatusStr() {
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    public String getStatusInt() {
        return statusInt;
    }

    public void setStatusInt(String statusInt) {
        this.statusInt = statusInt;
    }

    /**
     * Description: 获取对应枚举.<br/><br/>
     *
     * @param statusName 状态名称
     *
     */
    public static VoucherTypeStatusEnum statusNameToOrderStatusEnum(String statusName) {
        if (statusName != null) {
            for (int i = 0; i < VoucherTypeStatusEnum.values().length; i++) {
                if (statusName.equals(VoucherTypeStatusEnum.values()[i].getStatusStr())) {
                    return VoucherTypeStatusEnum.values()[i];
                }
            }
        }
        return VoucherTypeStatusEnum.VOUCHER_STATUS_0;
    }


    /**
     * Description: 获取对应枚举.<br/><br/>
     *
     * @param status 状态
     *
     */
    public static VoucherTypeStatusEnum statusToOrderStatusEnum(String status) {
        if (status != null) {
            for (int i = 0; i < VoucherTypeStatusEnum.values().length; i++) {
                if (status.equals(VoucherTypeStatusEnum.values()[i].getStatusInt())) {
                    return VoucherTypeStatusEnum.values()[i];
                }
            }
        }
        return VoucherTypeStatusEnum.VOUCHER_STATUS_0;
    }

    /**
     * Description: 获取对应枚举.<br/><br/>
     *
     * @param enumName 枚举名称
     *
     */
    public static VoucherTypeStatusEnum enumNameToOrderStatusEnum(String enumName) {
        if (enumName != null) {
            for (int i = 0; i < VoucherTypeStatusEnum.values().length; i++) {
                if (enumName.equals(VoucherTypeStatusEnum.values()[i].toString())) {
                    return VoucherTypeStatusEnum.values()[i];
                }
            }
        }
        return VoucherTypeStatusEnum.VOUCHER_STATUS_0;
    }


    /**
     * Description: 根据状态获取状态对于的状态名称.<br/><br/>
     *
     * @param status 状态
     *
     */
    public static String statusToOrderStatus(String status) {
        if (status != null) {
            for (int i = 0; i < VoucherTypeStatusEnum.values().length; i++) {
                if (status.equals(VoucherTypeStatusEnum.values()[i].getStatusInt())) {
                    return VoucherTypeStatusEnum.values()[i].getStatusStr();
                }
            }
        }
        return VoucherTypeStatusEnum.VOUCHER_STATUS_0.getStatusStr();
    }

}
