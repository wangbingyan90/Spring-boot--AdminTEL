package wby.SpeingBoot.bean.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import wby.SpeingBoot.bean.Admin;

public interface AdminDao extends JpaRepository<Admin, Integer> {
    Admin findByNameAndAndPassow(String name,String passow);

}
