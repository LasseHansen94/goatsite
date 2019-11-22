package stud.kea.lbh.goatsite.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stud.kea.lbh.goatsite.model.Gender;
import stud.kea.lbh.goatsite.model.Goat;

import java.util.Date;


@Repository
public interface GoatRepository extends CrudRepository<Goat, Long> {
//    Iterable<Goat> findByName(String name);
    Goat findByName(String name);

    Iterable<Goat> findByGender(Gender gender);

    @Query(value = "SELECT * FROM Goats g WHERE g.id < 4", nativeQuery = true)
    Iterable<Goat> findTheOldTimers();

    //Virker ikke endnu
    @Query(value = "UPDATE goats SET dob = ?, long_description = ?, name = ?, short_description = ?, address = ?, city = ?, postnumber = ?" +
            "WHERE id = ?", nativeQuery = true)

    Iterable<Goat> updateGoatProfile(Date dob, String long_description, String name, String short_description, String address, String city, Long postnumber);


    Goat findGoatByUsername(String username);



    /*
    //todo lav en create like
    Iterable<Like> createLike(long goatLiked, Long goatLiker);
    */
}
