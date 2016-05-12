package com.fast.library.sample.tools;

import android.text.TextUtils;
import com.fast.library.HttpUtils;
import com.fast.library.http.RequestParams;
import com.fast.library.http.callback.BaseHttpCallBack;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 说明：Api
 * <p/>
 * 作者：fanly
 * <p/>
 * 时间：2016/5/12 22:38
 * <p/>
 * 版本：verson 1.0
 */
public class Api {

    //预置token
    public final static String TOKEN = "3e90e0b25748e02b5b96fc4691b01d3a";
    //base url
    public final static String BASE_URL = "http://nd.hn-csk.com/api/";

    interface Url{
        String merchant = "merchant";//获取商家列表
        String page = "page";//获取h5页面
        String merchantcategories = "merchant/categories";//获取商家类别
        String accountagreement = "account/agreement";//获取用户协议免责条款
        String accountlogin = "account/login";//登录
        String accountregister= "account/register";//注册
        String accountsmscode = "account/smscode";//短信验证码
        String accountget_uid = "account/get_uid";//获取当前用户ID
        String accountuserinfo = "account/userinfo";//获取当前用户信息
        String accountpass_find = "account/pass_find";//找回密码
        String accountavatar = "account/avatar";//更换头像
        String accountprofile = "account/profile";//编辑个人信息
        String accountpass_edit = "account/pass_edit";//密码修改
        String accountlogout = "account/logout";//登出
        String bbscategories = "bbs/categories";//社区类别
        String bbspic_upload = "bbs/pic_upload";//分享图片上传
    }

    private static String getUrl(String url){
        return BASE_URL + url + "/";
    }

    private static String getTimesTamp(){
        return System.currentTimeMillis()/1000+"";
    }

    private static String getAK(String url,String timesTamp){
        String des = url + timesTamp + TOKEN;
        return SHA1(des);
    }

    public static String SHA1(String decript) {
        try {
            MessageDigest digest = MessageDigest
                    .getInstance("SHA-1");
            digest.update(decript.getBytes());
            byte messageDigest[] = digest.digest();
            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            // 字节数组转换为 十六进制 数
            for (int i = 0; i < messageDigest.length; i++) {
                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 获取h5页面
     */
    public static void getH5page(String q,String id,BaseHttpCallBack callBack) {
        String timestamp = getTimesTamp();
        String url = Url.page;
        RequestParams params = new RequestParams(getUrl(url));
        params.put("timestamp", timestamp);
        params.put("ak", getAK(url,timestamp));
        params.put("q", q);
        if (!TextUtils.isEmpty(id)) {
            params.put("id", id);
        }
        HttpUtils.get(getUrl(url), params, callBack);
    }

}
