package com.goal.merchantsimulator.config;

import com.goal.merchantsimulator.dto.outbound.GeneralResponse;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class Constant {

//    public GeneralResponse setResponse(GeneralResponse generalResponse, String response) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
//        Class res = Class.forName(response);
//        Object fasdfa = res.newInstance();
////        ResponseCode asdfasdf =  (ResponseCode) res.getDeclaredConstructor().newInstance();
////        res.getDeclaredConstructor().newInstance();
//        generalResponse.setResponseCode(ResponseCode.fasdfa.code);
//        generalResponse.setResponseMessage(ResponseCode.asdfasdf.msg);
//        generalResponse.setResponseStatus(ResponseCode.response.status);
//        return generalResponse;
//    }
        
    public static class ResponseCode {
//        public class DefaultClass {
//            private int code;
//            private String msg;
//            private String status;
//
//            public DefaultClass(int code, String msg, String status) {
//                this.code = code;
//                this.msg = msg;
//                this.status = status;
//            }
//
//            public int getCode() {
//                return code;
//            }
//
//            public String getMsg() {
//                return msg;
//            }
//
//            public String getStatus() {
//                return status;
//            }
//        }


        public static class Success {
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

        public static class InvalidPin {
            public static final int code = 355;
            public static final String msg = "Invalid PIN";
        }

        public static class PinLimitTriesWasReached {
            public static final int code = 375;
            public static final String msg = "PIN tries limit was reached";
        }

        public static class AccountNumber {
            public static final int code = 10;
            public static final String msg = "Should select account number";
            public static final String status = "Failed";
        }

        public static class ChangePVV {
            public static final int code = 11;
            public static final String msg = "Should change PVV";
        }

        public static class SelectBill {
            public static final int code = 13;
            public static final String msg = "Select Bill";
        }

        public static class PersonalInfoInput {
            public static final int code = 17;
            public static final String msg = "Personal information input error";
        }

        public static class PrepaidCodeNotFound {
            public static final int code = 20;
            public static final String msg = "Prepaid code not found";
        }

        public static class AccountExhausted {
            public static final int code = 21;
            public static final String msg = "Corresponding account exhausted";
        }

        public static class AcquirerLimitExceeded {
            public static final int code = 22;
            public static final String msg = "Acquirer limit exceeded";
        }

        public static class LostCard {
            public static final int code = 40;
            public static final String msg = "Lost card";
        }

        public static class StolenCard {
            public static final int code = 41;
            public static final String msg = "Stolen card";
        }

        public static class IneligibleVendorAccount {
            public static final int code = 49;
            public static final String msg = "Ineligible vendor account";
        }

        public static class UnauthorizedUsage {
            public static final int code = 50;
            public static final String msg = "Unauthorized usage";
        }

        public static class ExpiredCard {
            public static final int code = 51;
            public static final String msg = "Expired card";
        }

        public static class InvalidCard {
            public static final int code = 52;
            public static final String msg = "Invalid card";
        }

        public static class SystemError {
            public static final int code = 54;
            public static final String msg = "System error";
        }

        public static class IneligibleTransaction {
            public static final int code = 55;
            public static final String msg = "ineligible transaction";
        }

        public static class IneligibleAccount {
            public static final int code = 56;
            public static final String msg = "Ineligible account";
        }

        public static class TransactionNotSupported {
            public static final int code = 57;
            public static final String msg = "Transaction not supported";
        }

        public static class RestrictedCard {
            public static final int code = 58;
            public static final String msg = "Restricted Card";
        }

        public static class InsufficientFunds {
            public static final int code = 59;
            public static final String msg = "Insufficient funds";
        }

        public static class UsesLimitExceeded {
            public static final int code = 60;
            public static final String msg = "Uses limit exceeded";
        }

        public static class WithdrawalLimitWouldBeExceeded {
            public static final int code = 61;
            public static final String msg = "Withdrawal limit would be exceeded";
        }

        public static class WithdrawalLimitReached {
            public static final int code = 63;
            public static final String msg = "Withdrawal limit already reached";
        }

        public static class CreditLimit {
            public static final int code = 64;
            public static final String msg = "Credit amount limit";
        }

        public static class NoStatementInfo {
            public static final int code = 65;
            public static final String msg = "No statement information";
        }

        public static class StatementNotAvailable {
            public static final int code = 66;
            public static final String msg = "Statement not available";
        }

        public static class InvalidAmount {
            public static final int code = 67;
            public static final String msg = "Invalid amount";
        }

        public static class ExternalDecline {
            public static final int code = 68;
            public static final String msg = "External decline";
        }

        public static class NoSharing {
            public static final int code = 69;
            public static final String msg = "No sharing";
        }

        public static class ContactCardIssuer {
            public static final int code = 71;
            public static final String msg = "Contact card issuer";
        }

        public static class DestinationNotAvailable {
            public static final int code = 72;
            public static final String msg = "Destination not available";
        }

        public static class RoutingError {
            public static final int code = 73;
            public static final String msg = "Routing error";
        }

        public static class FormatError {
            public static final int code = 74;
            public static final String msg = "Format error";
        }

        public static class ExternalDeclineSpecial {
            public static final int code = 75;
            public static final String msg = "External decline special condition";
        }

        public static class BadCvv {
            public static final int code = 80;
            public static final String msg = "Bad CVV";
        }

        public static class BadCvv2 {
            public static final int code = 81;
            public static final String msg = "Bad CVV2";
        }

        public static class InvalidTransaction {
            public static final int code = 82;
            public static final String msg = "Invalid transaction";
        }

        public static class PinLimitExceeded {
            public static final int code = 83;
            public static final String msg = "PIN tries limit was exceeded";
        }

        public static class BadCavv {
            public static final int code = 84;
            public static final String msg = "Bad CAVV";
        }

        public static class BadArqc {
            public static final int code = 85;
            public static final String msg = "Bad ARQC";
        }

        public static class ServerUp {
            public static final int code = 86;
            public static final String msg = "Server is Up";
        }

        public static class None {
            public static final int code = 87;
            public static final String msg = "None";
        }

        public static class BillerDeclinedTrans {
            public static final int code = 300;
            public static final String msg = "Biller Declined Transaction";
        }

        public static class BillerTimeout {
            public static final int code = 301;
            public static final String msg = "Unresolved Transaction Due to Biller TimeOut";
        }

        public static class BillUnavailable {
            public static final int code = 302;
            public static final String msg = "Biller Destination is Unavailable or Unreachable";
        }

        public static class InvalidInvoice {
            public static final int code = 303;
            public static final String msg = "Payment Declined Invalid Invoice";
        }

        public static class WrongAddData {
            public static final int code = 304;
            public static final String msg = "Payment Declined Wrong Add Data";
        }

        public static class AlreadyPaid {
            public static final int code = 305;
            public static final String msg = "Payment Declined Already Paid";
        }

        public static class InvalidInvoiceAmount {
            public static final int code = 306;
            public static final String msg = "Payment Declined Invalid Invoice Amount";
        }

        public static class InvalidIpinBlock {
            public static final int code = 600;
            public static final String msg = "INVALID_IPIN_BLOCK";
        }

        public static class InvalidUuid {
            public static final int code = 602;
            public static final String msg = "INVALID_UUID";
        }

        public static class InvalidTranDateTime {
            public static final int code = 603;
            public static final String msg = "INVALID_TRAN_DATE_TIME";
        }

//        public static class InvalidTranDateTime {
//            public static final int code = 603;
//            public static final String msg = "INVALID_TRAN_DATE_TIME";
//        }

        public static class InvalidPayeeId {
            public static final int code = 612;
            public static final String msg = "INVALID_PAYEE_ID";
        }


        public static class InvalidPhone {
            public static final int code = 616;
            public static final String msg = "INVALID_PHONE";
        }

        public static class InvalidInvoiceNo {
            public static final int code = 618;
            public static final String msg = "INVALID_INVOICE_NO";
        }

        public static class InvalidAuthenticationType {
            public static final int code = 620;
            public static final String msg = "Invalid Authentication Type";
        }

        public static class InvalidEntityId {
            public static final int code = 624;
            public static final String msg = "Invalid Entity Id";
        }


        public static class InvalidEntityType {
            public static final int code = 625;
            public static final String msg = "Invalid Entity Type";
        }

        public static class IncorrectAmount {
            public static final int code = 628;
            public static final String msg = "INCORRECT_AMOUNT";
        }

        public static class ThisAmountExceedAmountDue {
            public static final int code = 631;
            public static final String msg = "THIS_AMOUNT_EXCEED_AMOUNT_DUE";
        }

        public static class invalidMobileWallet {
            public static final int code = 671;
            public static final String msg = "Wrong Mobile Wallet Number";
        }


        public static class ThisInvoiceAlreadyCanceled {
            public static final int code = 690;
            public static final String msg = "THIS_INVOICE_ALREADY_CANCELED";
        }


        public static class ThisInvoiceAlreadyPaid {
            public static final int code = 691;
            public static final String msg = "THIS_INVOICE_ALREADY_PAID";
        }

        public static class ExpiredInvoice {
            public static final int code = 693;
            public static final String msg = "EXPIRED_INVOICE";
        }


    }
}

