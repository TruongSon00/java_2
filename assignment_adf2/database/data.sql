use TestDB
use adf2


-- ------------ customer ------------
insert into customer
    (maKH, tenKH, cmt, soDT, email, ngaySinh, gioiTinh, address, loaiKH)
values
    ('son3008', N'Vũ Trường Sơn', '0312000000', '0587234423', 'soi30082000', '2000-08-30', 1, N'HP', 1),
    ('vu3008', N'Trần Long Vũ', '0312000001', '0587234424', 'vu30082000', '2000-10-29', 1, N'HN', 0),
    ('an3008', N'Nguyễn Ngọc An', '0312000002', '0587234425', 'an30082000', '2000-02-01', 1, N'VP', 1)


-- ---------- account -------------
insert into account
    (kh_id , loaitk , trangThai, ngayTao, soTien, hanMuc)
VALUES
    (1, 0, 1, '2021-07-20', 5000000, 1000000)
insert into account
    (kh_id , loaitk , trangThai, ngayTao, soTien, hanMuc)
VALUES
    (1, 1, 1, '2021-07-30', 0, 10000000)
insert into account
    (kh_id , loaitk , trangThai, ngayTao, soTien, hanMuc)
VALUES
    (2, 0, 1, '2021-07-20', 5000000, 1000000)

insert into account
    (kh_id , loaitk , trangThai, ngayTao, soTien, hanMuc)
VALUES
    (2, 1, 1, '2021-01-20', 0, 1000000)

insert into account
    (kh_id , loaitk , trangThai, ngayTao, soTien, hanMuc)
VALUES
    (3, 0, 1, '2021-03-20', 5000000, 1000000)

-- ------------ giao dich ------------
insert into giaoDich
values
    ('000001', 1, 1000000, '2021-08-20', N'HP'),
    ('000001', 0, 1000000, '2021-08-20', N'HP'),
    ('000003', 0, 500000, '2021-08-20', N'HP'),
    ('000003', 0, 2000000, '2021-08-20', N'HP'),
    ('000004', 1, 1000000, '2021-08-20', N'HP'),
    ('000005', 1, 500000, '2021-09-20', N'HP'),
    ('000005', 0, 500000, '2021-09-20', N'HP')

SELECT *
from giaoDich
-- ------------- test loi ------------


insert into customer
    (maKH, tenKH, cmt, soDT, email, ngaySinh, gioiTinh, address, loaiKH)
values('son30083', N'Vũ Hữu Cường', '031200000', '058723442', 'cuong30082000s', '2000-08-20', 1, N'HP', 1)

select *
from account
insert into account
VALUES
    (1, '0312003', 0, 1, '2021-07-20', 5000000, 1000000)


insert into giaoDich
values
    ('031201', 1, 1000000, '2021-08-20', N'HP')


drop table test
create table test
(
    id int IDENTITY(1,1),
    sotk as right('000000' + cast(id as varchar(6)), 6),
    name char(6)
)

go
create trigger test_sotk on test after insert
    as 
begin
    update  test 
    set     sotk = right ('000000' + cast(id as varchar(6)), 6)
    where   sotk is null
        and id in (select id
        from inserted)
end

insert into test
    (name)
values
    ('son')
insert into test
    (name)
values
    ('hih')
insert into test
    (name)
values
    ('haha')

SELECT *
from test