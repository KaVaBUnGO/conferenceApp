package com.conference.service;


import com.conference.domain.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {
}
