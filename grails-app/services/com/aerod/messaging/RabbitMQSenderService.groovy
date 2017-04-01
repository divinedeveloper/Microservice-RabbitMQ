package com.aerod.messaging



class RabbitMQSenderService {
	
	private static final String SOCIAL_USER_QUEUE = "socialUserQueue"
	private static final String EXCHANGE_NAME = "user.created"
	

    boolean sendMessageToQueue(jsonBody) {
		rabbitSend(EXCHANGE_NAME, null, jsonBody.data.toString())
		return true
    }
}
