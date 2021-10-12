package pe.com.bcp.jms.colasMQ.logic;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@Slf4j
public class FormulasService {

    public Float disponibilidadInstancia(String estado,  Float horas) {
        log.info("Estado : {}", estado);

        return 100 - ((horas / 24) * 100);
    }

    public Float generateHours(Long millisecondDate, String dateAfter, String statusBefore) throws ParseException {
        Long mill = 0L;

        if(millisecondDate == 0 || statusBefore.equals("STARTED"))
           mill = 0L;

        if(statusBefore.equals("STOPPED"))
            mill = (this.generateMillis(dateAfter) - millisecondDate) < 0 ? 0 : (this.generateMillis(dateAfter) - millisecondDate);

        log.info("Mill : {} ", mill);

        return mill.floatValue()/3600000;
    }

    public Long generateMillis(String date) throws ParseException {
        Date fechaLogs = this.formatDate(date);

        return fechaLogs.getTime();
    }

    public Date formatDate(String date) throws ParseException {
        return new SimpleDateFormat("MM/dd/yy HH:mm:ss").parse(date);
    }

    public Boolean validateDates(Long date1, String date2) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yy");
        Date fecha1 = format.parse(format.format(new Date(date1)));
        Date fecha2 = format.parse(date2.split(" ")[0]);

        return fecha1.compareTo(fecha2) == 0;
    }

}
