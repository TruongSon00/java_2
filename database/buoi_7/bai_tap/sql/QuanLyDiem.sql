/*=====================Create DataBase======================*/


use tempdb

go
if exists(select name
from sysdatabases
where name='QuanLyDiemSV')
drop Database QuanLyDiemSV
go
Create Database QuanLyDiemSV
go
use QuanLyDiemSV
go


/*=============DANH MUC KHOA==============*/


Create table DMKhoa
(
    MaKhoa char(2)primary key,
    TenKhoa nvarchar(30)not null,
)


/*==============DANH MUC SINH VIEN============*/


Create table DMSV
(
    MaSV char(3) not null primary key,
    HoSV nvarchar(15) not null,
    TenSV nvarchar(7) not null,
    Phai nchar(7),
    NgaySinh datetime not null,
    NoiSinh nvarchar(20),
    MaKhoa char(2),
    HocBong float,

)




/*===================MON HOC========================*/



create table DMMH
(
    MaMH char(2) not null,
    TenMH nvarchar(25) not null,
    SoTiet tinyint
        Constraint DMMH_MaMH_pk primary key(MaMH)
)



/*=====================KET QUA===================*/

create table KetQua
(
    MaSV char(3) not null,
    MaMH char(2) not null,
    LanThi tinyint,
    Diem decimal(4,2),
    Constraint KetQua_MaSV_MaMH_LanThi_pk primary key(MaSV,MaMH,LanThi)
)

/*==========================TAO KHOA NGOAI==============================*/
Alter table dmsv
add Constraint DMKhoa_MaKhoa_fk foreign key(MaKhoa)
References DMKhoa ( MaKhoa)
Alter table KetQua
add Constraint KetQua_MaSV_fk foreign key(MaSV) references DMSV (MaSV),
constraint DMMH_MaMH_fk foreign key(MaMH) references DMMH (MaMH)





-- ======== update diem ============
create procedure pr_update_diem
    @MaSV char(3),
    @MaMH char(2),
    @LanThi tinyint,
    @diem decimal(4,2),
    @status varchar(20) out
AS
IF ((select count (*)
from KetQua
where MaSV = @MaSV and MaMH = @MaMH) = 1 )
BEGIN
    update KetQua set LanThi = @LanThi, Diem = @diem where MaSV = @MaSV
        and MaMH = @MaMH
    SET @status = 'Succes'
END
ELSE
    SET @status = 'not exits'

-- ========= update  khoa ========

create procedure pr_update_khoa
    @maKhoa char(2),
    @tenKhoa NVARCHAR(30),
    @status varchar(20) out

as
if((select count(*)
from DMKhoa
where MaKhoa = @maKhoa) = 1)
begin
    update DMKhoa set TenKhoa = @tenKhoa where MaKhoa = @maKhoa
    set @status = 'Update succes'
end 
else 
    set @status = 'not exits'


