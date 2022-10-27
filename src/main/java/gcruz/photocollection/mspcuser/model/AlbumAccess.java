package gcruz.photocollection.mspcuser.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="tbl_album_access")
public class AlbumAccess {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column()
    private Integer idAlbum;

    @Column()
    private Integer idUserAccess;

    @JoinTable(
            name = "tbl_album_user_permissions",
            joinColumns = {@JoinColumn(name = "fk_id_album_access")},
            inverseJoinColumns = {@JoinColumn(name = "fk_id_permission")}
    )
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Permission> permissions;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(Integer idAlbum) {
        this.idAlbum = idAlbum;
    }

    public Integer getIdUserAccess() {
        return idUserAccess;
    }

    public void setIdUserAccess(Integer idUserAccess) {
        this.idUserAccess = idUserAccess;
    }

    public List<Permission> getListPermissions() {
        return permissions;
    }

    public void setListPermissions(List<Permission> listPermissions) {
        this.permissions = listPermissions;
    }
}
