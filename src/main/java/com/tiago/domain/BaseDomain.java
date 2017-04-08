package com.tiago.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by F on 2017/4/8.
 */
@MappedSuperclass
public abstract class BaseDomain implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseDomain)) return false;

        BaseDomain that = (BaseDomain) o;

        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
