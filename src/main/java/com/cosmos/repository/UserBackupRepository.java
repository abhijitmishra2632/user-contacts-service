package com.cosmos.repository;

import com.cosmos.model.backup.UserBackup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserBackupRepository extends JpaRepository<UserBackup, Long>{

}
