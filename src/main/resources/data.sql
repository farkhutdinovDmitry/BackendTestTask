CREATE TRIGGER quote_trigger
    AFTER INSERT
    ON voting
    FOR EACH ROW
CALL "ru.kameleoon.trial.database.QuoteTrigger";

insert into users(login, password)
values ('dima', 'dima');
insert into quotes(content, author_id)
values ('content 1', 1);
insert into voting(choice, quote_id, user_id)
values (1, 1, 1);
insert into quotes(content, author_id)
values ('content 2', 1);