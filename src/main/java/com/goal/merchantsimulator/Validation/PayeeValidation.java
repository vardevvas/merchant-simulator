package com.goal.merchantsimulator.Validation;

import com.goal.merchantsimulator.config.Constant;
import com.goal.merchantsimulator.dto.inbound.BillInquiryRequest;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@FunctionalInterface
@Component
public interface PayeeValidation extends Function<BillInquiryRequest, Map<Object, Object>>{

    static PayeeValidation isPayeeIdValid() {
        return billInquiryRequest -> {
            Map<Object,Object> res = new HashMap<>();
            res.put("code",Constant.ResponseCode.Success.code);
            res.put("msg",Constant.ResponseCode.Success.msg);
            res.put("status",Constant.ResponseCode.Success.status);
            String payeeId = billInquiryRequest.getPayeeId();
            String[] paymentInfoFirstSplit = billInquiryRequest.getPersonalPaymentInfo().split("/");
            String[][] paymentInfoSecondSplit = new String[paymentInfoFirstSplit.length][];
            Map<String, String> paymentInfo = new HashMap<>();
            try {
                for (int i = 0; i < paymentInfoFirstSplit.length; i++) {
                    paymentInfoSecondSplit[i] = paymentInfoFirstSplit[i].split("=");
                    paymentInfo.put(paymentInfoSecondSplit[i][0], paymentInfoSecondSplit[i][1]);
                }
            } catch (Exception e){
                res.clear();
                res.put("code",Constant.ResponseCode.InvalidPersonalPaymentInformationFormat.code);
                res.put("msg",Constant.ResponseCode.InvalidPersonalPaymentInformationFormat.msg);
                res.put("status","Failed");
                return res;
            }
            switch (payeeId) {
                case "0010010001":
                case "0010010002":
                case "0010010003":
                case "0010010004":
                case "0010010005":
                case "0010010006":
                    if (paymentInfo.containsKey("MPHONE") && !paymentInfo.get("MPHONE").isEmpty()) {
                        return res;
                    }
                    break;
                case "0010020001":
                    if (paymentInfo.containsKey("METER") && !paymentInfo.get("METER").isEmpty()) {
                        return res;
                    }
                    break;
                case "0010030002":
                    if ((paymentInfo.containsKey("SETNUMBER") && paymentInfo.containsKey("STUDCOURSEID") && paymentInfo.containsKey("STUDFORMKIND")) && (!paymentInfo.get("METER").isEmpty() && !paymentInfo.get("STUDCOURSEID").isEmpty() && !paymentInfo.get("STUDFORMKIND").isEmpty())) {
                        return res;
                    }
                    break;
                case "0010030003":
                    if ((paymentInfo.containsKey("BANKCODE") && paymentInfo.containsKey("DECLARANTCODE ")) && (!paymentInfo.get("BANKCODE").isEmpty() && !paymentInfo.get("DECLARANTCODE").isEmpty())) {
                        return res;
                    }
                    break;
                case "0010030004":
                    if ((paymentInfo.containsKey("STUCNAME") && paymentInfo.containsKey("STUCPHONE") && paymentInfo.containsKey("STUDCOURSEID") && paymentInfo.containsKey("STUDFORMKIND")) && (!paymentInfo.get("STUCNAME").isEmpty() && !paymentInfo.get("STUCPHONE").isEmpty() && !paymentInfo.get("STUDCOURSEID").isEmpty() && !paymentInfo.get("STUDFORMKIND").isEmpty())) {
                        return res;
                    }
                    break;
                case "0010050001":
                    if ((paymentInfo.containsKey("SERVICEID") && paymentInfo.containsKey("INVOICENUMBER") && paymentInfo.containsKey("PHONENUMBER")) && (!paymentInfo.get("SERVICEID").isEmpty() && !paymentInfo.get("INVOICENUMBER").isEmpty() && !paymentInfo.get("PHONENUMBER").isEmpty())) {
                        return res;
                    }
                    break;
                case "0010060002":
                    if ((paymentInfo.containsKey("REFTYPE") && paymentInfo.containsKey("REFVALUE")) && (!paymentInfo.get("REFTYPE").isEmpty() && !paymentInfo.get("REFVALUE").isEmpty())) {
                        return res;
                    }
                    break;
                case "0010060003":
                case "0010060004":
                case "0010060005":
                    if (paymentInfo.containsKey("SERVICEREFERENCE") && !paymentInfo.get("SERVICEREFERENCE").isEmpty()) {
                        return res;
                    }
                    break;
                case "0055555555":
                case "0010017801":
                case "0055555556":
                    if (paymentInfo.containsKey("customerBillerRef") && !paymentInfo.get("customerBillerRef").isEmpty()) {
                        return res;
                    }
                    break;
                default:
                    res.clear();
                    res.put("code",Constant.ResponseCode.InvalidPayeeId.code);
                    res.put("msg",Constant.ResponseCode.InvalidPayeeId.msg);
                    res.put("status","Failed");
                    return res;
            }
            res.clear();
            res.put("code",Constant.ResponseCode.InvalidPersonalPaymentInformationFormat.code);
            res.put("msg",Constant.ResponseCode.InvalidPersonalPaymentInformationFormat.msg);
            res.put("status","Failed");
            return res;
        };
    }

    default PayeeValidation and(PayeeValidation other) {
        return defaultRequest -> {
            Map<Object,Object > result = this.apply(defaultRequest);
            return result.containsValue(0) ? other.apply(defaultRequest) : result;
        };
    }


}
