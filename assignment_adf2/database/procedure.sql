
use adf2


-- -------- procedure update customer ---------
go
create procedure pr_update_customer
    @id int,
    @maKH varchar(20),
    @tenKH nvarchar(100),
    @cmt VARCHAR(10),
    @soDT VARCHAR(10),
    @email VARCHAR(50),
    @ngaySinh DATE,
    @gioiTinh int,
    @address NVARCHAR(100),
    @loaiKH int,
    @status int out
as
begin
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
go

create proc pr_delete_customer
    @maKH VARCHAR(20),
    @status int out
as
if exists( select customer.maKH
from customer
    inner join account on customer.id = account.kh_id )
set @status = 1

else 
begin
    delete from customer where maKH = @maKH
    set @status = 0

end


-- =========== account ==========

-- ------- proceduce nap tien ----------

drop pr_NapTien_account

go
create proc pr_NapTien_account
    @soTk char(6),
    @soTien int ,
    @loaitk int,
    @status int out,
    @noiTT nvarchar(100) out
AS
if exists(select soTien
from account
where  sotk = @soTk and loaitk = 0)
begin
    update account set soTien = soTien + @soTien

    set @noitt = (select customer.address
    from customer inner join account on customer.id = account.kh_id
    where  account.sotk = @soTk)

    set @status = 1

end 
else 
set @status = 0

-- --------- procedure rut tien ------------
go
create proc pr_RutTien_account
    @soTk char(6),
    @soTienRut int ,
    @soTienCon int out,
    @status varchar(30) out,
    @noiTT nvarchar(100) out
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
            set @status = 'so tien con lai khong du'
        end
        else if(@soTienRut >= @hanMuc) 
        begin
            set @status = 'Khong the rut qua han muc'
        end                
        else 
        begin
            update account set  soTien = soTien - @soTienRut  where sotk = @soTk
            set @soTienCon = @soTienCon - @soTienRut
            set @status = 'rut tien tu the tra truoc thanh cong'
        end
    end 
    else 
    begin
        if( @soTienRut <= @hanMuc )
        begin
            update account set hanMuc = hanMuc - @soTienRut 
            where sotk = @soTk
            set @status = 'rut tien tu the visa thanh cong'
        end
        else 
        begin
            set @status = 'Khong the rut qua han muc'
        end
    end
end 
else 
begin
    set @status = 'so tai khoan khong ton tai'
end




