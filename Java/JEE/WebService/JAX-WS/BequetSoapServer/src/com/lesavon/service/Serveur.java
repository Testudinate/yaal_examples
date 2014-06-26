package com.lesavon.service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * Сервлет - кэширующий роутер.
 */
public class Serveur extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            final String UTF8 = "text/xml; charset=utf-8";
            if (!req.getContentType().endsWith(UTF8)) {
                throw new SavonException("This server only handles: ", UTF8);
            }

            String cacheKey = req.getHeader("LeSavon-Cache-Key");
            byte[] cacheData = null;
            byte[] inputBytes = null;
            if (cacheKey == null) {
                try {
                    inputBytes = readInputBytes(req);
                    cacheKey = SOAPCache.getCache().computeCacheKey(req, new ByteArrayInputStream(inputBytes),
                            getServletConfig().getServletContext());
                } catch (Exception e) {
                    throw new SavonException("Internal error in computin cache key");
                }
            }
        } catch (Exception e) {

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
