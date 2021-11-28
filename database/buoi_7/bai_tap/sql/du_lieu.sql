/*==================NHAP DU LIEU====================*/

/*==============NHAP DU LIEU DMMH=============*/
Insert into DMMH
    (MaMH,TenMH,SoTiet)
values('01', N'Cơ Sở Dữ Liệu', 45)
Insert into DMMH
    (MaMH,TenMH,SoTiet)
values('02', N'Trí Tuệ Nhân Tạo', 45)
Insert into DMMH
    (MaMH,TenMH,SoTiet)
values('03', N'Truyền Tin', 45)
Insert into DMMH
    (MaMH,TenMH,SoTiet)
values('04', N'Đồ Họa', 60)
Insert into DMMH
    (MaMH,TenMH,SoTiet)
values('05', N'Văn Phạm', 60)

/*==============NHAP DU LIEU DMKHOA=============*/
Insert into DMKhoa
    (MaKhoa,TenKhoa)
values('AV', N'Anh Văn')
Insert into DMKhoa
    (MaKhoa,TenKhoa)
values('TH', N'Tin Học')
Insert into DMKhoa
    (MaKhoa,TenKhoa)
values('TR', N'Triết')
Insert into DMKhoa
    (MaKhoa,TenKhoa)
values('VL', N'Vật Lý')


/*==============NHAP DU LIEU DMSV=============*/


SET DATEFORMAT DMY
GO

Insert into DMSV
values('A01', N'Nguyễn Thị', N'Hải', N'Nữ', '23/02/1990', N'Hà Nội', 'TH', 130000)
Insert into DMSV
    (MaSV,HoSV,TenSV,Phai,NgaySinh,NoiSinh,MaKhoa,HocBong)
values('A02', N'Trần Văn', N'Chính', N'Nam', '24/12/1992', N'Bình Định', 'VL', 150000)
Insert into DMSV
    (MaSV,HoSV,TenSV,Phai,NgaySinh,NoiSinh,MaKhoa,HocBong)
values('A03', N'Lê Thu Bạch', N'Yến', N'Nữ', '21/02/1990', N'TP Hồ Chí Minh', 'TH', 170000)
Insert into DMSV
    (MaSV,HoSV,TenSV,Phai,NgaySinh,NoiSinh,MaKhoa,HocBong)
values('A04', N'Trần Anh', N'Tuấn', N'Nam', '20/12/1990', N'Hà Nội', 'AV', 80000)
Insert into DMSV
    (MaSV,HoSV,TenSV,Phai,NgaySinh,NoiSinh,MaKhoa,HocBong)
values('B01', N'Trần Thanh', N'Mai', N'Nữ', '12/08/1991', N'Hải Phòng', 'TR', 0)
Insert into DMSV
    (MaSV,HoSV,TenSV,Phai,NgaySinh,NoiSinh,MaKhoa,HocBong)
values('B02', N'Trần Thị Thu', N'Thủy', N'Nữ', '02/01/1991', N'TP Hồ Chí Minh', 'AV', 0)
-- ------------ test date ----------------------
use QuanLyDiemSV
Insert into DMSV
values('A01', N'Nguyễn Thị', N'Hải', N'Nữ', '23/02/1990', N'Hà Nội', 'TH', 130000)
SELECT *
from DMSV



/*==============NHAP DU LIEU BANG KET QUA=============*/

Insert into KetQua
    (MaSV,MaMH,LanThi,Diem)
values('A01', '01', 1, 3)
Insert into KetQua
    (MaSV,MaMH,LanThi,Diem)
values('A01', '01', 2, 6)
Insert into KetQua
    (MaSV,MaMH,LanThi,Diem)
values('A01', '02', 2, 6)
Insert into KetQua
    (MaSV,MaMH,LanThi,Diem)
values('A01', '03', 1, 5)
Insert into KetQua
    (MaSV,MaMH,LanThi,Diem)
values('A02', '01', 1, 4.5)
Insert into KetQua
    (MaSV,MaMH,LanThi,Diem)
values('A02', '01', 2, 7)
Insert into KetQua
    (MaSV,MaMH,LanThi,Diem)
values('A02', '03', 1, 10)
Insert into KetQua
    (MaSV,MaMH,LanThi,Diem)
values('A02', '05', 1, 9)
Insert into KetQua
    (MaSV,MaMH,LanThi,Diem)
values('A03', '01', 1, 2)
Insert into KetQua
    (MaSV,MaMH,LanThi,Diem)
values('A03', '01', 2, 5)
Insert into KetQua
    (MaSV,MaMH,LanThi,Diem)
values('A03', '03', 1, 2.5)
Insert into KetQua
    (MaSV,MaMH,LanThi,Diem)
values('A03', '03', 2, 4)
Insert into KetQua
    (MaSV,MaMH,LanThi,Diem)
values('A04', '05', 2, 10)
Insert into KetQua
    (MaSV,MaMH,LanThi,Diem)
values('B01', '01', 1, 7)
Insert into KetQua
    (MaSV,MaMH,LanThi,Diem)
values('B01', '03', 1, 2.5)
Insert into KetQua
    (MaSV,MaMH,LanThi,Diem)
values('B01', '03', 2, 5)
Insert into KetQua
    (MaSV,MaMH,LanThi,Diem)

values('B02', '02', 1, 6)
Insert into KetQua
    (MaSV,MaMH,LanThi,Diem)
values('B02', '04', 1, 10)