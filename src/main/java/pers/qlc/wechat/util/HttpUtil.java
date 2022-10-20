package pers.qlc.wechat.util;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import java.io.IOException;

/**
 * @author QLC
 */
public class HttpUtil {

    private static final int STATUS_200 = 200;

    private static final int STATUS_404 = 404;

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
                if (response.getStatusLine().getStatusCode() != STATUS_200) {
                    if (response.getStatusLine().getStatusCode() != STATUS_404) {
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
