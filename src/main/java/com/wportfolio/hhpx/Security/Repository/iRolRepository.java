package com.wportfolio.hhpx.Security.Repository;

import com.wportfolio.hhpx.Security.Entity.Rol;
import com.wportfolio.hhpx.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRolRepository extends JpaRepository<Rol, Integer> {
     Optional<Rol> findByRolNombre(RolNombre rolNombre);
}