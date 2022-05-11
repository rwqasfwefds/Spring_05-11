package assember;

import spring.ChangePasswordService;
import spring.MemberDao;
import spring.MemberRegisterService;

/**
 * packageName : assember
 * fileName : Assembler
 * author : ds
 * date : 2022-05-11
 * description : 정의 된 클래스를 생성해서 조립하는 클래스
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-11         ds          최초 생성
 */
public class Assembler {
//    객체 생성을 위한 멤버 변수 정의
    private MemberDao memberDao; // CRUD dao 클래스
    private MemberRegisterService reqSvc; // 회원등록 service 클래스
    private ChangePasswordService pwdSvc; // 패스워드 변경 service 클래스

//    기본 생성자
//    다른 클래스들을 모두 생성 함
    public Assembler() {
//        외부에서 memberDao 객체를 생성
//        예) MemberDao 얘가 성능이 너무 떨어져서 MemberDao 얘를 상속받는 MemberCachedDao 이 클래스를 만들었음 
//        MemberCachedDao() : MemberDao 자식 클래스
//        그래서 DI형태가 왜 좋냐면 여기서 어떻게 수정만 하면 되냐면
//        memberDao = new MemberCachedDao(); 이렇게만 수정하면 됨 개 씹 간단 원래는 여러군대 수정을 했어야 했잖슴
//        아래가 매개변수가 있는 메소드 형태가 아니라면
//        각각의 클래스 소스를 열어서 MemberDao() -> MemberCachedDao() 이렇게 모든 걸 다 수정해야됨
        memberDao = new MemberDao();
//        매개변수가 있는 생성자(다른 클래스 객체를 전달) : 생성자 DI
        reqSvc = new MemberRegisterService(memberDao);
//        매개변수가 있는 setter(다른 클래스 객체를 전달) : setter DI
        pwdSvc = new ChangePasswordService();
        pwdSvc.setMemberDao(memberDao); // setter DI
    }

    public MemberDao getMemberDao() {
        return memberDao;
    }

    public MemberRegisterService getMemberRegisterService() {
        return reqSvc;
    }

    public ChangePasswordService getChangePasswordService() {
        return pwdSvc;
    }
}
