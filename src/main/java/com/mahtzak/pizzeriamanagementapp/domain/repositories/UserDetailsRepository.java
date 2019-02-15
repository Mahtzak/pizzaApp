package com.mahtzak.pizzeriamanagementapp.domain.repositories;

import com.mahtzak.pizzeriamanagementapp.domain.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface UserDetailsRepository extends JpaRepository<UserDetails,Long> {

   /* @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update UserDetails ud set ud.firstName=?1, ud.lastName=?2," +
            "ud.address=?3, ud.phoneNumber=?4 where ud.userId=?5")
    void updateUserDetails(String firstName, String lastName, String address,
                           String phoneNumber,Long userId);*/

    @Query(nativeQuery = true,
            value="select id from user_details where first_name=?1 and last_name=?2 and " +
            "phone_number=?3")
    UserDetails getAllFromLastSavedUserDetails(String firstName, String lastName,
                                     String phoneNumber);

    UserDetails findFirstByUserEmail(String email);
}
