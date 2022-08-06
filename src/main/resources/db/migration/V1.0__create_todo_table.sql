create sequence todo_sequence start 1;

create table if not exists todo
(
    id
    integer
    generated
    by
    default as
    identity,
    text
    varchar
(
    255
) not null,
    done boolean default false
    UNIQUE
(
    id
)
    );
