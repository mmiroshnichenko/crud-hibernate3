package org.crudhibernate3.service;

import org.crudhibernate3.model.Label;
import org.crudhibernate3.repository.LabelRepository;
import org.crudhibernate3.repository.impl.HibernateLabelRepositoryImpl;

import java.util.List;

public class LabelService {
    private final LabelRepository labelRepository;

    public LabelService() {
        this.labelRepository = new HibernateLabelRepositoryImpl();
    }

    public LabelService(LabelRepository labelRepository) {
        this.labelRepository = labelRepository;
    }

    public List<Label> getList() {
        return labelRepository.getAll();
    }

    public List<Label> getListByIds(List<Long> ids) {
        return labelRepository.getByIds(ids);
    }

    public Label saveNewLabel(String name) {
        Label label = new Label();
        label.setName(name);
        return this.save(label);
    }

    public Label save(Label label) {
        return labelRepository.save(label);
    }

    public Label getById(Long id)  {
        return labelRepository.getById(id);
    }

    public Label update(Label label, String name) {
        label.setName(name);
        return labelRepository.update(label);
    }

    public void delete(Long id) {
        //TODO check label existing in posts
        labelRepository.deleteById(id);
    }
}
