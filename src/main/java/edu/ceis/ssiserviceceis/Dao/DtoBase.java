package edu.ceis.ssiserviceceis.Dao;

import edu.ceis.ssiserviceceis.domain.ModelBase;

public abstract class DtoBase<E extends ModelBase> {

    private Long id;

    public abstract DtoBase toDto(E element);

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}