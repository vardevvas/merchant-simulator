package com.goal.merchantsimulator.config;

import com.goal.merchantsimulator.dto.outbound.GeneralResponse;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class Constant {

//    public GeneralResponse setResponse(GeneralResponse generalResponse, ResponseCode. response) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
//        Class res = Class.forName(response);
//        Object fasdfa = res.newInstance();
//        ResponseCode asdfasdf =  (ResponseCode) res.getDeclaredConstructor().newInstance();
//        res.getDeclaredConstructor().newInstance();
//        generalResponse.setResponseCode(response.code);
//        generalResponse.setResponseMessage(ResponseCode.asdfasdf.msg);
//        generalResponse.setResponseStatus(ResponseCode.response.status);
//        return generalResponse;
//    }
//
    public static class ResponseCode {

    public class Success {
        public static final int code = 0;
        public static final String msg = "Approved";
        public static final String status = "Successful";

    }

    public static class InvalidClientId {
        public static final int code = 600;
        public static final String msg = "Invalid System Trace Audit Number";
    }

    public static class InvalidTerminalId {
        public static final int code = 389;
        public static final String msg = "Invalid System Trace Audit Number";
    }

    public static class InvalidSystemTraceAuditNumber {
        public static final int code = 606;
        public static final String msg = "Invalid System Trace Audit Number";
    }

    public static class FormatError {
        public static final int code = 103;
        public static final String msg = "Format error";
    }

    public static class InvalidPersonalPaymentInformationFormat {
        public static final int code = 607;
        public static final String msg = "Personal Payment Information field format was violated";
    }

    public static class InvalidPayeeId {
        public static final int code = 608;
        public static final String msg = "INVALID_PAYEE_ID";
    }

    public static class InvalidCard {
        public static final int code = 52;
        public static final String msg = "Invalid card";
    }

}
}

