package com.bingprojects.conference.repositories;

import com.bingprojects.conference.models.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakerRepository extends JpaRepository<Speaker, Long> {
}
