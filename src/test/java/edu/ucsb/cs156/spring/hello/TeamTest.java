package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
       assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_for_same_object(){
       assertEquals(team.equals(team), true);
    }

    @Test
    public void equals_for_different_class(){
       int tester = 1;
       assertEquals(team.equals(tester), false);
    }

    @Test
    public void equals_for_third_case(){
    	Team team2 = new Team("test-team");
	assertEquals(team, team2);
	team2.addMember("Brian");
	assertEquals(team.equals(team2), false);
	Team team3 = new Team("test-fail");
	assertEquals(team.equals(team3), false);
	team3.addMember("Brian");
        assertEquals(team.equals(team3), false);
    }

    @Test
    public void hashCode_basic_test(){
	//code from jpa02 instructions by Phil Conrad, slightly modified strings
    	Team t1 = new Team();
   	t1.setName("Code from jpa02 steps");
   	t1.addMember("Me");
   	Team t2 = new Team();
   	t2.setName("Code from jpa02 steps");
   	t2.addMember("Me");
   	assertEquals(t1.hashCode(), t2.hashCode());
    }   

    @Test
    public void hashCode_mutation_test(){
    	Team t = new Team("mutant-test");
	t.addMember("John Doe");
	//code from jpa02 instructions by Phil Conrad
	int result = t.hashCode();
	int expectedResult = -1076527932;
	assertEquals(expectedResult, result);
    }

    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

}
