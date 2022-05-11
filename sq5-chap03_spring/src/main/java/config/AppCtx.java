package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import spring.ChangePasswordService;
import spring.MemberDao;
import spring.MemberRegisterService;

/**
 * packageName : config
 * fileName : AppCtx
 * author : ds
 * date : 2022-05-11
 * description : 스프링 환경설정 자바 클래스(Assembler에 한 걸 대신 함(조립))
 * 과거에는 환경설정을 xml파일에서 했는데 현재는 자바에서 함
 * 스프링 : 객체를 생성, 소멸시키는 작업을 대행해줌
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-11         ds          최초 생성
 */
// 환경 설정을 위한 어노테이션
@Configuration
@ComponentScan(basePackages = {"spring"})
public class AppCtx {

//    @ComponentScan을 통해 자동으로 @Bean 으로 등록 됨 -> 주석 처리함
//    MemberDao 객체 생성
//    @Bean : 스프링에 컴포넌트 객체로 등록
//    @Bean
//    public MemberDao memberDao(){
//        return new MemberDao();
//    }
    
//    @ComponentScan을 통해 자동으로 @Bean 으로 등록 됨 -> 주석 처리함
//    MemberRegSvc : 멤버 등록 서비스 객체를 생성
//    @Bean : 스프링에 컴포넌트 객체로 등록
//    스프링에 등록 될 이름 : memberRegSvc
//    @Bean
//    public MemberRegisterService memberRegSvc(){
////        매개변수로 memberDao 객체를 전달 : 생성자 DI
//        return new MemberRegisterService(memberDao());
//    }

    //    @ComponentScan을 통해 자동으로 @Bean 으로 등록 됨 -> 주석 처리함
//    스프링에 등록 될 이름 : changePwdSvc
//    @Autowired가 걸려있어서 setter DI(의존성 주입) 코딩을 생략해도 됨
//    스프링이 알아서 setter DI를 해줌
//    @Bean
//    public ChangePasswordService changePwdSvc(){
////        패스워드 변경 서비스 객체 생성
////        ChangePasswordService pwdSvc = new ChangePasswordService();
////        패스워드 변경 서비스 객체의 setter 호출 : 정보가 저장
////        setter DI
////        pwdSvc.setMemberDao(memberDao());
//
//        return new ChangePasswordService();
//    }
}
