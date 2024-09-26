package baylinux01.webApiDeneme3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import baylinux01.webApiDeneme3.entities.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser,Long>{

	AppUser findByUsername(String username);
	
	

}
