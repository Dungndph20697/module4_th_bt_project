package com.codegym.demo1.bt.formyte.model;

import lombok.*;

import java.util.Map;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class FormYTe {
    private Integer id;
    private String hoTen;
    private Integer namSinh;
    private Boolean gioiTinh;
    private String quocTich;
    private String cccd;
    private String phuongTien;
    private String soHieuPhuongTien;
    private Integer soGhe;
    private Integer ngayKhoiHanh;
    private Integer thangKhoiHanh;
    private Integer namKhoiHanh;
    private Integer ngayKetThuc;
    private Integer thangKetThuc;
    private Integer namKetThuc;
    private String lichSuDiChuyen;
    private String tinhThanh;
    private String quanHuyen;
    private String phuongXa;
    private String diaChi;
    private String dienThoai;
    private String email;
    private TrieuChung trieuChung;
    private LichSuTiepXuc lichSuTiepXuc;
}
