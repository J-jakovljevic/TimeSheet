package com.timeSheet.TimeSheet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.timeSheet.TimeSheet.model.Role;

public interface RoleRepository extends JpaRepository<Role,Long> {

	//treba da vrati optional da pretrazuje role po imenu
}
