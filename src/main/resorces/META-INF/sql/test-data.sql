USE TEST;
SET
master_user_profile.fellow = 'y';
insert into car (license_plate, manufacturer, manufacture_date)
VALUES ('LICENSE-1001', 'Ford', '1980-07-30'),
       ('LICENSE-1002', 'Toyota', '1992-12-30'),
       ('LICENSE-1003', 'ВМW', '2003-1-6');