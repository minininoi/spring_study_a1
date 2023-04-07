package models.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
@Transactional
public class MemberDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * 회원 정보 추가
     *
     * @param member
     */

    public long insert(Member member){
        String sql ="INSERT INTO MEMBER(userNo, userId, userPw, userNm) " +
                "VALUES (SEQ_MEMBER.nextval, ? ,? ,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        int cnt = jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement pstmt = con.prepareStatement(sql, new String[]{"userNo"}); //증감 번호 keyholder로 가져온다
                pstmt.setString(1, member.getUserId());
                pstmt.setString(2, member.getUserPw());
                pstmt.setString(3, member.getUserNm());
                return pstmt;
                }

        },keyHolder);
        Number keyValue = keyHolder.getKey(); //증감 번호 - long, int 일 수 있어 Integer의 상위 클래스 Number가져온다
        long userNo =keyValue.longValue();
        return userNo;

    }
    /*
    public boolean insert(Member member) {
        String sql = "INSERT INTO MEMBER (userNo, userId, userPw,userNm) " +
                " VALUES (SEQ_MEMBER.nextval, ?, ?, ?)";

        int cnt = jdbcTemplate.update(sql, member.getUserId(), member.getUserPw(), member.getUserNm());
        // cnt - 반영된 레코드 갯수 -> 0개 이상 -> 성공

        return cnt > 0;
    }*/

    /**
     * 회원정보를 아이디로 조회
     * @param userId
     * @return
     */
    public Member get(String userId) {
        try {
            String sql = "SELECT * FROM MEMBER WHERE userId = ?";
            Member member = jdbcTemplate.queryForObject(sql, this::memberMapper);
            return member;
        }catch (Exception e){
            return  null;
        }
    }

    /**
     * 회원 목록 조회
     * @return
     */
    public List<Member> get(){
        String sql ="SELECT * FROM MEMBER";
        List<Member> members = jdbcTemplate.query(sql,this::memberMapper);

        return members;
    }
    private  Member memberMapper(ResultSet rs, int i) throws SQLException{

        Member member = new Member();
        member.setUserNo(rs.getLong("USERNO"));
        member.setUserId(rs.getString("USERID"));
        member.setUserPw(rs.getString("USERPW"));
        member.setUserNm(rs.getString("USETNM"));
        member.setRegDt(rs.getTimestamp("regDt").toLocalDateTime());
        return member;
    }


    public boolean delete(String userId) {
        String sql ="DELETE FROM MEMBER WHERE userId = ?";
        int cnt =jdbcTemplate.update(sql,userId);

        return cnt > 0;
    }

    /**
     * 전체 회원수
     * @return
     */

    public long getTotal(){
        long total =jdbcTemplate.queryForObject("SELECT COUNT(*) FROM MRMBER" ,Long.class );
        return total;
    }
}
