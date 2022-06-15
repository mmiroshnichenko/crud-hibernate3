CREATE TABLE IF NOT EXISTS post (
  id BIGSERIAL PRIMARY KEY,
  content text,
  created timestamp NOT NULL,
  updated timestamp NOT NULL
 );

ALTER TABLE post ADD COLUMN writerId integer NOT NULL
    CONSTRAINT post_writer_fk REFERENCES writer (id)
        ON UPDATE CASCADE ON DELETE CASCADE;