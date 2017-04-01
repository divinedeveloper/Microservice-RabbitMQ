package aerod.backend.messaging



class RabbitMQSenderService {

    def Boolean serviceMethod(jsonBody) {
		rabbitSend('queueSocial', jsonBody.data.toString())
		return true
    }
}
