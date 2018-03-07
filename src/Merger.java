import java.io.*;
import java.util.*;

public class Merger {
	
	private ArrayList<Team> teamList;
	private File homeFile;
	private File awayFile;
	
	public Merger() {
		teamList = new ArrayList<>();
		homeFile = new File("ScoutingInfo.txt");
		awayFile = new File("ScoutingInfo1.txt");
		
		try {
			addFileInfoToList(homeFile);
			addFileInfoToList(awayFile);
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private void addFileInfoToList(File file) throws FileNotFoundException {
		Scanner reader = new Scanner(file);
		
		while(reader.hasNext()) {
			int name = reader.nextInt();
			int index = getTeamIndex(name);
			
			int numOfRounds;
			
			if(index >= 0) {
				numOfRounds = reader.nextInt();
				
				for(int x = 0; x < numOfRounds; x++) {
					teamList.get(x).addClimb(reader.nextInt());
					teamList.get(x).addAutoCrossLine(reader.next().equals("1"));
					teamList.get(x).addAutoSwitchScore(reader.next().equals("1"));
					teamList.get(x).addAutoScaleScore(reader.next().equals("1"));
					teamList.get(x).addRobotFunctioned(reader.next().equals("1"));
					teamList.get(x).addExchangeScore(reader.nextInt());
					teamList.get(x).addSwitchScore(reader.nextInt());
					teamList.get(x).addScaleScore(reader.nextInt());
					teamList.get(x).addWin(reader.next().equals("1"));
					teamList.get(x).addRound();
				}
			}
			else {
				Team newTeam = new Team(name);
				numOfRounds = reader.nextInt();
				
				for(int x = 0; x < numOfRounds; x++) {
					newTeam.addClimb(reader.nextInt());
					newTeam.addAutoCrossLine(reader.next().equals("1"));
					newTeam.addAutoSwitchScore(reader.next().equals("1"));
					newTeam.addAutoScaleScore(reader.next().equals("1"));
					newTeam.addRobotFunctioned(reader.next().equals("1"));
					newTeam.addExchangeScore(reader.nextInt());
					newTeam.addSwitchScore(reader.nextInt());
					newTeam.addScaleScore(reader.nextInt());
					newTeam.addWin(reader.next().equals("1"));
					newTeam.addRound();
				}
				
				teamList.add(newTeam);
			}
		}
	}
	
	private int getTeamIndex(int name) {
		for(int x = 0; x < teamList.size(); x++) {
			if(name == teamList.get(x).getName()) {
				return x;
			}
		}
		return -1;
	}
	
	public ArrayList<Team> getMergedList(){
		return teamList;
	}
	
	public File getAwayFile() {
		return awayFile;
	}
}
