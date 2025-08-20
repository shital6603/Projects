package email_wwrite_app;


import lombok.Data;

@Data
public class EmailRequest {
    private String emailContent;
    private String tone;
}
