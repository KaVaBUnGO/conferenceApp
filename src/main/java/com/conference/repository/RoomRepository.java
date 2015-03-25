package com.conference.repository;


import com.conference.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {

    Room findByName(String name);
}
