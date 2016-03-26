package com.abanppc.gateway

enum Gateway {
	IRANCELL
}

class ServiceNumber {
	String shortCode
	Gateway gateway
	String deliveryNotificationURL
	String notificationURL

    static constraints = {
		shortCode nullable : false, unique : true
		gateway nullable : false
		deliveryNotificationURL nullable : true
		notificationURL nullable : true
    }
}
