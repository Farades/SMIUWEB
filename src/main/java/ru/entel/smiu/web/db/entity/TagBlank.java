package ru.entel.smiu.web.db.entity;

import javax.persistence.*;

/**
 * Created by farades on 05.11.15.
 */
@Entity
@Table(name = "tag_blank", schema = "", catalog = "smiu")
public class TagBlank {
    private int id;
    private String tagDescr;
    private String tagName;
    private String tagId;
    private int delay;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "tag_descr")
    public String getTagDescr() {
        return tagDescr;
    }

    public void setTagDescr(String tagDescr) {
        this.tagDescr = tagDescr;
    }

    @Basic
    @Column(name = "tag_name")
    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    @Basic
    @Column(name = "tag_id")
    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    @Basic
    @Column(name = "delay")
    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TagBlank that = (TagBlank) o;

        if (id != that.id) return false;
        if (delay != that.delay) return false;
        if (tagDescr != null ? !tagDescr.equals(that.tagDescr) : that.tagDescr != null) return false;
        if (tagName != null ? !tagName.equals(that.tagName) : that.tagName != null) return false;
        if (tagId != null ? !tagId.equals(that.tagId) : that.tagId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (tagDescr != null ? tagDescr.hashCode() : 0);
        result = 31 * result + (tagName != null ? tagName.hashCode() : 0);
        result = 31 * result + (tagId != null ? tagId.hashCode() : 0);
        result = 31 * result + delay;
        return result;
    }
}
