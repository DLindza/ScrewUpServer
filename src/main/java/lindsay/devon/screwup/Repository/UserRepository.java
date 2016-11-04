package lindsay.devon.screwup.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import lindsay.devon.screwup.domain.User;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

/**
 * Created by devon on 11/2/16.
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long>{

     User findByUsername(@Param("username") String username);


}
