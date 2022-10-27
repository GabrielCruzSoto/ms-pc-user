package gcruz.photocollection.mspcuser.repository;

import gcruz.photocollection.mspcuser.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPermissionRepository extends JpaRepository<Permission,Integer> {
}
