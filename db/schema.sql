
/* START SETTINGS */

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = ON;
SET check_function_bodies = FALSE;
SET client_min_messages = WARNING;
SET search_path = PUBLIC, pg_catalog;
SET default_tablespace = '';
SET default_with_oids = FALSE;

/* END SETTINGS */

/* START DROP */

DROP TABLE IF EXISTS public.file_type             CASCADE;
DROP TABLE IF EXISTS public.roles                 CASCADE;
DROP TABLE IF EXISTS public.users                 CASCADE;
DROP TABLE IF EXISTS public.question              CASCADE;
DROP TABLE IF EXISTS public.question_translation  CASCADE;
DROP TABLE IF EXISTS public.user_answer           CASCADE;
DROP TABLE IF EXISTS public.user_files            CASCADE;
DROP TABLE IF EXISTS public.file                  CASCADE;
DROP TABLE IF EXISTS public.user_roles            CASCADE;
DROP TABLE IF EXISTS public.user_attempts         CASCADE;
DROP TABLE IF EXISTS public.privilege             CASCADE;
DROP TABLE IF EXISTS public.roles_privileges      CASCADE;
DROP TABLE IF EXISTS public.persistent_login      CASCADE;
DROP TABLE IF EXISTS public.password_reset        CASCADE;
DROP TABLE IF EXISTS public.verification_token    CASCADE;

/* END DROP */

/* START CREATE */

CREATE TABLE public.roles
(
    id   SERIAL PRIMARY KEY
  , name VARCHAR(36) NOT NULL
);

CREATE TABLE public.file
(
    id      SERIAL PRIMARY KEY
  , name    VARCHAR(255)       NOT NULL
  , size    INT                NOT NULL
  , content_type VARCHAR(100)  NOT NULL
);

CREATE TABLE public.users
(
    uuid                  VARCHAR(36) PRIMARY KEY
  , username              VARCHAR(45) UNIQUE        NOT NULL
  , firstName             VARCHAR(255)
  , lastName              VARCHAR(255)
  , email                 VARCHAR UNIQUE            NOT NULL
  , password              TEXT
  , enabled               BOOLEAN                   NOT NULL
  , accountNonExpired     BOOLEAN                   NOT NULL
  , accountNonLocked      BOOLEAN                   NOT NULL
  , credentialsNonExpired BOOLEAN                   NOT NULL
  , authProvider          INT                       NOT NULL 
);

CREATE TABLE public.question
(
    id       SERIAL PRIMARY KEY
  , day      VARCHAR(2)        NOT NULL
  , month    VARCHAR(2)        NOT NULL
  , year     VARCHAR(4)         NOT NULL
);

CREATE TABLE public.question_translation
(
    id SERIAL PRIMARY KEY
  , question_id   INT REFERENCES public.question(id) NOT NULL
  , question_text TEXT                               NOT NULL
  , language      VARCHAR(2)                         NOT NULL
);

CREATE TABLE public.user_answer
(
    uuid        VARCHAR(36) PRIMARY KEY
  , user_uuid   VARCHAR(36) REFERENCES public.users(uuid)  NOT NULL
  , question_id INT         REFERENCES public.question(id) NOT NULL
  , answer      TEXT                                       NOT NULL
);

CREATE TABLE public.user_files
(
    user_uuid VARCHAR(36) REFERENCES public.users(uuid) NOT NULL
  , file_id   INT         REFERENCES public.file(id)    NOT NULL
);

CREATE TABLE user_attempts (
    id           SERIAL PRIMARY KEY
  , user_uuid    VARCHAR(36) REFERENCES public.users(uuid) NOT NULL
  , attempts     INTEGER                                   NOT NULL
  , last_modified TIMESTAMP                                 NOT NULL
);

CREATE TABLE public.user_roles
(
    user_uuid VARCHAR(36) REFERENCES public.users(uuid) NOT NULL
  , role_id   INTEGER     REFERENCES public.roles(id)   NOT NULL
);

CREATE TABLE public.privilege
(
    id   SERIAL PRIMARY KEY
  , name VARCHAR(36) NOT NULL
);

CREATE TABLE public.roles_privileges
(
    role_id      INT REFERENCES public.roles (id)    NOT NULL
  , privilege_id INT REFERENCES public.privilege(id) NOT NULL
);

CREATE TABLE public.persistent_login
(
    series    VARCHAR(64) PRIMARY KEY                    NOT NULL
  , user_uuid VARCHAR(36) REFERENCES public.users (uuid) NOT NULL
  , token     VARCHAR(64) DEFAULT NULL                   NOT NULL
  , last_used TIMESTAMP                                  NOT NULL
);

CREATE TABLE public.password_reset
(
    id          SERIAL PRIMARY KEY
  , token       VARCHAR(64)                               NOT NULL
  , user_uuid   VARCHAR(36) REFERENCES public.users(uuid) NOT NULL
  , expire_date TIMESTAMP                                 NOT NULL
);

CREATE TABLE public.verification_token
(
    id          SERIAL PRIMARY KEY
  , token       VARCHAR(64)                               NOT NULL
  , user_uuid   VARCHAR(36) REFERENCES public.users(uuid) NOT NULL
  , expire_date TIMESTAMP                                 NOT NULL
);

/* END CREATE */