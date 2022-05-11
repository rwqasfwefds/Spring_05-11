/**
 * packageName : PACKAGE_NAME
 * fileName : A2
 * author : ds
 * date : 2022-05-11
 * description : DI(의존성 주입)를 써서 코딩하는 클래스
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-11         ds          최초 생성
 */
public class A2 {
//    B 객체 멤버 변수로 등록
    B b;

//    DI : 생성자의 매개변수로 B라는 객체를 전달하는 형태
    public A2(B b){
//        DI 핵심 : B 클래스 기능이 변경이 되면 아래 코딩은 고칠 필요가 없음
        this.b = b; // DI 사용한 코딩
    }
}
