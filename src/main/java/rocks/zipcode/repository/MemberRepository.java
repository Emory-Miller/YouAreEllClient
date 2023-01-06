package rocks.zipcode.repository;

import java.util.List;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import rocks.zipcode.domain.Member;

/**
 * Spring Data JPA repository for the Member entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    @Query("select member from Member member where member.user.login = ?#{principal.username}")
    List<Member> findByUserIsCurrentUser();
}
