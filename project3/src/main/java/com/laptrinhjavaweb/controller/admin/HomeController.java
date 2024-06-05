package com.laptrinhjavaweb.controller.admin;

import java.util.ArrayList;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.model.anh;
import com.laptrinhjavaweb.model.chiTietDonHang;
import com.laptrinhjavaweb.model.danhMuc;
import com.laptrinhjavaweb.model.donHang;
import com.laptrinhjavaweb.model.feedBack;
import com.laptrinhjavaweb.model.sanPham;
import com.laptrinhjavaweb.service.IanhService;
import com.laptrinhjavaweb.service.IchiTietDonHangService;
import com.laptrinhjavaweb.service.IdanhMucService;
import com.laptrinhjavaweb.service.IdonHangService;
import com.laptrinhjavaweb.service.IfeedbackService;
import com.laptrinhjavaweb.service.IsanPhamService;

@Controller(value = "homeControllerOfAdmin")
public class HomeController {
	@Autowired
	private IdanhMucService IdanhMucServices;
	@Autowired
	private IsanPhamService IsanPhamServices;
	@Autowired
	private IanhService IanhServices;
	@Autowired
	private IdonHangService IdonHangServices;
	@Autowired
	private IfeedbackService IfeedbackServices;
	@Autowired
	private IchiTietDonHangService IchiTietDonHangServices;
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView homePage() {
		ModelAndView mav = new ModelAndView("admin/home");
		return mav;
	}

	@RequestMapping(value = "/quanlydanhmuc", method = RequestMethod.GET)
	public ModelAndView quanlydanhmuc() {
		ModelAndView mav = new ModelAndView("admin/quanlydanhmuc");
		ArrayList<danhMuc> dm = new ArrayList<>();
		for (danhMuc danhMuc : IdanhMucServices.findAll()) {
			dm.add(danhMuc);
		}
		mav.addObject("danhMucList", dm);
		return mav;
	}

	@RequestMapping(value = "/suadanhmuc", method = RequestMethod.GET)
	public ModelAndView suadanhmuc(@RequestParam("danhMucId") int danhMucId) {
		ModelAndView mav = new ModelAndView("admin/suadanhmuc");
		danhMuc dm = IdanhMucServices.findByID(danhMucId);
		mav.addObject("danhMuc", dm);
		return mav;
	}

	@RequestMapping(value = "/suadanhmucxong", method = RequestMethod.GET)
	public ModelAndView suadanhmucxong(@RequestParam("danhMucId") int danhMucId,
			@RequestParam("suaDanhMuc") String tenDanhMuc) {
		ModelAndView mav = new ModelAndView("admin/quanlydanhmuc");
		danhMuc danhmuc = new danhMuc(danhMucId, tenDanhMuc,1);
		IdanhMucServices.suaDanhMuc(danhmuc);
		ArrayList<danhMuc> dm = new ArrayList<>();
		for (danhMuc danhMuc : IdanhMucServices.findAll()) {
			dm.add(danhMuc);
		}
		mav.addObject("danhMucList", dm);
		return mav;
	}

	@RequestMapping(value = "/xoadanhmuc", method = RequestMethod.GET)
	public ModelAndView xoadanhmuc(@RequestParam("danhMucId") int danhMucId) {
		ModelAndView mav = new ModelAndView("admin/quanlydanhmuc");
		danhMuc danhmuc=IdanhMucServices.findByID(danhMucId);
		danhmuc.setTonTai(0);
		IdanhMucServices.suaDanhMuc(danhmuc);
		ArrayList<danhMuc> dm = new ArrayList<>();
		for (danhMuc danhMuc : IdanhMucServices.findAll()) {
			dm.add(danhMuc);
		}
		mav.addObject("danhMucList", dm);

		return mav;
	}

	@RequestMapping(value = "/themdanhmuc", method = RequestMethod.GET)
	public ModelAndView themdanhmuc(@RequestParam("themdanhmuc") String themdanhmuc) {
		ModelAndView mav = new ModelAndView("admin/quanlydanhmuc");
		Random rd = new Random();
		int madanhmuc = (int) (System.currentTimeMillis() + rd.nextInt(1000));
		danhMuc danhmuc = new danhMuc(madanhmuc, themdanhmuc,1);
		IdanhMucServices.themDanhMuc(danhmuc);
		ArrayList<danhMuc> dm = new ArrayList<>();
		for (danhMuc danhMuc : IdanhMucServices.findAll()) {
			dm.add(danhMuc);
		}
		mav.addObject("danhMucList", dm);

		return mav;
	}

	@RequestMapping(value = "/quanlysanpham", method = RequestMethod.GET)
	public ModelAndView quanlysanpham() {
		ModelAndView mav = new ModelAndView("admin/quanlysanpham");
		ArrayList<danhMuc> dm = new ArrayList<>();
		for (danhMuc danhMuc : IdanhMucServices.findAll()) {
			dm.add(danhMuc);
		}
		mav.addObject("danhMucList", dm);
		ArrayList<sanPham> sp = new ArrayList<>();
		for (sanPham sanPham2 : IsanPhamServices.findAll()) {
			sp.add(sanPham2);
		}
		mav.addObject("sanPhamList", sp);
		return mav;
	}
	
	@RequestMapping(value = "/suasanpham", method = RequestMethod.GET)
	public ModelAndView suasanpham(@RequestParam("sanphamid") int sanPham) {
		sanPham sanpham=IsanPhamServices.findByID(sanPham);
		ModelAndView mav = new ModelAndView("admin/suasanpham");
		ArrayList<danhMuc> dm = new ArrayList<>();
		for (danhMuc danhMuc : IdanhMucServices.findAll()) {
			dm.add(danhMuc);
		}
		mav.addObject("danhMucList", dm);
		ArrayList<anh> a= new ArrayList<>();
		for (anh anh : IanhServices.findAll()) {
			a.add(anh);
		}
		mav.addObject("sanPham",sanpham);
		mav.addObject("danhMucList", dm);
		mav.addObject("anhList", a);
		return mav;
	}

	@RequestMapping(value = "/suasanphamxong", method = RequestMethod.GET)
	public ModelAndView suasanphamxong(@RequestParam("sanPhamId") int sanphamId,@RequestParam("tieude") String tieude,@RequestParam("danhmuc") int danhMucId,
			@RequestParam("gia") int gia,@RequestParam("giaban") int giaban,@RequestParam("hinhanh") int hinhanh,@RequestParam("motasanpham") String motasanpham) {
		ModelAndView mav = new ModelAndView("admin/quanlysanpham");
	    danhMuc danhmuc= IdanhMucServices.findByID(danhMucId);
	    anh anh=IanhServices.selectByID(hinhanh);
		sanPham sp= new sanPham(sanphamId, danhmuc, tieude, gia, giaban, anh, motasanpham, 1);
		IsanPhamServices.update(sp);
		ArrayList<sanPham> sanpham = new ArrayList<>();
		for (sanPham sanPham2 : IsanPhamServices.findAll()) {
			sanpham.add(sanPham2);
		}
		mav.addObject("sanPhamList", sanpham);
		return mav;
	}

	@RequestMapping(value = "/xoasanpham", method = RequestMethod.GET)
	public ModelAndView xoasanpham(@RequestParam("sanPhamId") int sanphamId) {
		ModelAndView mav = new ModelAndView("admin/quanlysanpham");
		sanPham sp= IsanPhamServices.findByID(sanphamId);
		sp.setTonTai(0);
		IsanPhamServices.update(sp);
		ArrayList<sanPham> sanpham = new ArrayList<>();
		for (sanPham sanPham2 : IsanPhamServices.findAll()) {
			sanpham.add(sanPham2);
		}
		mav.addObject("sanPhamList", sanpham);

		return mav;
	}

	@RequestMapping(value = "/themsanpham", method = RequestMethod.GET)
	public ModelAndView themsanpham(@RequestParam("tieude") String tieude,@RequestParam("danhmuc") int danhMucId,@RequestParam("gia") int gia,
			@RequestParam("giaban") int giaban,@RequestParam("hinhanh") String hinhanh,@RequestParam("motasanpham") String motasanpham) {
		System.out.println(hinhanh);
		ModelAndView mav = new ModelAndView("admin/quanlysanpham");
		Random rd = new Random();
		int masanpham = (int) (System.currentTimeMillis() + rd.nextInt(1000));
		danhMuc danhMuc=IdanhMucServices.findByID(danhMucId);
		String hinhanh2="img/product/"+hinhanh;
		int anh_id=(int) (System.currentTimeMillis() + rd.nextInt(1000));
		anh anh= new anh(anh_id, hinhanh2);
		IanhServices.insert(anh);
		anh a = IanhServices.selectByID(anh_id);
		sanPham sanpham = new sanPham(masanpham, danhMuc, tieude, gia, giaban, a, motasanpham, 1);
		IsanPhamServices.insert(sanpham);
		ArrayList<sanPham> sp = new ArrayList<>();
		for (sanPham sanPham2 : IsanPhamServices.findAll()) {
			sp.add(sanPham2);
		}
		ArrayList<danhMuc> dm = new ArrayList<>();
		for (danhMuc danhMuc1 : IdanhMucServices.findAll()) {
			dm.add(danhMuc1);
		}
		mav.addObject("danhMucList", dm);
		mav.addObject("sanPhamList", sp);

		return mav;
	}
	@RequestMapping(value = "/quanlydonhang", method = RequestMethod.GET)
	public ModelAndView quanlydonhang() {
		ModelAndView mav = new ModelAndView("admin/quanlydonhang");
		ArrayList<donHang> dh = new ArrayList<>();
		for (donHang donHang : IdonHangServices.findAll()) {
			dh.add(donHang);
		}
		mav.addObject("donHangList", dh);
		return mav;
	}
	@RequestMapping(value = "/quanlyphanhoi", method = RequestMethod.GET)
	public ModelAndView quanlyfeedback() {
		ModelAndView mav = new ModelAndView("admin/quanlyphanhoi");
		ArrayList<feedBack> fb = new ArrayList<>();
		for (feedBack feedback : IfeedbackServices.findAll()) {
			fb.add(feedback);
		}
		mav.addObject("feedbackList", fb);
		return mav;
	}
	@RequestMapping(value = "/docfeedback", method = RequestMethod.GET)
	public ModelAndView docfeedback(@RequestParam("noiDung") String noiDung,@RequestParam("sanpham") int sanpham) {
		ModelAndView mav = new ModelAndView("admin/docfeedback");
		sanPham sanPham=IsanPhamServices.findByID(sanpham);
		mav.addObject("noidung", noiDung);
		mav.addObject("sanPham", sanPham);
		return mav;
	}
	@RequestMapping(value = "/xoafeedback", method = RequestMethod.GET)
	public ModelAndView xoafeedback(@RequestParam("sanPhamId") int sanpham,@RequestParam("userId") int user) {
		ModelAndView mav = new ModelAndView("admin/quanlyphanhoi");
		IfeedbackServices.xoa(sanpham, user);
		ArrayList<feedBack> fb = new ArrayList<>();
		for (feedBack feedback : IfeedbackServices.findAll()) {
			fb.add(feedback);
		}
		mav.addObject("feedbackList", fb);
		return mav;
	}
	@RequestMapping(value = "/xemdonhang", method = RequestMethod.GET)
	public ModelAndView xemdonhang(@RequestParam("donHangId") int donhangid) {
		ModelAndView mav = new ModelAndView("admin/xemdonhang");
		ArrayList<chiTietDonHang> ctdh=new ArrayList<>();
		int tong=0;
		for (chiTietDonHang cthd : IchiTietDonHangServices.sellectAllById(donhangid)) {
			tong+=cthd.getSoLuong()*cthd.getSanPham().getGiaBan();
			ctdh.add(cthd);
		}
		
		mav.addObject("ctdh", ctdh);
		mav.addObject("tongtien", tong);
		return mav;
	}
	@RequestMapping(value = "/xoadonhang", method = RequestMethod.GET)
	public ModelAndView xoadonhang(@RequestParam("donHangId") int donhangid) {
		IchiTietDonHangServices.delete(donhangid);
		IdonHangServices.delete(donhangid);
		ModelAndView mav = new ModelAndView("admin/quanlydonhang");
		ArrayList<donHang> dh = new ArrayList<>();
		for (donHang donHang : IdonHangServices.findAll()) {
			dh.add(donHang);
		}
		mav.addObject("donHangList", dh);
		return mav;
	}
}
