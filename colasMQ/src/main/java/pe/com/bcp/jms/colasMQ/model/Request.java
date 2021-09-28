package pe.com.bcp.jms.colasMQ.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Request<T> {
    private T message;
    private String identifier;

    @Override
    public String toString() {
        return "{\"message\": \"" + message + "\", \"identifier\":\"" + identifier + "\"}";
    }
}
