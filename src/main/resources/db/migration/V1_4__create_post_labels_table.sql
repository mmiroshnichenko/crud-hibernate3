CREATE TABLE IF NOT EXISTS post_label (
    id BIGSERIAL PRIMARY KEY
);

ALTER TABLE post_label ADD COLUMN postId integer NOT NULL
    CONSTRAINT post_label_post_fk REFERENCES post (id)
        ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE post_label ADD COLUMN labelId integer NOT NULL
    CONSTRAINT post_label_label_fk REFERENCES label (id)
        ON UPDATE CASCADE ON DELETE CASCADE;

CREATE UNIQUE INDEX post_label_unique_idx on post_label (postId, labelId);