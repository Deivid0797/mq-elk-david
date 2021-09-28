package pe.com.bcp.jms.colasMQ.config;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ConfigurationLogStash {

	public void conexion(String mensaje, int puerto) {
		log.info("Entrado: {}", mensaje);
		
		try {
			Socket socket = new Socket("localhost", puerto);
			DataOutputStream os = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
			os.writeBytes(mensaje);
			os.flush();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.print("Error="+e);
			e.printStackTrace();
		}
		
	}
	
	public CamposBean gestionaMsg(String cad) {
		CamposBean bean = new CamposBean();
		int inicio = 427;
		int[] arr = {15, 6, 14, 2, 8};
		String[] campos = {"codEmpresa","codOperacion","fechaHora","canal","numOperacion"};
		
		if(cad.lastIndexOf("<Data>")>-1) {
			int ini = cad.lastIndexOf("<Data>");
			int fin = cad.lastIndexOf("</Data>");
			cad = cad.substring(ini+6, fin);
			
			//temporal
			String tipo = cad.substring(0, 6);
			cad = cad.substring(6, cad.length()-6);
			bean.setCodigoEstado(tipo);
			
			int tmp = 0;
			int totCad=inicio;
			String ncad = "";
			
			tmp = totCad; totCad = totCad+arr[0];
		    ncad = cad.substring(tmp,totCad);
		    bean.setCodEmpresa(ncad.trim());
			
			tmp = totCad; totCad = totCad+arr[1];
		    ncad = cad.substring(tmp,totCad);
		    bean.setTipoOperacion(ncad.trim());
			
			tmp = totCad; totCad = totCad+arr[2];
		    ncad = cad.substring(tmp,totCad);
		    bean.setFechaHora(ncad.trim());
			
			tmp = totCad; totCad = totCad+arr[3];
		    ncad = cad.substring(tmp,totCad);
		    bean.setCanal(ncad.trim());
			
			tmp = totCad; totCad = totCad+arr[4];
		    ncad = cad.substring(tmp,totCad);
		   // System.out.println(tmp+","+totCad+"="+ncad);
			bean.setNumOperacion(ncad.trim());
		}
		
		return bean;
	}
}
