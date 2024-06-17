package com.example.basic;

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

@SpringBootTest
class BasicApplicationTests {
	@Autowired
	PlayerRepository playerRepository;

	@Autowired
	TeamRepository teamRepository;

	@Test @Transactional
	void TeamRepository조회Test(){
	Optional<Team> opt = teamRepository.findById(1);
		if(opt.isPresent()){
			Team team = opt.get();
			System.out.println(team);
			// System.out.println(team.getTeamName());
			// List<Player> players = team.getPlayers();
			// for(Player p : players){
			// 	System.out.println(p.getPlayerName());
			// }
		}
	}
	@Test
	void TeamRepositoryTest(){
		Team t = new Team();
		t.setTeamId(1);
		t.setTeamName("A팀");
		teamRepository.save(t); 
	}

	@Test @Transactional
	void PlayerRepository조회Test(){
	Optional<Player>	opt = playerRepository.findById(2); // select 한번
		if(opt.isPresent()){
			Player p = opt.get();
			System.out.println(p.getPlayerName());
			Team t = p.getTeam(); //select 두번
			System.out.println(t.getTeamName());
		}
	}

	@Test
	void PlayerRepositoryTest(){
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
