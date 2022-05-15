package isi.tn.repository;



import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import isi.tn.entities.User;

@Repository
public interface userRepository extends JpaRepository<User,Long> {
	Optional <User> findByLogin(String login);
	Boolean existsByLogin(String login);

	Boolean existsByPwd(String pwd);
}



