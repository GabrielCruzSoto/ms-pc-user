package gcruz.photocollection.mspcuser.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;


@Entity
@Table(name="tbl_login")
public class Login implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="USER_ID")
    private Integer userId;

    @Column(name = "USER_NAME")
    private int userName;

    @Column(name = "PWD")
    private String password;

    @Column(name = "IS_ACTIVE")
    private boolean isActive;

    @Column(name="DATE_CREATED")
    private Date DateCreated;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public int getUserName() {
        return userName;
    }

    public void setUserName(int userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Date getDateCreated() {
        return DateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        DateCreated = dateCreated;
    }
}
