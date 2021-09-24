package pe.com.bcp.jms.colasMQ.config;

public class CamposBean {
	
	private String codigoEstado;
	private String codEmpresa;
	private String tipoOperacion;
	private String fechaHora;
	private String canal;
	private String numOperacion;
	public String getCodEmpresa() {
		return codEmpresa;
	}
	public void setCodEmpresa(String codEmpresa) {
		this.codEmpresa = codEmpresa;
	}
	public String getFechaHora() {
		return fechaHora;
	}
	public void setFechaHora(String fechaHora) {
		this.fechaHora = fechaHora;
	}
	public String getCanal() {
		return canal;
	}
	public void setCanal(String canal) {
		this.canal = canal;
	}
	public String getNumOperacion() {
		return numOperacion;
	}
	public void setNumOperacion(String numOperacion) {
		this.numOperacion = numOperacion;
	}

	public String getCodigoEstado() {
		return codigoEstado;
	}

	public void setCodigoEstado(String codigoEstado) {
		this.codigoEstado = codigoEstado;
	}

	public String getTipoOperacion() {
		return tipoOperacion;
	}

	public void setTipoOperacion(String tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}
	

}
