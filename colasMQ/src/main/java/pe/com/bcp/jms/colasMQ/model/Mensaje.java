package pe.com.bcp.jms.colasMQ.model;

import java.util.Date;

public class Mensaje<T> {
	private String nombreInstancia;
	private T datoLogs;
	private String horaEjecucionLogs;
	private String codRevisionEstado;
	private String resErrorRevEstado;
	private String estadoInstancia;
	private String reinicio;
	private String horaReinicio;
	private String estadoFinal;
	private String resultadoReinicio;
	private Float disponibilidadInstancia;

	public String getNombreInstancia() {
		return nombreInstancia;
	}
	public void setNombreInstancia(String nombreInstancia) {
		this.nombreInstancia = nombreInstancia;
	}
	
	public T getDatoLogs() {
		return datoLogs;
	}
	public void setDatoLogs(T datoLogs) {
		this.datoLogs = datoLogs;
	}
	public String getHoraEjecucionLogs() {
		return horaEjecucionLogs;
	}
	public void setHoraEjecucionLogs(String horaEjecucionLogs) {
		this.horaEjecucionLogs = horaEjecucionLogs;
	}
	public String getCodRevisionEstado() {
		return codRevisionEstado;
	}
	public void setCodRevisionEstado(String codRevisionEstado) {
		this.codRevisionEstado = codRevisionEstado;
	}
	public String getResErrorRevEstado() {
		return resErrorRevEstado;
	}
	public void setResErrorRevEstado(String resErrorRevEstado) {
		this.resErrorRevEstado = resErrorRevEstado;
	}
	public String getEstadoInstancia() {
		return estadoInstancia;
	}
	public void setEstadoInstancia(String estadoInstancia) {
		this.estadoInstancia = estadoInstancia;
	}
	public String getReinicio() {
		return reinicio;
	}
	public void setReinicio(String reinicio) {
		this.reinicio = reinicio;
	}
	public String getHoraReinicio() {
		return horaReinicio;
	}
	public void setHoraReinicio(String horaReinicio) {
		this.horaReinicio = horaReinicio;
	}
	public String getEstadoFinal() {
		return estadoFinal;
	}
	public void setEstadoFinal(String estadoFinal) {
		this.estadoFinal = estadoFinal;
	}
	public String getResultadoReinicio() {
		return resultadoReinicio;
	}
	public void setResultadoReinicio(String resultadoReinicio) {
		this.resultadoReinicio = resultadoReinicio;
	}

	public Float getDisponibilidadInstancia() {
		return disponibilidadInstancia;
	}

	public void setDisponibilidadInstancia(Float disponibilidadInstancia) {
		this.disponibilidadInstancia = disponibilidadInstancia;
	}
}
