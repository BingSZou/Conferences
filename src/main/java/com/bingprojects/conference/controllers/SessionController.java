package com.bingprojects.conference.controllers;

import com.bingprojects.conference.models.Session;
import com.bingprojects.conference.repositories.SessionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionController {
    @Autowired
    private SessionRepository sessionRepository;

    @GetMapping
    public List<Session> allSessions() {
        return sessionRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Session getSession(@PathVariable Long id) {
        return sessionRepository.getOne(id);
    }

    @PostMapping
    public void create(@RequestBody Session session) {
        sessionRepository.saveAndFlush(session);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        sessionRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Session update(@PathVariable Long id, @RequestBody Session newSession) {
        Session oldSession = sessionRepository.getOne(id);
        BeanUtils.copyProperties(newSession, oldSession, "session_id");
        return sessionRepository.saveAndFlush(oldSession);
    }
}
