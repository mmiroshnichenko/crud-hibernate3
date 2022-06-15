package org.crudhibernate3.repository;

import org.crudhibernate3.model.Label;

import java.util.List;

public interface LabelRepository extends GenericRepository<Label, Long>{
    List<Label> getByIds(List<Long> ids);
}
