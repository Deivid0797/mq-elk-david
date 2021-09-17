package pe.com.bcp.jms.colasMQ.rest;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;
import pe.com.bcp.jms.colasMQ.config.ConfigurationLogStash;
import pe.com.bcp.jms.colasMQ.model.InMensaje;
import pe.com.bcp.jms.colasMQ.model.Mensaje;
import pe.com.bcp.jms.colasMQ.model.TransportMensaje;


@Slf4j
@RequestMapping("/was/status")
@RestController
public class WASController {
	
	@PostMapping
    public ResponseEntity<String> createOrder(@RequestBody InMensaje req) throws Exception {
        //log.info("Mensaje '{}' enviado", req.getMessage());
		TransportMensaje respuesta = new TransportMensaje();
		Mensaje msg = new Mensaje();
		
			String[] arr1 = req.getMessage().split(",");
				
				for(int i= 0; i<arr1.length; i++) {
					switch (i) {
					case 0:
						msg.setNombreInstancia(arr1[i]);
						break;
					case 1:
						String[] arr2 = arr1[1].split("\\+");
						msg.setDatoLogs(arr2);
						break;
					case 2:
						msg.setHoraEjecucionLogs(arr1[i]);
						break;
					case 3:
						msg.setCodRevisionEstado(arr1[i]);
						break;
					case 4:
						msg.setResErrorRevEstado(arr1[i]);
						break;
					case 5:
						msg.setEstadoInstancia(arr1[i]);
						break;
					case 6:
						msg.setReinicio(arr1[i]);
						break;
					case 7:
						msg.setHoraReinicio(arr1[i]);
						break;
					case 8:
						msg.setEstadoFinal(arr1[i]);
						break;
					case 9:
						msg.setReinicio(arr1[i]);
						break;
					default: 
						break;
					}
					
				}

				respuesta.setIdentifier(req.getIdentifier());
				respuesta.setMessage(msg);
				
				Gson g = new Gson();
				//System.out.println(g.toJson(respuesta));
				
				//Envia a Kibana
				ConfigurationLogStash envio = new ConfigurationLogStash();
				envio.conexion(g.toJson(msg),10001);
				
				//envio.conexion(g.toJson(respuesta));
       

        return new ResponseEntity(respuesta, HttpStatus.ACCEPTED);
    }

}
