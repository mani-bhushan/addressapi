package com.apps.addressapi.repositories;

import java.util.Optional;

import com.apps.addressapi.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends JpaRepository<Address, Integer> {

    @Query(
        nativeQuery = true,
        value
        = "SELECT ea.id, ea.city, ea.state FROM gfgdemodb.address ea join gfgdemodb.employee e on e.id = ea.id where ea.id=:id")
       Optional<Address> findAddressByEmployeeId(@Param("id") long employeeId);
}
