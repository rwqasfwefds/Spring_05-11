package spring;

import java.time.LocalDateTime;

// Dao + Service => 웹 개발을 할 때 설계를 위한 이름 약속임(Naming Rule)(접미어에 ...Dao 또는 ...Service 같은것들)
// XXXService 역할 : 비지니스(업무) 로직이 작성되어 있는 클래스
// XXXDao 활용 + Model( Member, RegisterMember 클래스 )(안에 getter/setter만 있는 놈들을 모델이라고 함) 활용 => 업무로직을 짦(코딩)
public class MemberRegisterService {
//    Dao 맴버변수로 등록 : CRUD를 하기 위해서
    private MemberDao memberDao;

//    생성자 : Dao 객체를 생성(외부에서 매개변수를 통해 생성 : DI(의존성 주입))
//    다형성을 이용할려고 DI를 씀
    public MemberRegisterService(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

//    regist 메소드 : 뉴비 회원 등록 서비스
    public Long regist(RegisterRequest req) {
//        이메일(키값)을 가지고 검색하는 메소드를 호출
//        반환값 : Member 객체가 반환
//        selectByEmail <- 얘 반환값이 Member로 되어있음 Member객체 전체를 가져오는거임
        Member member = memberDao.selectByEmail(req.getEmail());

//        기존에 회원이 있으면 : member 값이 null이 아님
        if(member !=null) {
//            에러를 발생시킴
            throw new DuplicateMemberException("dup email" + req.getEmail());
        }

//        member값이 null이면 회원이 없다는 것임
//        Member 생성자를 호출해서 객체를 생성 : 회원 등록을 위한 객체 생성
        Member newMember = new Member(
                req.getEmail(),req.getPassword(), req.getName(), LocalDateTime.now()
        );

//        회원 등록 메소드를 호출
        memberDao.insert(newMember);
        return newMember.getId();
    }
}
