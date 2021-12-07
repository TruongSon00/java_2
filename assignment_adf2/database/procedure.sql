
use TestDB
use adf2


-- -------- procedure update customer ---------

go
create procedure pr_update_customer

    @maKH varchar(20),
    @tenKH nvarchar(100),
    @cmt VARCHAR(10),
    @soDT VARCHAR(10),
    @email VARCHAR(50),
    @ngaySinhStr varchar(20),
    @gioiTinh int,
    @address NVARCHAR(100),
    @loaiKH int,
    @status int out
as

begin
    declare @ngaySinh date = convert (date, @ngaySinhStr, 103)
    if((select count(*)
    from customer
    where maKH = @maKH) = 1)
begin
        update customer set  tenKH = @tenKH, cmt = @cmt, soDT = @soDT, email = @email, ngaySinh = @ngaySinh,
gioiTinh = @gioiTinh, address = @address, loaiKH= @loaiKH where maKH = @maKH
        set @status = 1

    end 
else 
    set @status = 0

end

-- -------- procedure delete customer ---------
drop proc pr_delete_customer
go
create proc pr_delete_customer
    @maKH VARCHAR(20),
    @status int out
as
if exists(select customer.maKH
from customer inner join account on customer.id = account.kh_id
where maKH = @maKH)
    set @status = 0

else if exists (select maKH
from customer
where maKH = @maKH )
begin
    delete from customer where maKH = @maKH
    set @status = 1
end
else 
set @status = -1


-- =========== account ==========
-- -------- check account ---------
drop proc pr_checkAcc_account
go
create proc pr_checkAcc_account
    @maKH varchar(20),
    @status int OUT
as
if exists (select makh
from customer
WHERE maKH = @maKH )
begin
    declare @countAcc int = (select count(*)
    from account inner join customer on account.kh_id = customer.id
    WHERE customer.maKH = @maKH )

    if  (@countAcc = 1)
        set @status = 0
    else if(@countAcc = 0)
        set @status = 1
    else 
        set @status = -1
end 

else  
    set @status = -2
-- -------- insert ------------

go
create proc pr_insert_account
    @maKH varchar(20),
    @loaitk int
as
declare @kh_id  int, @loaiKH int
select @kh_id = id, @loaiKH = loaiKH
from customer
where maKH = @maKH



if (@loaitk = 0)
begin
    insert into account
        (kh_id , loaitk , trangThai, ngayTao, soTien, hanMuc)
    values
        ( @kh_id, @loaitk, 1, getdate(), 0, 1000000)
end 

else 
begin
    declare @hanMuc int
    set @hanMuc =  (case 
        when @loaiKH = 0 then 1000000
        when @loaiKH = 1 then 30000000
        else 0
    end)
    insert into account
        (kh_id , loaitk , trangThai, ngayTao, soTien, hanMuc)
    values
        ( @kh_id, @loaitk, 1, getdate(), 0, @hanMuc)
end 






-- ------- proceduce nap tien ----------


go
create proc pr_NapTien_account
    @soTk char(6),
    @soTien int ,
    @status int out,
    @soTienCon int out,
    @noiTT nvarchar(100) out
AS

if exists(select soTien
from account
where  sotk = @soTk)
begin
    if exists(select soTien
    from account
    where  sotk = @soTk and loaitk = 0)
    begin
        update account set @soTienCon = soTien = soTien + @soTien 
            where  account.sotk = @soTk

        select @noitt = address
        from customer
        where id = ANY (select kh_id
        from account
        where  account.sotk = @soTk)

        set @status = 1

    end
    else 
    set @status = -1
end 

else 
    set @status = 0


-- --------- procedure rut tien ------------
drop proc  pr_RutTien_account
go
create proc pr_RutTien_account
    @soTk char(6),
    @soTienRut int ,
    @soTienCon int out,
    @status varchar(100) out,
    @check int out,
    @noiTT nvarchar(100) out,
    @hanMucCon int out


as

declare @loaitk int, @loaiKH int, @hanMuc int;
if exists (select soTk
from account
where sotk = @soTk )
begin
    set @loaiKh = (select customer.loaiKH
    from customer inner join account on customer.id = account.kh_id
    where sotk = @soTk)

    select @soTienCon=  soTien, @hanMuc = hanMuc, @loaitk = loaitk
    from account
    where sotk = @soTk

    if(@loaitk = 0)
    begin
        if(@soTienRut >= @soTienCon)
        begin
            set @check = -1
            set @status = 'so tien con lai khong du'
        end
    
        else if(@soTienRut >= @hanMuc) 
        begin
            set @check = -1
            set @status = 'Khong the rut qua han muc'
        end
                    
        else 
        begin
            update account set  soTien = (soTien - @soTienRut)  where sotk = @soTk
            set @soTienCon = @soTienCon - @soTienRut
            set @status = 'rut tien tu the tra truoc thanh cong'
            set @check = 1
        end
    end 
    else 
    begin
        if( @soTienRut <= @hanMuc )
        begin
            update account set @hanMucCon = hanMuc = (hanMuc - @soTienRut )
            where sotk = @soTk
            set @status = 'rut tien tu the visa thanh cong'
            set @check  = 2

        end
        else 
        begin
            set @check = -1
            set @status = 'Khong the rut qua han muc'
        end

    end
end 
else 
begin
    set @check = 0
    set @status = 'so tai khoan khong ton tai'
end

go

-- ---------- procedure transactionTheoCus -----------

create PROC pr_select_transaction_cus

    @maKH varchar(20),
    @beginTimeStr varchar(20),
    @endTimeStr varchar(20)

as
DECLARE @beginTime date = CONVERT(date,@beginTimeStr,103), @endTime date = CONVERT(date,@endTimeStr,103)
begin
    select giaoDich.*
    from giaoDich inner join account on account.sotk = giaoDich.sotk
        inner join customer on customer.id = account.kh_id
    where customer.maKH = @maKH and giaoDich.ngayTao >= @beginTime and giaoDich.ngayTao <= @endTime
    order by account.loaitk,giaoDich.ngayTao

end

exec dbo.pr_select_transaction_cus 'vu3008','20/10/2020','20/10/2021'

-- ---------- procedure transaction xuatFile -----------

go
create proc pr_transaction_theoMonth
    @month int,
    @year int
as

begin
    select giaoDich.id, giaoDich.sotk, giaoDich.loaitt, giaoDich.soTien, giaoDich.ngayTao, giaoDich.noiThucHien, customer.maKH
    from giaoDich inner join account on account.sotk = giaoDich.sotk
        inner join customer on customer.id = account.kh_id
    where  month(giaoDich.ngayTao) = @month and year(giaoDich.ngayTao) = @year

    order by customer.maKH, giaoDich.sotk
end





