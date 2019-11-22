package stud.kea.lbh.goatsite.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stud.kea.lbh.goatsite.model.Gender;
import stud.kea.lbh.goatsite.model.Goat;
import stud.kea.lbh.goatsite.model.Like;

@Repository
public interface GoatRepository extends CrudRepository<Goat, Long> {
//    Iterable<Goat> findByName(String name);
    Goat findByName(String name);

    Iterable<Goat> findByGender(Gender gender);

    @Query(value = "SELECT * FROM goats g WHERE g.id < 4", nativeQuery = true)
    Iterable<Goat> findTheOldTimers();

    int findIdByUsername(String username);

    /*
    //todo lav en create like
    Iterable<Like> createLike(long goatLiked, Long goatLiker);
    */

}
