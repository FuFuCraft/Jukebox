package org.abstruck.fabric.fufucraft.jukebox.util;

import javax.net.ssl.*;
import java.io.InputStream;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * @author Astrack
 * @date 2023/7/21
 */
public class UrlUtils {
    public static X509TrustManager trustManager = new X509TrustManager() {
        @Override
        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {

        }

        @Override
        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {

        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    };
    public static InputStream download(URL url) throws Exception {
        SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
        sslContext.init(null,new TrustManager[]{trustManager},new SecureRandom());
        HostnameVerifier verifier = (hostname, session) -> true;
        HttpsURLConnection.setDefaultHostnameVerifier(verifier);
        HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());
        HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
        urlConnection.setConnectTimeout(60*1000);
        urlConnection.setReadTimeout(0);

        int code = urlConnection.getResponseCode();
        if (code != HttpsURLConnection.HTTP_OK){
            throw new Exception("code: "+code+","+urlConnection.getResponseMessage());
        }
        return urlConnection.getInputStream();
    }
}
