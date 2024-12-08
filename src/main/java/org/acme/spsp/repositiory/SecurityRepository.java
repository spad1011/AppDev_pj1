package org.acme.spsp.repositiory;

import org.acme.spsp.entity.Uzer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecurityRepository extends JpaRepository<Uzer, String> {

}
