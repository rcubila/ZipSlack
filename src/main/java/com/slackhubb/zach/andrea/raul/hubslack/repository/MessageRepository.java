package com.slackhubb.zach.andrea.raul.hubslack.repository;

import com.slackhubb.zach.andrea.raul.hubslack.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository <Message, Long> {

}
