DROP SCHEMA public CASCADE;CREATE SCHEMA public;GRANT ALL ON SCHEMA public TO postgres;GRANT ALL ON SCHEMA public TO public;CREATE SEQUENCE hibernate_sequence START 1;ALTER DATABASE postgres SET timezone TO 'Europe/Moscow';