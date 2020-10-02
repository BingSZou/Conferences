package com.bingprojects.conference.models;

import org.hibernate.annotations.Type;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.List;

@Entity(name = "sessions")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer session_id;
    private String session_name;
    private String session_description;
    private Integer session_length;

    @Lob
    @Type(type = "org.hibernate.type.BinaryType")
    private byte[] speaker_photo;

    public byte[] getSpeaker_photo() {
        return speaker_photo;
    }

    public void setSpeaker_photo(byte[] speaker_photo) {
        this.speaker_photo = speaker_photo;
    }

    public Session() {

    }

    public List<Speaker> getSpeakers() {
        return speakers;
    }

    public void setSpeakers(List<Speaker> speakers) {
        this.speakers = speakers;
    }

    @ManyToMany
    @JoinTable(
                name = "session_speakers",
                joinColumns = @JoinColumn(name = "session_id"),
                inverseJoinColumns = @JoinColumn(name = "speaker_id"))
    private List<Speaker> speakers;

    public Integer getSession_id() {
        return session_id;
    }

    public void setSession_id(Integer session_id) {
        this.session_id = session_id;
    }

    public String getSession_name() {
        return session_name;
    }

    public void setSession_name(String session_name) {
        this.session_name = session_name;
    }

    public String getSession_description() {
        return session_description;
    }

    public void setSession_description(String session_description) {
        this.session_description = session_description;
    }

    public Integer getSession_length() {
        return session_length;
    }

    public void setSession_length(Integer session_length) {
        this.session_length = session_length;
    }
}
