package com.bingprojects.conference.controllers;

import com.bingprojects.conference.models.Speaker;
import com.bingprojects.conference.repositories.SpeakerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/speakers")
public class SpeakerController {
    @Autowired
    private SpeakerRepository speakerRepository;

    @GetMapping
    public List<Speaker> list() {
        return speakerRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Speaker getSpeaker(@PathVariable Long id) {
        return speakerRepository.getOne(id);
    }

    @PostMapping
    public void create(@RequestBody Speaker speaker) {
        speakerRepository.saveAndFlush(speaker);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        speakerRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Speaker updateSpeaker(@PathVariable Long id, @RequestBody Speaker newSpeaker) {
        Speaker oldSpeaker = speakerRepository.getOne(id);
        BeanUtils.copyProperties(newSpeaker, oldSpeaker, "speaker_id");
        return speakerRepository.saveAndFlush(oldSpeaker);
    }
}
