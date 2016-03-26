
/**
 * PolicyException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package com.huawei.sdp.sms.soap.client;

public class PolicyException extends java.lang.Exception{

    private static final long serialVersionUID = 1447829980059L;
    
    private com.huawei.sdp.sms.soap.client.SendSmsServiceStub.PolicyExceptionE faultMessage;

    
        public PolicyException() {
            super("PolicyException");
        }

        public PolicyException(java.lang.String s) {
           super(s);
        }

        public PolicyException(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public PolicyException(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(com.huawei.sdp.sms.soap.client.SendSmsServiceStub.PolicyExceptionE msg){
       faultMessage = msg;
    }
    
    public com.huawei.sdp.sms.soap.client.SendSmsServiceStub.PolicyExceptionE getFaultMessage(){
       return faultMessage;
    }
}
    