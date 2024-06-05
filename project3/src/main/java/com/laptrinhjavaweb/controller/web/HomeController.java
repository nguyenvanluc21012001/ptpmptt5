package com.laptrinhjavaweb.controller.web;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.DAO.impl.userDAO;
import com.laptrinhjavaweb.model.chiTietDonHang;
import com.laptrinhjavaweb.model.danhMuc;
import com.laptrinhjavaweb.model.donHang;
import com.laptrinhjavaweb.model.feedBack;
import com.laptrinhjavaweb.model.gioHang;
import com.laptrinhjavaweb.model.kho;
import com.laptrinhjavaweb.model.role;
import com.laptrinhjavaweb.model.sanPham;
import com.laptrinhjavaweb.model.user;
import com.laptrinhjavaweb.service.IchiTietDonHangService;
import com.laptrinhjavaweb.service.IdanhMucService;
import com.laptrinhjavaweb.service.IdonHangService;
import com.laptrinhjavaweb.service.IfeedbackService;
import com.laptrinhjavaweb.service.IgioHangService;
import com.laptrinhjavaweb.service.IkhoService;
import com.laptrinhjavaweb.service.IsanPhamService;
import com.laptrinhjavaweb.service.IuserService;



@Controller(value = "homeControllerOfWeb")
public class HomeController {
	@Autowired
	private IsanPhamService IsanPhamServices;
	@Autowired
	private IfeedbackService IfeedbackServices;
	@Autowired
	private IkhoService IkhoServices;
	@Autowired
	private IgioHangService IgioHangServices;
	@Autowired
	private IdanhMucService IdanhMucServices;
	@Autowired
	private IuserService IuserServices;
	@Autowired
	private IdonHangService IdonHangServices;
	@Autowired
	private IchiTietDonHangService IchiTietDonHangServices;
	@RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
	public ModelAndView homePage(@ModelAttribute("sanPhamModel") sanPham sanPham) {
		ModelAndView mav = new ModelAndView("web/home");
		ArrayList<sanPham> sp = new ArrayList<>();
		for (sanPham sanPham2 : IsanPhamServices.findAll()) {
			sp.add(sanPham2);
		}
		ArrayList<danhMuc> dm = new ArrayList<>();
		for (danhMuc danhMuc : IdanhMucServices.findAll()) {
			dm.add(danhMuc);
		}
		mav.addObject("danhMucList", dm);
		mav.addObject("sanPhamList", sp);
		return mav;
	}

	@RequestMapping(value = "/chiTietSanPham", method = RequestMethod.GET)
	public ModelAndView danhSachSanPham(@RequestParam("data") int productId) {
		ModelAndView mav = new ModelAndView("web/chiTietSanPham");
		sanPham sanPham = IsanPhamServices.findByID(productId);
		ArrayList<feedBack> fb = new ArrayList<>();
		for (feedBack feedback : IfeedbackServices.findByID(productId)) {
			fb.add(feedback);
		}
		kho kho = IkhoServices.find(productId, 1);
		mav.addObject("kho", kho);
		mav.addObject("feedbackList", fb);
		mav.addObject("sanPham", sanPham);

		return mav;
	}

	@RequestMapping(value = "/dang-nhap", method = RequestMethod.GET)
	public ModelAndView dangNhap() {
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}
	@RequestMapping(value = "/dang-ky", method = RequestMethod.GET)
	public ModelAndView dangKy(@RequestParam("tenDangNhap") String tenDangNhap, @RequestParam("matKhau") String matKhau,
			@RequestParam("hoVaTen") String hoVaTen, @RequestParam("email") String email,
			@RequestParam("diaChiKhachHang") String diaChi, @RequestParam("vaitro") String vaitro) {
		Random rd = new Random();
		int user_id = (int) (System.currentTimeMillis() + rd.nextInt(1000));
		role role_id= new role();
		if(vaitro.endsWith("nhân viên")) {
			role_id.setRole_id(2);
			role_id.setName("nhân viên");
		}
		user u= new user(user_id, tenDangNhap, matKhau, hoVaTen, email, diaChi,role_id, 1);
		IuserServices.insert(u);
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam("tenDangNhap") String tenDangNhap, @RequestParam("matKhau") String matKhau,
			HttpServletRequest request) {
//		user user = IuserService.sellectByTaiKhoanMatKhau(tenDangNhap, matKhau);
		userDAO userDAO = new userDAO();
		user user = userDAO.sellectByTaiKhoanMatKhau(tenDangNhap, matKhau);
		String url = "";
		if (user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			int vaitro = user.getRole_id().getRole_id();
			if (vaitro == 2) {
				url = "web/home";
			} else {
				url = "admin/home";
			}
		} else {
			request.setAttribute("baoLoi", "Tên đăng nhập hoặc mật khẩu không đúng!");
			url = "/login";
		}
		ArrayList<sanPham> sp = new ArrayList<>();

		for (sanPham sanPham2 : IsanPhamServices.findAll()) {
			sp.add(sanPham2);
		}
		ArrayList<danhMuc> dm = new ArrayList<>();
		for (danhMuc danhMuc : IdanhMucServices.findAll()) {
			dm.add(danhMuc);
		}
		
		ModelAndView mav = new ModelAndView(url);
		mav.addObject("danhMucList", dm);
		mav.addObject("sanPhamList", sp);
		return mav;
	}

	@RequestMapping(value = "/dang-xuat", method = RequestMethod.GET)
	public ModelAndView dangXuat(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("web/home");
		ArrayList<sanPham> sp = new ArrayList<>();
		for (sanPham sanPham2 : IsanPhamServices.findAll()) {
			sp.add(sanPham2);
		}
		ArrayList<danhMuc> dm = new ArrayList<>();
		for (danhMuc danhMuc : IdanhMucServices.findAll()) {
			dm.add(danhMuc);
		}
		mav.addObject("danhMucList", dm);
		mav.addObject("sanPhamList", sp);
		HttpSession session = request.getSession();
		session.invalidate();
		return mav;
	}

	@RequestMapping(value = "/size", method = RequestMethod.GET)
	public ModelAndView size(@RequestParam("sanpham") int productId, @RequestParam("size") int sizeID) {
		ModelAndView mav = new ModelAndView("web/chiTietSanPham");
		sanPham sanPham = IsanPhamServices.findByID(productId);
		ArrayList<feedBack> fb = new ArrayList<>();
		for (feedBack feedback : IfeedbackServices.findByID(productId)) {
			fb.add(feedback);
		}
		kho kho = IkhoServices.find(productId, sizeID);
		mav.addObject("kho", kho);
		mav.addObject("feedbackList", fb);
		mav.addObject("sanPham", sanPham);
		return mav;
	}

	@RequestMapping(value = "/themvaogiohang", method = RequestMethod.GET)
	public ModelAndView themvaogiohang(@RequestParam("user_id") int userId, @RequestParam("sanpham_id") int sanPhamId,
			@RequestParam("soluong") int soLuong) {
		ModelAndView mav = new ModelAndView("web/giohang");
		IgioHangServices.insert(sanPhamId, userId, soLuong);
		ArrayList<gioHang> gh = new ArrayList<>();
		for (gioHang gioHang : IgioHangServices.findById(userId)) {
			System.out.println(gioHang.getSanPham().getAnh().getHinhAnh());
			System.out.println(gioHang.getSanPham().getId());
			gh.add(gioHang);
		}
		mav.addObject("gioHangList", gh);
		return mav;
	}

	@RequestMapping(value = "/timkiemsanpham", method = RequestMethod.GET)
	public ModelAndView timkiemsanpham(@RequestParam("timkiemsanpham") String timkiemsanpham) {
		ModelAndView mav = new ModelAndView("web/home");
		ArrayList<sanPham> sp = new ArrayList<>();
		for (sanPham sanPham2 : IsanPhamServices.findBytieuDe(timkiemsanpham)) {
			sp.add(sanPham2);
		}
		ArrayList<danhMuc> dm = new ArrayList<>();
		for (danhMuc danhMuc : IdanhMucServices.findAll()) {
			dm.add(danhMuc);
		}
		mav.addObject("danhMucList", dm);
		mav.addObject("sanPhamList", sp);
		return mav;
	}

	@RequestMapping(value = "/timKiemDanhMuc", method = RequestMethod.GET)
	public ModelAndView timKiemDanhMuc(@RequestParam("data") int danhMucID) {
		ModelAndView mav = new ModelAndView("web/home");
		ArrayList<sanPham> sp = new ArrayList<>();
		for (sanPham sanPham2 : IsanPhamServices.findByDanhMucID(danhMucID)) {
			sp.add(sanPham2);
		}
		ArrayList<danhMuc> dm = new ArrayList<>();
		for (danhMuc danhMuc : IdanhMucServices.findAll()) {
			dm.add(danhMuc);
		}
		mav.addObject("danhMucList", dm);
		mav.addObject("sanPhamList", sp);
		return mav;
	}

	@RequestMapping(value = "/mua", method = RequestMethod.GET)
	public ModelAndView mua(@RequestParam("selectedItems") int[] selectedItems, @RequestParam("user_id") int userId) {
		ModelAndView mav = new ModelAndView("web/dangkydonhang");
		ArrayList<Integer> selectedLucValues = new ArrayList<>();
		if (selectedItems != null) {
			for (int selectedItem : selectedItems) {
				System.out.println(selectedItem);
				selectedLucValues.add(selectedItem);
			}
		}
		mav.addObject("user_id", userId);
		mav.addObject("selectedLucValues", selectedLucValues);
		return mav;
	}

	@RequestMapping(value = "/dangkydonhang", method = RequestMethod.GET)
	public ModelAndView dangkydonhang(@RequestParam("listParam") int[] selectedItems,
			@RequestParam("user_id") int userId, @RequestParam("ten") String ten,
			@RequestParam("sdt") String sodienthoai, @RequestParam("diachi") String diachi) {
		ModelAndView mav = new ModelAndView("web/xacnhandonhang");
		ArrayList<Integer> selectedLucValues = new ArrayList<>();
		if (selectedItems != null) {
			for (int selectedItem : selectedItems) {
				selectedLucValues.add(selectedItem);
			}
		}
		user user=IuserServices.findById(userId);
		Random rd = new Random();
		int madonhang = (int) (System.currentTimeMillis() + rd.nextInt(1000));
		LocalDateTime currentTime = LocalDateTime.now();
		donHang dh = new com.laptrinhjavaweb.model.donHang(madonhang, user, ten,sodienthoai, diachi, currentTime, 1);
		IdonHangServices.insert(dh);
		donHang donhang=IdonHangServices.findByid(madonhang);
		
		ArrayList<gioHang> listgiohang = new ArrayList<>();
		for (gioHang giohang1 : IgioHangServices.findById(userId)) {
			listgiohang.add(giohang1);
		}
		gioHang[] gh = new gioHang[100];
		int i = 0;
		for (gioHang element : listgiohang) {
			gh[i] = element;
			i++;
		}
		
		for (int luc = 0; luc < listgiohang.size(); luc++) {
			if (selectedLucValues.contains(luc)) {
			    com.laptrinhjavaweb.model.chiTietDonHang ctdh = new com.laptrinhjavaweb.model.chiTietDonHang(donhang,gh[luc].getSanPham(), gh[luc].getSoLuong());
				IchiTietDonHangServices.insert(ctdh);
			}
		}
		int tong=0;
		ArrayList<chiTietDonHang> ctdh = new ArrayList<>();
		for (chiTietDonHang cthd : IchiTietDonHangServices.sellectAllById(madonhang)) {
			tong+=cthd.getSoLuong()*cthd.getSanPham().getGiaBan();
			ctdh.add(cthd);
		}
		
		mav.addObject("ctdh", ctdh);
		mav.addObject("tongtien", tong);
		return mav;
	}
	
	@RequestMapping(value = "/guinhanxet", method = RequestMethod.GET)
	public ModelAndView guinhanxet(@RequestParam("user_id") int userId,@RequestParam("sanpham_id") int sanphamId,@RequestParam("nhanxet") String nhanxet) {
		user u=IuserServices.findById(userId);
		sanPham sp=IsanPhamServices.findByID(sanphamId);
		feedBack feedback1=new feedBack(u, sp, "đánh giá sản phẩm", nhanxet);
		IfeedbackServices.insert(feedback1);
		ModelAndView mav = new ModelAndView("web/chiTietSanPham");
		sanPham sanPham = IsanPhamServices.findByID(sanphamId);
		ArrayList<feedBack> fb = new ArrayList<>();
		for (feedBack feedback : IfeedbackServices.findByID(sanphamId)) {
			fb.add(feedback);
		}
		kho kho = IkhoServices.find(sanphamId, 1);
		mav.addObject("kho", kho);
		mav.addObject("feedbackList", fb);
		mav.addObject("sanPham", sanPham);

		return mav;
	}
	@RequestMapping(value = "/hoanthanh", method = RequestMethod.GET)
	public ModelAndView hoanthanh(@RequestParam("user_id") int userId) {
		user u=IuserServices.findById(userId);
		ModelAndView mav = new ModelAndView("web/hoanthanh");
		mav.addObject("user", u);
		return mav;
	}


}
