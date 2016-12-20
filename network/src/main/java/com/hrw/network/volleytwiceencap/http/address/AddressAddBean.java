package com.hrw.network.volleytwiceencap.http.address;

import com.hrw.shopping.http.IResponse;

import java.util.List;

/**
 * Created by wtz on 2016/12/10.
 */
public class AddressAddBean implements IResponse {

    /**
     * response :  addresssave
     * addressList : [{"id":134,"addressArea":"洪山区","addressDetail":"文华路文华学院","city":"武汉市","isDefault":0,"name":"张瑞丽","phoneNumber":"18986104910","province":"湖北","zipCode":"1008611"},{"addressArea":"洪山区","addressDetail":"街道口地铁c口","city":"武汉市","id":139,"isDefault":1,"name":"itcast","phoneNumber":"027-81970008","province":"湖北","zipCode":"430070"}]
     */

    private String response;
    private List<AddressListBean> addressList;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public List<AddressListBean> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<AddressListBean> addressList) {
        this.addressList = addressList;
    }
    private int error_code;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }
    public static class AddressListBean {
        /**
         * id : 134
         * addressArea : 洪山区
         * addressDetail : 文华路文华学院
         * city : 武汉市
         * isDefault : 0
         * name : 张瑞丽
         * phoneNumber : 18986104910
         * province : 湖北
         * zipCode : 1008611
         */

        private int id;
        private String addressArea;
        private String addressDetail;
        private String city;
        private int isDefault;
        private String name;
        private String phoneNumber;
        private String province;
        private String zipCode;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getAddressArea() {
            return addressArea;
        }

        public void setAddressArea(String addressArea) {
            this.addressArea = addressArea;
        }

        public String getAddressDetail() {
            return addressDetail;
        }

        public void setAddressDetail(String addressDetail) {
            this.addressDetail = addressDetail;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public int getIsDefault() {
            return isDefault;
        }

        public void setIsDefault(int isDefault) {
            this.isDefault = isDefault;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getZipCode() {
            return zipCode;
        }

        public void setZipCode(String zipCode) {
            this.zipCode = zipCode;
        }
    }
}
