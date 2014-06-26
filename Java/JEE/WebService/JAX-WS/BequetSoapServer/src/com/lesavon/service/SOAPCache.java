package com.lesavon.service;

import org.apache.soap.rpc.SOAPContext;
import org.apache.soap.transport.TransportMessage;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;

public class SOAPCache {
    private static final SOAPCache cache = new SOAPCache();

    private SOAPCache() {
    }

    public static SOAPCache getCache() {
        return cache;
    }

    public String computeCacheKey(HttpServletRequest req, InputStream inputStream, ServletContext servletContext) {
        return "test";
    }

    public byte[] getCacheData(String key) {
        return null;
    }

    public byte[] submitAndCache(byte[] requestText, String url, String key) {
        TransportMessage request = null;
        TransportMessage response = null;
        SOAPContext ctx = new SOAPContext();
        try {
            request = new TransportMessage(new String(requestText), ctx, null);
            request.save();
        } catch (Exception e) {
            System.err.println("SOAPCache.submitAndCache: exception " + e + " ingnored");
        }
        return response.getBytes();
    }

    public synchronized void startCacheThread(ServletContext ctx) {
    }

    public synchronized void stopCacheThread() {
    }

    public synchronized void flush() {
    }

    public synchronized void refresh() {
    }
}
