package com.commsdk.base;

/**
 * 描述：项目的id地址设置(开发环境、线上测试环境、正式环境)
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017/3/17
 * 版本：2.0
 */
public class IPConfig {

    /***开发环境*/
    enum DEVEROP_ADRESS{

        HOST_8080("http://192.168.1.90:8080",8080),//球球
        HOST_8081("http://192.168.1.90:8081",8081),//小萌
        HOST_8082("http://192.168.1.90:8082",8082),//大强、三哥
        HOST_8084("http://192.168.1.90:8084",8084),//春阳
        HOST_8085("http://192.168.1.90:8085",8085),//卫国
        HOST_8089("http://192.168.1.90:8089",8089),//政霖
        HOST_8099("http://192.168.1.90:8099",8099);//宁宁
        /**端口对于的地址*/
        private String host;
        /**端口号*/
        private int port;

        public String getHost() {
            return host;
        }

        public void setHost(String host) {
            this.host = host;
        }

        public int getPort() {
            return port;
        }

        public void setPort(int port) {
            this.port = port;
        }

        DEVEROP_ADRESS(String host, int port){
            this.host=host;
            this.port=port;
        }

        /**
         * Description: 根据host获取对应枚举.<br/><br/>
         *
         * @param hostName 状态名称
         *
         */
        public static DEVEROP_ADRESS hostNameToHostEnum(String hostName) {
            if (hostName != null) {
                for (int i = 0; i < DEVEROP_ADRESS.values().length; i++) {
                    if (hostName.equals(DEVEROP_ADRESS.values()[i].getHost())) {
                        return DEVEROP_ADRESS.values()[i];
                    }
                }
            }
            return DEVEROP_ADRESS.HOST_8080;
        }


        /**
         * Description: 根据端口号port获取对应枚举.<br/><br/>
         *
         * @param port 状态
         *
         */
        public static DEVEROP_ADRESS portToHostEnum(int port) {
                for (int i = 0; i < DEVEROP_ADRESS.values().length; i++) {
                    if (DEVEROP_ADRESS.values()[i].getPort()==port) {
                        return DEVEROP_ADRESS.values()[i];
                    }
                }
            return DEVEROP_ADRESS.HOST_8080;
        }


        /**
         * Description: 根据端口port获取状态对于的地址host.<br/><br/>
         *
         * @param port 状态
         *
         */
        public static String portToHost(int port) {
                for (int i = 0; i < DEVEROP_ADRESS.values().length; i++) {
                    if (DEVEROP_ADRESS.values()[i].getPort()==port) {
                        return DEVEROP_ADRESS.values()[i].getHost();
                    }
                }
            return DEVEROP_ADRESS.HOST_8080.getHost();
        }
    }



    /**
     *   线上测试环境
     *   1.http://sso.chainwine.com/upload/images
     *   2.http://cust.chainwine.com
     *   3.http://portal.chainwine.com
     *
     * */
    enum TEST_ADRESS{
        PORT("http://portal.chainwine.com"),
        CUST("http://cust.chainwine.com"),
        SSO("http://sso.chainwine.com"),
        ORDER("http://order.chainwine.com"),
        PUSH("http://47.93.80.77:8088/");

        private String host;

        public String getHost() {
            return host;
        }

        public void setHost(String host) {
            this.host = host;
        }

        TEST_ADRESS(String host){
            this.host=host;
        }

        /**
         * Description: 根据host获取对应枚举.<br/><br/>
         *
         * @param hostName 状态名称
         *
         */
        public static TEST_ADRESS hostNameToHostEnum(String hostName) {
            if (hostName != null) {
                for (int i = 0; i < TEST_ADRESS.values().length; i++) {
                    if (hostName.equals(TEST_ADRESS.values()[i].getHost())) {
                        return TEST_ADRESS.values()[i];
                    }
                }
            }
            return TEST_ADRESS.CUST;
        }
    }


}
