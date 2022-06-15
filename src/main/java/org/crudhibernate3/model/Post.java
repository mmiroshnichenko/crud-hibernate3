package org.crudhibernate3.model;

import org.crudhibernate3.utils.PostgreSQLEnumType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "post")
@TypeDef(
        name = "pgsql_enum",
        typeClass = PostgreSQLEnumType.class
)
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "writerId")
    private Writer writer;

    @Column(name = "content")
    private String content;

    @Column(name = "created")
    private Date created;

    @Column(name = "updated")
    private Date updated;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "post_label",
            joinColumns = @JoinColumn(name = "postId"),
            inverseJoinColumns = @JoinColumn(name = "labelId"))
    private List<Label> labels;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition  = "status")
    @Type( type = "pgsql_enum" )
    private PostStatus status;

    public Post() {
    }

    public Post(Long id, Writer writer, String content, Date created, Date updated, List<Label> labels, PostStatus status) {
        this.id = id;
        this.writer = writer;
        this.content = content;
        this.created = created;
        this.updated = updated;
        this.labels = labels;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Writer getWriter() {
        return writer;
    }

    public void setWriter(Writer writer) {
        this.writer = writer;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public List<Label> getLabels() {
        return labels;
    }

    public void setLabels(List<Label> labels) {
        this.labels = labels;
    }

    public void addLabel(Label label) {
        this.labels.add(label);
    }

    public PostStatus getStatus() {
        return status;
    }

    public void setStatus(PostStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Post post = (Post) o;

        if (!id.equals(post.id)) return false;
        if (!writer.equals(post.writer)) return false;
        if (!content.equals(post.content)) return false;
        if (!created.equals(post.created)) return false;
        if (!updated.equals(post.updated)) return false;
        if (!labels.equals(post.labels)) return false;
        return status == post.status;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + writer.hashCode();
        result = 31 * result + content.hashCode();
        result = 31 * result + created.hashCode();
        result = 31 * result + updated.hashCode();
        result = 31 * result + labels.hashCode();
        result = 31 * result + status.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", writer=" + writer +
                ", content='" + content + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                ", labels=" + labels +
                ", status=" + status +
                '}';
    }
}
