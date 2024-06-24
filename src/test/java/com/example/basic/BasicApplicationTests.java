package com.example.basic;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.basic.entity.Major;
import com.example.basic.entity.Player;
import com.example.basic.entity.Team;
import com.example.basic.repository.MajorRepository;
import com.example.basic.repository.PlayerRepository;
import com.example.basic.repository.TeamRepository;
import com.example.basic.util.Mailer;
import com.example.basic.util.SMTPAuthenticator;

@SpringBootTest
class BasicApplicationTests {
	@Autowired
	Mailer mailer;

	@Test
	void emailsend(){
		for(int i = 0; i<100; i++){
		mailer.sendMail(
				"dugyeon@gmail.com", "차단해봐라", "ㅋㅋㅋㅋ..ㅋㅋ", new SMTPAuthenticator());
				
			}

	}

	// @Autowired PasswordEncoder passwordEncoder;
	// @Test
	// void 스프링암호화(){
	// 	String pw  = passwordEncoder.encode("1");
	// 	System.out.println(pw);
	// }

	@Test
	void 암호화() throws NoSuchAlgorithmException {
		String raw = "password1234";
		String rawAndSalt = "abcd1234";
		MessageDigest md = MessageDigest.getInstance("SHA-256");

		md.update(raw.getBytes());
		String hex = String.format("%064x", new BigInteger(1, md.digest()));
		System.out.println("raw의 해시값 : " + hex);
		md.update(rawAndSalt.getBytes());
		hex = String.format("%064x", new BigInteger(1, md.digest()));
		System.out.println("raw+salt의 해시값 : " + hex);
	}

	@Autowired
	PlayerRepository playerRepository;

	@Autowired
	TeamRepository teamRepository;

	@Test
	@Transactional // lazy 사용시 Transactional 사용하면 원하는 부분 + 나머지 전체부분 보여줌
	void TeamRepository조회Test() {
		Optional<Team> opt = teamRepository.findById(1);
		if (opt.isPresent()) {
			Team team = opt.get();
			System.out.println(team);
			// System.out.println(team.getTeamName());
			// List<Player> players = team.getPlayers();
			// for(Player p : players){
			// System.out.println(p.getPlayerName());
			// }
		}
	}

	@Test
	void TeamRepositoryTest() {
		Team t = new Team();
		t.setTeamId(1);
		t.setTeamName("A팀");
		teamRepository.save(t);
	}

	@Test
	@Transactional
	void PlayerRepository조회Test() {
		Optional<Player> opt = playerRepository.findById(2); // select 한번
		if (opt.isPresent()) {
			Player p = opt.get();
			System.out.println(p.getPlayerName());
			Team t = p.getTeam(); // select 두번
			System.out.println(t.getTeamName());
		}
	}

	@Test
	void PlayerRepositoryTest() {
		Team team = new Team();
		team.setTeamId(1);

		Player p = new Player();
		p.setPlayerId(2);
		p.setPlayerName("회원2");
		p.setTeam(team);
		playerRepository.save(p);
	}

	@Autowired
	MajorRepository majorRepository;

	@Test
	void ServiceCenter레파지토리테스트() {
		Major major = new Major();
		major.setName("아무거나");
		major.setEbtbDate(new Date());
		major.setMaxPrsn(30);
		majorRepository.save(major);
	}

	@Test
	void Major엔티티테스트() {
		System.out.println("테스트");
	}

}
