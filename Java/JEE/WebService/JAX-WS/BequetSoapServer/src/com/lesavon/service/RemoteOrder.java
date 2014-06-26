package com.lesavon.service;

import org.w3c.dom.Element;

/**
 * Заказ.
 */
public interface RemoteOrder {
    Order[] getOrderList(String userName) throws SavonException;

    Element getOrder(String userName, int orlderId) throws SavonException;
}
