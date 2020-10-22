package com.bit.paperhouse.service;

import java.security.Key;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.crypto.spec.SecretKeySpec;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bit.paperhouse.dao.UserRepository;
import com.bit.paperhouse.dto.ArticleDto;
import com.bit.paperhouse.dto.UserDto;
import com.bit.paperhouse.dto.WriterDto;

import oracle.security.pki.Cipher;


@Service
@Transactional
public class UserService {

	@Autowired
	UserRepository dao;

	@Autowired
	PasswordEncoder bCryptPasswordEncoder;


	// 이메일 인증 후 처리
	public void regi( UserDto dto ) throws Exception {
		System.out.print("UserService reig()");
			  
		 dao.emailCheckAf(dto);
	}
	
	// 소셜서비스를 이용한 화원가입
	public void socialRegi( String email ) {
		UserDto dto = new UserDto();
		System.out.print("UserService socialRegi()");
		dto.setEmail(email);
		String rPwd = (int)((Math.random()*899999) +100000) +"";
		String securityPwd = bCryptPasswordEncoder.encode(rPwd);
		dto.setAuthority("ROLE_USER");
		dto.setPwd(securityPwd);
		dto.setEnabled(0);
		String nickname = nickname();
	
		dto.setNickname(nickname);
		 dao.regi(dto);
	
	}
	
	//이메일 인증 전 회원가입
	public void nonEmailRegi( UserDto dto ) {
		System.out.print("UserService nonEmailRegi()");
		String rPwd = dto.getPwd();
		String securityPwd = bCryptPasswordEncoder.encode(rPwd);
		dto.setAuthority("ROLE_USER");
		dto.setPwd(securityPwd);
		dto.setEnabled(1);
		
		String nickname = nickname();
	
		dto.setNickname(nickname);
		 dao.regi(dto);
	}
	
	// 소셜로그인 시 체크
	public UserDto findByEmail(String email) {
		System.out.print("findByEmail()");
		return dao.findByEmail(email);
	}

	// 임시 비밀번호 설정
	public void resetPassword(UserDto dto) {
		System.out.print("resetPassword()");
		String rPwd = dto.getPwd();
		String securityPwd = bCryptPasswordEncoder.encode(rPwd);
		dto.setPwd(securityPwd);
		
		dao.resetPassword(dto);
	}
	

	
	
	
	
	
	
	
	
	
	// 닉네임 생성기
	public String nickname() {
		
		List<String> name3 = Arrays.asList("김", "이", "박", "최", "정", "강", "조", "윤", "장", "임", "한", "오", "서", "신", "권", "황", "안", "송", "류", 
				"전", "홍", "고", "문", "양", "손", "배", "조", "백", "허", "유", "남", "심", "노", "정", "하", "곽", "성", "차", "주", "우", "구", "신", "임", 
				"나", "전", "민", "유", "진", "지", "엄", "채", "원", "천", "방", "공", "강", "현", "함", "변", "염", "양", "변", "여", "추", "노", "도", "소", 
				"신", "석", "선", "설", "마", "길", "주", "연", "방", "위", "표", "명", "기", "반", "왕", "금", "옥", "육", "인", "맹", "제", "모", "장", "남", "탁", "국", "여", "진", "어", "은", "편", "구", "용"); 
		
		List<String> name4 = Arrays.asList("가", "강", "건", "경", "고", "관", "광", "구", "규", "근", "기", "길", "나", "남", "노", "누", "다", "단", "달", 
				"담", "대", "덕", "도", "동", "두", "라", "래", "로", "루", "리", "마", "만", "명", "무", "문", "미", "민", "바", "박", "백", "범", "별", "병", "보", "빛", "사", "산", "상", "새", "서", "석", "선", 
				"설", "섭", "성", "세", "소", "솔", "수", "숙", "순", "숭", "슬", "승", "시", "신", "아", "안", "애", "엄", "여", "연", "영", "예", "오", "옥", "완", "요", "용", "우", "원", "월", "위", "유", "윤", 
				"율", "으", "은", "의", "이", "익", "인", "일", "잎", "자", "잔", "장", "재", "전", "정", 
				"제", "조", "종", "주", "준", "중", "지", "진", "찬", "창", "채", "천", "철", "초", "춘", "충", "치", "탐", "태", "택", "판", "하", "한", "해", "혁", "현", "형", "혜", "호", "홍", "화", "환", "회",
				"효", "훈", "휘", "희", "운", "모", "배", "부", "림", "봉", "혼", "황", "량", "린", "을", "비", "솜", "공", "면", "탁", "온", "디", "항", "후", 
				"려", "균", "묵", "송", "욱", "휴", "언", "령", "섬", "들", "견", "추", "걸", "삼", "열", "웅", "분", "변", "양", "출", "타", "흥", "겸", "곤", "번", "식", "란", "더", "손", "술", "훔", "반", "빈", 
				"실", "직", "흠", "흔", "악", "람", "뜸", "권", "복", "심", "헌", "엽", "학", "개", "롱", "평", "늘", "늬", "랑", "얀", "향", "울", "련"); 
		
		List<String> name5 = Arrays.asList("행복한","원빈동생","역시","달리는","날개달린","기분나쁜","기분좋은","신바람나는","상쾌한","짜릿한","그리운","자유로운","서운한","다그닥다그닥","꿀꿀","드르렁","뿡","멍멍","야옹야옹","삐약삐약", "와장창","목소리 큰","친구 한명인",
				"킹카","퀸카","냉정한","부정적인","독서왕","출석왕", "우쭈쭈","으라차차","파닥파닥","울적한","비참한","조용한","말이없는","위축되는","긴장되는","두려운","당당한","배부른","수줍은","말많은","창피한","멋있는", "열받은","심심한","잘생긴","이쁜","시끄러운");
       String num = (int)((Math.random()*899999) +100000) +"";
		Collections.shuffle(name3); Collections.shuffle(name4); Collections.shuffle(name5);//return name.get(0) + name2.get(0) + name2.get(1);
        String nickname = name5.get(5) + name3.get(3) + name4.get(2) + num;
        
        return nickname;
		
	}
	
	/*
	인증번호 암호화 수정중
	
	public Key getAESKey() throws Exception {
	    String iv;
	    Key keySpec;

	    String key = "1234567890123456";
	    iv = key.substring(0, 16);
	    byte[] keyBytes = new byte[16];
	    byte[] b = key.getBytes("UTF-8");

	    int len = b.length;
	    if (len > keyBytes.length) {
	       len = keyBytes.length;
	    }

	    System.arraycopy(b, 0, keyBytes, 0, len);
	    keySpec = new SecretKeySpec(keyBytes, "AES");

	    return keySpec;
	}


	// 복호화
	public String decAES(String enStr) throws Exception {
	    Key keySpec = getAESKey();
	    Cipher c = Cipher.getInstance("DESede");
	    c.init(Cipher.DECRYPT_MODE, keySpec);
	    byte[] byteStr = Base64.decodeBase64(enStr.getBytes("UTF-8"));
	    String decStr = new String(c.doFinal(byteStr), "UTF-8");

	    return decStr;
	}
	*/


}
