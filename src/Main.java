import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {
		ArrayList<Team> teamList = new ArrayList<>();
		Save firstFile = new Save();
		Save secondFile = new Save("ScoutingInfo(1).txt");
		teamList.addAll(firstFile.loadArrayList());
		teamList.addAll(secondFile.loadArrayList());
		firstFile.saveTextFile(teamList);
	}

}
