package org.crudhibernate3.service;

import org.crudhibernate3.model.Writer;
import org.crudhibernate3.repository.PostRepository;
import org.crudhibernate3.repository.WriterRepository;
import org.crudhibernate3.repository.impl.HibernatePostRepositoryImpl;
import org.crudhibernate3.repository.impl.HibernateWriterRepositoryImpl;

import java.util.List;

public class WriterService {
    private final WriterRepository writerRepository;
    private final PostRepository postRepository;

    public WriterService() {
        this.writerRepository = new HibernateWriterRepositoryImpl();
        this.postRepository = new HibernatePostRepositoryImpl();
    }

    public WriterService(WriterRepository writerRepository, PostRepository postRepository) {
        this.writerRepository = writerRepository;
        this.postRepository = postRepository;
    }

    public List<Writer> getList() {
        return writerRepository.getAll();
    }

    public Writer saveNewWriter(String firstName, String lastName) {
        Writer writer = new Writer();
        writer.setFirstName(firstName);
        writer.setLastName(lastName);
        return this.save(writer);
    }

    public Writer save(Writer writer) {
        return writerRepository.save(writer);
    }

    public Writer getById(Long id) {
        return writerRepository.getById(id);
    }

    public Writer update(Writer writer, String firstName, String lastName) {
        writer.setFirstName(firstName);
        writer.setLastName(lastName);

        return writerRepository.update(writer);
    }

    public void delete(Long id) {
        writerRepository.deleteById(id);
    }
}
