package com.rodrigoteixeira.workshopmongo.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class Url {

    public static String decodeParam(String url) {
        try{
            return URLDecoder.decode(url, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }
}
