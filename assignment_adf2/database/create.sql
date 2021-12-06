use TestDB

go
if EXISTS (select name
from sys.databases
WHERE name = 'adf2')
drop database adf2
create database adf2
use adf2

-- ---------- create table ------------

-- ----------- table customer --------

go

create table customer
(
    id int IDENTITY(1,1),
    maKH varchar(20) unique,
    tenKH nvarchar(100),
    cmt char(10) UNIQUE check(ISNUMERIC(cmt) = 1 and len(cmt) = 10),
    soDT char(10) UNIQUE check(ISNUMERIC(soDT) = 1 and len(soDT) = 10),
    email VARCHAR(50) UNIQUE,
    ngaySinh DATE,
    gioiTinh int CHECK (gioiTinh >= 0 and gioiTinh <= 2) ,
    address NVARCHAR(100),
    loaiKH int CHECK(loaiKH =0 or loaiKH = 1),
    CONSTRAINT PK_Customer PRIMARY KEY (ID),
)



create table account
(
    id int IDENTITY(1,1),
    kh_id int,
    sotk char(6) unique ,
    loaitk int check(loaitk = 0 or loaitk =1),
    trangThai int CHECK (trangThai=0 or trangThai = 1),
    ngayTao date check (ngayTao <= getdate()),
    soTien int CHECK (soTien >= 0),
    hanMuc int ,
    CONSTRAINT PK_Account PRIMARY KEY (ID),
)

go
create trigger trig_sotk on account after insert 
as 
begin
    update account set sotk = right('000000' + cast (id as varchar(6)), 6)
where id in(select id
    from inserted)

end 

go
create TABLE giaoDich
(
    id int IDENTITY(1,1),
    sotk char(6),
    loaitt int CHECK(loaitt = 0 or loaitt = 1),
    soTien int check(soTien > 0),
    ngayTao date check(ngayTao <= getdate()),
    noiThucHien NVARCHAR(100),
    CONSTRAINT PK_Giaodich PRIMARY KEY (ID),
)
-- --------- create foreign key ----------
ALTER TABLE account
ADD FOREIGN KEY (kh_id) REFERENCES customer(id);
ALTER TABLE giaoDich
ADD FOREIGN KEY (sotk) REFERENCES account(sotk);




