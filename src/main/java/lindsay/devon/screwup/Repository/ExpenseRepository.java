package lindsay.devon.screwup.Repository;

import lindsay.devon.screwup.domain.Expense;
import lindsay.devon.screwup.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by devon on 11/3/16.
 */
@Repository
public interface ExpenseRepository extends JpaRepository<Expense,Long>{

    Expense findByName(@Param("name") String name);
    List<Expense> findByUser(@Param("user") User user);
}
