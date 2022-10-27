package gcruz.photocollection.mspcuser.repository;

import gcruz.photocollection.mspcuser.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ILoginRepository extends JpaRepository<Login,Integer> {

    @Query("SELECT u FROM Login u WHERE u.userName = ?1")
    Optional<Login> findLoginByUserId(Integer userId);
}
