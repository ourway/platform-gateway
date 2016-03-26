package com.huawei.sdp.sms.soap.client;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axis2.AxisFault;
import org.apache.axis2.databinding.ADBException;
import org.apache.axis2.databinding.types.URI;
import org.apache.axis2.databinding.types.URI.MalformedURIException;
import cn.com.huawei.www.schema.common.v2_1.RequestSOAPHeader;
import cn.com.huawei.www.schema.common.v2_1.RequestSOAPHeaderE;
import com.huawei.sdp.sms.soap.client.SendSmsServiceStub.ChargingInformation;
import com.huawei.sdp.sms.soap.client.SendSmsServiceStub.SendSms;
import com.huawei.sdp.sms.soap.client.SendSmsServiceStub.SendSmsE;
import com.huawei.sdp.sms.soap.client.SendSmsServiceStub.SendSmsResponseE;
import com.huawei.sdp.sms.soap.client.SendSmsServiceStub.SimpleReference;

public class SoapSendSmsClient {

	public static RequestSOAPHeaderE createHeader()
	{
	RequestSOAPHeaderE requestHeaderE = new RequestSOAPHeaderE();
	RequestSOAPHeader requestHeader = new RequestSOAPHeader();
	String spId = "897899789";
	String serviceId = "";
	String spPassword = "123456";
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
	String created = sdf.format(Calendar.getInstance().getTime());
	String password = Security.md5(spId + spPassword + created);
	requestHeader.setSpId(spId);
	requestHeader.setSpPassword(password);
	requestHeader.setServiceId(serviceId);
	requestHeader.setTimeStamp(created);
	requestHeader.setLinkid("");
	requestHeader.setOA("8613300000010");
	requestHeader.setFA("8613300000010");
	requestHeaderE.setRequestSOAPHeader(requestHeader);
	return requestHeaderE;
	}
	public static SendSmsE createBody()
	{
	try
	{
	URI address = new URI("tel:86122333");
	URI endpoint = new URI("http://10.133.177.148:8310/SendSmsService/services/SendSms");
	ChargingInformation charging = new ChargingInformation();
	charging.setAmount(new BigDecimal(1));
	charging.setCode("111");
	charging.setCurrency("RMB");
	charging.setDescription("description");
	SimpleReference sim = new SimpleReference();
	sim.setCorrelator("123");
	sim.setEndpoint(endpoint);
	sim.setInterfaceName("SmsNotification");
	SendSms param = new SendSms();
	param.addAddresses(address);
	param.setCharging(charging);
	param.setData_coding(0);
	param.setDestinationport(0);
	//param.setEncode("utf-8");
	param.setEsm_class(1);
	param.setMessage("send a message!");
	param.setReceiptRequest(sim);
	param.setSenderName("1111");
	param.setSourceport(123);
	SendSmsE sendSms = new SendSmsE();
	sendSms.setSendSms(param);
	return sendSms;
	}
	catch (MalformedURIException e)
	{
	return null;
	}
	}
	public static void sendSms(RequestSOAPHeaderE header, SendSmsE body)
	{
	try
	{
	SendSmsServiceStub stub = new
	SendSmsServiceStub("http://10.133.177.148:8310/SendSmsService/services/SendSms");
	stub._getServiceClient().addHeader(header.getOMElement(RequestSOAPHeaderE.MY_QNAME,
	OMAbstractFactory.getSOAP11Factory()));
	SendSmsResponseE response = stub.sendSms(body);
	System.out.println(response.getOMElement(SendSmsResponseE.MY_QNAME,
			OMAbstractFactory.getSOAP11Factory()));
			}
			catch (AxisFault e)
			{
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
			catch (RemoteException e)
			{
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
			catch (PolicyException e)
			{
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
			catch (ServiceException e)
			{
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
			catch (ADBException e)
			{
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
			}
	public static void main(String[] args)
	{
	sendSms(createHeader(), createBody());
	}
}
