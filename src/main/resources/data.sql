insert into `user` (user_id, user_password, user_email, user_auth, user_status)
values ('user1', '123', 'email1', 'MEMBER', 'ACTIVE'),
       ('user2', '123', 'email2', 'MEMBER', 'ACTIVE'),
       ('user3', '123', 'email3', 'MEMBER', 'INACTIVE'),
       ('user4', '123', 'email4', 'MEMBER', 'ACTIVE'),
       ('user5', '123', 'email5', 'MEMBER', 'DELETED');

insert into `project` (project_name, project_status)
values ('project1', 'ACTIVE'),
       ('project2', 'INACTIVE'),
       ('project3', 'ACTIVE'),
       ('project4', 'INACTIVE'),
       ('project5', 'ACTIVE');


