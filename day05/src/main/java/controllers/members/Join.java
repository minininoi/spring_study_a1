package controllers.members;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
public class Join {
    @NotBlank //값이 null인지 또는 null이 아닌지 검사 , Message()를 통해 변경
    @Size(min=6, max=16)
    private String userId;
    @NotBlank
    @Size(min=8)
    private String userPw;
    @NotBlank
    private String userPwRe;
    @NotBlank
    private String userNm;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDt;
    @Email
    private String email;
    @AssertTrue //값이 true인지 또는 false인지 검사
    private boolean agree;

}
