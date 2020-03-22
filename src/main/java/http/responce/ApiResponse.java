package http.responce;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse {
    private ApiStatus status;
    private String message;
    private Object payload;

    private ApiResponse() {
    }

    public static ApiResponse success(@NonNull ApiStatus status) {
        ApiResponse response = new ApiResponse();
        response.status = status;

        return response;
    }

    public ApiResponse message(String message, String... params) {
        this.message = String.format(message, params);

        return this;
    }

    public ApiResponse payload(Object payload) {
        this.payload = payload;

        return this;
    }

    @Getter
    @AllArgsConstructor
    public enum ApiStatus {
        S2000("Success"),
        E4001("Unauthorized"),
        E4003("Forbidden"),
        E4004("Resource not found"),
        E4009("Conflict"),
        E5000("Internal API Error");

        private final String message;
    }
}

