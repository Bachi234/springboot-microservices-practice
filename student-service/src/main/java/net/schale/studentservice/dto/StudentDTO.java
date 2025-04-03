package net.schale.studentservice.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data@NoArgsConstructor@AllArgsConstructor
public class StudentDTO {
    private Long id;
    private String studFName;
    private String studLName;
    private String studDescription;
    private String studEmail;
    private String studCode;
}
