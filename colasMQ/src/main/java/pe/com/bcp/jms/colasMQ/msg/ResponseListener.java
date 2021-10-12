package pe.com.bcp.jms.colasMQ.msg;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import pe.com.bcp.jms.colasMQ.config.CamposBean;
import pe.com.bcp.jms.colasMQ.config.ConfigurationLogStash;


import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;
import java.text.ParseException;
import java.util.Random;

@Slf4j
@Component
public class ResponseListener {

    @Autowired
    private JmsTemplate jmsTemplate;

    @JmsListener(destination = "JMS.RESPONSE")
    public void receiveSendResponse(Message message) throws JMSException, ParseException {
    	ConfigurationLogStash envio = new ConfigurationLogStash();
        TextMessage textMessage = (TextMessage) message;
        
        String msg = textMessage.getText();

        String codEstado[] = {"CP0133", "CP0135", "CP0095", "CP0138", "CP0037", "CP0004", "CP0053", "CP0103",
                              "CP0080", "CP0000", "CP0010", "CP0006", "CP0141", "CP0140", "CP0142", "CP0139",
                              "CP0000", "CP0000", "CP0000", "CP0000", "CP0000", "CP0000", "CP0000", "CP0000",
                              "CP0000", "CP0000", "CP0000", "CP0000"};
        Random random = new Random();
        Integer posRandom = random.nextInt(codEstado.length);
        String nuevaCadena = insertString(msg, codEstado[posRandom], 18);
        
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		CamposBean bean = envio.gestionaMsg(nuevaCadena, "RESPONSE");
		
        envio.conexion(gson.toJson(bean),10000, "RESPONSE");
    }

    @JmsListener(destination = "JMS.REQUEST")
    public void receive(Message message) throws JMSException, ParseException {
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

        ConfigurationLogStash envio = new ConfigurationLogStash();
        TextMessage textMessage = (TextMessage) message;

        String msg = textMessage.getText();

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        CamposBean bean = envio.gestionaMsg(msg, "REQUEST");

        envio.conexion(gson.toJson(bean),10000, "REQUEST");

    }

    public String insertString(String originalString, String stringToBeInserted, int index)
    {
        String newString = "";

        for (int i = 0; i < originalString.length(); i++) {
            newString += originalString.charAt(i);

            if (i == index)
                newString += stringToBeInserted;

        }

        return newString;
    }

}
