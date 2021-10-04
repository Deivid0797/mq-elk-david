package pe.com.bcp.jms.colasMQ.rest;

import com.ibm.mq.jms.MQQueue;

import lombok.extern.slf4j.Slf4j;
import pe.com.bcp.jms.colasMQ.model.Request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

import javax.jms.JMSException;
import javax.jms.TextMessage;
import java.nio.charset.StandardCharsets;

@Slf4j
@RequestMapping("/jms/mq")
@RestController
public class JMSController {

    @Autowired
    private JmsTemplate jmsTemplate;

    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody Request req) throws JMSException {
        //log.info("Mensaje '{}' enviado", req.getMessage());

       // MQQueue orderRequestQueue = new MQQueue("JMS.REQUEST");
        /*MQQueue orderRequestQueue = new MQQueue("JMS.RESPONSE.ALIAS");

        jmsTemplate.convertAndSend(orderRequestQueue, req.getMessage(), textMessage -> {
            textMessage.setJMSCorrelationID(req.getIdentifier());
            return textMessage;
        });

        return new ResponseEntity(req, HttpStatus.ACCEPTED);*/

        log.info("Enviando mensaje ... ");

        MQQueue orderRequestQueue = new MQQueue("JMS.REQUEST");
        jmsTemplate.convertAndSend(orderRequestQueue, req.toString());

        MQQueue orderRequestQueue2 = new MQQueue("JMS.RESPONSE");
        jmsTemplate.convertAndSend(orderRequestQueue2, req.toString());

        return new ResponseEntity(req, HttpStatus.ACCEPTED);
    }


    @Deprecated // Se usa para recoger mensaje con un identificador
    @GetMapping
    public ResponseEntity<Request> findOrderByCorrelationId(@RequestParam String correlationId) throws JMSException {
    	log.info("Identificador= '{}'", correlationId);
        String convertedId = bytesToHex(correlationId.getBytes());
        
        Request response = null;
        try {
	        final String mensajeUbicado = String.format("JMSCorrelationID='ID:%s'", convertedId);
	        jmsTemplate.setReceiveTimeout(2000);
	        final TextMessage jmsRespuesta = (TextMessage) jmsTemplate.receiveSelected("JMS.REQUEST", mensajeUbicado);
	         response = Request.builder()
	                .message(jmsRespuesta.getText())
	                .identifier(correlationId)
	                .build();
	         return new ResponseEntity(response, HttpStatus.OK);
        }catch(Exception e) {
        	response.setIdentifier("0");
        	response.setMessage(e.getCause());
        	return new ResponseEntity(response, HttpStatus.EXPECTATION_FAILED);
        }
        
        
    }

    // Libreria para formato de mensaje
    private static final byte[] HEX_ARRAY = "0123456789ABCDEF".getBytes();
    public static String bytesToHex(byte[] bytes) {
        byte[] hexChars = new byte[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = HEX_ARRAY[v >>> 4];
            hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
        }
        return new String(hexChars, StandardCharsets.UTF_8);
    }
}
