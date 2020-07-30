-- begin KAFKASAMPLE_KAFKA_MESSAGE
create table KAFKASAMPLE_KAFKA_MESSAGE (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    KAFKA_ID integer,
    CONTENT varchar(255),
    --
    primary key (ID)
)^
-- end KAFKASAMPLE_KAFKA_MESSAGE
