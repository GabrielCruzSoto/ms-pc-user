package gcruz.photocollection.mspcuser.repository;

import gcruz.photocollection.mspcuser.model.AlbumAccess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAlbumAccess extends JpaRepository<AlbumAccess,Integer> {
}
