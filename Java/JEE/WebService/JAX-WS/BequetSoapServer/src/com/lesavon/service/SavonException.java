package com.lesavon.service;

import javax.xml.soap.SOAPException;

/**
 * Исключение.
 */
public class SavonException extends SOAPException {
    public SavonException(String format, Object... args) {
        super(String.format(format, args));
    }

    public SavonException(String reason) {
        super(reason);
    }
}