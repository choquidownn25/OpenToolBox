package com.proyecto.opentoolbox;

/**
 * Created by choqu_000 on 19/06/2017.
 */

import android.webkit.URLUtil;

public class OpenTokConfig {
    // *** Fill the following variables using your own Project info from the OpenTok dashboard  ***
    // ***                      https://dashboard.tokbox.com/projects                           ***

    // Replace with your OpenTok API key
    public static final String API_KEY = "45896062";
    // Replace with a generated Session ID
    public static final String SESSION_ID = "2_MX40NTg5NjA2Mn5-MTQ5NzkxOTk5MDA2NX5ENWRVRks5ZkNrTnJSOFJCOTlWWUhoWkt-fg";
    // Replace with a generated token (from the dashboard or using an OpenTok server SDK)
    public static final String TOKEN = "T1==cGFydG5lcl9pZD00NTg5NjA2MiZzaWc9ZGQyY2E2N2U5YzcxNTIxMzUzNDgyMDNjYmEzMzkzODQ4NGE0ODYzYzpzZXNzaW9uX2lkPTJfTVg0ME5UZzVOakEyTW41LU1UUTVOemt4T1RrNU1EQTJOWDVFTldSVlJrczVaa05yVG5KU09GSkNPVGxXV1Vob1drdC1mZyZjcmVhdGVfdGltZT0xNDk3OTIxNTc5Jm5vbmNlPTAuNTg2MjQwNTkxMTk5MDA2MSZyb2xlPXB1Ymxpc2hlciZleHBpcmVfdGltZT0xNTAwNTEzNTc3JmNvbm5lY3Rpb25fZGF0YT1kYXRv";

    /*                           ***** OPTIONAL *****
     If you have set up a server to provide session information replace the null value
     in CHAT_SERVER_URL with it.

     For example: "https://yoursubdomain.com"
    */
    public static final String CHAT_SERVER_URL = null;
    public static final String SESSION_INFO_ENDPOINT = CHAT_SERVER_URL + "/session";


    // *** The code below is to validate this configuration file. You do not need to modify it  ***

    public static String webServerConfigErrorMessage;
    public static String hardCodedConfigErrorMessage;

    public static boolean areHardCodedConfigsValid() {
        if (OpenTokConfig.API_KEY != null && !OpenTokConfig.API_KEY.isEmpty()
                && OpenTokConfig.SESSION_ID != null && !OpenTokConfig.SESSION_ID.isEmpty()
                && OpenTokConfig.TOKEN != null && !OpenTokConfig.TOKEN.isEmpty()) {
            return true;
        }
        else {
            hardCodedConfigErrorMessage = "API KEY, SESSION ID and TOKEN in OpenTokConfig.java cannot be null or empty.";
            return false;
        }
    }

    public static boolean isWebServerConfigUrlValid(){
        if (OpenTokConfig.CHAT_SERVER_URL == null || OpenTokConfig.CHAT_SERVER_URL.isEmpty()) {
            webServerConfigErrorMessage = "CHAT_SERVER_URL in OpenTokConfig.java must not be null or empty";
            return false;
        } else if ( !( URLUtil.isHttpsUrl(OpenTokConfig.CHAT_SERVER_URL) || URLUtil.isHttpUrl(OpenTokConfig.CHAT_SERVER_URL)) ) {
            webServerConfigErrorMessage = "CHAT_SERVER_URL in OpenTokConfig.java must be specified as either http or https";
            return false;
        } else if ( !URLUtil.isValidUrl(OpenTokConfig.CHAT_SERVER_URL) ) {
            webServerConfigErrorMessage = "CHAT_SERVER_URL in OpenTokConfig.java is not a valid URL";
            return false;
        } else {
            return true;
        }
    }
}
