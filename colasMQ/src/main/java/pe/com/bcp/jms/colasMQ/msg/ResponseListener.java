package pe.com.bcp.jms.colasMQ.msg;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import pe.com.bcp.jms.colasMQ.config.CamposBean;
import pe.com.bcp.jms.colasMQ.config.ConfigurationLogStash;


import org.springframework.boot.jackson.JsonObjectSerializer;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonEncoding;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import pe.com.bcp.jms.colasMQ.model.Request;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

@Slf4j
@Component
public class ResponseListener {

    @Autowired
    private JmsTemplate jmsTemplate;

    @JmsListener(destination = "JMS.RESPONSE.ALIAS")
    public void receiveSendResponse(Message message) throws JMSException {
    	/*ConfigurationLogStash envio = new ConfigurationLogStash();
        TextMessage textMessage = (TextMessage) message;
        
        String msg = textMessage.getText();
        
		GsonBuilder builder = new GsonBuilder();
		 Gson gson = builder.create();
		CamposBean bean = envio.gestionaMsg(msg);
		
        envio.conexion(gson.toJson(bean),10000);*/
        //log.info("Mensaje recibido---- : {} , ID: {}",
        //        textMessage.getText(), textMessage.getJMSCorrelationID());

        log.info("Recibiendo mensaje COLA RESPONSE ALIAS : {}", message );
    }

    @JmsListener(destination = "JMS.REQUEST.ALIAS")
    public void receive(Message message) throws JMSException {
        /*TextMessage textMessage = (TextMessage) message;
        String msg = textMessage.getText();
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        Request request = gson.fromJson(msg, Request.class);

        log.info("Enviando a la cola RESPONSE... ");

        jmsTemplate.convertAndSend("JMS.RESPONSE", request.getMessage(), textMessage2 -> {
            textMessage2.setJMSCorrelationID(request.getIdentifier());
            return textMessage2;
        });*/
        log.info("Recibiendo mensaje COLA REQUEST ALIAS : {}", message);
    }
    
}
