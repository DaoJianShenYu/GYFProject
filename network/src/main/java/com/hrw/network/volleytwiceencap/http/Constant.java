package com.hrw.network.volleytwiceencap.http;

/**
 * Created by Beata on 2016/10/14.
 */
public interface Constant {
  //http://192.168.12.47:8080/RedBabyServer/login
  String HOST = "http://192.168.12.54:8080";
  String SERVER_URL = HOST + "/RedBabyServer";

  String REQUEST_LOGIN = SERVER_URL + "/login";
  int LOGIN = 1001;
  String REQUEST_LOGOUT = SERVER_URL + "/logout";
  int LOGOUT = 1002;
  String REQUEST_REGISTER = SERVER_URL + "/register";
  int register = 1101;
  String ADDRESS_URL = SERVER_URL + "/addresslist";
  int ADDRESS_REQUEST_CODE = 1004;
  String ADDRESS_ADD_URL = SERVER_URL + "/addresssave";
  int ADDRESS_ADD_REQUEST_CODE = 1005;
  String REQUEST_RECOMMENDBRAND = SERVER_URL + "/brand";
  String COMMODITYLIST = SERVER_URL+"/productlist?page=1&pageNum=10&cId=22&orderby=saleDown&filter=s1-p8";

  String COMMODITYDETAIL = SERVER_URL + "/product?pId=";  //商品详情
  String REQUEST_TOPIC = SERVER_URL + "/topic";//促销快报接口
  String REQUEST_NEWARRIVAL = SERVER_URL + "/newproduct";

  ///http://192.168.12.66:8080/RedBabyServer/limitbuy/images?page=1&pageNum=10/product/detail/b1.jpg
  String REQUEST_limitbuy = SERVER_URL + "/limitbuy";//限时抢购接口
  int limitbuy = 1006;

  String REQUEST_SEARCH = SERVER_URL +"/search";//搜索页面的接口
  int search = 1007;
  String REQUEST_RECOMMEND = SERVER_URL + "/search/recommend";//搜索推荐页面借口
  int recommend = 1102;
  //http://192.168.12.66:8080/RedBabyServer/home?homeTopic
  String  REQUEST_HOME = SERVER_URL +"/home";//home轮播图的接口
    int HOMECODE = 1008;

  String  REQUEST_HOTPRODUCT = SERVER_URL +"/hotproduct";//热门单品的接口
  String REQUEST_CLASS = SERVER_URL + "/category";//分类页面
  int CLASSCODE = 1009;
  int THIRD_CLASS_FRAGMENT_REQUEST_CODE = 1010;
  String THIRD_CLASS_FRAGMENT_REQUEST_URL = SERVER_URL + "/productlist";
  int DEFAULTCODE = 666;
  //地址求情删除url
  String REQUEST_ADDRESS_DELETE = SERVER_URL + "/addressdelete";
  int REQUEST_ADDRESS_DELETE_CODE= 1010;
//地址请求默认地址url
  String REQUEST_ADDRESS_DEFAULT = SERVER_URL + "/addressdefault";
  int REQUEST_ADDRESS_DEFAULT_CODE= 1011;

  String REQUEST_HELP = SERVER_URL + "/help";//帮助中心的借口
  int HELP = 1113;
  String REQUEST_HELPDETAIL = SERVER_URL + "/helpDetail";//用户指南的借口
  int HELPDETAIL = 10101;

  String REQUEST_FAVOURITES = SERVER_URL+"/favorites";
  int favourites = 1102;

  //订单url
  String REQUEST_ORDER_URL = SERVER_URL + "/orderlist";
  int REQUEST_URL_CODE = 1012;
  String REQUEST_CHECKOUT = SERVER_URL + "/checkout";//结算中心的接口
  int CHECKOUT = 1114;

  String REQUEST_INVOICE = SERVER_URL + "/invoice";//发票信息的接口
  int INVOICE = 1115;
  String REQUEST_SUBMIT = SERVER_URL + "/ordersumbit";//提交结算的接口
  int ORDERSUBMIT = 1116;
  String CART = SERVER_URL + "/cart";

  String REQUEST_ORDER_DETAIL_URL = SERVER_URL + "/orderdetail";
  int REQUEST_ORDER_DETAIL_URL_CODE = 1013;

  String REQUEST_ORDER_CANCLE_URL = SERVER_URL + "/ordercancel";
  int REQUEST_ORDER_CANCLE_URL_CODE = 1015;

  String REQUEST_USER_INFO_URL = SERVER_URL + "/userinfo";
  int REQUEST_USER_INFO_URL_CODE = 1014;
}
