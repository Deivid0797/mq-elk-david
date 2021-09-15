package pe.com.bcp.jms.colasMQ.msg;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

@Slf4j
@Component
public class ResponseListener {

    @JmsListener(destination = "JMS.RESPONSE")
    public void receive(Message message) throws JMSException {
        TextMessage textMessage = (TextMessage) message;
        log.info("Mensaje recibido : {} , ID: {}",
                textMessage.getText(), textMessage.getJMSCorrelationID());

        
    }
}
