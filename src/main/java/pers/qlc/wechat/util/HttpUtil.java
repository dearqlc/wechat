package pers.qlc.wechat.util;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import java.io.IOException;

public class HttpUtil {

    public HttpUtil() {
    }

    public static String getUrl(String url) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String str;
        try {
            HttpGet httpGet = new HttpGet(url);
            httpGet.addHeader("Connection", "close");
            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(18000).setConnectTimeout(5000).setConnectionRequestTimeout(18000).build();
            httpGet.setConfig(requestConfig);

            try (CloseableHttpResponse response = httpclient.execute(httpGet)) {
                Object entity;
                if (response.getStatusLine().getStatusCode() != 200) {
                    if (response.getStatusLine().getStatusCode() != 404) {
                        return null;
                    }
                    entity = "";
                    return (String) entity;
                }
                entity = response.getEntity();
                String result = EntityUtils.toString((HttpEntity) entity);
                EntityUtils.consume((HttpEntity) entity);
                str = result;
            }
        } finally {
            httpclient.close();
        }

        return str;
    }

}
