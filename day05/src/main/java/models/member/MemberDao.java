package models.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@Component //JDBC 템플릿 의존
public class MemberDao {
    @Autowired
    private Optional<JdbcTemplate> opt;

    //회원 추가
    public boolean insert(Member member){
        JdbcTemplate jdbcTemplate =opt.get();
        String sql="INSERT INTO MEMBER(USERNO, USERID, USERPW, USERNM, EMAIL) " + " VALUES(SEQ_MEMBER.nextval,?,?,?,?)";

        int cnt = jdbcTemplate.update(sql, member.getUserId(), member.getUserPw(), member.getUserNm(), member.getEmail());
        return cnt > 0;
    }
    //회원조회
    public Member get(String userId) {
        try {
            JdbcTemplate jdbcTemplate = opt.get();
            String sql = "SELECT * FROM MEMBER WHERE USERID = ?";
            Member member = jdbcTemplate.queryForObject(sql, (rs, i) -> {
                Member m = new Member();
                m.setUserNo(String.valueOf(rs.getLong("USERNo")));
                m.setUserId(rs.getString("USERID"));
                m.setUserPw(rs.getString("USERPW"));
                m.setUserNm(rs.getString("USERNM"));
                m.setEmail(rs.getString("EMAIL"));
                m.setRegDt(rs.getTimestamp("REGDT").toLocalDateTime());
                return m;
            }, userId);
                return member;
        } catch (Exception e) {
                 return null;
        }
    }
            public boolean isExists (String userId){
                JdbcTemplate jdbcTemplate = opt.get();
                String sql ="SELECT COUNT(*) FROM MEMBER WHERE USERID = ?";
                int cnt = jdbcTemplate.queryForObject(sql,Integer.class,userId);
                return cnt >0;
            }

}
