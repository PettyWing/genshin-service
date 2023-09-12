package com.example.uumemory.service;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Map;

import javax.net.ssl.SSLContext;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.ssl.TrustStrategy;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class HttpSupportClient implements InitializingBean {
    private static final Logger logger = LoggerFactory.getLogger(HttpSupportClient.class);
    private CloseableHttpClient httpClient;

    @Override
    public void afterPropertiesSet() throws Exception {
        init();
    }

    public void init() throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException {
        httpClient = buildHttpClient();
    }

    private CloseableHttpClient buildHttpClient()
        throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException {
        RequestConfig requestConfig = RequestConfig.custom()
            .setSocketTimeout(4000)
            .setConnectTimeout(2000)
            .setConnectionRequestTimeout(2000)
            .build();

        SSLContext sslContext = SSLContexts.custom().loadTrustMaterial(null, new TrustStrategy() {
            @Override
            public boolean isTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
                return true;
            }
        }).build();

        // 忽略证书校验
        return HttpClients.custom().setDefaultRequestConfig(requestConfig).setSslcontext(sslContext).setSSLHostnameVerifier(new NoopHostnameVerifier()).setMaxConnTotal(200)
            .setMaxConnPerRoute(200).build();
    }

    public String doGet(String url) {
        return doGet(url, null, false);
    }

    public String doGet(String url, boolean proxy) {
        return doGet(url, null, proxy);
    }

    public String doGet(String url, Map<String, String> headers, boolean proxy) {
        return doGet(url, headers, proxy, null);
    }

    public String doGet(String url, Map<String, String> headers, boolean proxy, String charset) {

        logger.info("HttpClientSupport send get request  url: {}", url);
        HttpGet getMethod = new HttpGet(url);
        return excute(getMethod, charset);
    }

    private String excute(final HttpUriRequest request, String charset) {
        CloseableHttpResponse httpResponse = null;
        try {
            httpResponse = httpClient.execute(request);
            if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.OK.value()) {
                return EntityUtils.toString(httpResponse.getEntity(), charset);
            } else {
                logger.info("http invoke fail.{}", httpResponse.getStatusLine().getStatusCode());
                return EntityUtils.toString(httpResponse.getEntity(), charset);
            }
        } catch (IOException e) {
            logger.error("HttpClientSupport error to send get request", e);
        } finally {
            if (httpResponse != null) {
                try {
                    httpResponse.close();
                } catch (IOException e) {
                    logger.error("HttpClientSupport error to send get request", e);
                }
            }
        }
        return null;
    }
}
