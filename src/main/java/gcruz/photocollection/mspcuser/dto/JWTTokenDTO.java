package gcruz.photocollection.mspcuser.dto;


import java.io.Serializable;

public class JWTTokenDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    public JWTTokenDTO(
            Integer statusCode,
            String token
    ){
        this.statusCode= statusCode;
        this.token=token;
    }

    private Integer statusCode;
    private String token;

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
