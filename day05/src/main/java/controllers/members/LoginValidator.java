package controllers.members;

import models.member.Member;
import models.member.MemberDao;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class LoginValidator implements Validator {
    @Autowired
    private MemberDao memberDao;
    @Override
    public boolean supports(Class<?> clazz) {
        return Login.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Login login = (Login)target;
        String userId =login.getUserId();
        String userPw = login.getUserPw();

        //1.실제 아이디로 회원이 조회 되는지
        Member member = null;
        if(userId != null && !userId.isBlank()){
            member= memberDao.get(userId);
            if(member==null){
                errors.rejectValue("userId","MemberNotExists","등록되지 않은 회원입니다" );
            }
        }

        //2. 회원이 있다면 -> 비밀번호 검증
        if(member != null && userPw !=null &&!userPw.isBlank()){
            String hash= member.getUserPw();
            boolean isMatched= BCrypt.checkpw(userPw,hash);

            if(!isMatched){
                errors.rejectValue("userPw", "incorrect", "비밀번호가 일치하지 않습니다");
            }
        }
    }
}
