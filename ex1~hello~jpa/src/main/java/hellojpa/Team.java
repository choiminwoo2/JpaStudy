package hellojpa;



import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "team_id")
    private Long id;

    @Column
    private String name;

    // 약간의 자원의 소모를 더 하게 되지만
    // 널 포인트 이셉션 등을 방지할 수 있으므로
    // 하이버네이트에서 인스턴스를 선언하고 사용하는 것을 권장한다!.
    @OneToMany(mappedBy = "team")
    private List<Member> members = new ArrayList<>();


}
