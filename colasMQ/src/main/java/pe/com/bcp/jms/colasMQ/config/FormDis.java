package pe.com.bcp.jms.colasMQ.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class FormDis
{
    public Long fechaPrimera;
    public Float horas;
    public Double disponibilidad;
    public String status;

    public FormDis() {
        this.horas = 0f;
        this.disponibilidad = 0d;
        this.fechaPrimera = 0L;
        this.status= "STARTED";
    }
}
