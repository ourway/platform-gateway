
/**
 * ServiceException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package com.huawei.sdp.sms.soap.client;

public class ServiceException extends java.lang.Exception{

    private static final long serialVersionUID = 1447829980075L;
    
    private com.huawei.sdp.sms.soap.client.SendSmsServiceStub.ServiceExceptionE faultMessage;

    
        public ServiceException() {
            super("ServiceException");
        }

        public ServiceException(java.lang.String s) {
           super(s);
        }

        public ServiceException(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public ServiceException(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(com.huawei.sdp.sms.soap.client.SendSmsServiceStub.ServiceExceptionE msg){
       faultMessage = msg;
    }
    
    public com.huawei.sdp.sms.soap.client.SendSmsServiceStub.ServiceExceptionE getFaultMessage(){
       return faultMessage;
    }
}
    