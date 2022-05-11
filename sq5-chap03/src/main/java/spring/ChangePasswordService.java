package spring;

// XXXService : 패스워드를 변경하는 서비스
// Service : 비지니스(업무) 로직을 처리하는 클래스
// Dao + Model(Member, RegisterMember 클래스) 활용해서 업무로직을 짬(코딩)
public class ChangePasswordService {
//    Dao 맴버 변수로 등록 : CRUD를 위해서
    private MemberDao memberDao;

//    changePassword 메소드 : 패스워드를 변경하는 서비스
    public void changePassword(String email, String oldPwd, String newPwd) {
//        selectByEmail 메소드 : 이메일로 회원정보를 검색
//        회원정보가 있으면 member 값이 null이 아님
//        회원정보가 없으면 member 값이 null 임
        Member member = memberDao.selectByEmail(email);
//        member가 null이면 회원정보가 없는것임
//        그러므로 패스워드를 변경 할 수 없으므로 에러를 발생시키고 메소드를 빠져나옴
        if(member == null) {
            throw new MemberNotFoundException();
        }

//        에러가 없으면(member가 null이 아니면) 회원정보가 있으므로
//        패스워드 변경 서비스 실행
        member.changePassword(oldPwd, newPwd);

        memberDao.update(member);
    }

    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

}
